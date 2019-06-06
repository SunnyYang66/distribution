package org.mfoyou.agent.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;


public class StoreOpenInfo implements Serializable {

    private HuawuStoreInfo       mfoyouStoreInfo;
    private List<MfoyouStoreOpen> list;

    public HuawuStoreInfo getMfoyouStoreInfo() {
        return mfoyouStoreInfo;
    }

    public void setMfoyouStoreInfo(HuawuStoreInfo mfoyouStoreInfo) {
        this.mfoyouStoreInfo = mfoyouStoreInfo;
    }

    public List<MfoyouStoreOpen> getList() {
        return list;
    }

    public void setList(List<MfoyouStoreOpen> list) {
        this.list = list;
    }
    
    public void addMfoyouStoreOpen(MfoyouStoreOpen open) {
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(open);
    }

}
