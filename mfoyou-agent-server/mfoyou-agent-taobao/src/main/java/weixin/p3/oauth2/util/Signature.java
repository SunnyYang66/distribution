package weixin.p3.oauth2.util;



import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.mfoyou.agent.utils.common.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants.SignType;
import com.github.wxpay.sdk.WXPayUtil;

/**
 * WeChat scan pay signature algorithm
 *
 * @author rizenguo hookszhang
 */
public class Signature {

    private static Logger log = Logger.getLogger(Signature.class);

    /**
     * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
     *
     * @param responseString API返回的XML数据字符串
     * @return API签名是否合法
     * @throws Exception 
     */
    public static boolean checkIsSignValidFromResponseString(String responseString,WXPayConfig config) throws Exception {

        Map<String, String> map = getMapFromXML(responseString);
        log.info(map.toString());

        String signFromAPIResponse = map.get("sign").toString();
        if (signFromAPIResponse == null || signFromAPIResponse.isEmpty()) {
            log.warn("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        // Util.log("服务器回包里面的签名是:" + signFromAPIResponse);
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        //map.put("sign", "");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String signForAPIResponse =  WXPayUtil.generateSignature(map, config.getKey(), SignType.HMACSHA256);//Signature.getSign(map,config);

        if (!signForAPIResponse.equals(signFromAPIResponse)) {
            //签名验不过，表示这个API返回的数据有可能已经被篡改了
            log.warn("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
            log.info("input="+signFromAPIResponse+" new="+signForAPIResponse);
            return false;
        }
        // Util.log("恭喜，API返回的数据签名验证通过!!!");
        return true;
    }
    
    public static Map<String, String> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = Util.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, String> map = new HashMap<String, String>();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
                map.put(node.getNodeName(), node.getNodeValue());
            }
            i++;
        }
        return map;

    }




}
