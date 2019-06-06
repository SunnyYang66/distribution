package org.mfoyou.agent.utils.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class StrUtil {

    private static final Logger LOGGER = Logger.getLogger(StrUtil.class);

    /**
     * 把搜索关键词的中文乱码
     * @param word
     * @return
     */
    public static String decodeURLWord(String word) {
        try {
            return new String(word.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(String.format("转换字符串编码出错,decodeURLWord(word=%s)", word), e);
        }

        return word;
    }

    public static String encodeURLWord(String word) {
        try {
            return URLEncoder.encode(word, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(String.format("转换字符串编码出错,encodeURLWord(word=%s)", word), e);
        }

        return word;
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

    /**
     * 验证邮箱地址是否合法
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static String toJSON(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Throwable e) {
            LOGGER.error(String.format("对象转json出错,toJSON(object=%s)", object), e);
        }
        return "";
    }

    public static <T> T toObject(String json, Class<T> tClass) {
        if (StringUtils.isBlank(json) || tClass == null) {
            return null;
        }

        try {
            return new ObjectMapper().readValue(json, tClass);
        } catch (Throwable e) {
            LOGGER.error(String.format("json转对象出错,toObject(json=%s,tClass=%s)", json, tClass), e);
        }

        return null;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    public static Integer parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer parseInteger(Object s) {
        try {
            if(s==null)return null;
            return Integer.parseInt(s.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static Long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Float parseFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double parseDouble(Object s) {
        try {
            if (s instanceof Double) {
                return (Double) s;
            }
            return Double.parseDouble(s.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseDate(String s) {
        try {
            return DateUtils.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static String fen2yuan(Integer fen) {
        if (fen == null)
            return "0";
        if (fen % 100 == 0) {
            return "" + (fen / 100);
        }
        int yuan = fen / 100;
        int jiao = fen / 10 - yuan * 10;
        fen = fen % 10;

        return "" + yuan + "." + jiao + fen;
    }

    public static String getCenterStar(String content) {
        if (content == null)
            return content;
        int len = content.length();
        int begin = len / 4;
        int end = len * 3 / 4;
        return getStarString(content, begin, end);
    }

    /* 
    ** 
    * 对字符串处理:将指定位置到指定位置的字符以星号代替 
    *  
    * @param content 
    *            传入的字符串 
    * @param begin 
    *            开始位置 
    * @param end 
    *            结束位置 
    * @return 
    */
    public static String getStarString(String content, int begin, int end) {

        if (begin >= content.length() || begin < 0) {
            return content;
        }
        if (end >= content.length() || end < 0) {
            return content;
        }
        if (begin >= end) {
            return content;
        }
        String starStr = "";
        for (int i = begin; i < end; i++) {
            starStr = starStr + "*";
        }
        return content.substring(0, begin) + starStr + content.substring(end, content.length());

    }

    /** 
    * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替 
    *  
    * @param content 
    *            传入的字符串 
    * @param frontNum 
    *            保留前面字符的位数 
    * @param endNum 
    *            保留后面字符的位数 
    * @return 带星号的字符串 
    */

    public static String getStarString2(String content, int frontNum, int endNum) {

        if (frontNum >= content.length() || frontNum < 0) {
            return content;
        }
        if (endNum >= content.length() || endNum < 0) {
            return content;
        }
        if (frontNum + endNum >= content.length()) {
            return content;
        }
        String starStr = "";
        for (int i = 0; i < (content.length() - frontNum - endNum); i++) {
            starStr = starStr + "*";
        }
        return content.substring(0, frontNum) + starStr + content.substring(content.length() - endNum, content.length());

    }

    public static Boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
    * 剔除数字
    * @param value
    */
    public static String removeDigital(String value) {
        if (value == null)
            return value;
        Pattern p = Pattern.compile("[\\d]");
        Matcher matcher = p.matcher(value);
        String result = matcher.replaceAll("");
        return result;
    }

    /**
    * 剔除字母
    * @param value
    */
    public static String removeLetter(String value) {
        if (value == null)
            return value;
        Pattern p = Pattern.compile("[a-zA-z]");
        Matcher matcher = p.matcher(value);
        String result = matcher.replaceAll("");
        return result;
    }

    /**
    * 替换
    * @param value
    * @param replacement
    */
    public static String replaceLetter(String value, String replaceParam) {
        if (value == null)
            return value;
        Pattern p = Pattern.compile("[a-zA-z]");
        Matcher matcher = p.matcher(value);
        String result = matcher.replaceAll(replaceParam);
        return result;
    }

    /**
     * 替换数字
     * @param value
     * @param replacement
     */
    public static String replaceDigital(String value, String replaceParam) {
        if (value == null)
            return value;
        Pattern p = Pattern.compile("[\\d]");
        Matcher matcher = p.matcher(value);
        String result = matcher.replaceAll(replaceParam);
        return result;
    }

    public static String filterEmoji(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("*");
                return source;
            }
            return source;
        }
        return source;
    }
    /** 
     * 检测是否有emoji字符 
     * 
     * @param source 
     * @return 一旦含有就抛出 
     */  
    public static boolean containsEmoji(String source) {  
        if (StringUtils.isBlank(source)) {  
            return false;  
        }  
        int len = source.length();  
        for (int i = 0; i < len; i++) {  
            char codePoint = source.charAt(i);  
            if (!isNotEmojiCharacter(codePoint)) {  
                //判断到了这里表明，确认有表情字符  
                return true;  
            }  
        }  
        return false;  
    }  
  
    /** 
     * 判断是否为非Emoji字符 
     * 
     * @param codePoint 比较的单个字符 
     * @return 
     */  
    private static boolean isNotEmojiCharacter(char codePoint) {  
        return (codePoint == 0x0) ||  
                (codePoint == 0x9) ||  
                (codePoint == 0xA) ||  
                (codePoint == 0xD) ||  
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||  
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||  
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));  
    }  
  
    /** 
     * 过滤emoji 或者 其他非文字类型的字符 
     * 
     * @param source 
     * @return 
     */  
    public static String filterEmojiEx(String source) {  
        if (StringUtils.isBlank(source)) {  
            return source;  
        }  
        if (!containsEmoji(source)) {  
            return source;//如果不包含，直接返回  
        }  
        StringBuilder buf = new StringBuilder();  
        int len = source.length();  
        for (int i = 0; i < len; i++) {  
            char codePoint = source.charAt(i);  
            if (isNotEmojiCharacter(codePoint)) {  
                buf.append(codePoint);  
            }  
        }  
  
        return buf.toString().trim();  
    }  
 

    public static void main(String[] args) {
//        System.out.println(replaceDigital("1大家好222222订单33333", "*"));
//        System.out.println(filterEmojiEx("Rosé"));
    	System.out.println(isInteger("1523967300000"));
    }
}
