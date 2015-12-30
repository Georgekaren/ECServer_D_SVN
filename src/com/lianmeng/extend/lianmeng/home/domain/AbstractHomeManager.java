/**************************************************************************************** 
 Copyright © 2015-2020  LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.extend.lianmeng.home.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
 * @see com.lianmeng.extend.lianmeng.home.domain <br>
 */

public abstract class AbstractHomeManager implements Serializable {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 1680275241815984904L;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract ArrayList<HashMap<String, String>> qryHomeBarImgDataById() throws AppException;
}
