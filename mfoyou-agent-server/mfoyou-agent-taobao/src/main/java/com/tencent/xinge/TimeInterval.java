/*    */ package com.tencent.xinge;
/*    */ 
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ public class TimeInterval {
           private int m_startHour;
/*    */   private int m_startMin;
/*    */   
/*  8 */   public TimeInterval(int startHour, int startMin, int endHour, int endMin) { this.m_startHour = startHour;
/*  9 */     this.m_startMin = startMin;
/* 10 */     this.m_endHour = endHour;
/* 11 */     this.m_endMin = endMin;
/*    */   }
/*    */   
/*    */   private int m_endHour;
/*    */   private int m_endMin;
/* 16 */   public boolean isValid() { if ((this.m_startHour >= 0) && (this.m_startHour <= 23) && (this.m_startMin >= 0) && (this.m_startMin <= 59) && (this.m_endHour >= 0) && (this.m_endHour <= 23) && (this.m_endMin >= 0) && (this.m_endMin <= 59))
/*    */     {
/*    */ 
/*    */ 
/* 20 */       return true;
/*    */     }
/* 22 */     return false;
/*    */   }
/*    */   
            
/*    */   public JSONObject toJsonObject()
/*    */   {
/* 27 */     JSONObject json = new JSONObject();
/* 28 */     JSONObject js = new JSONObject();
/* 29 */     JSONObject je = new JSONObject();
/* 30 */     js.put("hour", String.valueOf(this.m_startHour));
/* 31 */     js.put("min", String.valueOf(this.m_startMin));
/* 32 */     je.put("hour", String.valueOf(this.m_endHour));
/* 33 */     je.put("min", String.valueOf(this.m_endMin));
/* 34 */     json.put("start", js);
/* 35 */     json.put("end", je);
/* 36 */     return json;
/*    */   }
/*    */

public int getM_startHour() {
    return m_startHour;
}

public void setM_startHour(int m_startHour) {
    this.m_startHour = m_startHour;
}

public int getM_startMin() {
    return m_startMin;
}

public void setM_startMin(int m_startMin) {
    this.m_startMin = m_startMin;
}

public int getM_endHour() {
    return m_endHour;
}

public void setM_endHour(int m_endHour) {
    this.m_endHour = m_endHour;
}

public int getM_endMin() {
    return m_endMin;
}

public void setM_endMin(int m_endMin) {
    this.m_endMin = m_endMin;
} }


/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\TimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */