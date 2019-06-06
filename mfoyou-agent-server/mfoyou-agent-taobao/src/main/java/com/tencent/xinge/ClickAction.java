/*     */ package com.tencent.xinge;

/*     */
/*     */ import org.json.JSONObject;

/*     */
/*     */ public class ClickAction {
    public static final int           TYPE_ACTIVITY = 1;
    /*     */ public static final int TYPE_URL      = 2;
    /*     */ public static final int TYPE_INTENT   = 3;
    /*     */ private int             m_actionType;
    /*     */ private String          m_url;
    /*     */ private int             m_confirmOnUrl;
    /*     */

    /*  12 */ public void setActionType(int actionType) {
        this.m_actionType = actionType;
    }

    public int getM_actionType() {
        return m_actionType;
    }

    public void setM_actionType(int m_actionType) {
        this.m_actionType = m_actionType;
    }

    public String getM_url() {
        return m_url;
    }

    public void setM_url(String m_url) {
        this.m_url = m_url;
    }

    public int getM_confirmOnUrl() {
        return m_confirmOnUrl;
    }

    public void setM_confirmOnUrl(int m_confirmOnUrl) {
        this.m_confirmOnUrl = m_confirmOnUrl;
    }

    public String getM_activity() {
        return m_activity;
    }

    public void setM_activity(String m_activity) {
        this.m_activity = m_activity;
    }

    public String getM_intent() {
        return m_intent;
    }

    public void setM_intent(String m_intent) {
        this.m_intent = m_intent;
    }

    public int getM_atyAttrIntentFlag() {
        return m_atyAttrIntentFlag;
    }

    public void setM_atyAttrIntentFlag(int m_atyAttrIntentFlag) {
        this.m_atyAttrIntentFlag = m_atyAttrIntentFlag;
    }

    public int getM_atyAttrPendingIntentFlag() {
        return m_atyAttrPendingIntentFlag;
    }

    public void setM_atyAttrPendingIntentFlag(int m_atyAttrPendingIntentFlag) {
        this.m_atyAttrPendingIntentFlag = m_atyAttrPendingIntentFlag;
    }

    public String getM_packageDownloadUrl() {
        return m_packageDownloadUrl;
    }

    public void setM_packageDownloadUrl(String m_packageDownloadUrl) {
        this.m_packageDownloadUrl = m_packageDownloadUrl;
    }

    public int getM_confirmOnPackageDownloadUrl() {
        return m_confirmOnPackageDownloadUrl;
    }

    public void setM_confirmOnPackageDownloadUrl(int m_confirmOnPackageDownloadUrl) {
        this.m_confirmOnPackageDownloadUrl = m_confirmOnPackageDownloadUrl;
    }

    public String getM_packageName() {
        return m_packageName;
    }

    public void setM_packageName(String m_packageName) {
        this.m_packageName = m_packageName;
    }

    /*     */
    /*     */ private String m_activity;

    /*     */
    /*  16 */ public void setActivity(String activity) {
        this.m_activity = activity;
    }

    /*     */
    /*     */ private String m_intent;

    /*     */
    /*  20 */ public void setUrl(String url) {
        this.m_url = url;
    }

    /*     */
    /*     */ private int m_atyAttrIntentFlag;

    /*     */
    /*  24 */ public void setConfirmOnUrl(int confirmOnUrl) {
        this.m_confirmOnUrl = confirmOnUrl;
    }

    /*     */
    /*     */ private int m_atyAttrPendingIntentFlag;

    /*     */
    /*  28 */ public void setIntent(String intent) {
        this.m_intent = intent;
    }

    /*     */
    /*     */ private String m_packageDownloadUrl;

    /*     */
    /*  32 */ public void setAtyAttrIntentFlag(int atyAttrIntentFlag) {
        this.m_atyAttrIntentFlag = atyAttrIntentFlag;
    }

    /*     */
    /*     */ private int    m_confirmOnPackageDownloadUrl;
    /*     */ private String m_packageName;

    /*  36 */ public void setAtyAttrPendingIntentFlag(int atyAttrPendingIntentFlag) {
        this.m_atyAttrPendingIntentFlag = atyAttrPendingIntentFlag;
    }

    /*     */
    /*     */ public void setPackageDownloadUrl(String packageDownloadUrl)
    /*     */ {
        /*  40 */ this.m_packageDownloadUrl = packageDownloadUrl;
        /*     */ }

    /*     */
    /*     */ public void setConfirmOnPackageDownloadUrl(int confirmOnPackageDownloadUrl) {
        /*  44 */ this.m_confirmOnPackageDownloadUrl = confirmOnPackageDownloadUrl;
        /*     */ }

    /*     */
    /*     */ public void setPackageName(String packageName) {
        /*  48 */ this.m_packageName = packageName;
        /*     */ }

    /*     */
    /*     */ public String toJson()
    /*     */ {
        /*  53 */ JSONObject json = new JSONObject();
        /*  54 */ json.put("action_type", this.m_actionType);
        /*  55 */ JSONObject browser = new JSONObject();
        /*  56 */ browser.put("url", this.m_url);
        /*  57 */ browser.put("confirm", this.m_confirmOnUrl);
        /*  58 */ json.put("browser", browser);
        /*  59 */ json.put("activity", this.m_activity);
        /*  60 */ json.put("intent", this.m_intent);
        /*     */
        /*  62 */ JSONObject aty_attr = new JSONObject();
        /*  63 */ aty_attr.put("if", this.m_atyAttrIntentFlag);
        /*  64 */ aty_attr.put("pf", this.m_atyAttrPendingIntentFlag);
        /*  65 */ json.put("aty_attr", aty_attr);
        /*     */
        /*  67 */ return json.toString();
        /*     */ }

    /*     */
    /*     */ public JSONObject toJsonObject()
    /*     */ {
        /*  72 */ JSONObject json = new JSONObject();
        /*  73 */ json.put("action_type", this.m_actionType);
        /*  74 */ JSONObject browser = new JSONObject();
        /*  75 */ browser.put("url", this.m_url);
        /*  76 */ browser.put("confirm", this.m_confirmOnUrl);
        /*  77 */ json.put("browser", browser);
        /*  78 */ json.put("activity", this.m_activity);
        /*  79 */ json.put("intent", this.m_intent);
        /*     */
        /*  81 */ JSONObject aty_attr = new JSONObject();
        /*  82 */ aty_attr.put("if", this.m_atyAttrIntentFlag);
        /*  83 */ aty_attr.put("pf", this.m_atyAttrPendingIntentFlag);
        /*  84 */ json.put("aty_attr", aty_attr);
        /*     */
        /*  86 */ return json;
        /*     */ }

    /*     */
    /*     */ public boolean isValid()
    /*     */ {
        /*  91 */ if ((this.m_actionType < 1) || (this.m_actionType > 3)) {
            return false;
            /*     */ }
        /*  93 */ if (this.m_actionType == 2)
        /*     */ {
            /*  95 */ if ((this.m_url.isEmpty()) || (this.m_confirmOnUrl < 0) || (this.m_confirmOnUrl > 1))
                return false;
            /*  96 */ return true;
            /*     */ }
        /*  98 */ if (this.m_actionType == 3)
        /*     */ {
            /* 100 */ if (this.m_intent.isEmpty())
                return false;
            /* 101 */ return true;
            /*     */ }
        /* 103 */ return true;
        /*     */ }

    /*     */
    /*     */ public ClickAction()
    /*     */ {
        /* 108 */ this.m_url = "";
        /* 109 */ this.m_actionType = 1;
        /* 110 */ this.m_activity = "";
        /*     */
        /* 112 */ this.m_atyAttrIntentFlag = 0;
        /* 113 */ this.m_atyAttrPendingIntentFlag = 0;
        /*     */
        /* 115 */ this.m_packageDownloadUrl = "";
        /* 116 */ this.m_confirmOnPackageDownloadUrl = 1;
        /* 117 */ this.m_packageName = "";
        /*     */ }
    /*     */ }

/* Location:              C:\Users\Administrator\Desktop\Xg-Push-SDK-JAVA-1.1.8\PushJavaSDK.jar!\com\tencent\xinge\ClickAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */