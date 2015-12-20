/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.jdbc;

import java.util.ArrayList;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.bo.server.IAction;
import com.lianmeng.core.framework.exceptions.AppException;

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
public class TestJdbcSu extends BaseJdbcSupport implements IAction {

    @Override
    public int perform(DynamicDict paramDynamicDict) throws AppException {

        paramDynamicDict.set("tebo", "1");
        ArrayList<String> sl = new ArrayList<String>();
        paramDynamicDict.set("prodList", this.queryList("select * from srv_prod ", sl));

        return 0;
    }

}
