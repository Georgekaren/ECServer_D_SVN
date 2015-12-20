/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import com.lianmeng.core.framework.exceptions.DaoException;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.jdbc <br>
 */
public class BaseJdbcSupport implements InitializingBean {

    /**
     * logger <br>
     */
    private static final Logger logger = Logger.getLogger(BaseJdbcSupport.class);

    /**
     * database <br>
     */
    public DriverManagerDataSource database;

    /**
     * lobHandler <br>
     */
    private LobHandler lobHandler;

    /**
     * jdbcTemplate <br>
     */
    private JdbcTemplate jdbcTemplate;

    /** 
     *BaseJdbcSupport  
     */ 
    public BaseJdbcSupport() {
    }


    /** 
     * Description: <br> 
     * @param database  DriverManagerDataSource
     */ 
    public BaseJdbcSupport(DriverManagerDataSource database) {
        // System.out.println("++++++++++++");
        this.setDataSource(database);
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param database DriverManagerDataSource<br>
     */ 
    public void setDataSource(DriverManagerDataSource database) { 
        this.database = database;
    }

    public final void setLobHandler(LobHandler lobHandler) {
        this.lobHandler = lobHandler;
    }

    public final LobHandler getLobHandler() {
        return lobHandler;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param dataSource DataSource<br>
     */ 
    private void createJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public final JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return String<br>
     */ 
    public String test() {
       /* String rtn = "";
        // conn =database.getConnection();
        String sql = "select * from srv_prod where id= ? ";
        ArrayList<String> inList = new ArrayList<String>();
        inList.add("1");
        // this.queryList(sql, inList);
        Map m = this.queryList(sql, inList).get(0);

        return m.get("name") + "";*/
        return "";
    }

    // ======================兼容现有操作数据库方式========================
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return <br>
     */ 
    public Connection createConnection() {
        logger.debug("createConnection...");
        // TODO 需要对nativeJdbcExtractor处理JDBC容器获得的Connection
        return DataSourceUtils.getConnection(this.getDataSource());
    }

    private DataSource getDataSource() {
        return database;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param connection Connection<br>
     */ 
    public void releaseConnection(Connection connection) {
        logger.debug("releaseConnection...");
        DataSourceUtils.releaseConnection(connection, this.getDataSource());
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param connection Connection
     * @param stmt Statement
     * @param rs  ResultSet<br>
     */ 
    public void cleanUp(Connection connection, Statement stmt, ResultSet rs) {
        logger.debug("close rs...");
        JdbcUtils.closeResultSet(rs);
        logger.debug("close stmt...");
        JdbcUtils.closeStatement(stmt);
        logger.debug("releaseConnection...");
        DataSourceUtils.releaseConnection(connection, this.getDataSource());
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param connection  Connection
     * @param ps PreparedStatement
     * @param stmt Statement
     * @param rs  ResultSet<br>
     */ 
    public void cleanUp(Connection connection, PreparedStatement ps, Statement stmt, ResultSet rs) {
        logger.debug("close rs...");
        JdbcUtils.closeResultSet(rs);
        logger.debug("close ps...");
        JdbcUtils.closeStatement(ps);
        logger.debug("close stmt...");
        JdbcUtils.closeStatement(stmt);
        logger.debug("releaseConnection...");
        DataSourceUtils.releaseConnection(connection, this.getDataSource());
    }

    // =====================提供简单的读写Clob函数=========================================
    /**
     * 写Clob字段 sql中需要用'?'预留clob的位置
     * 
     * @param sql String
     * @param clobContent String
     */
    public void writeClob(String sql, final String clobContent) {
        writeClob(sql, clobContent, new Object[] {});
    }

    /**
     * 写Clob字段 sql中需要用'?'预留clob的位置，并且是语句中第一个
     * 
     * @param sql String
     * @param args Object[]
     * @param clobContent  String
     */
    public void writeClob(String sql, final String clobContent, final Object[] args) {
        this.getJdbcTemplate().execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.getLobHandler()) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) {
                try {
                    lobCreator.setClobAsString(ps, 1, clobContent);

                    if (args != null) {
                        for (int i = 0; i < args.length; i++) {
                            Object arg = args[i];
                            if (arg instanceof SqlParameterValue) {
                                SqlParameterValue paramValue = (SqlParameterValue) arg;
                                StatementCreatorUtils.setParameterValue(ps, i + 2, paramValue, paramValue.getValue());
                            }
                            else {
                                StatementCreatorUtils.setParameterValue(ps, i + 2, SqlTypeValue.TYPE_UNKNOWN, arg);
                            }
                        }
                    }
                }
                catch (SQLException e) {
                    throw new DaoException("SQL语句填充Clob字段出错！", e);
                }
            }
        });
    }

    /**
     * 读clob字段 sql中返回值clob字段位于结果集列的第一个
     * 
     * @param sql String
     * @return String
     */
    public String readClob(String sql) {
        return readClob(sql, new Object[] {});
    }

    /**
     * 读clob字段 sql中返回值clob字段位于结果集列的第一个
     * 
     * @param sql String
     * @param args  Object[]
     * @return String
     */
    public String readClob(String sql, Object[] args) {
        String clobContent = (String) getJdbcTemplate().queryForObject(sql, args, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) {
                String txt;
                try {
                    txt = getLobHandler().getClobAsString(rs, 1);
                }
                catch (SQLException e) {
                    throw new DaoException("读取Clob字段出错！", e);
                }
                return txt;
            }
        });

        return clobContent;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br> <br>
     */ 
    protected final void checkConfig() {
        this.jdbcTemplate.afterPropertiesSet();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        createJdbcTemplate(database);
        checkConfig();
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param sql String
     * @param paramList  ArrayList<String>
     * @return <br>
     */ 
    public int update(String sql, ArrayList<String> paramList) {
        return this.jdbcTemplate.update(sql, paramList.toArray());
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param sql String
     * @return <br>
     */ 
    public int update(String sql) {
        return this.jdbcTemplate.update(sql);
    }

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param sql String
     * @param paramList ArrayList<String>
     * @return <br>
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ArrayList<HashMap<String, String>> queryList(String sql, ArrayList<String> paramList) {
        ArrayList<HashMap<String, String>> chgli = new ArrayList<HashMap<String, String>>();
        ArrayList rtnList = (ArrayList) this.jdbcTemplate.queryForList(sql, paramList.toArray());
        for (int i = 0; i < rtnList.size(); i++) {
            if (rtnList.get(i) instanceof ListOrderedMap) {
                ListOrderedMap lMap = (ListOrderedMap) rtnList.get(i);
                chgli.add(ServiceObjectToJsonUtil.getHashMapByListOrderMap(lMap));
            }
            else {
                chgli.add((HashMap<String, String>) rtnList.get(i));
            }
        }
        return chgli;
    }

}
