package com.mfoyou.agent.web.service.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCart;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.MfoyouCustomerCart;
import org.mfoyou.agent.common.entity.SearchStoreInfo;
import org.mfoyou.agent.common.inf.IGoods;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.map.MapObjectTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
	private static Logger logger = Logger.getLogger(GoodsService.class);
	@Autowired
	IGoods iGoods;
	@Autowired
	IStatistics statisticsService;

	public MfoyouGoodsInfo getGoodsByidV2(Integer id) {
		return iGoods.getGoodsByid(id);
	}

	public GoodsInfo getGoods(Integer id) {
		return statisticsService.getGoodsInfo(id);
	}

	public MfoyouGoodsInfo getMfoyouGoodsInfo(Integer goodsId) {
		return iGoods.getGoodsByid(goodsId);
	}

	public MfoyouGoodsInfo addGoodsV2(MfoyouGoodsInfo info) {
		int result = iGoods.addGoods(info);
		if (result == 0) {
			return null;
		}
		info.setGoodsId(result);
		return info;
	}

	public int deleteGoodsV2(Integer id, Integer storeId) {
		return iGoods.removeGoods(id, storeId);
	}

	public List<MfoyouGoodsTypeV2> getTypesV2(Integer storeId, int model) {
		List<MfoyouGoodsTypeV2> typeList = iGoods.getTypeListV2(storeId, model);
		return typeList;
	}

	public int addTypeV2(Integer storeId, String typeName) {
		return iGoods.addType(storeId, typeName);
	}

	public ArrayListObject<?> listGoods(Integer pageSize, Integer pageId, MfoyouGoodsInfo info) {

		ArrayListObject<GoodsInfo> listGoods = statisticsService.listGoods(pageSize, pageId, info, 0);
		for (GoodsInfo goodsInfo : listGoods) {
			goodsInfo.setGoodsIdStr(MfoyouEncrypt.enCode(goodsInfo.getGoodsId()));
		}
		return listGoods;
	}

	public ArrayListObject<?> listGoodsStore(Integer pagesize, Integer pageId, MfoyouGoodsInfo mfoyouGoodsInfo) {

		ArrayListObject<GoodsInfo> listGoods = statisticsService.listGoods(pagesize, pageId, mfoyouGoodsInfo, 1);
		for (GoodsInfo goodsInfo : listGoods) {
			goodsInfo.setGoodsIdStr(MfoyouEncrypt.enCode(goodsInfo.getGoodsId()));
		}
		return listGoods;
	}

	public MfoyouGoodsInfo updateGoods(MfoyouGoodsInfo info) {

		return iGoods.updateGoods(info);
	}

	public int deleteTypeByid(Integer id, Integer storeId) {

		return iGoods.deleteType(id, storeId);
	}

	public int updateType(MfoyouGoodsType type, Integer storeId, Integer typeid) {

		return iGoods.updateType(typeid, storeId, type);
	}

	public List<MfoyouGoodsPackage> getPackageByid(Integer goodsId) {

		return iGoods.getPackageByid(goodsId);
	}

	public MfoyouGoodsPackage getPackage(Integer packageId) {
		return iGoods.getPackage(packageId);
	}

	public int addPackage(MfoyouGoodsPackage mfoyouGoodsPackage, Integer storeId) {

		return iGoods.addPackage(mfoyouGoodsPackage, storeId);
	}

	public int deletePackage(Integer storeId, Integer packageId, Integer goodsid) {

		return iGoods.deletePackage(storeId, packageId, goodsid);
	}

	public int updateGoods(MfoyouGoodsInfo info, List<MfoyouGoodsPackage> packages) {

		MfoyouGoodsInfo goodsinfo = iGoods.updateGoods(info);
		int result1 = 0;
		if (goodsinfo != null) {
			result1 = 1;
		}
		if (info.getGoodsPackageType() != null) {
			iGoods.deletePackage(null, null, info.getGoodsId());
			if (info.getGoodsPackageType() == 1) {
				for (MfoyouGoodsPackage package1 : packages) {
					iGoods.addPackage(package1, info.getStoreId());
				}
			}
		}
		return result1;
	}

	public int updatePacket(MfoyouGoodsPackage mfoyouGoodsPackage, Integer goodsId, Integer storeId) {

		return iGoods.updatePacket(mfoyouGoodsPackage, goodsId, storeId);
	}

	public List<MfoyouGoodsInfo> getGoodsByStoreid(MfoyouGoodsInfo mfoyouGoodsInfo) {

		return iGoods.getGoodListByStoreId(mfoyouGoodsInfo);
	}

	// 购物车
	public MfoyouCustomerCart getGoodsOrderCartDetailedInformation(Integer userId, Double lon, Double lat) {

		MfoyouCustomerCart customerCart = new MfoyouCustomerCart();
		customerCart.setCustomerId(userId);
		customerCart.setLat(lat);
		customerCart.setLon(lon);
		customerCart.setList(new ArrayList<MfoyouCustomerCart.Store>());

		List<MfoyouGoodsOrderCart> list = iGoods.getMfoyouGoodsOrderCartList(userId);
		if (list.size() == 0) {
			return customerCart;
		}
		List<Integer> storeId = new ArrayList<>();
		List<Integer> goodsId = new ArrayList<>();
		List<Integer> packagesId = new ArrayList<>();
		for (MfoyouGoodsOrderCart cart : list) {
			storeId.add(cart.getStoreId());
			goodsId.add(cart.getGoodsId());
			if (cart.getPackageId() != null) {
				packagesId.add(cart.getPackageId());
			}
		}
		Map<Integer, MfoyouCustomerCart.Store> storemap = new HashMap<>();
		Map<Integer, MfoyouGoodsInfo> goodsMap = MapObjectTrans.ListToMap(iGoods.getMfoyouGoodsInfos(goodsId),
				MfoyouGoodsInfo.class, "goodsId");
		Map<Integer, HuawuStoreInfo> storeMap = MapObjectTrans.ListToMap(iGoods.getMfoyouStoreInfos(storeId),
				HuawuStoreInfo.class, "storeId");
		Map<Integer, MfoyouGoodsPackage> packageMap = MapObjectTrans.ListToMap(iGoods.getMfoyouPackageInfos(packagesId),
				MfoyouGoodsPackage.class, "packageId");
		for (MfoyouGoodsOrderCart cart : list) {
			MfoyouGoodsInfo mfoyouGoodsInfo = goodsMap.get(cart.getGoodsId());
			if (mfoyouGoodsInfo == null)
				continue;
			MfoyouGoodsPackage mfoyouGoodsPackage = packageMap.get(cart.getPackageId());
			MfoyouCustomerCart.goods goods = new MfoyouCustomerCart.goods();
			goods.setAddTime(cart.getItemGct());
			goods.setBuyCount(cart.getItemNumber());
			goods.setCostPrice(mfoyouGoodsInfo.getGoodsCostPrice());
			goods.setDiscountPrice(mfoyouGoodsInfo.getGoodsDiscountPrice());
			goods.setGoodsId(mfoyouGoodsInfo.getGoodsId());
			goods.setGoodsNumber(mfoyouGoodsInfo.getGoodsNumber());
			goods.setGoodsTitle(mfoyouGoodsInfo.getGoodsTitle());
			goods.setItemSelect(cart.getItemSelect());
			goods.setCartItemId(cart.getCartItmeId());
			goods.setState(1);
			goods.setGoodsUrl(mfoyouGoodsInfo.getGoodsMainPic());
			goods.setPackageId(cart.getPackageId());
			if (mfoyouGoodsPackage != null) {
				goods.setCostPrice(mfoyouGoodsPackage.getPackageCostPrice());
				goods.setDiscountPrice(mfoyouGoodsPackage.getPackageDiscountPrice());
				goods.setGoodsNumber(mfoyouGoodsPackage.getPackageNumber());
				goods.setPackagetitle(mfoyouGoodsPackage.getPackageName());
			} else if (mfoyouGoodsPackage == null && cart.getPackageId() != null) {
				goods.setState(0);
			}
			goods.setPromotionType(mfoyouGoodsInfo.getGoodsPromotionType());
			MfoyouCustomerCart.Store store = storemap.get(cart.getStoreId());
			if (store == null) {
				HuawuStoreInfo mfoyouStoreInfo = storeMap.get(cart.getStoreId());
				if (mfoyouStoreInfo == null) {
					logger.error("store notfund:" + cart.getStoreId() + " userId = " + userId);
					continue;
				}
				store = new MfoyouCustomerCart.Store();
				store.setStoreId(cart.getStoreId());
				store.setStoreStr(MfoyouEncrypt.enCode(cart.getStoreId()));
				storemap.put(cart.getStoreId(), store);
				store.setList(new ArrayList<MfoyouCustomerCart.goods>());
				store.setAddress(mfoyouStoreInfo.getStoreAddress());
				store.setLat(mfoyouStoreInfo.getStoreLocalLat());
				store.setLon(mfoyouStoreInfo.getStoreLocalLon());
				store.setOpenState(mfoyouStoreInfo.getStoreCurrentOpenState());
				store.setStoreName(mfoyouStoreInfo.getStoreName());
				store.setStroePic(mfoyouStoreInfo.getStoreLogo());
				store.setMaxDeliveryDistance(mfoyouStoreInfo.getStoreMaxDeliveryDistance());
				store.setStoreMinGoodsAmount(mfoyouStoreInfo.getStoreMinGoodsAmount());
				store.setStoreFreeFreightAmount(mfoyouStoreInfo.getStoreFreeFreightAmount());
				// 计算店铺和用户的距离
				Double storeLon = mfoyouStoreInfo.getStoreLocalLon();
				Double storeLat = mfoyouStoreInfo.getStoreLocalLat();
				if (lon != null && lat != null && storeLon != null && storeLat != null) {
					store.setDistance((int) (1000 * GisUtils.distVincenty(lat, lon, storeLat, storeLon)));
				}
			}
			store.getList().add(goods);
		}

		customerCart.getList().addAll(storemap.values());
		Collections.sort(customerCart.getList());

		return customerCart;

	}

	public int addGoodsV2(MfoyouGoodsInfo info, List<MfoyouGoodsPackage> packages) {

		return iGoods.addGoods(info, packages);
	}

	public List<SearchStoreInfo> searchStore(String key, Integer pageId, Integer pageSize, Double lat, Double lon,
			Integer agentid) {
		List<SearchStoreInfo> searchStore = iGoods.searchStore(key, pageId, pageSize, lat, lon, agentid);
		for (SearchStoreInfo info : searchStore) {
			if (info.getStoreId() != null) {
				info.setStoreStr(MfoyouEncrypt.enCode(info.getStoreId()));
			}
		}
		return searchStore;
	}

	public ArrayListObject<GoodsInfo> searchGoodsByStore(Integer storeId, String key, Integer pageId,
			Integer pageSize) {
		ArrayListObject<GoodsInfo> searchGoodsByStore = iGoods.searchGoodsByStore(storeId, key, pageId, pageSize);
		for (GoodsInfo goodsInfo : searchGoodsByStore) {
			if (goodsInfo.getGoodsId() != null) {
				goodsInfo.setGoodsIdStr(MfoyouEncrypt.enCode(goodsInfo.getGoodsId()));
			}
		}
		return searchGoodsByStore;
	}

	public int modifyTypeOrder(Integer storeId, String[] ids, String[] seqs, String seq) {
		return iGoods.modifyTypeOrder(storeId, ids, seqs, seq);
	}

	public ArrayListObject<GoodsInfo> getGoodsByStoreid(Integer storeId, String key, Integer state, Integer type,
			Integer pageId, Integer pageSize) {
		ArrayListObject<GoodsInfo> goodsByStoreid = iGoods.getGoodsByStoreid(storeId, key, state, type, pageId,
				pageSize);
		for (GoodsInfo mfoyouGoodsInfo : goodsByStoreid) {
			mfoyouGoodsInfo.setGoodsIdStr(MfoyouEncrypt.enCode(mfoyouGoodsInfo.getGoodsId()));
		}
		return goodsByStoreid;
	}

	public int deleteBatchGoods(Integer[] goodsids, Integer storeId) {
		return iGoods.deleteBatchGoods(goodsids, storeId);
	}

	public int updateshevelState(Integer[] goodsids, Integer state, Integer storeId) {

		return iGoods.batchUpdateState(goodsids, state, storeId);
	}

	public int updateBatchGroup(Integer[] goodsids, Integer typeId, Integer storeId) {

		return iGoods.updateBatchGroup(goodsids, typeId, storeId);
	}

	public List<MfoyouGoodsSearch> getSearchList() {
		// TODO Auto-generated method stub
		return iGoods.getSearchList();
	}

}
