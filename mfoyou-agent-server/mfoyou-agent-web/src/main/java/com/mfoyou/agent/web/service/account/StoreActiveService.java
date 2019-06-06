package com.mfoyou.agent.web.service.account;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttend;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.map.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.utils.common.StoreActiveInfo;

@Service
public class StoreActiveService {

    @Autowired
    private IStore iStore;

    public StoreActiveInfo getStoreActive(Integer storeId) {

        MfoyouStoreActive mfoyouStoreActive = iStore.getMfoyouStoreActive(storeId);
        if (mfoyouStoreActive == null) {
            mfoyouStoreActive = new MfoyouStoreActive();
            mfoyouStoreActive.setStoreId(storeId);
            mfoyouStoreActive.setFullcutActiveState(0);
            mfoyouStoreActive.setNewUserActiveState(0);
            iStore.addMfoyouStoreActive(mfoyouStoreActive);
        }
        StoreActiveInfo storeActiveInfo = new StoreActiveInfo();
        ReflectUtil.ObjectCopy(mfoyouStoreActive, storeActiveInfo);
        storeActiveInfo.makeContent();
        return storeActiveInfo;
    }

    public Boolean mdfStoreActive(StoreActiveInfo storeActiveInfo) {
        if (storeActiveInfo.getFullcutActiveInfos() != null) {
            storeActiveInfo.setFullcutActiveInfos(storeActiveInfo.getFullcutActiveInfos());
        }
        MfoyouStoreActive param = new MfoyouStoreActive();
        ReflectUtil.ObjectCopy(storeActiveInfo, param);
        return iStore.mdfMfoyouStoreActive(param);
    }
    
    public MfoyouStoreActive getMfoyouStoreActive(Integer storeId){
        return iStore.getMfoyouStoreActive(storeId);
    }
    
    public int getUserStoreActiveCount(Integer userId,Integer storeId){
       return iStore.getUserStoreActiveCount(userId, storeId); 
    }
    
    public Integer addMfoyouUserActiveAttend(MfoyouUserActiveAttend mfoyouUserActiveAttend){
       return iStore.addMfoyouUserActiveAttend(mfoyouUserActiveAttend);
    }
    
    public Integer delMfoyouUserActiveAttend(Integer orderId){
      return iStore.delMfoyouUserActiveAttend(orderId);
    }
 
}
