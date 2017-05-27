package bhz.sys.web;

import bhz.com.util.RequestUtils;
import bhz.com.util.ResponseUtils;
import bhz.sys.facade.MemberCenterFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2017/3/18.
 */
@Controller
@RequestMapping("/memberCenter/")
public class MemberCenterController {

    @Resource
    private MemberCenterFacade memberCenterFacade;

    @RequestMapping(value = "/myCar/insert/list.json", method = RequestMethod.POST)
    public void myCarInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String query = request.getParameter("query");
        JSONObject json = JSONObject.parseObject(query);
//        json.put("createtime",RequestUtils.getCurrentTime());
        System.out.println(json);
        int value = this.memberCenterFacade.insert(json);

        JSONObject record = new JSONObject();
        record.put("code", "1");
        record.put("desc", "添加成功");
        record.put("data", value);
        ResponseUtils.putJsonResponse(response, record);
    }

    @RequestMapping(value = "/myCar/getList/list.json", method = RequestMethod.POST)
    public void getinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getParameter("query"));
        String query = request.getParameter("query");
        JSONObject json = JSONObject.parseObject(query);
        String userId = json.getString("user_id");

        JSONObject value = (JSONObject) this.memberCenterFacade.getList(userId);

        System.out.println("-----------------han---value----");
        System.out.println(value);
        ResponseUtils.putJsonResponse(response, value);
    }
}
