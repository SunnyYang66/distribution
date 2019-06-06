/*     */ package com.tencent.xinge;
/*     */ 
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ public class Message
/*     */ {
/*     */   public static final int TYPE_NOTIFICATION = 1;
/*     */   public static final int TYPE_MESSAGE = 2;
/*     */   private String m_title;
/*     */   private String m_content;
/*     */   private int m_expireTime;
/*     */   private String m_sendTime;
/*     */   private java.util.Vector<TimeInterval> m_acceptTimes;
/*     */   
/*     */   public Message()
/*     */   {
/*  17 */     this.m_title = "";
/*  18 */     this.m_content = "";
/*  19 */     this.m_sendTime = "2013-12-20 18:31:00";
/*  20 */     this.m_acceptTimes = new java.util.Vector();
/*  21 */     this.m_multiPkg = 0;
/*  22 */     this.m_raw = "";
/*  23 */     this.m_loopInterval = -1;
/*  24 */     this.m_loopTimes = -1;
/*  25 */     this.m_action = new ClickAction();
/*  26 */     this.m_style = new Style(0); }
/*     */   
/*     */   private int m_type;
/*     */   private int m_multiPkg;
/*     */   
/*  31 */   public void setTitle(String title) { this.m_title = title; }
/*     */   
/*     */   private Style m_style;
/*     */   
/*  35 */   public void setContent(String content) { this.m_content = content; }
/*     */   
/*     */   private ClickAction m_action;
/*     */   
/*  39 */   public void setExpireTime(int expireTime) { this.m_expireTime = expireTime; }
/*     */   
/*     */   private java.util.Map<String, Object> m_custom;
/*     */   
/*  43 */   public int getExpireTime() { return this.m_expireTime; }
/*     */   
/*     */   private String m_raw;
/*     */   
/*  47 */   public void setSendTime(String sendTime) { this.m_sendTime = sendTime; }
/*     */   
/*     */   private int m_loopInterval;
/*     */   private int m_loopTimes;
/*  51 */   public String getSendTime() { return this.m_sendTime; }
/*     */   
/*     */   public void addAcceptTime(TimeInterval acceptTime)
/*     */   {
/*  55 */     this.m_acceptTimes.add(acceptTime);
/*     */   }
/*     */   
/*     */   public String acceptTimeToJson() {
/*  59 */     org.json.JSONArray json_arr = new org.json.JSONArray();
/*  60 */     for (TimeInterval ti : this.m_acceptTimes)
/*     */     {
/*  62 */       JSONObject jtmp = ti.toJsonObject();
/*  63 */       json_arr.put(jtmp);
/*     */     }
/*  65 */     return json_arr.toString();
/*     */   }
/*     */   
/*     */   public org.json.JSONArray acceptTimeToJsonArray() {
/*  69 */     org.json.JSONArray json_arr = new org.json.JSONArray();
/*  70 */     for (TimeInterval ti : this.m_acceptTimes)
/*     */     {
/*  72 */       JSONObject jtmp = ti.toJsonObject();
/*  73 */       json_arr.put(jtmp);
/*     */     }
/*  75 */     return json_arr;
/*     */   }
/*     */   
/*     */   public void setType(int type) {
/*  79 */     this.m_type = type;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  83 */     return this.m_type;
/*     */   }
/*     */   
/*     */   public void setMultiPkg(int multiPkg) {
/*  87 */     this.m_multiPkg = multiPkg;
/*     */   }
/*     */   
/*     */   public int getMultiPkg() {
/*  91 */     return this.m_multiPkg;
/*     */   }
/*     */   
/*     */   public void setStyle(Style style) {
/*  95 */     this.m_style = style;
/*     */   }
/*     */   
/*     */   public void setAction(ClickAction action) {
/*  99 */     this.m_action = action;
/*     */   }
/*     */   
/*     */   public void setCustom(java.util.Map<String, Object> custom) {
/* 103 */     this.m_custom = custom;
/*     */   }
/*     */   
/*     */   public void setRaw(String raw) {
/* 107 */     this.m_raw = raw;
/*     */   }
/*     */   
/*     */   public int getLoopInterval() {
/* 111 */     return this.m_loopInterval;
/*     */   }
/*     */   
/*     */   public void setLoopInterval(int loopInterval) {
/* 115 */     this.m_loopInterval = loopInterval;
/*     */   }
/*     */   
/*     */   public int getLoopTimes() {
/* 119 */     return this.m_loopTimes;
/*     */   }
/*     */   
/*     */   public void setLoopTimes(int loopTimes) {
/* 123 */     this.m_loopTimes = loopTimes;
/*     */   }
/*     */   
/*     */   public boolean isValid()
/*     */   {
/* 128 */     if (!this.m_raw.isEmpty()) return true;
/* 129 */     if ((this.m_type < 1) || (this.m_type > 2))
/* 130 */       return false;
/* 131 */     if ((this.m_multiPkg < 0) || (this.m_multiPkg > 1))
/* 132 */       return false;
/* 133 */     if (this.m_type == 1)
/*     */     {
/* 135 */       if (!this.m_style.isValid()) return false;
/* 136 */       if (!this.m_action.isValid()) return false;
/*     */     }
/* 138 */     if ((this.m_expireTime < 0) || (this.m_expireTime > 259200))
/* 139 */       return false;
/* 140 */     java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     try
/*     */     {
/* 143 */       sdf.parse(this.m_sendTime);
/*     */     } catch (java.text.ParseException e) {
/* 145 */       return false;
/*     */     }
/* 147 */     for (TimeInterval ti : this.m_acceptTimes) {
/* 148 */       if (!ti.isValid()) return false;
/*     */     }
/* 150 */     if ((this.m_loopInterval > 0) && (this.m_loopTimes > 0) && ((this.m_loopTimes - 1) * this.m_loopInterval + 1 > 15))
/*     */     {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   public String toJson()
/*     */   {
/* 160 */     if (!this.m_raw.isEmpty()) return this.m_raw;
/* 161 */     JSONObject json = new JSONObject();
/* 162 */     if (this.m_type == 1)
/*     */     {
/* 164 */       json.put("title", this.m_title);
/* 165 */       json.put("content", this.m_content);
/* 166 */       json.put("accept_time", acceptTimeToJsonArray());
/* 167 */       json.put("builder_id", this.m_style.getBuilderId());
/* 168 */       json.put("ring", this.m_style.getRing());
/* 169 */       json.put("vibrate", this.m_style.getVibrate());
/* 170 */       json.put("clearable", this.m_style.getClearable());
/* 171 */       json.put("n_id", this.m_style.getNId());
/* 172 */       json.put("ring_raw", this.m_style.getRingRaw());
/* 173 */       json.put("lights", this.m_style.getLights());
/* 174 */       json.put("icon_type", this.m_style.getIconType());
/* 175 */       json.put("icon_res", this.m_style.getIconRes());
/* 176 */       json.put("style_id", this.m_style.getStyleId());
/* 177 */       json.put("small_icon", this.m_style.getSmallIcon());
/* 178 */       json.put("action", this.m_action.toJsonObject());
/*     */     }
/* 180 */     else if (this.m_type == 2)
/*     */     {
/* 182 */       json.put("title", this.m_title);
/* 183 */       json.put("content", this.m_content);
/* 184 */       json.put("accept_time", acceptTimeToJsonArray());
/*     */     }
/* 186 */     json.put("custom_content", this.m_custom);
/* 187 */     return json.toString();
/*     */   }
public String getM_title() {
    return m_title;
}
public void setM_title(String m_title) {
    this.m_title = m_title;
}
public String getM_content() {
    return m_content;
}
public void setM_content(String m_content) {
    this.m_content = m_content;
}
public int getM_expireTime() {
    return m_expireTime;
}
public void setM_expireTime(int m_expireTime) {
    this.m_expireTime = m_expireTime;
}
public String getM_sendTime() {
    return m_sendTime;
}
public void setM_sendTime(String m_sendTime) {
    this.m_sendTime = m_sendTime;
}
public java.util.Vector<TimeInterval> getM_acceptTimes() {
    return m_acceptTimes;
}
public void setM_acceptTimes(java.util.Vector<TimeInterval> m_acceptTimes) {
    this.m_acceptTimes = m_acceptTimes;
}
public int getM_type() {
    return m_type;
}
public void setM_type(int m_type) {
    this.m_type = m_type;
}
public int getM_multiPkg() {
    return m_multiPkg;
}
public void setM_multiPkg(int m_multiPkg) {
    this.m_multiPkg = m_multiPkg;
}
public Style getM_style() {
    return m_style;
}
public void setM_style(Style m_style) {
    this.m_style = m_style;
}
public ClickAction getM_action() {
    return m_action;
}
public void setM_action(ClickAction m_action) {
    this.m_action = m_action;
}
public java.util.Map<String, Object> getM_custom() {
    return m_custom;
}
public void setM_custom(java.util.Map<String, Object> m_custom) {
    this.m_custom = m_custom;
}
public String getM_raw() {
    return m_raw;
}
public void setM_raw(String m_raw) {
    this.m_raw = m_raw;
}
public int getM_loopInterval() {
    return m_loopInterval;
}
public void setM_loopInterval(int m_loopInterval) {
    this.m_loopInterval = m_loopInterval;
}
public int getM_loopTimes() {
    return m_loopTimes;
}
public void setM_loopTimes(int m_loopTimes) {
    this.m_loopTimes = m_loopTimes;
}
            
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */