/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.extprod.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.jdbc.BaseJdbcDAO;
import com.lianmeng.extend.lianmeng.extprod.domain.AbstractExtProdManager;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.extend.lianmeng.home.dao <br>
 */

public abstract class ExtProdManagerDAO extends BaseJdbcDAO<AbstractExtProdManager> {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryLimitProdList() throws AppException;

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */
    public abstract HashMap<String, String> queryProdDetailList(AbstractExtProdManager prod) throws AppException;

    /**
     * Description: 查询产品关联的图片信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryProdRelaPictureList(AbstractExtProdManager prod) throws AppException;
    
    /**
     * Description: 查询产品关联的促销信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryProdRelaSaleList(AbstractExtProdManager prod) throws AppException;

    /**
     * Description: 查询最基础产品信息<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryBaseProdList(AbstractExtProdManager prod) throws AppException;

    /**
     * Description: 查询最基础产品类型<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryProdTypeList(AbstractExtProdManager prod) throws AppException;

    /**
     * Description: 查询公共静态常量--方法需要移到产品包<br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param prod AbstractExtProdManager
     * @return ArrayList<HashMap<String, String>>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> queryBasePubsFinalList(AbstractExtProdManager prod) throws AppException;

    
}
