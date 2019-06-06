package org.mfoyou.agent.utils.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页的data,遵从规定:https://gitlab.tcredit.com/fuyun.zhao/credit_2b_pc/wikis/ajax
 */
public class PageData<T>  implements Serializable{

    private static final long serialVersionUID = 1;

    private int count;
    private int current;
    private int limit;
    private List<T> list = Collections.emptyList();

    public PageData() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "count=" + count +
                ", current=" + current +
                ", limit=" + limit +
                ", list=" + list +
                '}';
    }
}
