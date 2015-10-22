package cn.lovefish.util;

/**
 *
 * @Description: 响应体为空异常 
 * @since
 * @version 1.0
 */
public class HttpEntityNullException extends Exception {

	private static final long serialVersionUID = -4271047424364284692L;
	
	public HttpEntityNullException() {
		super();
	}
	
	public HttpEntityNullException(String message) {
		super(message);
	}

}
