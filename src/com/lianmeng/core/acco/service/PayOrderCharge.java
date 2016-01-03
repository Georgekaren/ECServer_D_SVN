package com.lianmeng.core.acco.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.internal.LinkedTreeMap;
import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.ChannelException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.exception.PingppException;
import com.pingplusplus.model.App;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.ChargeCollection;


import com.lianmeng.core.framework.exceptions.AppException;



/**
 * Charge 对象相关示例
 * 
 * @author sunkai 该实例程序演示了如何从 ping++ 服务器获得 charge ，查询 charge。 开发者需要填写 apiKey 和 appId , apiKey 可以在 ping++ 管理平台【应用信息里面查看】 apiKey 有 TestKey 和 LiveKey 两种。
 *         TestKey 模式下不会产生真实的交易。
 */
public class PayOrderCharge {

    /**
     * apiKey pingpp 管理平台对应的 API key
     */
    public static String apiKey = "sk_test_GGqXrPmbDK00Oa9C84aPa98C";
  //  public static String apiKey = "ch_z1WjPCrvP0CKPy9aPCHSWzTS";
    /**
     * pingpp 管理平台对应的应用 ID
     */
   // public static String appId = "app_DWrP8GWjzvTKi9G0";
    public static String appId = "app_DWrP8GWjzvTKi9G0";

   /* public static void main(String[] args) {
        Pingpp.apiKey = apiKey;
        ChargeExample ce = new ChargeExample();
        System.out.println("---------创建 charge");
        Charge charge = ce.charge();
        System.out.println(charge.toString());
       // System.out.println("---------查询 charge");
      //  ce.retrieve(charge.getId());
       // System.out.println("---------查询 charge列表");
      //  ce.all();
    }*/

    /**
     * Description: <br>
     * 
     * @author shen.zhi<br>
     * @taskId <br>
     * @param orderNo String
     * @param channel String
     * @param amount String
     * @return String
     * @throws AppException <br>
     */
    public static  String getCharge(String orderNo, String channel, String amount) throws AppException {
        Charge charge = charge(orderNo, channel, amount);
        return charge.toString();
    }
    
    /**
     * Description: 创建 Charge 创建 Charge 用户需要组装一个 map 对象作为参数传递给 Charge.create(); map 里面参数的具体说明请参考：https://pingxx.com/document/api#api-c-new<br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param orderNo String
     * @param channel String
     * @param amount String
     * @return Charge
     * @throws AppException <br>
     */ 
    public static  Charge charge(String orderNo, String channel, String amount)  throws AppException {
        Pingpp.apiKey = apiKey;
        Charge charge = null;
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", amount);
        chargeMap.put("currency", "cny");
        chargeMap.put("subject", "Your Subject");
        chargeMap.put("body", "Your Body");
        chargeMap.put("order_no", orderNo);
        chargeMap.put("channel", channel);
        chargeMap.put("client_ip", "127.0.0.1");
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        chargeMap.put("app", app);
            // 发起交易请求
        try {
            charge = Charge.create(chargeMap);
        }
        catch (AuthenticationException e) {
            throw new AppException(e);
        }
        catch (InvalidRequestException e) {
            throw new AppException(e);
        }
        catch (APIConnectionException e) {
            throw new AppException(e);
        }
        catch (APIException e) {
            throw new AppException(e);
        }
        catch (ChannelException e) {
            throw new AppException(e);
        }
          //  System.out.println(charge.toString());
        //charge.getRefunds().getURL();
        
        return charge;
    }

    
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param chg Charge<br>
     * @return  String
     */ 
    public static String checkNewCharge(Charge chg) {
        StringBuffer rtnString = new StringBuffer();
        rtnString.append("{");
        rtnString.append("\"id\": \"").append(chg.getId()).append("\",");
        rtnString.append("\"object\": \"").append(chg.getObject()).append("\",");
        rtnString.append("\"created\": ").append(chg.getCreated()).append(",");
        rtnString.append("\"livemode\": ").append(chg.getLivemode()).append(",");
        rtnString.append("\"paid\": ").append(chg.getPaid()).append(",");
        rtnString.append("\"refunded\": ").append(chg.getRefunded()).append(",");
        rtnString.append("\"app\": \"").append(chg.getApp()).append("\",");
        rtnString.append("\"channel\": \"").append(chg.getChannel()).append("\",");
        rtnString.append("\"order_no\": \"").append(chg.getOrderNo()).append("\",");
        rtnString.append("\"client_ip\": \"").append(chg.getClientIp()).append("\",");
        rtnString.append("\"amount\": ").append(chg.getAmount()).append(",");
        rtnString.append("\"amount_settle\": ").append(chg.getAmountSettle()).append(",");
        rtnString.append("\"currency\": \"").append(chg.getCurrency()).append("\",");
        rtnString.append("\"subject\": \"").append(chg.getSubject()).append("\",");
        rtnString.append("\"body\": \"").append(chg.getBody()).append("\",");
        rtnString.append("\"time_paid\": ").append(chg.getTimePaid()).append(",");
        rtnString.append("\"time_expire\": ").append(chg.getTimeExpire()).append(",");
        rtnString.append("\"time_settle\": ").append(chg.getTimeSettle()).append(",");
        rtnString.append("\"transaction_no\": \"").append(chg.getTransactionNo()).append("\",");
        if (chg.getRefunds() != null) {
            rtnString.append("\"refunds\": {");
            if (chg.getRefunds().getObject() != null) {
                rtnString.append("\"object\": \"").append(chg.getRefunds().getObject()).append("\",");
            }
            else {
                rtnString.append("\"object\":\"\",");
            }
            if (chg.getRefunds().getURL() != null) {
                rtnString.append("\"url\": \"").append(chg.getRefunds().getURL().replace("/", "\\/")).append("\",");
            }
            else {
                rtnString.append("\"url\":\"\",");
            }
            rtnString.append("\"has_more\": \"").append(chg.getRefunds().getHasMore()).append("\",");

            if (chg.getRefunds().getData().size() > 0) {
                rtnString.append("\"data\": \"").append(chg.getRefunds().getData().toString()).append("\",");
            }
            else {
                rtnString.append("\"object\":[]");
            }
            rtnString.append("},");
        }
        else {
            rtnString.append("\"refunds\": {},");
        }
        rtnString.append("\"amount_refunded\": ").append(chg.getAmountRefunded()).append(",");
        rtnString.append("\"failure_code\": \"").append(chg.getFailureCode()).append("\",");
        rtnString.append("\"failure_msg\": \"").append(chg.getFailureMsg()).append("\",");
        if (chg.getMetadata() != null) {
            rtnString.append("\"metadata\": \"").append(chg.getMetadata().toString()).append("\",");
        }
        else {
            rtnString.append("\"metadata\": {},");
        }

        if (chg.getCredential() != null) {
            rtnString.append("\"credential\": {");
            rtnString.append("\"object\": \"").append(chg.getCredential().get("object")).append("\",");
            if (chg.getCredential().get("alipay") != null) {
                rtnString.append("\"alipay\": {");
                LinkedTreeMap aliMap = (LinkedTreeMap) chg.getCredential().get("alipay");
                // aliMap.get("orderInfo").toString().replace("\"", "\"");
                rtnString.append("\"orderInfo\": \"").append(aliMap.get("orderInfo").toString().replace("\"", "\\\"")).append("\",");
                rtnString.append("},");
            }
            else {
                rtnString.append("\"alipay\": {},");
            }
            rtnString.append("},");
        }
        else {
            rtnString.append("\"credential\": {},");
        }
        if (chg.getExtra() != null) {
            rtnString.append("\"extra\": \"").append(chg.getExtra().toString()).append("\",");
        }
        else {
            rtnString.append("\"extra\": {},");
        }
        if (chg.getDescription() != null) {
            rtnString.append("\"description\": \"").append(chg.getDescription().toString()).append("\"");
        }
        else {
            rtnString.append("\"description\": \"\" ");
        }
        rtnString.append("}");
        return rtnString.toString();
    }
    
    
    
    /**
     * 查询 Charge 该接口根据 charge Id 查询对应的 charge 。 参考文档：https://pingxx.com/document/api#api-c-inquiry 该接口可以传递一个 expand ， 返回的 charge 中的 app 会变成 app 对象。
     * 参考文档： https://pingxx.com/document/api#api-expanding
     * 
     * @param id String
     * @throws AppException 
     */
    public void retrieve(String id) throws AppException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            List<String> expande = new ArrayList<String>();
            expande.add("app");
            param.put("expand", expande);
            // Charge charge = Charge.retrieve(id);
            // Expand app
            Charge charge = Charge.retrieve(id, param);
            if (charge.getApp() instanceof App) {
                // App app = (App) charge.getApp();
                // System.out.println("App Object ,appId = " + app.getId());
            }
            else {
                // System.out.println("String ,appId = " + charge.getApp());
            }

          //  System.out.println(charge);

        }
        catch (PingppException e) {
            throw new AppException(e);
        }
    }

   
    /**
     * Description: 分页查询Charge 该接口为批量查询接口，默认一次查询10条。 用户可以通过添加 limit 参数自行设置查询数目，最多一次不能超过 100 条。 该接口同样可以使用 expand 参数<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @return <br>
     * @throws AppException 
     */ 
    public ChargeCollection all() throws AppException {
        ChargeCollection chargeCollection = null;
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("limit", 3);

        // 增加此处设施，刻意获取app expande
        // List<String> expande = new ArrayList<String>();
        // expande.add("app");
        // chargeParams.put("expand", expande);

        try {
            chargeCollection = Charge.all(chargeParams);
           // System.out.println(chargeCollection);
        }
        catch (AuthenticationException e) {
            throw new AppException(e);
        }
        catch (InvalidRequestException e) {
            throw new AppException(e);
        }
        catch (APIConnectionException e) {
            throw new AppException(e);
        }
        catch (APIException e) {
            throw new AppException(e);
        }
        catch (ChannelException e) {
            throw new AppException(e);
        }
        return chargeCollection;
    }
}
