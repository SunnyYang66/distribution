package org.mfoyou.agent.utils.common;


import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class JsonRet<T> implements Serializable {

    private static final long serialVersionUID = -5515998627762098591L;
    private static Logger logger = LoggerFactory.getLogger(JsonRet.class);

    private int status = 0;
    private String message = "";
    private T data;

    public JsonRet() {
    }
    public static <T> JsonRet<T> buildRet(int errorCode){
        String message = ErrorMessage.getCommonError(errorCode);
        JsonRet<T> ret = new JsonRet<T>();
        ret.setStatus(errorCode);
        ret.setMessage(message);
        ret.setData(null);
        logger.info(JSON.toJSONString(ret));
        return ret;
     }
    public static <T> JsonRet<T> buildRet(int errorCode,T data){
       String message = ErrorMessage.getCommonError(errorCode);
       JsonRet<T> ret = new JsonRet<T>();
       ret.setStatus(errorCode);
       ret.setMessage(message);
       ret.setData(data);
       logger.info(JSON.toJSONString(ret));
       return ret;
    }

    public static <T> JsonRet<T> buildSuccRet(T data){
        JsonRet<T> ret = new JsonRet<T>();
        ret.setStatus(0);
        ret.setMessage("OK");
        ret.setData(data);
        logger.info(JSON.toJSONString(ret));
        return ret;
    }

    public static <T> JsonRet<T> buildFailRet(String errmsg){
        JsonRet<T> ret = new JsonRet<T>();
        ret.setStatus(1);
        ret.setMessage(errmsg);
        ret.setData(null);
        logger.info(JSON.toJSONString(ret));
        return ret;
    }

    public static <T> JsonRet<T> buildFailRet(String errmsg,T data){
        JsonRet<T> ret = new JsonRet<T>();
        ret.setStatus(1);
        ret.setMessage(errmsg);
        ret.setData(data);
        logger.info(JSON.toJSONString(ret));
        return ret;
    }

    public static void main(String[] args){
        System.out.println(JsonRet.buildFailRet("test"));
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonRet{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
