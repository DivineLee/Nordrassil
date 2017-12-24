package pro.zhantss.log.api;

import org.slf4j.LoggerFactory;

public class Logger {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
				
	public static void info(String msg, Object... params) {
		logger.info(Log.log(LogStatus.INFO, msg, params).toString());
	}
	
	public static void warn(String msg, Object... params) {
		logger.info(Log.log(LogStatus.WARN, msg, params).toString());
	}
	
	public static void warn(String msg, Throwable throwable, Object... params) {
		logger.info(Log.log(LogStatus.WARN, msg, throwable, params).toString());
	}
	
	public static void error(String msg, Throwable throwable, Object... params) {
		logger.info(Log.log(LogStatus.ERROR, msg, throwable, params).toString());
	}
	
	public static void debug(String msg, Throwable throwable, Object... params) {
		logger.info(Log.log(LogStatus.DEBUG, msg, throwable, params).toString());
	}

}
