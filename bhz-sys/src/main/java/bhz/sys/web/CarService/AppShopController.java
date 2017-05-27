package bhz.sys.web.CarService;

import bhz.com.constant.Const;
import bhz.com.util.*;
import bhz.sys.facade.CarService.AppShopFacade;
import bhz.sys.facade.MemberCenterFacade;
import bhz.sys.facade.personalMgmt.MyCarFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/3/18.
 */
@Controller
@RequestMapping("/appNoLogin/appShop/")
public class AppShopController {

    @Resource
    private AppShopFacade appShopFacade;


    @RequestMapping(value = "/carService/insert/list.json", method = RequestMethod.POST)
    public void myCarInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String query = request.getParameter("query");
        JSONObject json = JSONObject.parseObject(query);
        System.out.println(json);
        int value = this.appShopFacade.insert(json);

        JSONObject record = new JSONObject();
        record.put("code", "1");
        record.put("desc", "添加成功");
        record.put("data", value);
        ResponseUtils.putJsonResponse(response, record);
    }


    @RequestMapping(value = "/carService/getList/list.json", consumes = "application/json")
    @ResponseBody
    @Transactional
    public void getinfo(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonData) throws Exception {
        /*System.out.println(query);
        JSONObject json = JSONObject.parseObject(query);
        String isHot = json.getString("is_hot");
        System.out.println(isHot);
       *//* JSONObject value = (JSONObject) this.carServiceFacade.getList(isHot);*//*
        ResponseJsonUtils.successRespond(response,this.listObj,this.listObj.size());
        return query;*/
        try {
            System.out.println(jsonData);
            JSONObject json = FastJsonConvert.convertJSONToObject(jsonData, JSONObject.class);
            System.out.println(json);
            /*this.listObj = this.myCarFacade.findMyCarList(json);*/
            ResponseJsonUtils.successRespond(response, json, json.size());
        } catch (Exception e) {
            ResponseJsonUtils.errorRespond(response, Const.ERROR_CODE_FIND);
            e.printStackTrace();
        }
    }



}
