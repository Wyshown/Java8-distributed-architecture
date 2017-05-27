package bhz.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bhz.com.constant.Const;
import bhz.com.dao.UserComDao;
import bhz.com.util.ResponseUtils;

import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController {

	private UserComDao userComDao;
	
	public UserComDao getUserComDao() {
		return userComDao;
	}
	@Autowired
	public void setUserComDao(UserComDao userComDao) {
		this.userComDao = userComDao;
	}

	/**
     * <B>方法名称：</B>系统首页<BR>
     * <B>概要说明：</B><BR>
     * 
     * @param request 页面请求
     * @param response 页面响应
     * @return ModelAndView 模型视图
     */
    @RequestMapping("/index.html")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView ret = new ModelAndView();
        String existsCookie = (String) request.getAttribute("existsCookie");
        String basePath = (String) request.getAttribute("basePath");
        String myTag = basePath.substring(basePath.indexOf("-")+1, basePath.length());
        if(existsCookie.equals(Const.FALSE)){
        	//设置cookie
        	String remoteUser = request.getRemoteUser();
        	JSONObject userInfo = this.userComDao.getUserInfo(remoteUser);

        	String userId = userInfo.getString("USER_ID");
			String userName = userInfo.getString("USER_NAME");
			String headUrl = userInfo.getString("HEAD_URL");
        	
        	StringBuffer validateKey = new StringBuffer();
        	validateKey.append(userId);

			if(!StringUtils.isBlank(userName)){
				validateKey.append(Const.COOKIE_VALIDATE_KEY_SPLIT);
				validateKey.append(userName);
			}
        	if(!StringUtils.isBlank(headUrl)){
            	validateKey.append(Const.COOKIE_VALIDATE_KEY_SPLIT);
            	validateKey.append(headUrl);
        	}
        	ResponseUtils.setValidateKey(response, validateKey.toString());
        } 
        for(String tag : Const.TAGS){
        	if(myTag.equals(tag)){
        		String redirect = "/" + tag + "index.html";
        		System.out.println(redirect);
        		ret.setViewName("redirect:" + redirect);
        	}
        }
        
        return ret;
    }
    

}
