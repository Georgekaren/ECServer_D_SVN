/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.version.domain;

import java.io.Serializable;
import java.util.HashMap;

import com.lianmeng.core.framework.exceptions.AppException;

/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-21 <br>
 * @since V8<br>
 * @see com.lianmeng.core.version.domain <br>
 */

public abstract class AbstractVersionManager implements Serializable {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -6974105571660110590L;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryVersionDataById() throws AppException;
}
