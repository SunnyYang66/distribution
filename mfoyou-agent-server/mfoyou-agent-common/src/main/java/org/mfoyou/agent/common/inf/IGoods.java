package org.mfoyou.agent.common.inf;

import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCart;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.SearchStoreInfo;
import org.mfoyou.agent.utils.common.ArrayListObject;

public interface IGoods {

	MfoyouGoodsInfo getGoodsByid(Integer id);

	int addGoods(MfoyouGoodsInfo info);

	List<MfoyouGoodsInfo> getGoodListByStoreId(MfoyouGoodsInfo mfoyouGoodsInfo);

	int removeGoods(Integer id, Integer storeId);

	int removeGoods(Integer id);

	int addGoods(MfoyouGoodsInfo info, List<MfoyouGoodsPackage> packages);

	int deletePackage(Integer storeId, Integer packageId, Integer goodsId);

	int addPackage(MfoyouGoodsPackage mfoyouGoodsPackage, Integer storeId);

	MfoyouGoodsInfo updateGoods(MfoyouGoodsInfo info);

	List<MfoyouGoodsTypeV2> getTypeListV2(Integer storeId, int model);

	int modifyTypeOrder(Integer storeId, String[] ids, String[] seqs, String seq);

	int deleteBatchGoods(Integer[] goodsids, Integer storeId);

	int batchUpdateState(Integer[] ids, Integer state, Integer storeId);

	int updateBatchGroup(Integer[] goodsids, Integer typeId, Integer storeId);

	ArrayListObject<GoodsInfo> getGoodsByStoreid(Integer storeId, String key, Integer state, Integer type,
			Integer pageId, Integer pageSize);

	ArrayListObject<GoodsInfo> searchGoodsByStore(Integer storeId, String key, Integer pageId, Integer pageSize);

	List<SearchStoreInfo> searchStore(String key, Integer pageIndex, Integer pageSize, Double lat, Double lon,
			Integer agentid);

	List<MfoyouGoodsOrderCart> getMfoyouGoodsOrderCartList(Integer userId);

	List<MfoyouGoodsInfo> getMfoyouGoodsInfos(List<Integer> goodsIds);

	List<HuawuStoreInfo> getMfoyouStoreInfos(List<Integer> storeIds);

	List<MfoyouGoodsPackage> getMfoyouPackageInfos(List<Integer> packageIds);

	int updatePacket(MfoyouGoodsPackage mfoyouGoodsPackage, Integer goodsId, Integer storeId);

	List<MfoyouGoodsPackage> getPackageByid(Integer id);

	MfoyouGoodsPackage getPackage(Integer packageId);

	int updateType(Integer id, Integer storeId, MfoyouGoodsType type);

	int deleteType(Integer id, Integer storeId);

	int addType(Integer storeId, String typeName);

	Boolean delMfoyouGoodsOrderCartItme(Integer itmeId);

	MfoyouGoodsOrderCart getMfoyouGoodsOrderCart(Integer goodsId, Integer packagId, Integer customerId);

	Integer addMfoyouGoodsOrderCartItem(MfoyouGoodsOrderCart mfoyouGoodsOrderCart);

	Boolean delAllMfoyouGoodsOrderCart(Integer customerId, Integer storeId);

	Boolean selectMfoyouGoodsOrderCartStore(Integer userId, Integer storeId, Integer selectState);

	Boolean ModeifyMfoyouGoodsOrderCartItme(MfoyouGoodsOrderCart mfoyouGoodsOrderCart);

	List<MfoyouGoodsSearch> getSearchList();

}
