/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.prod.domain;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.lianmeng.core.framework.exceptions.AppException;
import com.lianmeng.core.prod.dao.ProdManagerDAO;

/**
 * Description: <br>
 * 
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.prod.domain <br>
 */
public class ProdManager extends AbstractProdManager {

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(ProdManager.class);

    /**
     * prodManagerDAO <br>
     */
    private ProdManagerDAO prodManagerDAO;

    public void setProdManagerDAO(ProdManagerDAO prodManagerDAO) {
        this.prodManagerDAO = prodManagerDAO;
    }

    @Override
    public int add() throws AppException {

        this.prodManagerDAO.selectById("");
        logger.info("WWWWWWWWWWWWWWWWWWWWWW");
        return 0;
    }

    @Override
    public HashMap<String, String> qryProdDataById() throws AppException {
        return this.prodManagerDAO.selectById("");
    }

}
