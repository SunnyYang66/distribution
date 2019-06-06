package com.mfoyou.agent.web.service.file;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.poi.util.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.mfoyou.agent.common.dao.domain.HuawuFile;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.utils.common.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.fastdfs.FastDfsUtil;
import com.mfoyou.agent.web.utils.network.WebUtils;




@Service
public class FileService {

	@Autowired
	private FastDfsUtil fastDfsUtil;

	@Autowired
	private ICommon iCommon;

	@Autowired
	SessionService sessionService;

	static Logger logger = Logger.getLogger(FileService.class);
	
	public List<HuawuFile> uploadFile(HttpServletRequest request, MultipartFormDataInput input) {
		List<HuawuFile> list = new ArrayList<>();
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("file");
		Integer model = null;
		if(request.getParameter("model")!=null){
			model = Integer.parseInt(request.getParameter("model"));
		}
		for (InputPart inputPart : inputParts) {
			try {
				MultivaluedMap<String, String> header = inputPart.getHeaders();
				InputStream inputStream = inputPart.getBody(InputStream.class, null);
				byte[] bytes = IOUtils.toByteArray(inputStream);
				String ext = WebUtils.getFileext(header);
				//jpg
				String filepath = fastDfsUtil.upload("group1", bytes, ext, "");
				HuawuFile fi = new HuawuFile();
				fi.setFileModel(model);
				fi.setFileType(ext);
				fi.setFilePath(filepath);
				fi.setUserId(sessionService.currentUserId(request));
				int id = iCommon.insertFile(fi);
				fi.setFileId(id);
				list.add(fi);
			} catch (Exception e) {
				logger.error("", e);
				e.printStackTrace();
				list.add(null);
			}
		}
		return list;
	}

	
	
//	public MfoyouFile uploadFile(byte[] bytes,Integer userId,String fileName) {
//        try {
//            String ext = WebUtils.getFileext(fileName);
//            String filepath = fastDfsUtil.upload("group1", bytes, ext, "");
//            MfoyouFile fi = new MfoyouFile();
//            fi.setFileType(ext);
//            fi.setFilePath(filepath);
//            fi.setUserId(userId);
//            int id = iFileInfo.insertFile(fi);
//            fi.setFileId(id);
//            return fi;
//        } catch (Exception e) {
//            logger.error("", e);
//        }
//        return null;
//    }
//
	public List<HuawuFile> getFileInfos(List<Integer> ids) {
		return iCommon.getFileInfos(ids);
	}
//
	public List<HuawuFile> getFiles(Integer currentUserId, Integer model) {
		return iCommon.getFiles(currentUserId,model);
	}
//
//	public int modifyFile(MfoyouFile mfoyouFile) {
//		
//		return iFileInfo.modifyFile(mfoyouFile);
//	}
//
//	public List<MfoyouPicGallery> uploadFileToGallery(HttpServletRequest request, MultipartFormDataInput input, Integer typeId, String name, String keyWords) {
//		List<MfoyouPicGallery> list = new ArrayList<>();
//		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
//		List<InputPart> inputParts = uploadForm.get("file");
//		for (InputPart inputPart : inputParts) {
//			try {
//				MultivaluedMap<String, String> header = inputPart.getHeaders();
//				InputStream inputStream = inputPart.getBody(InputStream.class, null);
//				byte[] bytes = IOUtils.toByteArray(inputStream);
//				String fileName = WebUtils.getFileName(header);
//				String[] split = fileName.split("\\.");
//				if(split.length!=2) return null;
//				String filepath = fastDfsUtil.upload("group1", bytes, split[1], "");
//				MfoyouPicGallery mfoyouPicGallery = new MfoyouPicGallery();
//				mfoyouPicGallery.setPicName(name!=null?name:URLDecoder.decode(split[0],"utf-8"));
//				mfoyouPicGallery.setPicTypeId(typeId);
//				mfoyouPicGallery.setPicPath(filepath);
//				iFileInfo.insertGallery(mfoyouPicGallery);
//				list.add(mfoyouPicGallery);
//			} catch (Exception e) {
//				logger.error("", e);
//				e.printStackTrace();
//				list.add(null);
//			}
//		}
//		return list;
//	}
//
//	public ArrayListObject<MfoyouPicGallery> seachGallery(Integer typeId, String name, Integer pageId, Integer pageSize) {
//		return iFileInfo.seachGallery(typeId,name,pageId,pageSize);
//	}
//
//	public int addGalleryType(MfoyouPicGalleryType mfoyouPicGalleryType) {
//		return iFileInfo.addGalleryType(mfoyouPicGalleryType);
//	}
//
//	public List<MfoyouPicGalleryType> getGalleryType(Integer sourceId) {
//		return iFileInfo.getGalleryType(sourceId);
//	}
//
//	public int deleteType(Integer typeId) {
//		return iFileInfo.deleteType(typeId);
//	}
//
//	public int deleteGallery(Integer[] typeIds) {
//		return iFileInfo.deleteGallery(typeIds);
//	}
//
//	public int modifyType(MfoyouPicGalleryType parseObject) {
//		return iFileInfo.modifyType(parseObject);
//	}

}
