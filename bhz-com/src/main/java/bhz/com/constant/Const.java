package bhz.com.constant;

public final class Const {

    /**
     * <B>构造方法</B><BR>
     */
    private Const() {
    }

    /** 判断代码：是 */
    public static final String TRUE = "1";

    /** 判断代码：否 */
    public static final String FALSE = "0";

    /** 通用字符集编码 */
    public static final String CHARSET_UTF8 = "UTF-8";

    /** 中文字符集编码 */
    public static final String CHARSET_CHINESE = "GBK";

    /** 英文字符集编码 */
    public static final String CHARSET_LATIN = "ISO-8859-1";

    /** 根节点ID */
    public static final String ROOT_ID = "root";

    /** NULL字符串 */
    public static final String NULL = "null";

    /** 日期格式 */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /** 日期时间格式 */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /** 时间戳格式 */
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
    
    /** JSON成功标记 */
    public static final String JSON_SUCCESS = "success";

    /** JSON数据 */
    public static final String JSON_DATA = "data";

    /** JSON数据列表 */
    public static final String JSON_ROWS = "rows";
    
    /** JSON总数 */
    public static final String JSON_TOTAL = "total";

    /** JSON消息文本 */
    public static final String JSON_MESSAGE = "message";
    /** 系统型昵称 */
    public static final String TAG_SYS = "sys";
    /** 基础信息 */
    public static final String TAG_MST = "mst";
    /** MQ消息中间件服务 */
    public static final String TAG_MQ = "mq";
    /** 数据报错 */
    public static final String TAG_DAT = "dat";
    /** 统计分析 */
    public static final String TAG_STA = "sta";
    
    public static final String TAG_INT = "int";  
    
    public static final String[] TAGS = {TAG_SYS, TAG_MST, TAG_MQ, TAG_DAT, TAG_STA, TAG_INT};
    
    /** Cookie键值：验证键值 */
    public static final String COOKIE_VALIDATE_KEY = "VALIDATE_KEY";

    /** Cookie键值：验证键值分割符 */
    public static final String COOKIE_VALIDATE_KEY_SPLIT = "$_";

    /** 请求属性键值：当前项目标识 */
    public static final String REQ_CUR_TAG = "REQ_CUR_TAG";

    /** 请求属性键值：当前用户标识 */
    public static final String REQ_CUR_USER_ID = "CUR_USER_ID";

    /** 请求属性键值：当前用户名称 */
    public static final String REQ_CUR_USER_NAME = "CUR_USER_NAME";

    /** 请求属性键值：当前机构标识 */
    public static final String REQ_CUR_ORG_ID = "CUR_ORG_ID";

    /** 请求属性键值：当前角色名称 */
    public static final String REQ_CUR_ROLE_CODE = "ERROR_CODE";

    /** 请求属性键值：当前角色名称 */
    public static final String REQ_CUR_USER_IMG = "CUR_USER_IMG";


    // ------------------------------返回值定义---------------------------start------
    /**
     * 返回值错误代码: code:0为无错误 1为有错误
     */
    /*** 返回值错误代码:无错误 */
    public static final Integer SUCCESS_CODE = 0;
    /*** 返回值错误代码: 有错误 */
    public static final Integer ERROR_CODE = 1;

    public static final String CODE_STR_E = "e";
    public static final String CODE_STR_DATA = "data";
    public static final String CODE_STR_DESC = "desc";
    public static final String CODE_STR_CODE = "code";
    public static final String CODE_STR_COUNT = "count";
    public static final String CODE_STR_SENDDATA = "sendData";

    /**
     * ERROR_DESC
     */
    public static final String ERROR_CODE_FIND = "查询出错!";
    public static final String ERROR_CODE_ADD = "添加出错!";
    public static final String ERROR_CODE_UPDATE = "修改出错!";
    public static final String ERROR_CODE_DELETE = "删除出错!";
    public static final String ERROR_CODE_ADD_OR_UPDATE = "添加或修改出错!";
    public static final String ERROR_CODE_METHOD = "操作失败，请联系管理员!";

    /**
     * SUCCESS_DESC
     */
    public static final String SUCCESS_DESC_ADD = "添加成功!";
    public static final String SUCCESS_DESC_UPDATE = "修改成功!";

    // ------------------------------返回值定义---------------------------end-------

    /**
     * 时间格式
     */
    public static final String YYYYHHMM = "yyyy-MM-dd";
    public static final String HHMMSS = "HH:mm:ss";
    public static final String YYYYHHMMHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYHHMMHHMM = "yyyy-MM-dd HH:mm";


    public static final String OSS = "http://yichenghui.oss-cn-shanghai.aliyuncs.com/gouchehui/web";


}
