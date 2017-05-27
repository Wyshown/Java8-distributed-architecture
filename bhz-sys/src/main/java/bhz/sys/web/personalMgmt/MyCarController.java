package bhz.sys.web.personalMgmt;

import bhz.com.constant.Const;
import bhz.com.util.FastJsonConvert;
import bhz.com.util.RequestUtils;
import bhz.com.util.ResponseJsonUtils;
import bhz.com.util.ResponseUtils;
import bhz.sys.facade.CarService.AppShopFacade;
import bhz.sys.facade.personalMgmt.MyCarFacade;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Controller
@RequestMapping("/myCar")
@Transactional
public class MyCarController {

    List<JSONObject> listObj = new ArrayList<>();


    @Resource
    private MyCarFacade myCarFacade;

    @Resource
    private AppShopFacade appShopFacade;

    /**
     * @param jsonData Json格式如下:
               {"userId":"111"}
    http://localhost:8080/bhz-sys/myCar/findMyCarList.json
     * @Description:
     * @Return: 查询我的车的列表
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/24 9:35
     * @Version 2.0
     */
    @RequestMapping(value = "/findMyCarList.json", consumes = "application/json" )
    @ResponseBody
    public void findMyCarList(HttpServletRequest request, HttpServletResponse response, @RequestBody String jsonData) throws Exception{
        try{
            // 把String类型json的值 转化为JSONObject的json
            JSONObject json = FastJsonConvert.convertJSONToObject(jsonData, JSONObject.class);
            this.listObj = this.myCarFacade.findMyCarList(json);

            ResponseJsonUtils.successRespond(response,this.listObj,this.listObj.size());
        }catch (Exception e){
            ResponseJsonUtils.errorRespond(response, Const.ERROR_CODE_FIND);
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/insert.json", consumes = "application/json")
    @ResponseBody
    @Transactional
    public void getinfo(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonData) throws Exception {
        try{
            // 把String类型json的值 转化为JSONObject的json
            JSONObject json = FastJsonConvert.convertJSONToObject(jsonData, JSONObject.class);

            System.out.println(json);
            appShopFacade.insert(json);
            appShopFacade.insert2(json);

            ResponseJsonUtils.successRespond(response,this.listObj,this.listObj.size());
        }catch (Exception e){
            ResponseJsonUtils.errorRespond(response, Const.ERROR_CODE_FIND);
            e.printStackTrace();
        }
    }
}
