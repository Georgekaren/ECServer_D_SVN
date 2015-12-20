package com.lianmeng.core.framework.rest.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


/** 
 * Description: <br> 
 *  
 * @author XXX<br>
 * @version 8.0<br>
 * @taskId <br>
 * @CreateDate 2015-10-27 <br>
 * @since V8<br>
 * @see test.httptest <br>
 */
public class HttpRequest {

    /**
     * logger 用于记录日志<br>
     */
    private static Logger logger = Logger.getLogger(HttpRequest.class);
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param url s
     * @param param s
     * @return <br>
     */ 
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key : map.keySet()) {
                logger.info(key + "--->" + map.get(key));
            }

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }
        catch (Exception e) {
            logger.info(e);
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (Exception e2) {
                logger.info(e2);
            }
        }
        return result;
    }

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param url s
     * @param param s
     * @return <br>
     */ 
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
          //  conn.setRequestProperty("Content-Type", "application/text");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }
        catch (Exception e) {
            logger.info(e);
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                logger.info(ex);
            }
        }
        return result;
    }
}