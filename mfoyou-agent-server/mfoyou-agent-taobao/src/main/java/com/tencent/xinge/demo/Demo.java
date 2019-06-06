/*     */ package com.tencent.xinge.demo;
/*     */ 
/*     */ import com.tencent.xinge.Message;
/*     */ import com.tencent.xinge.MessageIOS;
/*     */ import com.tencent.xinge.XingeApp;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class Demo
/*     */ {
/*     */   private XingeApp xinge;
/*     */   private Message message1;
/*     */   private Message message2;
/*     */   private MessageIOS messageIOS;
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*  20 */     demoXingeSimple();
/*     */     
/*  22 */     Demo t = new Demo();
/*     */     
/*  24 */     System.out.println(t.demoPushSingleDeviceMessage());
/*  25 */     System.out.println(t.demoPushSingleDeviceNotification());
/*  26 */     System.out.println(t.demoPushSingleDeviceNotificationIntent());
/*  27 */     System.out.println(t.demoPushSingleAccount());
/*     */     
/*     */ 
/*  30 */     System.out.println(t.demoPushSingleDeviceMessageIOS());
/*  31 */     System.out.println(t.demoPushSingleDeviceNotificationIOS());
/*  32 */     System.out.println(t.demoPushSingleAccountIOS());
/*  33 */     System.out.println(t.demoPushAccountListIOS());
/*     */     
/*     */ 
/*  36 */     System.out.println(t.demoPushAccountList());
/*  37 */     System.out.println(t.demoPushAllDevice());
/*  38 */     System.out.println(t.demoPushTags());
/*  39 */     System.out.println(t.demoPushAccountListMultiple());
/*  40 */     System.out.println(t.demoPushDeviceListMultiple());
/*     */     
/*     */ 
/*  43 */     System.out.println(t.demoQueryPushStatus());
/*  44 */     System.out.println(t.demoQueryDeviceCount());
/*  45 */     System.out.println(t.demoQueryTags());
/*  46 */     System.out.println(t.demoQueryTagTokenNum());
/*  47 */     System.out.println(t.demoQueryTokenTags());
/*  48 */     System.out.println(t.demoQueryInfoOfToken());
/*  49 */     System.out.println(t.demoQueryTokensOfAccount());
/*     */     
/*     */ 
/*  52 */     System.out.println(t.demoCancelTimingPush());
/*  53 */     System.out.println(t.demoBatchSetTag());
/*  54 */     System.out.println(t.demoBatchDelTag());
/*  55 */     System.out.println(t.demoDeleteTokenOfAccount());
/*  56 */     System.out.println(t.demoDeleteAllTokensOfAccount());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void demoXingeSimple()
/*     */   {
/*  64 */     System.out.println(XingeApp.pushTokenAndroid(0L, "secretKey", "test", "测试", "token"));
/*  65 */     System.out.println(XingeApp.pushAccountAndroid(0L, "secretKey", "test", "测试", "account"));
/*  66 */     System.out.println(XingeApp.pushAllAndroid(0L, "secretKey", "test", "测试"));
/*  67 */     System.out.println(XingeApp.pushTagAndroid(0L, "secretKey", "test", "测试", "tag"));
/*     */     
/*  69 */     System.out.println(XingeApp.pushTokenIos(0L, "secretKey", "测试", "token", 2));
/*  70 */     System.out.println(XingeApp.pushAccountIos(0L, "secretKey", "测试", "account", 2));
/*  71 */     System.out.println(XingeApp.pushAllIos(0L, "secretKey", "测试", 2));
/*  72 */     System.out.println(XingeApp.pushTagIos(0L, "secretKey", "测试", "tag", 2));
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleDeviceMessage()
/*     */   {
/*  77 */     Message message = new Message();
/*  78 */     message.setTitle("title");
/*  79 */     message.setContent("content");
/*  80 */     message.setType(2);
/*  81 */     message.setExpireTime(86400);
/*  82 */     JSONObject ret = this.xinge.pushSingleDevice("token", message);
/*     */     
/*  84 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleDeviceNotification()
/*     */   {
/*  89 */     JSONObject ret = this.xinge.pushSingleDevice("token", this.message1);
/*  90 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected JSONObject demoPushSingleDeviceNotificationIntent()
/*     */   {
/*  97 */     JSONObject ret = this.xinge.pushSingleDevice("token", this.message2);
/*  98 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleDeviceMessageIOS()
/*     */   {
/* 103 */     MessageIOS remoteMessageIOS = new MessageIOS();
/* 104 */     remoteMessageIOS.setType(12);
/* 105 */     return this.xinge.pushSingleDevice("token", this.messageIOS, 2);
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleDeviceNotificationIOS()
/*     */   {
/* 110 */     com.tencent.xinge.TimeInterval acceptTime1 = new com.tencent.xinge.TimeInterval(0, 0, 23, 59);
/* 111 */     this.messageIOS.addAcceptTime(acceptTime1);
/* 112 */     java.util.Map<String, Object> custom = new java.util.HashMap();
/* 113 */     custom.put("key1", "value1");
/* 114 */     custom.put("key2", Integer.valueOf(2));
/* 115 */     this.messageIOS.setCustom(custom);
/*     */     
/* 117 */     JSONObject ret = this.xinge.pushSingleDevice("token", this.messageIOS, 2);
/* 118 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleAccount()
/*     */   {
/* 123 */     Message message = new Message();
/* 124 */     message.setExpireTime(86400);
/* 125 */     message.setTitle("title");
/* 126 */     message.setContent("content");
/* 127 */     message.setType(2);
/* 128 */     JSONObject ret = this.xinge.pushSingleAccount(0, "joelliu", message);
/* 129 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushAccountList()
/*     */   {
/* 134 */     Message message = new Message();
/* 135 */     message.setExpireTime(86400);
/* 136 */     message.setTitle("title");
/* 137 */     message.setContent("content");
/* 138 */     message.setType(2);
/* 139 */     List<String> accountList = new ArrayList();
/* 140 */     accountList.add("joelliu");
/* 141 */     JSONObject ret = this.xinge.pushAccountList(0, accountList, message);
/* 142 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushSingleAccountIOS()
/*     */   {
/* 147 */     MessageIOS message = new MessageIOS();
/* 148 */     message.setExpireTime(86400);
/* 149 */     message.setAlert("ios test");
/* 150 */     message.setBadge(1);
/* 151 */     message.setSound("beep.wav");
/* 152 */     com.tencent.xinge.TimeInterval acceptTime1 = new com.tencent.xinge.TimeInterval(0, 0, 23, 59);
/* 153 */     message.addAcceptTime(acceptTime1);
/* 154 */     java.util.Map<String, Object> custom = new java.util.HashMap();
/* 155 */     custom.put("key1", "value1");
/* 156 */     custom.put("key2", Integer.valueOf(2));
/* 157 */     message.setCustom(custom);
/*     */     
/* 159 */     JSONObject ret = this.xinge.pushSingleAccount(0, "joelliu", this.messageIOS, 2);
/* 160 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushAccountListIOS()
/*     */   {
/* 165 */     List<String> accountList = new ArrayList();
/* 166 */     accountList.add("joelliu");
/* 167 */     JSONObject ret = this.xinge.pushAccountList(0, accountList, this.messageIOS, 2);
/* 168 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushAllDevice()
/*     */   {
/* 173 */     JSONObject ret = this.xinge.pushAllDevice(0, this.message1);
/* 174 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushTags()
/*     */   {
/* 179 */     List<String> tagList = new ArrayList();
/* 180 */     tagList.add("joelliu");
/* 181 */     tagList.add("phone");
/* 182 */     JSONObject ret = this.xinge.pushTags(0, tagList, "OR", this.message1);
/* 183 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoPushAccountListMultiple()
/*     */   {
/* 188 */     Message message = new Message();
/* 189 */     message.setExpireTime(86400);
/* 190 */     message.setTitle("title");
/* 191 */     message.setContent("content");
/* 192 */     message.setType(1);
/*     */     
/* 194 */     JSONObject ret = this.xinge.createMultipush(message);
/* 195 */     if (ret.getInt("ret_code") != 0) {
/* 196 */       return ret;
/*     */     }
/* 198 */     JSONObject result = new JSONObject();
/*     */     
/* 200 */     List<String> accountList1 = new ArrayList();
/* 201 */     accountList1.add("joelliu1");
/* 202 */     accountList1.add("joelliu2");
/*     */     
/* 204 */     result.append("all", this.xinge.pushAccountListMultiple(ret.getJSONObject("result").getLong("push_id"), accountList1));
/*     */     
/* 206 */     List<String> accountList2 = new ArrayList();
/* 207 */     accountList2.add("joelliu3");
/* 208 */     accountList2.add("joelliu4");
/*     */     
/* 210 */     result.append("all", this.xinge.pushAccountListMultiple(ret.getJSONObject("result").getLong("push_id"), accountList2));
/* 211 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   protected JSONObject demoPushDeviceListMultiple()
/*     */   {
/* 217 */     Message message = new Message();
/* 218 */     message.setExpireTime(86400);
/* 219 */     message.setTitle("title");
/* 220 */     message.setContent("content");
/* 221 */     message.setType(1);
/*     */     
/* 223 */     JSONObject ret = this.xinge.createMultipush(message);
/* 224 */     if (ret.getInt("ret_code") != 0) {
/* 225 */       return ret;
/*     */     }
/* 227 */     JSONObject result = new JSONObject();
/*     */     
/* 229 */     List<String> deviceList1 = new ArrayList();
/* 230 */     deviceList1.add("joelliu1");
/* 231 */     deviceList1.add("joelliu2");
/*     */     
/* 233 */     result.append("all", this.xinge.pushDeviceListMultiple(ret.getJSONObject("result").getLong("push_id"), deviceList1));
/*     */     
/* 235 */     List<String> deviceList2 = new ArrayList();
/* 236 */     deviceList2.add("joelliu3");
/* 237 */     deviceList2.add("joelliu4");
/*     */     
/* 239 */     result.append("all", this.xinge.pushDeviceListMultiple(ret.getJSONObject("result").getLong("push_id"), deviceList2));
/* 240 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   protected JSONObject demoQueryPushStatus()
/*     */   {
/* 246 */     List<String> pushIdList = new ArrayList();
/* 247 */     pushIdList.add("390");
/* 248 */     pushIdList.add("389");
/* 249 */     JSONObject ret = this.xinge.queryPushStatus(pushIdList);
/* 250 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryDeviceCount()
/*     */   {
/* 255 */     JSONObject ret = this.xinge.queryDeviceCount();
/* 256 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryTags()
/*     */   {
/* 261 */     JSONObject ret = this.xinge.queryTags();
/* 262 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryTagTokenNum()
/*     */   {
/* 267 */     JSONObject ret = this.xinge.queryTagTokenNum("tag");
/* 268 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryTokenTags()
/*     */   {
/* 273 */     JSONObject ret = this.xinge.queryTokenTags("token");
/* 274 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoCancelTimingPush()
/*     */   {
/* 279 */     JSONObject ret = this.xinge.cancelTimingPush("32");
/* 280 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoBatchSetTag()
/*     */   {
/* 285 */     List<com.tencent.xinge.TagTokenPair> pairs = new ArrayList();
/*     */     
/*     */ 
/* 288 */     pairs.add(new com.tencent.xinge.TagTokenPair("tag1", "token00000000000000000000000000000000001"));
/* 289 */     pairs.add(new com.tencent.xinge.TagTokenPair("tag2", "token00000000000000000000000000000000001"));
/*     */     
/* 291 */     JSONObject ret = this.xinge.BatchSetTag(pairs);
/* 292 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoBatchDelTag()
/*     */   {
/* 297 */     List<com.tencent.xinge.TagTokenPair> pairs = new ArrayList();
/*     */     
/*     */ 
/* 300 */     pairs.add(new com.tencent.xinge.TagTokenPair("tag1", "token00000000000000000000000000000000001"));
/* 301 */     pairs.add(new com.tencent.xinge.TagTokenPair("tag2", "token00000000000000000000000000000000001"));
/*     */     
/* 303 */     JSONObject ret = this.xinge.BatchDelTag(pairs);
/*     */     
/* 305 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryInfoOfToken()
/*     */   {
/* 310 */     JSONObject ret = this.xinge.queryInfoOfToken("token");
/* 311 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoQueryTokensOfAccount()
/*     */   {
/* 316 */     JSONObject ret = this.xinge.queryTokensOfAccount("nickName");
/* 317 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoDeleteTokenOfAccount()
/*     */   {
/* 322 */     JSONObject ret = this.xinge.deleteTokenOfAccount("nickName", "token");
/* 323 */     return ret;
/*     */   }
/*     */   
/*     */   protected JSONObject demoDeleteAllTokensOfAccount()
/*     */   {
/* 328 */     JSONObject ret = this.xinge.deleteAllTokensOfAccount("nickName");
/* 329 */     return ret;
/*     */   }
/*     */   
/*     */   protected void buildMesssges() {
/* 333 */     this.message1 = new Message();
/* 334 */     this.message1.setType(1);
/* 335 */     com.tencent.xinge.Style style = new com.tencent.xinge.Style(1);
/* 336 */     style = new com.tencent.xinge.Style(3, 1, 0, 1, 0);
/* 337 */     com.tencent.xinge.ClickAction action = new com.tencent.xinge.ClickAction();
/* 338 */     action.setActionType(2);
/* 339 */     action.setUrl("http://xg.qq.com");
/* 340 */     java.util.Map<String, Object> custom = new java.util.HashMap();
/* 341 */     custom.put("key1", "value1");
/* 342 */     custom.put("key2", Integer.valueOf(2));
/* 343 */     this.message1.setTitle("title");
/* 344 */     this.message1.setContent("大小");
/* 345 */     this.message1.setStyle(style);
/* 346 */     this.message1.setAction(action);
/* 347 */     this.message1.setCustom(custom);
/* 348 */     com.tencent.xinge.TimeInterval acceptTime1 = new com.tencent.xinge.TimeInterval(0, 0, 23, 59);
/* 349 */     this.message1.addAcceptTime(acceptTime1);
/*     */     
/* 351 */     this.message2 = new Message();
/* 352 */     this.message2.setType(1);
/* 353 */     this.message2.setTitle("title");
/* 354 */     this.message2.setContent("通知点击执行Intent测试");
/* 355 */     style = new com.tencent.xinge.Style(1);
/* 356 */     action = new com.tencent.xinge.ClickAction();
/* 357 */     action.setActionType(3);
/* 358 */     action.setIntent("intent:10086#Intent;scheme=tel;action=android.intent.action.DIAL;S.key=value;end");
/* 359 */     this.message2.setStyle(style);
/* 360 */     this.message2.setAction(action);
/*     */     
/* 362 */     this.messageIOS = new MessageIOS();
/* 363 */     this.messageIOS.setType(11);
/* 364 */     this.messageIOS.setExpireTime(86400);
/* 365 */     this.messageIOS.setAlert("ios test");
/* 366 */     this.messageIOS.setBadge(1);
/* 367 */     this.messageIOS.setCategory("INVITE_CATEGORY");
/* 368 */     this.messageIOS.setSound("beep.wav");
/*     */   }
/*     */   
/*     */   public Demo() {
/* 372 */     XingeApp xinge = new XingeApp(0L, "secret_key");
/* 373 */     buildMesssges();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\demo\Demo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */