/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.addr.domain;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.lianmeng.core.addr.dao.AddressManagerDAO;
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
public class AddressManager extends AbstractAddressManager {

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(AddressManager.class);

    /**
     * AddressManagerDAO <br>
     */
    private AddressManagerDAO addressManagerDAO;

    public void setAddressManagerDAO(AddressManagerDAO addressManagerDAO) {
        this.addressManagerDAO = addressManagerDAO;
    }

    @Override
    public int add() throws AppException {
        this.setId(String.valueOf(this.addressManagerDAO.getSeq("SEQ_IM_ADDRESS_ID")));
        this.addressManagerDAO.insert(this);
        return 0;
    }

    
    @Override
    public int remove() throws AppException {
        this.addressManagerDAO.delete(this);
        return 0;
    }
    
    @Override
    public int modify() throws AppException {
        this.addressManagerDAO.update(this);
        return 0;
    }

    @Override
    public int setNoDefault() throws AppException {
        this.addressManagerDAO.setNoDefault(this);
        return 0;
    }

    
    @Override
    public ArrayList<HashMap<String, String>> qryAddressListByUser() throws AppException {
        return this.addressManagerDAO.qryAddressListByUser(this);
    }
    
}
