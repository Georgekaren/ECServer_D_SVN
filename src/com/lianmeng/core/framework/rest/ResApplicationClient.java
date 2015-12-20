/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.rest;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.framework.rest.app.util.HttpRequest;
import com.lianmeng.core.framework.rest.app.util.ServiceObjectToJsonUtil;


/** 
 * Description: <br> 
 *  
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-11-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.rest <br>
 */

public class ResApplicationClient {
    
    /**
     * Description: 向接口发送请求<br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param dictParam DynamicDict
     * @return <br>
     * @throws AppException 
     */ 
    public String sendPost(DynamicDict dictParam) throws AppException {
        String ofmHttpUrl = "";
        DynamicDict inDict = new DynamicDict();
        inDict.setServiceName("QIM_DIVERSION_QRY_OFM_URL");
       // ServiceFlow.callService(inDict);
        DynamicDict urlDict = (DynamicDict) inDict.getList("z_d_r").get(0);
        ofmHttpUrl = (String) urlDict.getValueByName("URL");
        String inParam = "{\"ServiceName\":\"" + dictParam.getServiceName() + "\",\"Data\":" + ServiceObjectToJsonUtil.getJsonData(dictParam) + "}";
        return HttpRequest.sendPost(ofmHttpUrl, inParam);
    }
}
