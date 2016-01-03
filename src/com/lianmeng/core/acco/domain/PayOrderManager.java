/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.acco.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

import com.lianmeng.core.acco.dao.PayOrderManagerDAO;
import com.lianmeng.core.framework.bo.utils.DateUtilBase;
import com.lianmeng.core.framework.exceptions.AppException;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-30 <br>
 * @since V8<br>
 * @see com.lianmeng.core.addr.domain <br>
 */
public class PayOrderManager extends AbstractPayOrderManager {

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(PayOrderManager.class);

    /**
     * PayOrderManagerDAO <br>
     */
    private PayOrderManagerDAO payOrderManagerDAO;

    public void setPayOrderManagerDAO(PayOrderManagerDAO payOrderManagerDAO) {
        this.payOrderManagerDAO = payOrderManagerDAO;
    }

    @Override
    public int add() throws AppException {
     //   this.setId(String.valueOf(this.payOrderManagerDAO.getSeq("SEQ_IM_ADDRESS_ID")));
       // this.payOrderManagerDAO.insert(this);
        return 0;
    }

    
    @Override
    public int remove() throws AppException {
        this.payOrderManagerDAO.delete(this);
        return 0;
    }
    
    @Override
    public int modify() throws AppException {
        this.payOrderManagerDAO.update(this);
        return 0;
    }

    @Override
    public ArrayList<HashMap<String, String>> qryPayOrderListByUser() throws AppException {
        return this.payOrderManagerDAO.qryPayOrderListByUser(this);
    }
    
    @Override
    public int payOrder() throws AppException {
        this.setOrderNo(DateUtilBase.getNameFileCurrentDate().replace("_", "") + RandomUtils.nextInt(10000));
        for (int i = 0; i < this.getProdIds().size(); i++) {
            this.setProdId(this.getProdIds().get(i));
            this.payOrderManagerDAO.payOrder(this);
        }
        return 0;
    }
    
    @Override
    public int payFinishOrder() throws AppException {
        this.payOrderManagerDAO.payFinishOrder(this);
        return 0;
    }
    
}
