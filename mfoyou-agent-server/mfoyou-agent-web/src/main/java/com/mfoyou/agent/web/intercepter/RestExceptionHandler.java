package com.mfoyou.agent.web.intercepter;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.exp.AppidNullException;
import org.mfoyou.agent.utils.exp.ArgsNullException;
import org.mfoyou.agent.utils.exp.DataNullException;
import org.mfoyou.agent.utils.exp.DataRangErrorException;


@Provider  
public class RestExceptionHandler implements ExceptionMapper<Throwable> {  
  private static Logger logger =    Logger.getLogger(RestExceptionHandler.class); 
    @Override  
    public Response toResponse(Throwable e) { 
    	int errorCode = -100;
    	if(e instanceof NotFoundException){
    		errorCode = -404;
    		logger.error("",(Exception)e);
    	}else 	if(e instanceof NotAllowedException){
    		errorCode = -405;
    		logger.error("",(Exception)e);
    	 } else if (e instanceof ArgsNullException) {
             errorCode = -96;
             logger.error("", (Exception) e);
    	 } else if (e instanceof DataRangErrorException) {
             errorCode = -73;
             logger.error("", (Exception) e);
         }else if (e instanceof AppidNullException) {
             errorCode = -1999;
             logger.error("", (Exception) e);
         } else if (e instanceof DataNullException) {
             errorCode = -98;
             logger.error("", (Exception) e);
    	}else 	if(e instanceof  Exception){
    		logger.error("",(Exception)e);
    	}
    	else{
    		logger.error(e.toString());
    	}
    	e.printStackTrace();
        return Response.status(200).header("Content-Type", "application/json;charset=UTF-8").entity(JsonRet.buildRet(errorCode)).build();  
    }  
}  