package com.mfoyou.agent.web.intercepter;


public enum UserRight {
	
	 //所有可访问
	 ALLACCESS(0),
	 //登陆后可访问
	 LOGINACCESS(1), 
//跑腿员可访问
	 RUNERACCESS(4),
//服务商可以访问
     AGENTACCESS(2),
// 不是我们系统
     STOREACCESS(8),
//     站长
     STATIONMASTER(32),
//	管理后台
	 ADMINACCESS(128);
	 
	
	 private int _value = 0;
	 
	 private UserRight(int value){
		 _value =  value;
	 }
	 
	 public int getValue(){
		 return _value;
	 }
	 
	 

}
