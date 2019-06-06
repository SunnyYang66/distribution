package com.mfoyou.agent.web.utils.wx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.mfoyou.agent.utils.common.Logger;

import com.boyuanitsm.pay.wxpay.common.HttpsRequest;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class HttpRequest {
	public interface ResultListener {
		public void onConnectionPoolTimeoutError();
	}

	private static Logger log = Logger.getLogger(HttpsRequest.class);

////	// 表示请求器是否已经做了初始化工作
//	private boolean hasInit = false;

	// 连接超时时间，默认10秒
	private int socketTimeout = 10000;

	// 传输超时时间，默认30秒
	private int connectTimeout = 30000;

	// 请求器的配置
	private RequestConfig requestConfig;

	// HTTP请求器
	private CloseableHttpClient httpClient;
	
//	private String pathName;

	public HttpRequest(String pathName,String passwd) {
//		this.pathName = pathName;
		try {
			init(pathName,passwd);
		} catch (UnrecoverableKeyException e) {
			
			e.printStackTrace();
		} catch (KeyManagementException e) {
			
			e.printStackTrace();
		} catch (KeyStoreException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	private void init(String pathName,String passwd) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException,
			KeyManagementException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(
				new File(pathName));// 加载本地的证书进行https加密传输
		try {
			keyStore.load(instream, passwd.toCharArray());// 设置证书密码
		} catch (Exception e) {
			e.printStackTrace();
			log.error("", e);
		} finally {
			instream.close();
		}
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, passwd.toCharArray()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
				null, new DefaultHostnameVerifier());

		httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();

		// 根据默认超时限制初始化requestConfig
		this.requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();

//		hasInit = true;
	}

	/**
	 * 通过Https往API post xml数据
	 *
	 * @param url
	 *            API地址
	 * @param xmlObj
	 *            要提交的XML数据对象
	 * @return API回包的实际数据
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	
	public String sendPost(String url, Object xmlObj) throws IOException, KeyStoreException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyManagementException {
		
//		if (!hasInit) {
//			init(pathName);
//		}

		String result = null;

		HttpPost httpPost = new HttpPost(url);

		// 解决XStream对出现双下划线的bug
		XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

		// 将要提交给API的数据对象转换成XML格式数据Post给API
		String postDataXML = xStreamForRequestPostData.toXML(xmlObj);

		log.debug("API，POST过去的数据是：");
		log.debug(postDataXML);

		// 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
		StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);

		// 设置请求器的配置
		httpPost.setConfig(requestConfig);

		log.info("executing request" + httpPost.getRequestLine());

		try {
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

		} catch (ConnectionPoolTimeoutException e) {
			log.error("http get throw ConnectionPoolTimeoutException(wait time out)");

		} catch (ConnectTimeoutException e) {
			log.error("http get throw ConnectTimeoutException");

		} catch (SocketTimeoutException e) {
			log.error("http get throw SocketTimeoutException");

		} catch (Exception e) {
			log.error("http get throw Exception");

		} finally {
			httpPost.abort();
		}
//		try {
//			if (Configure.DOWNLOAD_BILL_API.equals(url)) {
//				// 下载对账单接口 无需验证签名
//				return result;
//			}
//			boolean isSign = Signature.checkIsSignValidFromResponseString(result);
//			if (!isSign) {
//				log.warn("Validate sign fail: " + result);
//				return null;
//			}
//		} catch (Exception e) {
//			log.warn("Validate sign Error: " + result, e);
//			return null;
//		}
		return result;
	}

	/**
	 * 设置连接超时时间
	 *
	 * @param socketTimeout
	 *            连接时长，默认10秒
	 */
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
		resetRequestConfig();
	}

	/**
	 * 设置传输超时时间
	 *
	 * @param connectTimeout
	 *            传输时长，默认30秒
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
		resetRequestConfig();
	}

	private void resetRequestConfig() {
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
				.build();
	}

	/**
	 * 允许商户自己做更高级更复杂的请求器配置
	 *
	 * @param requestConfig
	 *            设置HttpsRequest的请求器配置
	 */
	public void setRequestConfig(RequestConfig requestConfig) {
		this.requestConfig = requestConfig;
	}
}
