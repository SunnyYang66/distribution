package com.mfoyou.agent.web.utils.common;

import java.util.Collections;
import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.Json2Object;

import com.alibaba.fastjson.JSON;

public class StoreActiveInfo extends MfoyouStoreActive {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6393832533601028755L;
	private String                  newUserActiveContent;
    private String                  fullcutActiveContent;
    private List<FullcutActiveInfo> fullcutActiveInfos;

    public String getNewUserActiveContent() {
        return newUserActiveContent;
    }

    public void setNewUserActiveContent(String newUserActiveContent) {
        this.newUserActiveContent = newUserActiveContent;
    }

    public String getFullcutActiveContent() {
        return fullcutActiveContent;
    }

    public void setFullcutActiveContent(String fullcutActiveContent) {
        this.fullcutActiveContent = fullcutActiveContent;
    }

    public List<FullcutActiveInfo> getFullcutActiveInfos() {
        return fullcutActiveInfos;
    }

    public void setFullcutActiveInfos(List<FullcutActiveInfo> fullcutActiveInfos) {
        this.fullcutActiveInfos = fullcutActiveInfos;
        if (this.fullcutActiveInfos != null) {
            setFullcutAmountDescribe(JSON.toJSONString(this.fullcutActiveInfos));
        }
    }
    public int getFullcutAmount(int amount){
        makeContent();
        int reduction = 0;
        for(FullcutActiveInfo info :fullcutActiveInfos){
            if(info.getAmount()!= null && info.getAmount() <= amount){
                if(info.getReduction() != null && info.getReduction() > reduction)reduction = info.getReduction();
            }
        }
        return reduction;
    }

    public void makeContent() {
        if (getNewUserActiveState() != null && getNewUserActiveState().intValue() == 1 && getNewUserReductionAmount() != null) {
            newUserActiveContent = "新用户下单立减" + StrUtil.fen2yuan(getNewUserReductionAmount()) + "元";
        }
        if (getFullcutActiveState() != null && getFullcutActiveState().intValue() == 1 && getFullcutAmountDescribe() != null && getFullcutAmountDescribe().length() > 5) {
            fullcutActiveInfos = Json2Object.json2Arrary(getFullcutAmountDescribe(), FullcutActiveInfo.class);
            Collections.sort(fullcutActiveInfos);
            fullcutActiveContent = "";
            for (int i = 0; i < fullcutActiveInfos.size(); i++) {
                if (i == 0) {
                    fullcutActiveContent = "满" + StrUtil.fen2yuan(fullcutActiveInfos.get(i).getAmount()) + "减" + StrUtil.fen2yuan(fullcutActiveInfos.get(i).getReduction());
                } else {
                    fullcutActiveContent += ",满" + StrUtil.fen2yuan(fullcutActiveInfos.get(i).getAmount()) + "减" + StrUtil.fen2yuan(fullcutActiveInfos.get(i).getReduction());

                }
            }
        }
    }

}
