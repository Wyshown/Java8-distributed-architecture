package bhz.sys.web;

import bhz.com.util.RequestUtils;
import bhz.com.util.ResponseUtils;
import bhz.sys.facade.HanFacade;
import bhz.sys.facade.SysUserFacade;
import com.alibaba.fastjson.JSONObject;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
@Controller
@RequestMapping("/test/")
public class HanController {

    @Resource
    private HanFacade hanFacade;
    @Resource
    private SysUserFacade sysUserFacade;

    @RequestMapping("/han.json")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "hanTest";
    }

    @RequestMapping(value = "/systest/list.json", method = RequestMethod.GET, produces = "application/json;charset=utf-8", consumes = "application/json")
    public void test(HttpServletRequest request, HttpServletResponse response, String query) throws Exception {
        String roleCode = RequestUtils.getCurrentRoleCode(request);
        List<JSONObject> records = new ArrayList<JSONObject>();
        JSONObject record = new JSONObject();
        //'id' ,'text' , 'type' , 'leaf', 'url'
        record.put("id", "12222");
        record.put("text", "text11");
        record.put("type", "type1111111");
        record.put("leaf", true);
        record.put("url", "url11111111");
        ResponseUtils.putJsonResponse(response, record);
    }

    @RequestMapping(value = "/test/list.json", method = RequestMethod.POST, produces = "application/json;charset=utf-8", consumes = "application/json")
    @ResponseBody
    public JSONObject test(@RequestBody String query) throws Exception {
        System.out.println(query);
        JSONObject json = JSONObject.parseObject(query);
        String id = json.getString("id");
        System.out.println(id);
        JSONObject value = this.sysUserFacade.getById(id);
        System.out.println(value);
        return value;

    }

    @RequestMapping(value = "/getinfo/list.json", method = RequestMethod.POST)
    public void getinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getParameter("query"));
        String query = request.getParameter("query");
        JSONObject json = JSONObject.parseObject(query);
        String id = json.getString("id");
        System.out.println(id);
        JSONObject value = this.sysUserFacade.getById(id);

        System.out.println("-----------------han---value----");
        System.out.println(value);
//        return value;
        ResponseUtils.putJsonResponse(response, value);
    }
}
