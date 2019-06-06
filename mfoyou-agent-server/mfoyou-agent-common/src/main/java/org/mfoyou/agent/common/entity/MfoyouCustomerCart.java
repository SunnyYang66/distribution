package org.mfoyou.agent.common.entity;

import java.util.Date;
import java.util.List;

public class MfoyouCustomerCart {

    Integer     customerId;
    Double      lon;
    Double      lat;
    List<Store> list;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public List<Store> getList() {
        return list;
    }

    public void setList(List<Store> list) {
        this.list = list;
    }

    public static class goods {
        String  goodsTitle;
        String  packagetitle;
        String  goodsUrl;
        Integer goodsNumber;
        Integer buyCount;
        Integer cartItemId;
        Integer goodsId;
        Integer packageId;
        Integer itemSelect;
        Date    addTime;
        Integer promotionType;//促销类型
        Integer costPrice;    //原价
        Integer discountPrice;//促销价格
        private Integer state;

        public String getGoodsUrl() {
            return goodsUrl;
        }

        public void setGoodsUrl(String goodsUrl) {
            this.goodsUrl = goodsUrl;
        }

        public Integer getCartItemId() {
            return cartItemId;
        }

        public void setCartItemId(Integer cartItemId) {
            this.cartItemId = cartItemId;
        }

        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }

        public String getPackagetitle() {
            return packagetitle;
        }

        public void setPackagetitle(String packagetitle) {
            this.packagetitle = packagetitle;
        }

        public Integer getGoodsNumber() {
            return goodsNumber;
        }

        public void setGoodsNumber(Integer goodsNumber) {
            this.goodsNumber = goodsNumber;
        }

        public Integer getBuyCount() {
            return buyCount;
        }

        public void setBuyCount(Integer buyCount) {
            this.buyCount = buyCount;
        }

        public Integer getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
        }

        public Integer getPackageId() {
            return packageId;
        }

        public void setPackageId(Integer packageId) {
            this.packageId = packageId;
        }

        public Integer getItemSelect() {
            return itemSelect;
        }

        public void setItemSelect(Integer itemSelect) {
            this.itemSelect = itemSelect;
        }

        public Date getAddTime() {
            return addTime;
        }

        public void setAddTime(Date addTime) {
            this.addTime = addTime;
        }

        public Integer getPromotionType() {
            return promotionType;
        }

        public void setPromotionType(Integer promotionType) {
            this.promotionType = promotionType;
        }

        public Integer getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(Integer costPrice) {
            this.costPrice = costPrice;
        }

        public Integer getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(Integer discountPrice) {
            this.discountPrice = discountPrice;
        }

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

    }

    public static class Store implements Comparable<Store> {

        List<goods> list;
        String      storeName;
        String      address;
        Integer     openState;
        Integer     distance;
        Integer     storeId;
        String      storeStr;
        String      StroePic;
        Double      lon;
        Double      lat;
        Integer     maxDeliveryDistance;
        //起送总价
        Integer     storeMinGoodsAmount;
        //免邮总价
        Integer     storeFreeFreightAmount;
        
        public Integer getStoreMinGoodsAmount() {
            return storeMinGoodsAmount;
        }

        public void setStoreMinGoodsAmount(Integer storeMinGoodsAmount) {
            this.storeMinGoodsAmount = storeMinGoodsAmount;
        }

        public Integer getStoreFreeFreightAmount() {
            return storeFreeFreightAmount;
        }

        public void setStoreFreeFreightAmount(Integer storeFreeFreightAmount) {
            this.storeFreeFreightAmount = storeFreeFreightAmount;
        }

        public Integer getMaxDeliveryDistance() {
            return maxDeliveryDistance;
        }

        public void setMaxDeliveryDistance(Integer maxDeliveryDistance) {
            this.maxDeliveryDistance = maxDeliveryDistance;
        }

        public List<goods> getList() {
            return list;
        }

        public void setList(List<goods> list) {
            this.list = list;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getOpenState() {
            return openState;
        }

        public void setOpenState(Integer openState) {
            this.openState = openState;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Integer getStoreId() {
            return storeId;
        }

        public void setStoreId(Integer storeId) {
            this.storeId = storeId;
        }

        public String getStroePic() {
            return StroePic;
        }

        public void setStroePic(String stroePic) {
            StroePic = stroePic;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        @Override
        public int compareTo(Store o) {
            if (distance == null) {
                return -1;
            }
            if (o.distance == null) {
                return 1;
            }
            return distance.compareTo(o.distance);
        }

		public String getStoreStr() {
			return storeStr;
		}

		public void setStoreStr(String storeStr) {
			this.storeStr = storeStr;
		}

    }

}
