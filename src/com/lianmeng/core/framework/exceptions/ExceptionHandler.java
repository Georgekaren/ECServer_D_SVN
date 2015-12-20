package com.lianmeng.core.framework.exceptions;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

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
public final class ExceptionHandler {
    /**
     * INNER_ERROR <br>
     */
    public static final int INNER_ERROR = 1;

    /**
     * BUSS_ERROR <br>
     */
    public static final int BUSS_ERROR = 0;

    /**
     * ENCODE_CONFIG_NODE <br>
     */
    public static final String ENCODE_CONFIG_NODE = "ExceptionHandler";

    /**
     * logger <br>
     */
    private static Logger logger = Logger.getLogger(ExceptionHandler.class);

    /**
     * appExceptionCount <br>
     */
    private static long appExceptionCount;

    public static synchronized long getAppExceptionCount() {
        return appExceptionCount;
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br> <br>
     */ 
    public static synchronized void increaseAppExceptionCount() {
        appExceptionCount += 1L;
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param t Throwable
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, Throwable t) throws AppException {
        return publish(errorCode, null, 1, t, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param errorType int
     * @param t Throwable
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, int errorType, Throwable t) throws AppException {
        return publish(errorCode, null, errorType, t, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode) throws AppException {
        return publish(errorCode, null, 1, null, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param errorType int
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, int errorType) throws AppException {
        return publish(errorCode, null, errorType, null, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg) throws AppException {
        return publish(errorCode, msg, 1, null, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param errorType int
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType) throws AppException {
        return publish(errorCode, msg, errorType, null, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param t Throwable
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, Throwable t) throws AppException {
        return publish(errorCode, msg, 1, t, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param errorType int
     * @param t Throwable
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, Throwable t) throws AppException {
        return publish(errorCode, msg, errorType, t, null, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param t Throwable
     * @param param String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, Throwable t, String param) throws AppException {
        return publish(errorCode, msg, 1, t, param, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param errorType int
     * @param t Throwable
     * @param param String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, Throwable t, String param) throws AppException {
        return publish(errorCode, msg, errorType, t, param, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param param1 String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, String param1) throws AppException {
        return publish(errorCode, msg, 1, null, param1, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param errorType int
     * @param param1 String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, String param1) throws AppException {
        return publish(errorCode, msg, errorType, null, param1, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param param1 String
     * @param param2 String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, String param1, String param2) throws AppException {
        return publish(errorCode, msg, 1, null, param1, param2, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param errorType int
     * @param param1 String
     * @param param2 String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, String param1, String param2) throws AppException {
        return publish(errorCode, msg, errorType, null, param1, param2, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String
     * @param msg String
     * @param param1 String
     * @param param2 String
     * @param param3 String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, String param1, String param2, String param3) throws AppException {
        return publish(errorCode, msg, 1, null, param1, param2, param3);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String String
     * @param msg String String
     * @param errorType int int
     * @param param1 String String
     * @param param2 String String
     * @param param3 String String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, String param1, String param2, String param3) throws AppException {
        return publish(errorCode, msg, errorType, null, param1, param2, param3);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String String
     * @param errorType int int
     * @param param1 String String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, int errorType, String param1) throws AppException {
        return publish(errorCode, null, errorType, null, param1, null, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String String
     * @param errorType int int
     * @param param1 String String
     * @param param2 String String
     * @return AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, int errorType, String param1, String param2) throws AppException {
        return publish(errorCode, null, errorType, null, param1, param2, null);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String String
     * @param errorType int String
     * @param param1 String errorCode
     * @param param2 String errorCode
     * @param param3 String errorCode
     * @return AppException 
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, int errorType, String param1, String param2, String param3) throws AppException {
        return publish(errorCode, null, errorType, null, param1, param2, param3);
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param errorCode String errorCode
     * @param msg String  errorCode
     * @param errorType int int
     * @param t Throwable Throwable
     * @param param1 String String
     * @param param2 String String
     * @param param3 String String
     * @return  AppException
     * @throws AppException <br>
     */ 
    public static AppException publish(String errorCode, String msg, int errorType, Throwable t, String param1, String param2, String param3)
        throws AppException {
        AppException AppException = null;
        if (t instanceof AppException) {
            AppException = (AppException) t;
        }
        else if (t instanceof InvocationTargetException) {
            Throwable cause = t.getCause();
            if (cause instanceof AppException) {
                AppException = (AppException) cause;
            }

        }
        throw AppException;
    }

    /**
     * Description: <br> 
     *  
     * @author shen.zhi<br>
     * @taskId <br>
     * @param m String
     * @param ex Throwable<br>
     */ 
    public static void logErrorInfo(String m, Throwable ex) {
        increaseAppExceptionCount();
        logger.error(m, ex);
    }
}