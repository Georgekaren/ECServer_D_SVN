/**************************************************************************************** 
 Copyright © 2015-2020 LianMeng Corporation. All rights reserved. Reproduction or <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.lianmeng.core.user.domain;

import java.util.HashMap;

import com.lianmeng.core.framework.bo.server.DynamicDict;
import com.lianmeng.core.framework.exceptions.AppException;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-24 <br>
 * @since V8<br>
 * @see com.lianmeng.core.srv.domain <br>
 */
/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-27 <br>
 * @since V8<br>
 * @see com.lianmeng.core.user.domain <br>
 */
public abstract class AbstractUserManager {

   
 
    /**
     * id <br>
     */
    private String id;
    /**
     * name <br>
     */
    private String name;
    /**
     * telephone <br>
     */
    private String telephone;
    /**
     * email <br>
     */
    private String email;
    /**
     * type <br>
     */
    private String type;
    /**
     * state <br>
     */
    private String state;
    /**
     * note <br>
     */
    private String note;
    /**
     * address <br>
     */
    private String address;
    /**
     * position <br>
     */
    private String position;
    /**
     * grade <br>
     */
    private String grade;
    /**
     * defaultAddressId <br>
     */
    private String defaultAddressId;
    
    /**
     * password <br>
     */
    private String password;
    
    
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getGrade() {
        return grade;
    }


    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getDefaultAddressId() {
        return defaultAddressId;
    }


    public void setDefaultAddressId(String defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }


    /**
     * Description:解析dict <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param aDict DynamicDict
     * @throws AppException <br>
     */ 
    public void dictToBO(DynamicDict aDict) throws AppException {
        if (aDict.get("id") != null && !"".equals(aDict.get("id"))) {
            this.setId((String) aDict.getValueByName("id"));
        }
        if (aDict.get("name") != null && !"".equals(aDict.get("name"))) {
            this.setName((String) aDict.getValueByName("name"));
        }
        if (aDict.get("telephone") != null && !"".equals(aDict.get("telephone"))) {
            this.setTelephone((String) aDict.getValueByName("telephone"));
        }
        if (aDict.get("email") != null && !"".equals(aDict.get("email"))) {
            this.setEmail((String) aDict.getValueByName("email"));
        }
        if (aDict.get("type") != null && !"".equals(aDict.get("type"))) {
            this.setType((String) aDict.getValueByName("type"));
        }
        if (aDict.get("state") != null && !"".equals(aDict.get("state"))) {
            this.setState((String) aDict.getValueByName("state"));
        }
        if (aDict.get("address") != null && !"".equals(aDict.get("address"))) {
            this.setAddress((String) aDict.getValueByName("address"));
        }
        if (aDict.get("note") != null && !"".equals(aDict.get("note"))) {
            this.setNote((String) aDict.getValueByName("note"));
        }
        if (aDict.get("position") != null && !"".equals(aDict.get("position"))) {
            this.setPosition((String) aDict.getValueByName("position"));
        }
        if (aDict.get("grade") != null && !"".equals(aDict.get("grade"))) {
            this.setGrade((String) aDict.getValueByName("grade"));
        }
        if (aDict.get("defaultAddressId") != null && !"".equals(aDict.get("defaultAddressId"))) {
            this.setDefaultAddressId((String) aDict.getValueByName("defaultAddressId"));
        }
        if (aDict.get("password") != null && !"".equals(aDict.get("password"))) {
            this.setPassword((String) aDict.getValueByName("password"));
        }
        
        
    }
    

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int add() throws AppException;

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryUserByName() throws AppException;
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return HashMap<String, String>
     * @throws AppException <br>
     */ 
    public abstract HashMap<String, String> qryUserInfo() throws AppException;
    
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int remove() throws AppException;
    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @return 0
     * @throws AppException <br>
     */ 
    public abstract int modify() throws AppException;
}
