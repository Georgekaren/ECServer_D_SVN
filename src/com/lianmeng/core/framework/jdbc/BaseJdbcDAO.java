/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.jdbc;

import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @param <T> <T>
 * @see com.lianmeng.core.framework.jdbc <br>
 */
public abstract class BaseJdbcDAO<T> extends BaseJdbcSupport {

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param paramT T
     * @throws AppException <br>
     */
    public abstract void insert(T paramT) throws AppException;

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param paramT T 
     * @return 0
     * @throws AppException <br>
     */
    public abstract int update(T paramT) throws AppException;

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param paramT T 
     * @return 0
     * @throws AppException <br>
     */
    public abstract int delete(T paramT) throws AppException;

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param paramString String
     * @return 0
     * @throws AppException <br>
     */
    public abstract int deleteById(String paramString) throws AppException;

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param paramString String
     * @return HashMap<String, String>
     * @throws AppException <br>
     */
    public abstract HashMap<String, String> selectById(String paramString) throws AppException;

}
