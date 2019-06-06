package org.mfoyou.agent.utils.common;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * 记录各种常量
 */
public class ConstantUtil {

    /**
     * 搜索结果,每页展示多少个公司
     */
    public static final int SEARCH_PAGE_SIZE = 9;
    /**
     * 搜索结果,最多展示几页，0为第一页
     */
    public static final int SEARCH_MAX_PAGENUM = 11;  //最多12页
    /**
     * 按照上面的分页设置，总共条目数
     */
    public static final int SEARCH_MAX_ITEM = SEARCH_PAGE_SIZE * (SEARCH_MAX_PAGENUM + 1);


    /**
     * 圈子
     */
    public static final Map<String, String> CIRCLE = ImmutableMap.<String, String>builder()
            .put("ecommer", "2")
            .put("pos", "1")
            .put("ipo", "6")
            .build();

    /**
     * 邮箱验证链接失效时间
     */
    public static final int VERIFY_EMAIL_EXPIRE_SECONDES = 30 * 60;

    /**
     * 找回密码的redis key后缀
     */
    public static final String FIND_PWD_SUFFIX = "_find_pwd";

    /**
     * 如果搜索结果是来自爬虫的公司，需要把对应的信息放到 redis
     */
    public static final String SPIDER_NEED_INFO_PREFIX = "spider:queryinfo:";

    /**
     * 缓存爬虫公司的 key
     */
    public static final String SPIDER_COMPANY_SUFFIX = "spider:industry:";

    /**
     * 购物车缓存
     */
    public static final String SHOPCARD_PREFIX = "shopcard:";
    /**
     * 购物车缓存时间
     */
    public static final int SHOPCARD_EXPIRE_SECONDES = 60 * 60 * 1;

    /**
     * price_config缓存key
     */
    public static final String PRICE_CONFIG_KEY = "price:config";
    /**
     * price_config缓存时间
     */
    public static final int PRICE_CONFIG_KEY_EXPIRE_SECONDES = 60 * 60 * 24;

    /**
     * 搜索结果页-省份首字母
     */
    public static final Map<String, String> PROVINCE_LETTER = ImmutableMap.<String, String>builder()
            .put("北京市", "B")
            .put("天津市", "T")
            .put("重庆市", "C")
            .put("上海市", "S")
            .put("河北省", "H")
            .put("山西省", "S")
            .put("辽宁省", "L")
            .put("吉林省", "J")
            .put("黑龙江省", "H")
            .put("江苏省", "J")
            .put("浙江省", "Z")
            .put("安徽省", "A")
            .put("福建省", "F")
            .put("江西省", "J")
            .put("山东省", "S")
            .put("河南省", "H")
            .put("湖北省", "H")
            .put("湖南省", "H")
            .put("广东省", "G")
            .put("海南省", "H")
            .put("四川省", "S")
            .put("贵州省", "G")
            .put("云南省", "Y")
            .put("陕西省", "S")
            .put("甘肃省", "G")
            .put("青海省", "Q")
            .put("台湾省", "T")
            .put("内蒙古自治区", "N")
            .put("广西壮族自治区", "G")
            .put("西藏自治区", "X")
            .put("宁夏回族自治区", "N")
            .put("新疆维吾尔自治区", "X")
            .put("香港特别行政区", "X")
            .put("澳门特别行政区", "A")
            .build();

    /**
     * 记录用户身份
     */
    public static final Map<String, String> USER_IDNTITY = ImmutableMap.<String, String>builder()
    		.put("admin","10")
    		.put("superuser","5")
    		.put("generaluser","1")
    		.build();
    		

}
