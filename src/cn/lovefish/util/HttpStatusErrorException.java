package cn.lovefish.util;

/**
 *
 * @Description: Http响应状态不符合要求
 * @since
 * @version 1.0
 */
public class HttpStatusErrorException extends Exception {

	private static final long serialVersionUID = 7701947438073791670L;
	
	public HttpStatusErrorException() {
		super();
	}
	
	public HttpStatusErrorException(String message) {
		super(message);
	}

}
