package bhz.com.util;

import bhz.com.constant.Const;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description:
 * @Return: 用来请求返回数据
 * @Author: 韩武洽 @Wyshown
 * @Date: 2017/3/23 16:44
 * @Version 2.0
 */
public final class ResponseJsonUtils {

    static JSONObject responseData = new JSONObject();
    static JSONObject e = new JSONObject();
    static JSONObject data = new JSONObject();

    /**
     * @param sentData 返回的数据
     * @param count 返回数据的总数
     * @Description: 返回JSON格式的数据
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/23 15:58
     * @Version 2.0
     */
    public static void successRespond(HttpServletResponse response, Object sentData, int count) {
        // 用来存放查询的结果
        data.put(Const.CODE_STR_COUNT,count);
        data.put(Const.CODE_STR_SENDDATA,sentData);

        responseData.put(Const.CODE_STR_DESC,"");
        responseData.put(Const.CODE_STR_CODE, Const.SUCCESS_CODE);
        responseData.put(Const.CODE_STR_DATA, data);
        ResponseUtils.putJsonResponse(response,responseData);
    }

    /**
     * @param sentData 数据
     * @Description: 返回JSON格式的数据
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/23 15:58
     * @Version 2.0
     */
    public static void successRespond(HttpServletResponse response, Object sentData) {
        // 用来存放查询的结果
        data.put(Const.CODE_STR_COUNT,0);
        data.put(Const.CODE_STR_SENDDATA,sentData);

        responseData.put(Const.CODE_STR_DESC,"");
        responseData.put(Const.CODE_STR_CODE, Const.SUCCESS_CODE);
        responseData.put(Const.CODE_STR_DATA, data);
        ResponseUtils.putJsonResponse(response,responseData);
    }

    /**
     * @param errorDesc 错误信息
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/23 15:58
     * @Version 2.0
     */
    public static void errorRespond(HttpServletResponse response,String errorDesc) {
        // 用来存放查询的结果
        data.put(Const.CODE_STR_COUNT,-1);
        data.put(Const.CODE_STR_SENDDATA, "{}");

        responseData.put(Const.CODE_STR_DESC,errorDesc);
        responseData.put(Const.CODE_STR_CODE, Const.ERROR_CODE);
        responseData.put(Const.CODE_STR_DATA, data);
        ResponseUtils.putJsonResponse(response,responseData);
    }



}
