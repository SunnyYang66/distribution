package org.mfoyou.agent.utils.common;

public class RunerWorkState implements Comparable<RunerWorkState>{
	//开工状态
	private Integer openState;
	//进行中订单
	private Integer remainderOrderCount;
	//用户id
	private Integer userId;
	//联系电话
	private String phone;
	//昵称
	private String nickName;
	//姓名
	private String name;
	//当前位置
	private String headUrl;
	private Double lat;
	private Double lon;
	//星级
	private Double star;
	//离目标距离(米)
	private Integer distane;
	private Integer todayOrderCount;
	private Integer todayAmount;
	
	public Integer getOpenState() {
		return openState;
	}
	public void setOpenState(Integer openState) {
		this.openState = openState;
	}
	public Integer getRemainderOrderCount() {
		return remainderOrderCount;
	}
	public void setRemainderOrderCount(Integer remainderOrderCount) {
		this.remainderOrderCount = remainderOrderCount;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getStar() {
		return star;
	}
	public void setStar(Double star) {
		this.star = star;
	}
	public Integer getDistane() {
		return distane;
	}
	public void setDistane(Integer distane) {
		this.distane = distane;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Override
    public int compareTo(RunerWorkState o) {
    	int sub = 0;
    	if(distane!=null && o.distane!=null){
    		 sub = distane - o.distane;
    		 return sub>0?1:-1;
    	}
    	if(distane==null){
    		return 1;
    	}
//    	if(o.distane==null){
    		return -1;
//    	}
//    	if(sub!=0){
//    		return sub>0?1:-1;
//    	}
//        if(sub == 0){
//            sub =  remainderOrderCount - o.remainderOrderCount;
//        }
//        if(sub!=0){
//    		return sub>0?1:-1;
//    	}
//        if(sub == 0){
//            sub = (int)(star - o.star);
//        }
//        return sub>0?1:-1;
    }
	public Integer getTodayOrderCount() {
		return todayOrderCount;
	}
	public void setTodayOrderCount(Integer todayOrderCount) {
		this.todayOrderCount = todayOrderCount;
	}
	public Integer getTodayAmount() {
		return todayAmount;
	}
	public void setTodayAmount(Integer todayAmount) {
		this.todayAmount = todayAmount;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	

}
