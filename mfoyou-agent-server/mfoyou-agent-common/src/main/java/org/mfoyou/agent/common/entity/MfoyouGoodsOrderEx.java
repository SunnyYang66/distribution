package org.mfoyou.agent.common.entity;

import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;


public class MfoyouGoodsOrderEx extends MfoyouGoodsOrder {
    private List<MfoyouGoodsOrderItme> list;
    //区别是否是农商.在店消费，0为在店消费，1为外卖
    private Integer type;
    private Integer killId;
    public List<MfoyouGoodsOrderItme> getList() {
        return list;
    }

    public void setList(List<MfoyouGoodsOrderItme> list) {
        this.list = list;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getKillId() {
		return killId;
	}

	public void setKillId(Integer killId) {
		this.killId = killId;
	}

}
