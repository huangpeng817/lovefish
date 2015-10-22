package cn.lovefish.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpClientUtil {
	
	public static RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(15000).build();
	
	/**
	 * @Description: get方式获取文本信息 
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws HttpStatusErrorException    
	 * @throws 
	 * @version 1.0
	 * @throws HttpEntityNullException 
	 */
	public static String get(String url, Map<String, String> params, Map<String, String> headers, RequestConfig requestConfig) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(createURI(url, params));
		get.setConfig(requestConfig);
		addHeaders(get, headers);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(get);
			StatusLine sl = response.getStatusLine();
			if(sl.getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, "UTF-8");
				} else {
					throw new HttpEntityNullException("response entity is null error, request URL[" + url + "]");
				}
			} else {
				throw new HttpStatusErrorException("response status error：" + sl + ", request URL[" + url + "]");
			}
		} finally {
			IOUtils.closeQuietly(response);
		}
		
	}	
	
	
	public static String get(String url, Map<String, String> params) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		return get(url, params, null, defaultRequestConfig);
	}
	
	public static String get(String url) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		return get(url, null, null, defaultRequestConfig);
	}
	
	public static String get(String url, Map<String, String> params, Map<String, String> headers, int recount) throws Exception {
		Exception exp = null;
		for (int i = 0; i < recount; ++i) {
			try {
				return get(url, params, headers, defaultRequestConfig);
			} catch (Exception e) {
				exp = e;
			}
		}
		throw exp;
	}
	
	public static String get(String url, Map<String, String> params, int recount) throws Exception {
		return get(url, params, null, recount);
	}
	
	public static String get(String url, int recount) throws Exception {
		return get(url, null, null, recount);
	}
	
	/**
	 * @Description: post方式获取文本信息 
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws HttpStatusErrorException    
	 * @throws 
	 * @version 1.0
	 * @throws HttpEntityNullException 
	 */
	public static String post(String url, Map<String, String> params, Map<String, String> headers, RequestConfig requestConfig) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		addHeaders(post, headers);
		CloseableHttpResponse response = null;
		try {
			addPostParams(post, params);
			response = httpClient.execute(post);
			StatusLine sl = response.getStatusLine();
			if(sl.getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, "UTF-8");
				} else {
					throw new HttpEntityNullException("response entity is null error, request URL[" + url + "]");
				}
			} else {
				throw new HttpStatusErrorException("response status error：" + sl + ", request URL[" + url + "]");
			}
		} finally {
			IOUtils.closeQuietly(response);
		}
	}
	
	public static String post(String url, Map<String, String> params) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		return post(url, params, null, defaultRequestConfig);
	}
	
	public static String post(String url, Map<String, String> params, Map<String, String> headers, int recount) throws Exception {
		Exception exp = null;
		for (int i = 0; i < recount; ++i) {
			try {
				return post(url, params, headers, defaultRequestConfig);
			} catch (Exception e) {
				exp = e;
			} 
		}
		throw exp; 
	}
	
	public static String post(String url, Map<String, String> params, int recount) throws Exception {
		return post(url, params, null, recount);
	}
	
	/**
	 * @Description: 添加Post参数
	 * @param post
	 * @param params
	 * @throws UnsupportedEncodingException    
	 * @throws 
	 * @version 1.0
	 */
	public static void addPostParams(HttpPost post, Map<String, String> params) throws UnsupportedEncodingException {
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		if (params != null) {
			for (String key : params.keySet()) {
				formParams.add(new BasicNameValuePair(key, params.get(key)
						.toString()));
			}
		}
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
		post.setEntity(uefEntity);
	}
	
	/**
	 * @Description: 添加头信息 
	 * @param request
	 * @param headers    
	 * @throws 
	 * @version 1.0
	 */
	public static void addHeaders(HttpRequestBase request, Map<String, String> headers) {
		if (headers != null) {
			for (String key : headers.keySet()) {
				request.addHeader(key, headers.get(key));
			}
		}
 	}
	
	/**
	 * @Description: 创建URI 
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException    
	 * @throws 
	 * @version 1.0
	 */
	public static URI createURI(String url, Map<String, String> params) throws URISyntaxException {
		URIBuilder builder = new URIBuilder(url);
		if (params != null) {
			for(String key : params.keySet()) {
				builder.addParameter(key, params.get(key));
			}
		}
		return builder.build();
	}
	
}
