package org.mfoyou.agent.utils.common;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * 主要存了北京那边查询过来的int对应的含义
 */
public class ContentMapUtil {

    /**
     * CompanyState:企业状态
     * 也是 营业状态busiState
     */
    public static final Map<Integer, String> COMPANY_STATE_MAP = ImmutableMap.<Integer, String>builder()
            .put(3, "迁出")
            .put(2, "其他")
            .put(1, "开业")
            .put(-1, "吊销")
            .put(0, "未知")
            .put(4, "存续")
            .build();

    /**
     * CompanyScale 企业规模
     */
    public static final Map<Integer, String> COMPANY_SCALE_MAP = ImmutableMap.<Integer, String>builder()
            .put(0, "未知")
            .put(1, "30以内")
            .put(2, "30~50")
            .put(3, "50~100")
            .put(4, "100~500")
            .put(5, "500~1000")
            .put(6, "1000~10000")
            .put(7, "10000以上")
            .build();

    /**
     * 企业商圈
     */
    public static final Map<Integer, String> COMPANY_BUSI_CIRCLE = ImmutableMap.<Integer, String>builder()
            .put(1, "POS圈")
            .put(2, "电商圈")
            .put(6, "上市公司圈")
            .build();

    /**
     * IPO类型
     */
    public static final Map<Integer, String> COMPANY_IPO_TYPE = ImmutableMap.<Integer, String>builder()
            .put(0, "未上市")
            .put(1, "A股")
            .put(2, "港股")
            .put(3, "美股")
            .build();


}
