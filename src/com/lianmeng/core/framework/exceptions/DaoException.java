/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.framework.exceptions;

/** 
 * Description: <br> 
 *  
 * @author shen.zhi<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see com.lianmeng.core.framework.exceptions <br>
 */
public class DaoException extends RuntimeException {
    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 1L;

    /**
     * code <br>
     */
    private String code;

    /**
     * resolve <br>
     */
    private String resolve;

    public String getCode() {
        return code;
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }

    /**
     * Description: <br>
     * 
     * @param message String
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Description: <br>
     * 
     * @param msg String
     * @param cause Throwable
     */
    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Description: <br>
     * 
     * @param cause Throwable
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Description: <br>
     */
    public DaoException() {
        super();
    }

    /**
     * Description: <br>
     * 
     * @param message String
     * @param code String
     * @param resolve String
     */
    public DaoException(String message, String code, String resolve) {
        super(message);
        this.code = code;
        this.resolve = resolve;
    }

    /**
     * Description: <br>
     * 
     * @param message String
     * @param code String
     * @param resolve String
     * @param e Throwable
     */
    public DaoException(String message, String code, String resolve, Throwable e) {
        super(message, e);
        this.code = code;
        this.resolve = resolve;
    }
}
