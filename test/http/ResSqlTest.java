package http;

/**
 * Description: <br>
 * 
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-12-20 <br>
 * @since V8<br>
 * @see http <br>
 */
public class ResSqlTest {

    /**
     * urlNew s<br>
     */
    static String urlNew;

    /**
     * type <br>
     */
    static int type; // 0 查询 1 更新 2 其它

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        qryContent();

    }

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * <br>
     */
    public static void qryContent() {

        // String sqlcontent = "select * from rim_migrate_prod where proj_id='000000000000000000041267'  ";
        // sqlcontent = xmlParseConvert(sqlcontent);
        urlNew = "http://localhost:8080/ECServer_D/BusiServlet";
        urlNew = "http://localhost:8080/ECServer_D/LoginServlet";
        urlNew = "http://localhost:8080/ECServer_D/lianmeng-service/rest/lianmeng/postJsonService";
        String QryPingContent = "{'ServiceName':'IC_IM_DIVERSION_QRY_CITY' , Data:[]}";
        QryPingContent = "{\"ServiceName\":\"testJdbcSu\" , \"Data\":{\"PROJ_ORD_NO\":\"CR201512180464\"}}";
        QryPingContent = "{\"ServiceName\":\"prodManagerService\" , \"Data\":{\"ACTION\":\"QRY\",\"ID\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"versionManagerService\" , \"Data\":{\"ACTION\":\"QRY\",\"ID\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"homeManagerService\" , \"Data\":{\"ACTION\":\"QRY\",\"ID\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYLIMITPROD\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYPRODDETAIL\",\"id\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYBASECONTENTPROD\",\"prodNew\":\"true\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYPRODTYPELIST\"}}";
      //  QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYBASECONTENTANDCOLORPROD\",\"type\":\"1001\"
        //,\"ordertype\":\"sale_down\",\"brandid\":\"1002001\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYPRODFINALSLIST\",\"finalkeyword\":\"SUBBRAND\"}}";
        
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYBASECONTENTPROD\",\"name\":\"苹果\"}}";
        QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"ADDORDER\",\"prodId\":\"3\",\"userId\":\"1\",\"prodNum\":\"1\",\"totalPrice\":\"13\"}}";
      //  QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"QRYBASEORDER\",\"userId\":\"1\"}}";
       // 
        QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"MODIFYORDER\",\"prodId\":\"3\",\"userId\":\"1\",\"prodNum\":\"2\",\"totalPrice\":\"13\"}}";
        QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"REMOVEORDER\",\"prodId\":\"3\",\"userId\":\"1\"}}";
        
        //QRYUSER
        QryPingContent = "{\"ServiceName\":\"userManagerService\" , \"Data\":{\"ACTION\":\"QRYUSER\",\"name\":\"11\",\"password\":\"123\"}}";
     //   QryPingContent = "{\"ServiceName\":\"userManagerService\" , \"Data\":{\"ACTION\":\"ADDUSER\",\"name\":\"123\",\"password\":\"1234\",\"telephone\":\"1232\"}}";
     //   QryPingContent = "{\"ServiceName\":\"userManagerService\" , \"Data\":{\"ACTION\":\"DELUSER\",\"id\":\"1002\"}}";
        QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"QRYHASORDER\",\"userId\":\"1\"}}";
        // 
        QryPingContent = "{\"ServiceName\":\"payOrderManagerService\" , \"Data\":{\"ACTION\":\"MIMPAYORDERLIST\",\"userId\":\"1\",\"orderNo\":\"1231121\",\"channel\":\"alipay\",\"amount\":\"30\"}}";
        
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"QRYADDRESSLIST\",\"userId\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"ADDADDRESS\",\"userId\":\"1\"" +
        		",\"id\":\"1\",\"name\":\"1\",\"teleNo\":\"111\",\"fixedTelNo\":\"1\",\"provinceId\":\"43\",\"cityId\":\"6\",\"areaId\":\"82\"" +
        		",\"detail\":\"1\",\"zipCode\":\"410000\",\"isDefault\":\"1\",\"level\":\"4\",\"position\":\"1\",\"note\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"MODIFYADDRESS\",\"userId\":\"1\"" +
            ",\"id\":\"1002\",\"name\":\"荷花\",\"teleNo\":\"111\",\"fixedTelNo\":\"1\",\"provinceId\":\"43\",\"cityId\":\"6\",\"areaId\":\"82\"" +
            ",\"detail\":\"1\",\"zipCode\":\"410000\",\"isDefault\":\"1\",\"level\":\"4\",\"position\":\"1\",\"note\":\"1\"}}";
  
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"REMOVEADDRESS\",\"userId\":\"1\",\"id\":\"1011\"}}";
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"MODIFYDEFAULT\",\"userId\":\"1\",\"id\":\"1012\",\"isDefault\":\"1\"}}";
        QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"QRYBASEFAVORITEPROD\",\"userId\":\"1\"}}";
      //  QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"MIMREMOVEFAVORITEPROD\",\"userId\":\"1\",\"id\":\"1\"}}";
      // QryPingContent = "{\"ServiceName\":\"extProdManagerService\" , \"Data\":{\"ACTION\":\"MIMADDFAVORITEPROD\",\"userId\":\"1\",\"id\":\"2\"}}";
        QryPingContent = "{\"ServiceName\":\"srvOrderManagerService\" , \"Data\":{\"ACTION\":\"QRYHASPAYORDERDETAIL\",\"userId\":\"1\",\"orderNo\":\"201512272020334441\",\"prodId\":[\"219\",\"220\"]}}";
        QryPingContent = "{\"ServiceName\":\"payOrderManagerService\" , \"Data\":{\"ACTION\":\"MIMPAYORDERLIST\",\"userId\":\"1\",\"prodId\":[\"2\",\"3\",],\"channel\":\"alipay\",\"amount\":\"3\"}}";
        
        QryPingContent = "{\"ServiceName\":\"addressManagerService\" , \"Data\":{\"ACTION\":\"QRYADDRESSLIST\",\"userId\":\"1\"}}";
        
        String sr = "";
        sr = HttpRequest.sendPost(urlNew, QryPingContent);
        System.out.println(sr);
    }

   

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param inputStr s
     * @return <br>
     */
    private static String xmlParseConvert(String inputStr) {

        return inputStr.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;");

    }

}
