/*    */ package com.tencent.xinge;
/*    */ 
/*    */ public class Style { private int m_builderId;
/*    */   private int m_ring;
/*    */   
/*  6 */   public Style(int builderId) { this(builderId, 0, 0, 1, 0, 1, 0, 1); }
/*    */   
/*    */   private int m_vibrate;
/*    */   
/* 10 */   public Style(int builderId, int ring, int vibrate, int clearable, int nId) { this.m_builderId = builderId;
/* 11 */     this.m_ring = ring;
/* 12 */     this.m_vibrate = vibrate;
/* 13 */     this.m_clearable = clearable;
/* 14 */     this.m_nId = nId; }
/*    */   
/*    */   private int m_clearable;
/*    */   private int m_nId;
/*    */   
/* 19 */   public Style(int builderId, int ring, int vibrate, int clearable, int nId, int lights, int iconType, int styleId) { this.m_builderId = builderId;
/* 20 */     this.m_ring = ring;
/* 21 */     this.m_vibrate = vibrate;
/* 22 */     this.m_clearable = clearable;
/* 23 */     this.m_nId = nId;
/* 24 */     this.m_lights = lights;
/* 25 */     this.m_iconType = iconType;
/* 26 */     this.m_styleId = styleId; }
/*    */   
/*    */   private String m_ringRaw;
/*    */   
/* 30 */   public int getBuilderId() { return this.m_builderId; }
/*    */   
/*    */   private int m_lights;
/*    */   
/* 34 */   public int getRing() { return this.m_ring; }
/*    */   
/*    */   private int m_iconType;
/*    */   
/* 38 */   public int getVibrate() { return this.m_vibrate; }
/*    */   
/*    */   private String m_iconRes;
/*    */   
/* 42 */   public int getClearable() { return this.m_clearable; }
/*    */   
/*    */   private int m_styleId;
/*    */   private String m_smallIcon;
/* 46 */   public int getNId() { return this.m_nId; }
/*    */   
/*    */   public int getLights()
/*    */   {
/* 50 */     return this.m_lights;
/*    */   }
/*    */   
/*    */   public int getIconType() {
/* 54 */     return this.m_iconType;
/*    */   }
/*    */   
/*    */   public int getStyleId() {
/* 58 */     return this.m_styleId;
/*    */   }
/*    */   
/*    */   public void setRingRaw(String ringRaw) {
/* 62 */     this.m_ringRaw = ringRaw;
/*    */   }
/*    */   
/*    */   public String getRingRaw() {
/* 66 */     return this.m_ringRaw;
/*    */   }
/*    */   
/*    */   public void setIconRes(String iconRes) {
/* 70 */     this.m_iconRes = iconRes;
/*    */   }
/*    */   
/*    */   public String getIconRes() {
/* 74 */     return this.m_iconRes;
/*    */   }
/*    */   
/*    */   public void setSmallIcon(String smallIcon) {
/* 78 */     this.m_smallIcon = smallIcon;
/*    */   }
/*    */   
/*    */   public String getSmallIcon() {
/* 82 */     return this.m_smallIcon;
/*    */   }
/*    */   
/*    */   public boolean isValid()
/*    */   {
/* 87 */     if ((this.m_ring < 0) || (this.m_ring > 1)) return false;
/* 88 */     if ((this.m_vibrate < 0) || (this.m_vibrate > 1)) return false;
/* 89 */     if ((this.m_clearable < 0) || (this.m_clearable > 1)) return false;
/* 90 */     if ((this.m_lights < 0) || (this.m_lights > 1)) return false;
/* 91 */     if ((this.m_iconType < 0) || (this.m_iconType > 1)) return false;
/* 92 */     if ((this.m_styleId < 0) || (this.m_styleId > 1)) { return false;
/*    */     }
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\Style.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */