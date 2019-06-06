package com.mfoyou.agent.web.intercepter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.interception.PostMatchContainerRequestContext;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.service.session.SessionService;

@Provider
@ServerInterceptor
@Service
public class LoginInterceptor implements ContainerRequestFilter, ContainerResponseFilter
// public class LoginInterceptor extends HandlerInterceptorAdapter
{
    Logger              logger = Logger.getLogger(LoginInterceptor.class);

    @Autowired
    SessionService      sessionService;

    @Context
    HttpServletRequest  request;

    @Context
    HttpServletResponse response;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (token == null) {
            token = request.getHeader("token");
        }
        // 兼容token和session
        if (token != null && token.length() > 10) {
            SessionService.setSeesionId(request, token);
        } else {
            SessionService.checkSeesionCookie(request, response);
        }
        logger.info("当前用户token为:" + SessionService.getSeesionId(request));
        if (handler instanceof Method) {
            Method handlerMethod = (Method) handler;
            UrlRight urlRight = handlerMethod.getAnnotation(UrlRight.class);
            // 此接口没有实现权限控制功能
            if (urlRight == null) {
                mustLoginRespose(request, response, "此路径为标注访问权限，请必须标注");
                return false;
            }
            UserRight[] rights = urlRight.value();
            MfoyouMap user = sessionService.currentUser(request);
            for (UserRight right : rights) {
                // 所有人可访问
                if (right == UserRight.ALLACCESS) {
                    return true;
                }
                if (user == null || user.size() < 3){
                    returnjson(response,"{\"status\":-18,\"message\":\"无访问此接口权限,\",\"data\":null}");
                    return false;
                }
                // 登陆后可访问
                if (right == UserRight.LOGINACCESS) {
                    return true;
                }
                if ((sessionService.currentUserType(request) & right.getValue()) > 0) {
                    return true;
                }
            }
            if (user != null) {
                returnjson(response, "{\"status\":-18,\"message\":\"无访问此接口权限\",\"data\":null}");
            } else {
                returnjson(response, "{\"status\":-403,\"message\":\"未登录\",\"data\":null}");
            }
        }
        return false;
    }

    private void mustLoginRespose(HttpServletRequest request, HttpServletResponse response, String message) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        try {
            String url = URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "utf-8");
            response.getWriter().print("<html><script type='text/javascript'>alert('" + (message == null ? "此页面需要登录后访问!" : message) + "');window.location.href='" + request.getContextPath()
                                       + "/toLogin?tourl=" + url + "';</script></html>");

        } catch (IOException e) {
            logger.error("", e);
        }
    }

    private void returnjson(HttpServletResponse response, String message) {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            logger.info(message);
            response.getWriter().print(message);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    // 搜索次数过多
    @SuppressWarnings("unused")
	private void mustplRespose(HttpServletRequest request, HttpServletResponse response, String message) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        try {
            String url = URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "utf-8");
            response.getWriter().print("<html><script type='text/javascript'>alert('" + (message == null ? "访问频率过高,请明天再使用!" : message) + "');window.location.href='" + request.getContextPath()
                                       + "/my_home';</script></html>");

        } catch (IOException e) {
            logger.error("", e);
        }
    }

    @SuppressWarnings("unused")
    private void mustBuyRespose(HttpServletRequest request, HttpServletResponse response, String companyId) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        try {
            response.getWriter().print("<script type='text/javascript'>alert('此页面需要购买后访问!" + "');" + "</script>");

        } catch (IOException e) {
            logger.error("", e);
        }
    }

    protected String getRequestBody(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            int size = request.getContentLength();
            if (size > 0) {
                /*
                 * InputStream is = request.getInputStream(); Field ib =
                 * is.getClass().getDeclaredField("ib"); ib.setAccessible(true);
                 * Object oIb = ib.get(is);
                 * oIb.getClass().getDeclaredField(name)
                 */
                /*
                 * if(is.markSupported()) { is.mark(0); byte[] reqBodyBytes =
                 * readBytes(is, size);
                 * 
                 * is.reset(); String res = new String(reqBodyBytes);
                 * 
                 * return res; }
                 */
            }

        } catch (Exception e) {

        }
        return "";
    }

    public static final byte[] readBytes(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;

            int readLengthThisTime = 0;

            byte[] message = new byte[contentLen];

            try {

                while (readLen != contentLen) {

                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);

                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }

                    readLen += readLengthThisTime;
                }

                return message;
            } catch (IOException e) {
                // Ignore
                // e.printStackTrace();
            }
        }

        return new byte[] {};
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if (requestContext instanceof PostMatchContainerRequestContext) {
            PostMatchContainerRequestContext postMatchContainerRequestContext = (PostMatchContainerRequestContext) requestContext;
            boolean bCan = false;
            try {
                logger.info(request.getRequestURI() + "\n" + JSON.toJSONString(request.getParameterMap()));
                // logger.info(getRequestBody(request));
                bCan = preHandle(request, response, postMatchContainerRequestContext.getResourceMethod().getMethod());
            } catch (Exception e) {
                logger.error("", e);
                e.printStackTrace();
            }
            if (!bCan) {
                postMatchContainerRequestContext.abortWith(Response.status(401).build());
            }

        }

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    	
        // System.out.println(requestContext.getMethod());
    }

}
