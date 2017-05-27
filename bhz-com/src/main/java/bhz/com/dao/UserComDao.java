package bhz.com.dao;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

@Repository
public class UserComDao extends BaseJdbcDao{

	private static final String SQL_SELECT_USER_INFO = "SELECT ID AS USER_ID, USER_NAME, HEAD_URL FROM gch_user_general WHERE USER_NAME = ?";
	private JSONObject appNoLoginUser = new JSONObject();

	public JSONObject getUserInfo(String userName){
		if (null == userName) {
			appNoLoginUser = new JSONObject();
			appNoLoginUser.put("USER_ID","-1");
			appNoLoginUser.put("USER_NAME","appNoLogin");
			return  appNoLoginUser;
		} else {
			return this.queryForJsonObject(SQL_SELECT_USER_INFO, userName);
		}
	}
	
	
}
