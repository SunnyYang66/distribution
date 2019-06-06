package org.mfoyou.agent.center.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.center.dao.inf.HuawuStoreInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsInfoMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsOrderCartMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsPackageMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsSearchMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouGoodsTypeMapper;
import org.mfoyou.agent.center.dao.mfoyou.inf.MfoyouSystemMapper;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfoExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfoExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfoExample.Criteria;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCart;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCartExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackageExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeExample;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.common.entity.SearchStoreInfo;
import org.mfoyou.agent.common.inf.IGoods;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.sql.MybatisGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GoodsService implements IGoods{
	@Autowired
	MfoyouGoodsInfoMapper mfoyouGoodsInfoMapper;
	@Autowired
	MfoyouGoodsPackageMapper mfoyouGoodsPackageMapper;
	@Autowired
	MfoyouGoodsTypeMapper mfoyouGoodsTypeMapper;
	@Autowired
	MfoyouSystemMapper  mfoyouSystemMapper;
	@Autowired
	MfoyouGoodsOrderCartMapper mfoyouGoodsOrderCartMapper;
	@Autowired
	HuawuStoreInfoMapper huawuStoreInfoMapper;
	@Autowired
	MfoyouGoodsSearchMapper mfoyouGoodsSearchMapper;
	@Override
    public MfoyouGoodsInfo getGoodsByid(Integer id) {
        return mfoyouGoodsInfoMapper.selectByPrimaryKey(id);
    }
	 @Override
	    public int addGoods(MfoyouGoodsInfo info) {
	        int result = mfoyouGoodsInfoMapper.insertSelective(info);
	        return result == 0 ? 0 : info.getGoodsId();
	    }

	    @Override
	    public List<MfoyouGoodsInfo> getGoodListByStoreId(MfoyouGoodsInfo mfoyouGoodsInfo) {
	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        example.or().andStoreIdEqualTo(mfoyouGoodsInfo.getStoreId()).andGoodsTypeEqualTo(mfoyouGoodsInfo.getGoodsType());
	        return mfoyouGoodsInfoMapper.selectByExample(example);

	    }
	    @Override
	    public int removeGoods(Integer id) {
	        MfoyouGoodsPackageExample example = new MfoyouGoodsPackageExample();
	        example.or().andGoodsIdEqualTo(id);
	        mfoyouGoodsPackageMapper.deleteByExample(example);
	        return mfoyouGoodsInfoMapper.deleteByPrimaryKey(id);
	    }
	  
	    
	    @Override
	    public int removeGoods(Integer id, Integer storeId) {
	        
	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        example.or().andGoodsIdEqualTo(id).andStoreIdEqualTo(storeId);
	        MfoyouGoodsPackageExample example1 = new MfoyouGoodsPackageExample();
	        example1.or().andGoodsIdEqualTo(id);
	        mfoyouGoodsPackageMapper.deleteByExample(example1);
	        return mfoyouGoodsInfoMapper.deleteByExample(example);
	    }
	    @Transactional
	    @Override
	    public int addGoods(MfoyouGoodsInfo info, List<MfoyouGoodsPackage> packages) {
	        
	        int result = mfoyouGoodsInfoMapper.insertSelective(info);
	        if (result == 0) {
	            throw new RuntimeException();
	        }
	        for (int i = 0; i < packages.size(); i++) {
	            MfoyouGoodsPackage mfoyouGoodsPackage = packages.get(i);
	            mfoyouGoodsPackage.setGoodsId(info.getGoodsId());
	            if (info.getGoodsId() == null) {
	                throw new RuntimeException();
	            }
	            int resultV2 = mfoyouGoodsPackageMapper.insertSelective(mfoyouGoodsPackage);
	            if (resultV2 == 0) {
	                throw new RuntimeException();
	            }
	        }
	        return 1;
	    }
	    @Override
	    public int deletePackage(Integer storeId, Integer packageId, Integer goodsId) {
	        
	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        if (storeId == null && packageId == null) {
	            MfoyouGoodsPackageExample example2 = new MfoyouGoodsPackageExample();
	            example2.or().andGoodsIdEqualTo(goodsId);
	            return mfoyouGoodsPackageMapper.deleteByExample(example2);
	        }
	        example.or().andStoreIdEqualTo(storeId).andGoodsIdEqualTo(goodsId);
	        List<MfoyouGoodsInfo> selectByExample = mfoyouGoodsInfoMapper.selectByExample(example);
	        if (selectByExample == null || selectByExample.size() == 0) {
	            return -1; //权限不对  操作别人的商店  危险
	        }
	        return mfoyouGoodsPackageMapper.deleteByPrimaryKey(packageId);
	    }
	    @Override
	    public int addPackage(MfoyouGoodsPackage mfoyouGoodsPackage, Integer storeId) {
	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        example.or().andStoreIdEqualTo(storeId).andGoodsIdEqualTo(mfoyouGoodsPackage.getGoodsId());
	        List<MfoyouGoodsInfo> selectByExample = mfoyouGoodsInfoMapper.selectByExample(example);
	        if (selectByExample == null || selectByExample.size() == 0) {
	            return -1; //权限不对  操作别人的商店  危险
	        }
	        int insertSelective = mfoyouGoodsPackageMapper.insertSelective(mfoyouGoodsPackage);
	        return insertSelective == 0 ? 0 : mfoyouGoodsPackage.getPackageId();
	    }
	    @Override
	    public MfoyouGoodsInfo updateGoods(MfoyouGoodsInfo info) {
	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        example.or().andGoodsIdEqualTo(info.getGoodsId()).andStoreIdEqualTo(info.getStoreId());
	        int result = mfoyouGoodsInfoMapper.updateByExampleSelective(info, example);
	        return result == 1 ? info : null;
	    }
	    @Override
	    public List<MfoyouGoodsTypeV2> getTypeListV2(Integer storeId,int model) {
	        //model为1的时候 不显示下架的  商品
	        return mfoyouGoodsTypeMapper.selectByStoreId(storeId,model);
	    }
	    public int updateType(Integer id, String name, Integer typeId) {
	        MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
	        mfoyouGoodsInfoExample.or().andGoodsTypeEqualTo(id);
	        if (mfoyouGoodsInfoMapper.selectByExample(mfoyouGoodsInfoExample).size() > 0) {
	            return -1;
	        }
	        MfoyouGoodsTypeExample example = new MfoyouGoodsTypeExample();
	        example.or().andStoreIdEqualTo(id).andTypeIdEqualTo(typeId);
	        MfoyouGoodsType type = new MfoyouGoodsType();
	        type.setTypeName(name);
	        return mfoyouGoodsTypeMapper.updateByExampleSelective(type, example);
	    }
	    @Override
		public int modifyTypeOrder(Integer storeId, String[] ids, String[] seqs, String seq) {
			String sql = "update mfoyou_goods_type set type_top = case type_id ";
			for(int i = 0 ;i < ids.length ; i++){
				sql+=" when " +ids[i]+" then "+seqs[i];
			}
			sql+=" end where type_id in ("+seq+") and store_id = "+storeId;
			int update_item = mfoyouSystemMapper.update_item(sql);
			return update_item;
		}
	    @Override
		public ArrayListObject<GoodsInfo> getGoodsByStoreid(Integer storeId, String key,Integer state,Integer type, Integer pageId, Integer pageSize) {
			MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
			Criteria or = mfoyouGoodsInfoExample.or().andStoreIdEqualTo(storeId);
			if(key!=null && !key.equals("")){
				or.andGoodsTitleLike("%"+key+"%");
			}
			if(type!=null){
				or.andGoodsTypeEqualTo(type);
			}
			if(state!=null){
				if(state==1){//已下架
					or.andGoodsShelvesStateEqualTo(0);
				}
				if(state==2) {//已售罄
					or.hasSoldAll();
				}
			}
			int totalCount = mfoyouGoodsInfoMapper.countByExample(mfoyouGoodsInfoExample);
			MybatisGenerator.setLimit(mfoyouGoodsInfoExample, pageId, pageSize);
			return ArrayListObject.bliudArrayList(mfoyouSystemMapper.selectGoodsByExample(mfoyouGoodsInfoExample), pageId, pageSize, totalCount);
		}

		@Override
		public int deleteBatchGoods(Integer[] goodsids, Integer storeId) {
		    MfoyouGoodsPackageExample example = new MfoyouGoodsPackageExample();
		    example.or().andGoodsIdIn(Arrays.asList(goodsids));
		    mfoyouGoodsPackageMapper.deleteByExample(example);
			MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
			mfoyouGoodsInfoExample.or().andStoreIdEqualTo(storeId).andGoodsIdIn(Arrays.asList(goodsids));
			int ret = mfoyouGoodsInfoMapper.deleteByExample(mfoyouGoodsInfoExample);
			return ret;
		}
		@Override
		public int batchUpdateState(Integer[] ids,Integer state,Integer storeId) {
			MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
			mfoyouGoodsInfoExample.or().andGoodsIdIn(Arrays.asList(ids)).andStoreIdEqualTo(storeId);
			MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
			mfoyouGoodsInfo.setGoodsShelvesState(state);
			return mfoyouGoodsInfoMapper.updateByExampleSelective(mfoyouGoodsInfo, mfoyouGoodsInfoExample);
		}

		@Override
		public int updateBatchGroup(Integer[] goodsids, Integer typeId, Integer storeId) {
			MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
			mfoyouGoodsInfoExample.or().andGoodsIdIn(Arrays.asList(goodsids)).andStoreIdEqualTo(storeId);
			MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
			mfoyouGoodsInfo.setGoodsType(typeId);
			return mfoyouGoodsInfoMapper.updateByExampleSelective(mfoyouGoodsInfo, mfoyouGoodsInfoExample);
		}
		public ArrayListObject<GoodsInfo> searchGoodsByStore(Integer storeId, String key, Integer pageIndex, Integer pageSize) {

	        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
	        MybatisGenerator.setLimit(example, pageIndex, pageSize);
	        Criteria criteria = example.or().andGoodsShelvesStateEqualTo(1);
	        if (key != null) {
	            criteria.andGoodsTitleLike("%" + key + "%");
	        }
	        criteria.andStoreIdEqualTo(storeId);
	        int count = mfoyouGoodsInfoMapper.countByExample(example);
	        List<MfoyouGoodsInfo> list = mfoyouGoodsInfoMapper.selectByExample(example);
	        List<Integer> goodsList = new ArrayList<>();
	        Map<Integer, GoodsInfo> map = new HashMap<>();
	        for (MfoyouGoodsInfo info : list) {
	            goodsList.add(info.getGoodsId());
	            GoodsInfo goodsInfo = new GoodsInfo();
	            goodsInfo.setGoodsId(info.getGoodsId());
	            goodsInfo.setPackages( new ArrayList<MfoyouGoodsPackage>());
	            map.put(info.getGoodsId(), goodsInfo);
	            goodsInfo.setMfoyouGoodsInfo(info);
	        }
	        if(goodsList.size() > 0){
	        	 MfoyouGoodsPackageExample examplePackage = new MfoyouGoodsPackageExample();
	             examplePackage.or().andGoodsIdIn(goodsList);
	             List<MfoyouGoodsPackage> packages = mfoyouGoodsPackageMapper.selectByExample(examplePackage);
	             for (MfoyouGoodsPackage mfoyouGoodsPackage : packages) {
	                 map.get(mfoyouGoodsPackage.getGoodsId()).addPackage(mfoyouGoodsPackage);
	             }
	        }
	        return ArrayListObject.bliudArrayList(new ArrayList<GoodsInfo>(map.values()), pageIndex, pageSize, count);
	    }
		 @Override
		    public List<SearchStoreInfo> searchStore(String key, Integer pageIndex, Integer pageSize,Double lat,Double lon,Integer agentid) {
		        if (pageIndex == null)
		            pageIndex = 1;
		        if (pageSize == null)
		            pageSize = 100;
		        else
		            pageSize = Math.min(100, pageSize);
		        key = "%" + key + "%";

		        List<SearchStoreInfo> list = mfoyouSystemMapper.selectStoreByExample(key,lat,lon,(pageIndex - 1) * pageSize, pageSize,agentid);
		        //Integer count = mfoyouSystemMapper.selectCount();
		        return list;

		    }
		 @Override
		  public List<MfoyouGoodsOrderCart> getMfoyouGoodsOrderCartList(Integer userId) {

		        MfoyouGoodsOrderCartExample example = new MfoyouGoodsOrderCartExample();
		        example.or().andUserIdEqualTo(userId);
		        example.setOrderByClause(" store_id desc,item_select desc");
		        return mfoyouGoodsOrderCartMapper.selectByExample(example);

		    }
		 @Override
		 public List<MfoyouGoodsInfo> getMfoyouGoodsInfos(List<Integer> goodsIds) {
		        if (goodsIds.size() == 0) {
		            return new ArrayList<>();
		        }
		        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
		        example.or().andGoodsIdIn(goodsIds);
		        return mfoyouGoodsInfoMapper.selectByExample(example);
		    }
		 @Override
		    public List<HuawuStoreInfo> getMfoyouStoreInfos(List<Integer> storeIds) {
		        if (storeIds.size() == 0) {
		            return new ArrayList<>();
		        }
		        HuawuStoreInfoExample example = new HuawuStoreInfoExample();
		        example.or().andStoreIdIn(storeIds);
		        return huawuStoreInfoMapper.selectByExample(example);
		    }
		 @Override
		    public List<MfoyouGoodsPackage> getMfoyouPackageInfos(List<Integer> packageIds) {
		        if (packageIds.size() == 0) {
		            return new ArrayList<>();
		        }
		        MfoyouGoodsPackageExample example = new MfoyouGoodsPackageExample();
		        example.or().andPackageIdIn(packageIds);
		        return mfoyouGoodsPackageMapper.selectByExample(example);
		    }
		  @Override
		    public int updatePacket(MfoyouGoodsPackage mfoyouGoodsPackage, Integer goodsId, Integer storeId) {
		        
		        MfoyouGoodsInfoExample example = new MfoyouGoodsInfoExample();
		        example.or().andStoreIdEqualTo(storeId).andGoodsIdEqualTo(goodsId);
		        List<MfoyouGoodsInfo> selectByExample = mfoyouGoodsInfoMapper.selectByExample(example);
		        if (selectByExample == null || selectByExample.size() == 0) {
		            return -1; //权限不对  操作别人的商店  危险
		        }
		        return mfoyouGoodsPackageMapper.updateByPrimaryKeySelective(mfoyouGoodsPackage);
		    }
		  @Override
		    public int updateType(Integer id, Integer storeId, MfoyouGoodsType type) {
		        
		        MfoyouGoodsTypeExample example = new MfoyouGoodsTypeExample();
		        example.or().andStoreIdEqualTo(storeId).andTypeIdEqualTo(id);
		        return mfoyouGoodsTypeMapper.updateByExampleSelective(type, example);
		    }

		    @Override
		    public List<MfoyouGoodsPackage> getPackageByid(Integer id) {
		        MfoyouGoodsPackageExample example = new MfoyouGoodsPackageExample();
		        example.or().andGoodsIdEqualTo(id);
		        return mfoyouGoodsPackageMapper.selectByExample(example);
		    }
		    @Override
		    public MfoyouGoodsPackage getPackage(Integer packageId) {
		        return mfoyouGoodsPackageMapper.selectByPrimaryKey(packageId);
		    }
		    @Override
		    public int deleteType(Integer id, Integer storeId) {
		        MfoyouGoodsInfoExample mfoyouGoodsInfoExample = new MfoyouGoodsInfoExample();
		        mfoyouGoodsInfoExample.or().andGoodsTypeEqualTo(id);
		        if (mfoyouGoodsInfoMapper.selectByExample(mfoyouGoodsInfoExample).size() > 0) {
		            return -1;
		        }
		        MfoyouGoodsTypeExample example = new MfoyouGoodsTypeExample();
		        example.or().andStoreIdEqualTo(storeId).andTypeIdEqualTo(id);
		        return mfoyouGoodsTypeMapper.deleteByExample(example);
		    }

		    @Override
		    public int addType(Integer storeId, String typeName) {
		        MfoyouGoodsType type = new MfoyouGoodsType();
		        MfoyouGoodsTypeExample example = new MfoyouGoodsTypeExample();
		        example.or().andTypeNameEqualTo(typeName).andStoreIdEqualTo(storeId);
		        if (mfoyouGoodsTypeMapper.countByExample(example) > 0) {
		            return -1;
		        }
		        type.setStoreId(storeId);
		        type.setTypeName(typeName);
		        mfoyouGoodsTypeMapper.insert(type);
		        return type.getTypeId();
		    }
		    @Override
		    public Integer addMfoyouGoodsOrderCartItem(MfoyouGoodsOrderCart mfoyouGoodsOrderCart) {
		        MfoyouGoodsOrderCart cart = getMfoyouGoodsOrderCart(mfoyouGoodsOrderCart.getGoodsId(), mfoyouGoodsOrderCart.getPackageId(), mfoyouGoodsOrderCart.getUserId());

		        if (cart == null) {
		            mfoyouGoodsOrderCartMapper.insertSelective(mfoyouGoodsOrderCart);
		            return mfoyouGoodsOrderCart.getCartItmeId();
		        } else {
		            cart.setItemGct(null);
		            cart.setItemGmt(null);
		            cart.setItemNumber(cart.getItemNumber() + mfoyouGoodsOrderCart.getItemNumber());
		            cart.setItemUserNonte(mfoyouGoodsOrderCart.getItemUserNonte());
		            cart.setItemSelect(mfoyouGoodsOrderCart.getItemSelect());
		            if (cart.getItemNumber() <= 0) {
		                delMfoyouGoodsOrderCartItme(cart.getCartItmeId());
		                return 0;
		            }
		            mfoyouGoodsOrderCartMapper.updateByPrimaryKeySelective(cart);
		            return cart.getCartItmeId();
		        }

		    }
		    @Override
		    public Boolean delMfoyouGoodsOrderCartItme(Integer itmeId) {
		        return mfoyouGoodsOrderCartMapper.deleteByPrimaryKey(itmeId) == 1;
		    }
		    @Override
		    public MfoyouGoodsOrderCart getMfoyouGoodsOrderCart(Integer goodsId, Integer packagId, Integer customerId) {
		        MfoyouGoodsOrderCartExample example = new MfoyouGoodsOrderCartExample();
		        MfoyouGoodsOrderCartExample.Criteria criteria = example.or().andUserIdEqualTo(customerId);
		        if (goodsId != null) {
		            criteria.andGoodsIdEqualTo(goodsId);
		        }
		        if (packagId != null) {
		            criteria.andPackageIdEqualTo(packagId);
		        } else {
		            criteria.andPackageIdIsNull();
		        }
		        List<MfoyouGoodsOrderCart> list = mfoyouGoodsOrderCartMapper.selectByExample(example);
		        if (list.size() > 0)
		            return list.get(0);
		        return null;
		    }
		    @Override
		    public Boolean delAllMfoyouGoodsOrderCart(Integer customerId, Integer storeId) {
		        MfoyouGoodsOrderCartExample example = new MfoyouGoodsOrderCartExample();
		        MfoyouGoodsOrderCartExample.Criteria criteria = example.or().andUserIdEqualTo(customerId);
		        if (storeId != null) {
		            criteria.andStoreIdEqualTo(storeId);
		        }
		        mfoyouGoodsOrderCartMapper.deleteByExample(example);
		        return true;
		    }
		    @Override
		    public Boolean ModeifyMfoyouGoodsOrderCartItme(MfoyouGoodsOrderCart mfoyouGoodsOrderCart) {
		        return mfoyouGoodsOrderCartMapper.updateByPrimaryKeySelective(mfoyouGoodsOrderCart) == 1;
		    }

		    @Override
		    public Boolean selectMfoyouGoodsOrderCartStore(Integer userId, Integer storeId, Integer selectState) {
		        MfoyouGoodsOrderCartExample example = new MfoyouGoodsOrderCartExample();
		        MfoyouGoodsOrderCartExample.Criteria criteria = example.or().andUserIdEqualTo(userId);
		        if (storeId != null) {
		            criteria.andStoreIdEqualTo(storeId);
		        }
		        MfoyouGoodsOrderCart save = new MfoyouGoodsOrderCart();
		        save.setItemSelect(selectState);
		        mfoyouGoodsOrderCartMapper.updateByExampleSelective(save, example);
		        return true;
		    }
			@Override
			public List<MfoyouGoodsSearch> getSearchList() {
				
				return mfoyouGoodsSearchMapper.selectByExample(null);
			}

}
