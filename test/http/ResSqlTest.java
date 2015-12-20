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
    /*public static void main(String[] args) {
        qryContent();

    }*/

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
        urlNew = "http://localhost:8080/ECServer_D/lianmeng-service/rest/lianmeng/postJsonService";
        String QryPingContent = "{'ServiceName':'IC_IM_DIVERSION_QRY_CITY' , Data:[]}";
        QryPingContent = "{\"ServiceName\":\"testJdbcSu\" , \"Data\":{\"PROJ_ORD_NO\":\"CR201512180464\"}}";
        QryPingContent = "{\"ServiceName\":\"prodManagerService\" , \"Data\":{\"ACTION\":\"QRY\"}}";

        String sr = "";
        sr = HttpRequest.sendPost(urlNew, QryPingContent);
      //  System.out.println(sr);
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
