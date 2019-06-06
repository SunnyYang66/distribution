package com.boyuanitsm.pay;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.InputStreamReader;

import org.mfoyou.agent.utils.common.Logger;

/**
 * Payment of the properties. Read classloader folder pay.yml file.
 * PayProperties.getInstance() to use it.
 *
 * @author hookszhang on 7/7/16.
 */
public class PayProperties {

    private static Logger log = Logger.getLogger(PayProperties.class);

    private PayProperties() {
    }

    private static PayProperties instance;

    private WeChat wechat;

    private Ali ali;

    private UnionPay unionpay;

    static {
        try {
            YamlReader reader = new YamlReader(new InputStreamReader(PayProperties.class.getClassLoader().getResourceAsStream("pay.yml")));
            PayProperties.instance = reader.read(PayProperties.class);
            reader.close();
        } catch (Exception e) {
            log.error("Load pay.yml error!", e);
        }
    }

    /**
     * Alipay properties
     */
    public static class Ali {

        private String partner;
        private String sellerId;
        private String privateKey;
        private String alipayPublicKey;
        private String notifyUrl;
        private String returnUrl;
        private String signType;
        private String logPath;
        private String inputCharset;
        private String antiPhishingKey;
        private String exterInvokeIp;

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        public String getAlipayPublicKey() {
            return alipayPublicKey;
        }

        public void setAlipayPublicKey(String alipayPublicKey) {
            this.alipayPublicKey = alipayPublicKey;
        }

        public String getNotifyUrl() {
            return notifyUrl;
        }

        public void setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
        }

        public String getReturnUrl() {
            return returnUrl;
        }

        public void setReturnUrl(String returnUrl) {
            this.returnUrl = returnUrl;
        }

        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }

        public String getLogPath() {
            return logPath;
        }

        public void setLogPath(String logPath) {
            this.logPath = logPath;
        }

        public String getInputCharset() {
            return inputCharset;
        }

        public void setInputCharset(String inputCharset) {
            this.inputCharset = inputCharset;
        }

        public String getAntiPhishingKey() {
            return antiPhishingKey;
        }

        public void setAntiPhishingKey(String antiPhishingKey) {
            this.antiPhishingKey = antiPhishingKey;
        }

        public String getExterInvokeIp() {
            return exterInvokeIp;
        }

        public void setExterInvokeIp(String exterInvokeIp) {
            this.exterInvokeIp = exterInvokeIp;
        }
    }

    /**
     * Wxpay properties
     */
    public static class WeChat {

        private String key_h5;
        private String appid_h5;
        private String mchid_h5;
        private String appid_wxxcx;
        private String appid_wxxcx_custom;
        private String submchid_h5;
        private String certLocalPath_h5;
        private String certPassword_h5;
        private String key_app;
        private String appid_app;
        private String mchid_app;
        private String submchid_app;
        private String certLocalPath_app;
        private String certPassword_app;
        private String useThreadToDoReport;
        private String ip;
        private String notifyUrl_h5;
        private String notifyUrl_app;

        public String getNotifyUrl_h5() {
			return notifyUrl_h5;
		}

		public void setNotifyUrl_h5(String notifyUrl_h5) {
			this.notifyUrl_h5 = notifyUrl_h5;
		}

		public String getNotifyUrl_app() {
			return notifyUrl_app;
		}

		public void setNotifyUrl_app(String notifyUrl_app) {
			this.notifyUrl_app = notifyUrl_app;
		}

        public String getKey_h5() {
			return key_h5;
		}

		public void setKey_h5(String key_h5) {
			this.key_h5 = key_h5;
		}

		public String getAppid_h5() {
			return appid_h5;
		}
		
		public void setAppid_h5(String appid_h5) {
			this.appid_h5 = appid_h5;
		}

		public String getMchid_h5() {
			return mchid_h5;
		}

		public void setMchid_h5(String mchid_h5) {
			this.mchid_h5 = mchid_h5;
		}

		public String getSubmchid_h5() {
			return submchid_h5;
		}

		public void setSubmchid_h5(String submchid_h5) {
			this.submchid_h5 = submchid_h5;
		}

		public String getCertLocalPath_h5() {
			return certLocalPath_h5;
		}

		public void setCertLocalPath_h5(String certLocalPath_h5) {
			this.certLocalPath_h5 = certLocalPath_h5;
		}

		public String getCertPassword_h5() {
			return certPassword_h5;
		}

		public void setCertPassword_h5(String certPassword_h5) {
			this.certPassword_h5 = certPassword_h5;
		}

		public String getKey_app() {
			return key_app;
		}

		public void setKey_app(String key_app) {
			this.key_app = key_app;
		}

		public String getAppid_app() {
			return appid_app;
		}

		public void setAppid_app(String appid_app) {
			this.appid_app = appid_app;
		}

		public String getMchid_app() {
			return mchid_app;
		}

		public void setMchid_app(String mchid_app) {
			this.mchid_app = mchid_app;
		}

		public String getSubmchid_app() {
			return submchid_app;
		}

		public void setSubmchid_app(String submchid_app) {
			this.submchid_app = submchid_app;
		}

		public String getCertLocalPath_app() {
			return certLocalPath_app;
		}

		public void setCertLocalPath_app(String certLocalPath_app) {
			this.certLocalPath_app = certLocalPath_app;
		}

		public String getCertPassword_app() {
			return certPassword_app;
		}

		public void setCertPassword_app(String certPassword_app) {
			this.certPassword_app = certPassword_app;
		}

		public String getUseThreadToDoReport() {
			return useThreadToDoReport;
		}

		public void setUseThreadToDoReport(String useThreadToDoReport) {
			this.useThreadToDoReport = useThreadToDoReport;
		}

		public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

		public String getAppid_wxxcx() {
			return appid_wxxcx;
		}

		public void setAppid_wxxcx(String appid_wxxcx) {
			this.appid_wxxcx = appid_wxxcx;
		}

		public String getAppid_wxxcx_custom() {
			return appid_wxxcx_custom;
		}

		public void setAppid_wxxcx_custom(String appid_wxxcx_custom) {
			this.appid_wxxcx_custom = appid_wxxcx_custom;
		}
    }

    /**
     * UnionPay properties
     */
    public static class UnionPay {

        private String merId;
        private String trId;
        private String frontUrl;
        private String backUrl;
        private String frontTransUrl;
        private String backTransUrl;
        private String singleQueryUrl;
        private String batchTransUrl;
        private String fileTransUrl;
        private String appTransUrl;
        private String cardTransUrl;
        private String jfFrontTransUrl;
        private String jfBackTransUrl;
        private String jfSingleQueryUrl;
        private String jfCardTransUrl;
        private String jfAppTransUrl;
        private String signCertPath;
        private String signCertPwd;
        private String signCertType;
        private String validateCertDir;
        private String singleMode;
        private String encryptCertPath;

        public String getMerId() {
            return merId;
        }

        public void setMerId(String merId) {
            this.merId = merId;
        }

        public String getTrId() {
            return trId;
        }

        public void setTrId(String trId) {
            this.trId = trId;
        }

        public String getFrontUrl() {
            return frontUrl;
        }

        public void setFrontUrl(String frontUrl) {
            this.frontUrl = frontUrl;
        }

        public String getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
        }

        public String getEncryptCertPath() {
            return encryptCertPath;
        }

        public void setEncryptCertPath(String encryptCertPath) {
            this.encryptCertPath = encryptCertPath;
        }

        public String getFrontTransUrl() {
            return frontTransUrl;
        }

        public void setFrontTransUrl(String frontTransUrl) {
            this.frontTransUrl = frontTransUrl;
        }

        public String getBackTransUrl() {
            return backTransUrl;
        }

        public void setBackTransUrl(String backTransUrl) {
            this.backTransUrl = backTransUrl;
        }

        public String getSingleQueryUrl() {
            return singleQueryUrl;
        }

        public void setSingleQueryUrl(String singleQueryUrl) {
            this.singleQueryUrl = singleQueryUrl;
        }

        public String getBatchTransUrl() {
            return batchTransUrl;
        }

        public void setBatchTransUrl(String batchTransUrl) {
            this.batchTransUrl = batchTransUrl;
        }

        public String getFileTransUrl() {
            return fileTransUrl;
        }

        public void setFileTransUrl(String fileTransUrl) {
            this.fileTransUrl = fileTransUrl;
        }

        public String getAppTransUrl() {
            return appTransUrl;
        }

        public void setAppTransUrl(String appTransUrl) {
            this.appTransUrl = appTransUrl;
        }

        public String getCardTransUrl() {
            return cardTransUrl;
        }

        public void setCardTransUrl(String cardTransUrl) {
            this.cardTransUrl = cardTransUrl;
        }

        public String getJfFrontTransUrl() {
            return jfFrontTransUrl;
        }

        public void setJfFrontTransUrl(String jfFrontTransUrl) {
            this.jfFrontTransUrl = jfFrontTransUrl;
        }

        public String getJfBackTransUrl() {
            return jfBackTransUrl;
        }

        public void setJfBackTransUrl(String jfBackTransUrl) {
            this.jfBackTransUrl = jfBackTransUrl;
        }

        public String getJfSingleQueryUrl() {
            return jfSingleQueryUrl;
        }

        public void setJfSingleQueryUrl(String jfSingleQueryUrl) {
            this.jfSingleQueryUrl = jfSingleQueryUrl;
        }

        public String getJfCardTransUrl() {
            return jfCardTransUrl;
        }

        public void setJfCardTransUrl(String jfCardTransUrl) {
            this.jfCardTransUrl = jfCardTransUrl;
        }

        public String getJfAppTransUrl() {
            return jfAppTransUrl;
        }

        public void setJfAppTransUrl(String jfAppTransUrl) {
            this.jfAppTransUrl = jfAppTransUrl;
        }

        public String getSignCertPath() {
            return signCertPath;
        }

        public void setSignCertPath(String signCertPath) {
            this.signCertPath = signCertPath;
        }

        public String getSignCertPwd() {
            return signCertPwd;
        }

        public void setSignCertPwd(String signCertPwd) {
            this.signCertPwd = signCertPwd;
        }

        public String getSignCertType() {
            return signCertType;
        }

        public void setSignCertType(String signCertType) {
            this.signCertType = signCertType;
        }

        public String getValidateCertDir() {
            return validateCertDir;
        }

        public void setValidateCertDir(String validateCertDir) {
            this.validateCertDir = validateCertDir;
        }

        public String getSingleMode() {
            return singleMode;
        }

        public void setSingleMode(String singleMode) {
            this.singleMode = singleMode;
        }

        @Override
        public String toString() {
            return "UnionPay{" +
                    "merId='" + merId + '\'' +
                    ", trId='" + trId + '\'' +
                    ", frontUrl='" + frontUrl + '\'' +
                    ", backUrl='" + backUrl + '\'' +
                    ", frontTransUrl='" + frontTransUrl + '\'' +
                    ", backTransUrl='" + backTransUrl + '\'' +
                    ", singleQueryUrl='" + singleQueryUrl + '\'' +
                    ", batchTransUrl='" + batchTransUrl + '\'' +
                    ", fileTransUrl='" + fileTransUrl + '\'' +
                    ", appTransUrl='" + appTransUrl + '\'' +
                    ", cardTransUrl='" + cardTransUrl + '\'' +
                    ", jfFrontTransUrl='" + jfFrontTransUrl + '\'' +
                    ", jfBackTransUrl='" + jfBackTransUrl + '\'' +
                    ", jfSingleQueryUrl='" + jfSingleQueryUrl + '\'' +
                    ", jfCardTransUrl='" + jfCardTransUrl + '\'' +
                    ", jfAppTransUrl='" + jfAppTransUrl + '\'' +
                    ", signCertPath='" + signCertPath + '\'' +
                    ", signCertPwd='" + signCertPwd + '\'' +
                    ", signCertType='" + signCertType + '\'' +
                    ", validateCertDir='" + validateCertDir + '\'' +
                    ", singleMode='" + singleMode + '\'' +
                    ", encryptCertPath='" + encryptCertPath + '\'' +
                    '}';
        }
    }

    public Ali getAli() {
        return ali;
    }

    public void setAli(Ali ali) {
        this.ali = ali;
    }

    public WeChat getWechat() {
        return wechat;
    }

    public void setWechat(WeChat wechat) {
        this.wechat = wechat;
    }

    public static PayProperties getInstance() {
        return instance;
    }

    public UnionPay getUnionpay() {
        return unionpay;
    }

    public void setUnionpay(UnionPay unionpay) {
        this.unionpay = unionpay;
    }
}
