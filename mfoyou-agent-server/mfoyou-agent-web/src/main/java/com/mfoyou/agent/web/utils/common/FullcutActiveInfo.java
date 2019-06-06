package com.mfoyou.agent.web.utils.common;

import java.io.Serializable;

public class FullcutActiveInfo implements Serializable ,Comparable<FullcutActiveInfo>{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4688608910290597898L;
	private Integer amount;
    private Integer reduction;
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getReduction() {
        return reduction;
    }
    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }
    @Override
    public int compareTo(FullcutActiveInfo o) {
        int i = amount - o.amount;//先按照年龄排序  
        if(i == 0){  
            return o.reduction - this.reduction;//如果年龄相等了再用分数进行排序  
        }  
        return i;  
    }
    
}
