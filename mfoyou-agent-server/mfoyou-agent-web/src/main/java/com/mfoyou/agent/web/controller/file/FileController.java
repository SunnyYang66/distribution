package com.mfoyou.agent.web.controller.file;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mfoyou.agent.common.dao.domain.HuawuFile;
import org.mfoyou.agent.common.entity.MfoyouFileRet;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.file.FileService;
import com.mfoyou.agent.web.service.session.SessionService;


@Path("/file")
@Service
public class FileController {

	@Autowired
	private FileService fileService;
	@Autowired
	SessionService sessionService;
	@Value("#{settings['image_server']}")
	private String image_server;

	Logger logger = new Logger(FileController.class);

	@POST
	@Path(value = "/upload")
	@Produces("application/json;charset=UTF-8")
	@Consumes("multipart/form-data")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> uploadFile(@Context HttpServletRequest request, MultipartFormDataInput input) {
		try {
			List<HuawuFile> list = fileService.uploadFile(request, input);
			MfoyouFileRet mfoyouFileRet = new MfoyouFileRet();
			mfoyouFileRet.setList(list);
			mfoyouFileRet.setBasUrl(image_server);
			return JsonRet.buildSuccRet(mfoyouFileRet);
		} catch (Exception e) {
			logger.error("", e);
			e.printStackTrace();
		}
		return JsonRet.buildFailRet("上传失败");
	}
////	@POST
////	@Path(value = "/uploadToGallery")
////	@Produces("application/json;charset=UTF-8")
////	@Consumes("multipart/form-data")
////	@UrlRight(UserRight.ADMINACCESS)
////	public JsonRet<?> uploadFileTogallery(@Context HttpServletRequest request, MultipartFormDataInput input
////			,@QueryParam("typeId")Integer typeId,@QueryParam("name")String name,@QueryParam("keyWords")String keyWords) {
////		if(typeId==null){
////			return JsonRet.buildRet(-96);
////		}
////		try {
////			List<MfoyouPicGallery> list = fileService.uploadFileToGallery(request, input,typeId,name,keyWords);
////			MfoyouFileRet mfoyouFileRet = new MfoyouFileRet();
////			mfoyouFileRet.setList(list);
////			mfoyouFileRet.setBasUrl(image_server);
////			return JsonRet.buildSuccRet(mfoyouFileRet);
////		} catch (Exception e) {
////			logger.error("", e);
////			e.printStackTrace();
////		}
////		return JsonRet.buildFailRet("上传失败");
////	}
////	@GET
////	@Path(value = "/seachGallery")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ALLACCESS)
////	public JsonRet<?> seachGallery(@QueryParam("typeId")Integer typeId,@QueryParam("name")String name,
////			@QueryParam("pageSize")Integer pageSize,@QueryParam("pageId")Integer pageId) {
////		
////		ArrayListObject<MfoyouPicGallery> list = fileService.seachGallery(typeId,name,pageId,pageSize);
////		return JsonRet.buildSuccRet(ListObject.BulidListObject(list));
////	}
////	@POST
////	@Path(value = "/addGalleryType")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ADMINACCESS)
////	public JsonRet<?> addGalleryType(String json) {
////		MfoyouPicGalleryType mfoyouPicGalleryType =JSON.parseObject(json, MfoyouPicGalleryType.class);
////		mfoyouPicGalleryType.setTypeid(null);
////		return JsonRet.buildRet(fileService.addGalleryType(mfoyouPicGalleryType)-1);
////	}
////	@GET
////	@Path(value = "/getGalleryType")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ALLACCESS)
////	public JsonRet<?> getGalleryType(@QueryParam("modelId")Integer sourceId) {
////		if(sourceId==null) sourceId=1;
////		return JsonRet.buildSuccRet(fileService.getGalleryType(sourceId));
////	}
////	@GET
////	@Path(value = "/deleteGalleryType")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ADMINACCESS)
////	public JsonRet<?> deleteGalleryType(@QueryParam("typeId")Integer typeId) {
////		if(typeId==null) return JsonRet.buildRet(-96);
////		return JsonRet.buildRet(fileService.deleteType(typeId)>0?0:-1);
////	}
////	@POST
////	@Path(value = "/modifyGalleryType")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ADMINACCESS)
////	public JsonRet<?> modifyGalleryType(String json) {
////		MfoyouPicGalleryType parseObject = JSON.parseObject(json, MfoyouPicGalleryType.class);
////		return JsonRet.buildRet(fileService.modifyType(parseObject)-1);
////	}
////	@GET
////	@Path(value = "/deleteGallery")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ADMINACCESS)
////	public JsonRet<?> deleteGallery(@QueryParam("picId")Integer[] typeIds) {
////		if(typeIds.length==0) return JsonRet.buildRet(-96);
////		return JsonRet.buildRet(fileService.deleteGallery(typeIds)>0?0:-1);
////	}
	@GET
	@Path(value = "/getFileList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> getFileList(@Context HttpServletRequest request,@QueryParam("model")Integer model) {
		if(model==null){
			return JsonRet.buildRet(-96);
		}
		Integer currentUserId = sessionService.currentUserId(request);
		List<HuawuFile> files = fileService.getFiles(currentUserId,model);
		MfoyouFileRet mfoyouFileRet = new MfoyouFileRet();
		mfoyouFileRet.setList(files);
		mfoyouFileRet.setBasUrl(image_server);
		return JsonRet.buildSuccRet(mfoyouFileRet);
	}
//	
	@GET
	@Path(value = "/fileInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> getFileInfo(@Context HttpServletRequest request, @QueryParam("ids") String ids) {
		if (ids.length() < 1) {
			return JsonRet.buildFailRet("参数错误", (List<HuawuFile>) null);
		}
		String[] params = ids.split(",");
		List<Integer> list = new ArrayList<>();
		for (String param : params) {
			list.add(Integer.parseInt(param));
		}
		MfoyouFileRet mfoyouFileRet = new MfoyouFileRet();
		mfoyouFileRet.setList(fileService.getFileInfos(list));
		mfoyouFileRet.setBasUrl(image_server);
		return JsonRet.buildSuccRet(mfoyouFileRet);
	}
////
	@GET
	@Path(value = "/fileServer")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> fileServer(@Context HttpServletRequest request) {
		return JsonRet.buildSuccRet(image_server);
	}
////	@GET
////	@Path(value = "/modifyModel/{fileId}/{fileModel}")
////	@Produces("application/json;charset=UTF-8")
////	@UrlRight(UserRight.ALLACCESS)
////	public JsonRet<?> modifyModel(@Context HttpServletRequest request,@PathParam("fileId")Integer fileId,
////			@PathParam("fileModel")Integer fileModel) {
////		MfoyouFile mfoyouFile = new MfoyouFile();
////		mfoyouFile.setFileId(fileId);
////		mfoyouFile.setFileModel(fileModel);
////		return JsonRet.buildSuccRet(fileService.modifyFile(mfoyouFile)-1);
////	}
}
