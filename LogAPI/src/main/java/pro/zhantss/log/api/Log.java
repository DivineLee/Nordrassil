package pro.zhantss.log.api;

import org.slf4j.helpers.MessageFormatter;

public class Log {
	
	private LogStatus status;
	
	private String msg;
	
	private Throwable throwable;
	
	public static Log log(Throwable throwable) {
		return new Log(throwable);
	}
	
	public static Log log(LogStatus status, String msg) {
		return new Log(status, msg);
	}
	
	public static Log log(LogStatus status, String msg, Object... params) {
		return new Log(status, msg, params);
	}
	
	public static Log log(LogStatus status, String msg, Throwable throwable) {
		return new Log(status, msg, throwable);
	}
	
	public static Log log(LogStatus status, String msg, Throwable throwable, Object... params) {
		return new Log(status, msg, throwable, params);
	}
	
	private Log(Throwable throwable) {
		this.throwable = throwable;
		this.status = LogStatus.ERROR;
		this.msg = throwable.getMessage();
	}
	
	private Log(LogStatus status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	private Log(LogStatus status, String msg, Object... params) {
		this.status = status;
		handlerParams(msg, params);
	}
	
	private Log(LogStatus status, String msg, Throwable throwable) {
		this.status = status;
		this.msg = msg;
		this.throwable = throwable;
	}
	
	private Log(LogStatus status, String msg, Throwable throwable, Object... params) {
		this.status = status;
		this.throwable = throwable;
		handlerParams(msg, params);
	}
	
	private void handlerParams(String msg, Object... params) {
		this.msg = MessageFormatter.arrayFormat(msg, params).getMessage();
	}

	public LogStatus getStatus() {
		return status;
	}

	public void setStatus(LogStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(this.status != null) {
			builder.append("[" + this.status.name() + "]");
		}
		if(this.msg != null) {
			builder.append(this.msg);
		}
		if(this.throwable != null) {
			builder.append(System.lineSeparator());
			builder.append(this.throwable.toString());
		}
		return builder.toString();
	}
	
}
