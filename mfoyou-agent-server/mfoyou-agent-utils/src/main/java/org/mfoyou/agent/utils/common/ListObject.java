package org.mfoyou.agent.utils.common;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ListObject implements Serializable {
    List<?>     list;
    private int totalCount;
    private int pageSize;
    private int pageId;
    private int curSize;

    public static ListObject BulidListObject(List<?> list) {
        return new ListObject(list);
    }

    public static ListObject BulidListObject(ArrayListObject<?> list) {
        return new ListObject(list, list.getTotalCount(), list.getPageSize(), list.getPageId());
    }

    public static ListObject BulidListObject(List<?> list, int totalItemCount, int pageSize, int curPageIndex) {
        return new ListObject(list, totalItemCount, pageSize, curPageIndex);
    }

    public ListObject(List<?> list, int totalItemCount, int pageSize, int curPageIndex) {
        init(list, totalItemCount, pageSize, curPageIndex);
    }

    public ListObject(List<?> list) {
        init(list, -1, -1, -1);
    }

    private void init(List<?> list, int totalItemCount, int pageSize, int curPageIndex) {
        this.list = list;
        if (list != null) {
            curSize = list.size();
            if (totalItemCount == -1) {
                this.totalCount = list.size();
            } else {
                this.totalCount = totalItemCount;
            }

            if (pageSize == -1) {
                this.pageSize = list.size();
            } else {
                this.pageSize = pageSize;
            }
            if (curPageIndex == -1) {
                this.pageId = 1;
            } else {
                this.pageId = curPageIndex;
            }
        }
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
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
