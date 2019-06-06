package org.mfoyou.agent.utils.common;

import java.util.ArrayList;
import java.util.List;

import org.mfoyou.agent.utils.json.JSONMaker;
import org.mfoyou.agent.utils.map.ReflectUtil;

import com.alibaba.fastjson.JSONObject;
public class ArrayListObject<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalCount;
	private int pageSize;
	private int pageId;
	private int curSize;
	
	public static<M,H> void copyDate(ArrayListObject<M> srcList,ArrayListObject<H> desList,Class<H> cs) throws InstantiationException, IllegalAccessException{
		desList.setCurSize(srcList.getCurSize());
		desList.setPageId(srcList.getPageId());
		desList.setPageSize(srcList.getPageSize());
		desList.setTotalCount(srcList.getTotalCount());
		for(M m:srcList){
			H e = cs.newInstance();
			ReflectUtil.ObjectCopy(m, e);
			desList.add(e);
		}	
	}

	public static <M> ArrayListObject<JSONObject> bliudArrayList(ArrayListObject<M> mList, String attchKey) {

		ArrayListObject<JSONObject> listObject = new ArrayListObject<JSONObject>();
		listObject.totalCount = mList.totalCount;
		listObject.pageSize = mList.pageSize;
		listObject.pageId = mList.pageId;
		listObject.curSize = mList.curSize;
		for (M e : mList) {
			listObject.add(JSONMaker.AttachSubJsonString(e, attchKey));
		}
		return listObject;
	}

	public static <E> ArrayListObject<E> bliudArrayList(List<E> list, Integer pageId, Integer pageSize,
			Integer totalCount) {
		ArrayListObject<E> listObject = new ArrayListObject<E>();
		listObject.addAll(list);
		if (pageId == null) {
			listObject.pageId = 1;
		} else {
			listObject.pageId = pageId;
		}
		if (pageSize != null) {
			listObject.pageSize = pageSize;
		} else {
			listObject.pageSize = list.size();
		}
		if (totalCount != null) {
			listObject.totalCount = totalCount;
		} else {
			listObject.totalCount = list.size();
		}
		listObject.curSize = list.size();

		return listObject;
	}
	public void  setBasInfo(@SuppressWarnings("rawtypes") ArrayListObject list){
	    this.setCurSize(list.getCurSize());
	    this.setPageId(list.getPageId());
	    this.setPageSize(list.getPageSize());
	    this.setTotalCount(list.getTotalCount());
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getCurSize() {
		return curSize;
	}

	public void setCurSize(int curSize) {
		this.curSize = curSize;
	}

}
