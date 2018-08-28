/**
 * 
 */
package com.eric.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.eric.common.dto.HttpQueryResponse;
import com.eric.common.dto.HttpResponse;

/**
 * @author Eric
 * 
 */
public class HttpClientUtil {

    private final static Log log = LogFactory.getLog(HttpClientUtil.class);

	/**
	 * 
	 * @param requestURL
	 * @param contentType
	 * @return
	 */
	public static HttpQueryResponse doPost(String requestURL, String contentType) {
		HttpQueryResponse response = new HttpQueryResponse();

		// 执行postMethod
		PostMethod postMethod = null;

		// 最后的结果
		StringBuffer responseSb = null;

		BufferedReader reader = null;

		HttpClient httpClient = new HttpClient();

		HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();

		managerParams.setConnectionTimeout(100000);// 设置连接超时时间(单位毫秒)

		managerParams.setSoTimeout(100000);// 设置读数据超时时间(单位毫秒)

		try {
			postMethod = new PostMethod(requestURL);

			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(5, false));

			postMethod.setRequestHeader("Content-type", contentType);

			int statusCode = httpClient.executeMethod(postMethod);

			if (statusCode != HttpStatus.SC_OK) {
				log.error(requestURL);
				throw new IllegalStateException("PostMethod failed: " + postMethod.getStatusLine());
			}

			reader = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(), "UTF-8"));

			String line = null;

			responseSb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				responseSb.append(line).append(System.getProperty("line.separator"));
			}

		} catch (HttpException e) {
			response.setTimeOut(true);
			log.error("调用接口HTTP异常", e);
		} catch (IOException e) {
			response.setTimeOut(true);
			log.error("调用接口IO异常", e);
		} catch (Exception e) {
			response.setTimeOut(true);
			log.error("调用接口异常", e);
		} finally {

			response.setResponseStr(null != responseSb ? responseSb.toString() : "");

			// 释放链接
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				log.error("关闭流异常", e);
			}

			if (null != postMethod) {
				postMethod.releaseConnection();
			}

		}

		return response;
	}

	/**
	 * 没有请求参数，直接将内容print到服务端
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String postString(String urlStr, String request) throws Exception {
		return postString(urlStr, request, "text/html;charset=UTF-8", 10000, 10000);
	}

	private static class TrustAllTrustManager implements X509TrustManager {

	public X509Certificate[] getAcceptedIssuers() {
	    return null;
	}

	public void checkClientTrusted(javax.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
	}

	public void checkServerTrusted(javax.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
	}

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
	    // TODO Auto-generated method stub

	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
	    // TODO Auto-generated method stub

	}
    }

	/**
	 * 没有请求参数，直接将内容print到服务端
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String postString(String urlStr, String request, String contentType, int connectTimeOut, int readTimeOut) throws Exception {
		URL url = new URL(urlStr);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();// 建立针对该URL的连接

		if (con instanceof HttpsURLConnection) {
			try {
				SSLContext localSSLContext = SSLContext.getInstance("TLS");
				localSSLContext.init(null, new TrustManager[] { new TrustAllTrustManager() }, new SecureRandom());
				((HttpsURLConnection) con).setSSLSocketFactory(localSSLContext.getSocketFactory());
				((HttpsURLConnection) con).setHostnameVerifier(new HostnameVerifier() {

					public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession) {
						return true;
					}
				});
			} catch (Exception localException) {
				throw new IOException(localException);
			}
		}

		con.setRequestMethod("POST");
		con.setUseCaches(false); // 不使用缓存
		con.setDoInput(true); // 允许输入
		con.setDoOutput(true); // 允许输出
		con.setRequestProperty("Content-Type", contentType);
		con.setConnectTimeout(connectTimeOut);
		con.setReadTimeout(readTimeOut);
		con.connect();

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
		out.write(request);
		out.flush();
		out.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String line = null;

		StringBuffer responseSb = new StringBuffer();

		while ((line = in.readLine()) != null) {
			responseSb.append(line).append(System.getProperty("line.separator"));
		}
		in.close();

		return responseSb.toString();
	}

    /**
     * 
     * <p>
     * 
     * 
     * 
     * </p>
     * 
     * @param url
     * @return
     * 
     * @author liuyunquan
     * @date 2016年7月28日 下午8:31:06
     * @version
     */
    public static HttpResponse doGet(String url) {
	return doGet(url, 15000, 15000);
    }

    public static HttpResponse doPost(String url, Map<String, String> params) {
	return doPost(url, params, 15000, 15000);
    }

    /**
     * 
     * <p>
     * 
     * 
     * 
     * </p>
     * 
     * @param url
     * @param connectTimeout 请求超时（毫秒）
     * @param socketTimeout 响应超时（毫秒）
     * @return
     * 
     * @author liuyunquan
     * @date 2016年7月28日 下午8:31:13
     * @version
     */

    public static HttpResponse doGet(String url, int connectTimeout, int socketTimeout) {
	return doGet(url, "text/html;charset=utf-8", connectTimeout, socketTimeout);
    }

    public static HttpResponse doPost(String url, Map<String, String> params, int connectTimeout, int socketTimeout) {
	return doPost(url, params, "text/html;charset=utf-8", connectTimeout, socketTimeout);
    }

    public static HttpResponse doPost(String url, String data, int connectTimeout, int socketTimeout) {
	return doPost(url, data, "text/html;charset=utf-8", connectTimeout, socketTimeout);
    }

	public static HttpResponse doGet(String url, String contentType, int connectTimeout, int socketTimeout) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout)
				.build();
		request.setConfig(config);
		return sendRequest(httpClient, request, contentType);
	}
    
	public static HttpResponse doGet(String url, Map<String, String> headerParams, String contentType,
			int connectTimeout, int socketTimeout) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		if (headerParams != null) {
			Set<String> keySet = headerParams.keySet();
			for (String key : keySet) {
				request.setHeader(key, headerParams.get(key));
			}
		}
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout)
				.build();
		request.setConfig(config);
		return sendRequest(httpClient, request, contentType);
	}

	public static HttpResponse doPost(String url, Map<String, String> params, String contentType, int connectTimeout, int socketTimeout) {
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost(url);
	RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
	httpPost.setConfig(config);
	List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	Set<String> keySet = params.keySet();
	for (String key : keySet) {
	    parameters.add(new BasicNameValuePair(key, params.get(key)));
	}
	HttpEntity entity = null;
	try {
	    entity = new UrlEncodedFormEntity(parameters, "utf-8");
	} catch (UnsupportedEncodingException e) {
	    log.error("htttp EncodingException .url:" + url, e);
	}
	httpPost.setEntity(entity);
	return sendRequest(httpClient, httpPost, contentType);
    }
    
    public static HttpResponse doPost(String url, Map<String, String> params, Map<String, String> headerParams, String contentType, int connectTimeout, int socketTimeout) {
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	HttpPost httpPost = new HttpPost(url);
    	if(headerParams != null){
    		Set<String> keySet = headerParams.keySet();
    		for (String key : keySet) {
    			httpPost.setHeader(key, headerParams.get(key));
    		}	
    	}
    	RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
    	httpPost.setConfig(config);
    	List<NameValuePair> parameters = new ArrayList<NameValuePair>();
    	Set<String> keySet = params.keySet();
    	for (String key : keySet) {
    	    parameters.add(new BasicNameValuePair(key, params.get(key)));
    	}
    	HttpEntity entity = null;
    	try {
    	    entity = new UrlEncodedFormEntity(parameters, "utf-8");
    	} catch (UnsupportedEncodingException e) {
    	    log.error("htttp EncodingException .url:" + url, e);
    	}
    	httpPost.setEntity(entity);
    	return sendRequest(httpClient, httpPost, contentType);
    }
    
    public static HttpResponse doPost(String url, String data, Map<String, String> headerParams, String contentType, int connectTimeout, int socketTimeout) {
    	CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		if (headerParams != null) {
			Set<String> keySet = headerParams.keySet();
			for (String key : keySet) {
				httpPost.setHeader(key, headerParams.get(key));
			}
		}
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
		httpPost.setConfig(config);
		HttpEntity entity = new StringEntity(data, "utf-8");
		httpPost.setEntity(entity);
		return sendRequest(httpClient, httpPost, contentType);
    }

	public static HttpResponse doPost(String url, String data, String contentType, int connectTimeout, int socketTimeout) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
		httpPost.setConfig(config);
		HttpEntity entity = new StringEntity(data, "utf-8");
		httpPost.setEntity(entity);
		return sendRequest(httpClient, httpPost, contentType);
	}

	private static HttpResponse sendRequest(CloseableHttpClient httpClient, HttpUriRequest request,
			String contentType) {
		HttpResponse queryResponse = new HttpResponse();
		String content = null;
		CloseableHttpResponse response = null;
		try {
			request.setHeader("Content-Type", contentType);
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, "utf-8");
			queryResponse.setContent(content);
			queryResponse.setStatus(HttpResponse.STATUS.SUCCESS);
		} catch (ClientProtocolException e) {
			queryResponse.setStatus(HttpResponse.STATUS.CONNECT_TIME_OUT);
			log.error("http request error.uri:" + request.getURI(), e);
		} catch (ConnectTimeoutException e) {
			queryResponse.setStatus(HttpResponse.STATUS.CONNECT_TIME_OUT);
			log.error("http request connect time out.uri:" + request.getURI(), e);
		} catch (SocketTimeoutException e) {
			queryResponse.setStatus(HttpResponse.STATUS.READ_TIME_OUT);
			log.error("http request socket time out.uri:" + request.getURI(), e);
		} catch (Exception e) {
			queryResponse.setStatus(HttpResponse.STATUS.SYSTEM_ERROR);
			log.error("http request error.uri:" + request.getURI(), e);
		} finally {
			try {
				if (response != null)
					response.close();
			} catch (IOException e) {
			}
			try {
				if (httpClient != null)
					httpClient.close();
			} catch (IOException e) {
			}
		}
		return queryResponse;
	}

}
