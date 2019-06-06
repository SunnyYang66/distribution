package com.mfoyou.agent.web.intercepter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.mfoyou.agent.web.utils.common.AES;
public class ParameterRequestWrapper extends HttpServletRequestWrapper {
    
    private Map<String , String[]> params = new HashMap<String, String[]>();
//    private static Logger logger = Logger.getLogger(ParameterRequestWrapper.class);

    @SuppressWarnings("unchecked")
	public ParameterRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(request.getParameterMap());
        //不捕获AES解码异常，让上层捕获后把response重定向到错误页
        String companyId = request.getParameter("companyId");
        if (companyId != null && !companyId.equals("")) {
            companyId = AES.decode(companyId);
            if (companyId.equals("")) {
                companyId = null;
            } else {
                params.put("companyId", new String[]{companyId});
            }
        }

    }
    //重载一个构造方法
    public ParameterRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
        this(request);
        addAllParameters(extendParams);//这里将扩展参数写入参数表
    }
    
    @Override
    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
        String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
    
    public String[] getParameterValues(String name) {//同上
         return params.get(name);
    }

   public void addAllParameters(Map<String , Object>otherParams) {//增加多个参数
        for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
            addParameter(entry.getKey() , entry.getValue());
        }
    }


    public void addParameter(String name , Object value) {//增加参数
        if(value != null) {
            if(value instanceof String[]) {
                params.put(name , (String[])value);
            }else if(value instanceof String) {
                params.put(name , new String[] {(String)value});
            }else {
                params.put(name , new String[] {String.valueOf(value)});
            }
        }
    }
}

