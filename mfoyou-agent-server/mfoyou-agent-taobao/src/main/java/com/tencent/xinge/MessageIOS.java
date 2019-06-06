/*     */ package com.tencent.xinge;
/*     */ 
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class MessageIOS
/*     */ {
/*     */   public static final int TYPE_APNS_NOTIFICATION = 11;
/*     */   public static final int TYPE_REMOTE_NOTIFICATION = 12;
/*     */   private int m_expireTime;
/*     */   private String m_sendTime;
/*     */   private java.util.Vector<TimeInterval> m_acceptTimes;
/*     */   private int m_type;
/*     */   private java.util.Map<String, Object> m_custom;
/*     */   
/*     */   public MessageIOS() {
/*  16 */     this.m_sendTime = "2014-03-13 16:13:00";
/*  17 */     this.m_acceptTimes = new java.util.Vector();
/*  18 */     this.m_raw = "";
/*  19 */     this.m_alertStr = "";
/*  20 */     this.m_alertJo = new JSONObject();
/*  21 */     this.m_badge = 0;
/*  22 */     this.m_sound = "";
/*  23 */     this.m_category = "";
/*  24 */     this.m_loopInterval = -1;
/*  25 */     this.m_loopTimes = -1;
/*  26 */     this.m_type = 11; }
/*     */   
/*     */   private String m_raw;
/*     */   
/*  30 */   public void setType(int type) { this.m_type = type; }
/*     */   
/*     */   private String m_alertStr;
/*     */   
/*  34 */   public int getType() { return this.m_type; }
/*     */   
/*     */   private JSONObject m_alertJo;
/*     */   
/*  38 */   public void setExpireTime(int expireTime) { this.m_expireTime = expireTime; }
/*     */   
/*     */   private int m_badge;
/*     */   
/*  42 */   public int getExpireTime() { return this.m_expireTime; }
/*     */   
/*     */   private String m_sound;
/*     */   
/*  46 */   public void setSendTime(String sendTime) { this.m_sendTime = sendTime; }
/*     */   
/*     */   private String m_category;
/*     */   
/*  50 */   public String getSendTime() { return this.m_sendTime; }
/*     */   
/*     */   private int m_loopInterval;
/*     */   private int m_loopTimes;
/*  54 */   public void addAcceptTime(TimeInterval acceptTime) { this.m_acceptTimes.add(acceptTime); }
/*     */   
/*     */   public String acceptTimeToJson()
/*     */   {
/*  58 */     org.json.JSONArray json_arr = new org.json.JSONArray();
/*  59 */     for (TimeInterval ti : this.m_acceptTimes) {
/*  60 */       JSONObject jtmp = ti.toJsonObject();
/*  61 */       json_arr.put(jtmp);
/*     */     }
/*  63 */     return json_arr.toString();
/*     */   }
/*     */   
/*     */   public org.json.JSONArray acceptTimeToJsonArray() {
/*  67 */     org.json.JSONArray json_arr = new org.json.JSONArray();
/*  68 */     for (TimeInterval ti : this.m_acceptTimes) {
/*  69 */       JSONObject jtmp = ti.toJsonObject();
/*  70 */       json_arr.put(jtmp);
/*     */     }
/*  72 */     return json_arr;
/*     */   }
/*     */   
/*     */   public void setCustom(java.util.Map<String, Object> custom) {
/*  76 */     this.m_custom = custom;
/*     */   }
/*     */   
/*     */   public void setRaw(String raw) {
/*  80 */     this.m_raw = raw;
/*     */   }
/*     */   
/*     */   public void setAlert(String alert) {
/*  84 */     this.m_alertStr = alert;
/*     */   }
/*     */   
/*     */   public void setAlert(JSONObject alert) {
/*  88 */     this.m_alertJo = alert;
/*     */   }
/*     */   
/*     */   public void setBadge(int badge) {
/*  92 */     this.m_badge = badge;
/*     */   }
/*     */   
/*     */   public void setSound(String sound) {
/*  96 */     this.m_sound = sound;
/*     */   }
/*     */   
/*     */   public void setCategory(String category) {
/* 100 */     this.m_category = category;
/*     */   }
/*     */   
/*     */   public int getLoopInterval() {
/* 104 */     return this.m_loopInterval;
/*     */   }
/*     */   
/*     */   public void setLoopInterval(int loopInterval) {
/* 108 */     this.m_loopInterval = loopInterval;
/*     */   }
/*     */   
/*     */   public int getLoopTimes() {
/* 112 */     return this.m_loopTimes;
/*     */   }
/*     */   
/*     */   public void setLoopTimes(int loopTimes) {
/* 116 */     this.m_loopTimes = loopTimes;
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/* 120 */     if (!this.m_raw.isEmpty()) {
/* 121 */       return true;
/*     */     }
/* 123 */     if ((this.m_type < 11) || (this.m_type > 12)) {
/* 124 */       return false;
/*     */     }
/* 126 */     if ((this.m_expireTime < 0) || (this.m_expireTime > 259200))
/* 127 */       return false;
/* 128 */     java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     try {
/* 130 */       sdf.parse(this.m_sendTime);
/*     */     } catch (java.text.ParseException e) {
/* 132 */       return false;
/*     */     }
/* 134 */     for (TimeInterval ti : this.m_acceptTimes) {
/* 135 */       if (!ti.isValid()) {
/* 136 */         return false;
/*     */       }
/*     */     }
/* 139 */     if (this.m_type == 12) {
/* 140 */       return true;
/*     */     }
/* 142 */     return (!this.m_alertStr.isEmpty()) || (this.m_alertJo.length() != 0);
/*     */   }
/*     */   
/*     */   public String toJson() {
/* 146 */     if (!this.m_raw.isEmpty()) {
/* 147 */       return this.m_raw;
/*     */     }
/* 149 */     JSONObject json = new JSONObject(this.m_custom);
/* 150 */     json.put("accept_time", acceptTimeToJsonArray());
/*     */     
/* 152 */     JSONObject aps = new JSONObject();
/* 153 */     if (this.m_type == 12) {
/* 154 */       aps.put("content-available", 1);
/* 155 */     } else if (this.m_type == 11) {
/* 156 */       if (this.m_alertJo.length() != 0) {
/* 157 */         aps.put("alert", this.m_alertJo);
/*     */       } else {
/* 159 */         aps.put("alert", this.m_alertStr);
/*     */       }
/* 161 */       if (this.m_badge != 0) {
/* 162 */         aps.put("badge", this.m_badge);
/*     */       }
/* 164 */       if (!this.m_sound.isEmpty()) {
/* 165 */         aps.put("sound", this.m_sound);
/*     */       }
/* 167 */       if (!this.m_category.isEmpty()) {
/* 168 */         aps.put("category", this.m_category);
/*     */       }
/*     */     }
/* 171 */     json.put("aps", aps);
/*     */     
/* 173 */     return json.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\MessageIOS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */