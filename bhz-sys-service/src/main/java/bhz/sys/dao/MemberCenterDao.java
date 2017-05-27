package bhz.sys.dao;

import bhz.com.dao.BaseJdbcDao;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberCenterDao")
public class MemberCenterDao extends BaseJdbcDao {
	
	private static final String SQL_TABLE_NAME = "gch_app_mycar";
	private static final String SQL_SELECT_SYS_USER = "SELECT * FROM gch_app_mycar WHERE USER_ID = ?";
	private static final String SQL_SELECT_SYS_USER_BYID = "SELECT * FROM gch_app_mycar WHERE ID = ?";
	
	public List<JSONObject> getList(String userId) throws Exception {
		return super.queryForJsonList(SQL_SELECT_SYS_USER,userId);
	}
	
	public JSONObject getById(String id){
		return super.queryForJsonObject(SQL_SELECT_SYS_USER_BYID, id);
	}
	
	public int insert(JSONObject jsonObject) throws Exception {
		return super.insert(SQL_TABLE_NAME, jsonObject);
	}
	
}
