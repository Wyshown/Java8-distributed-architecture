package bhz.sys.dao.CarService;

import bhz.com.dao.BaseJdbcDao;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("appShopeDao")
@Transactional
public class AppShopDao extends BaseJdbcDao {
	
	private static final String SQL_TABLE_NAME = "SYS_USER";

	private static final String SQL_SELECT_SYS_USER_BYID = "SELECT * FROM gch_app_shop WHERE ID = ?";
	
	public List<JSONObject> getAppShopList(JSONObject jsonObject) throws Exception {
		String sql = "SELECT * FROM gch_view_shop_goods where shop_title like '%"+jsonObject.get("select")+"%' or goods_name like '%"+jsonObject.get("select")+"%'  group by shop_id";
		return super.queryForJsonList(sql);
	}
	
	public JSONObject getAppShopDetails(String id){
		String sql = "select * from gch_app_shop where id ="+ id;
		return super.queryForJsonObject(sql);
	}

	public int insert(JSONObject jsonObject) throws Exception {
		jsonObject.put("createtime",getCurrentTime());
		return super.insert(SQL_TABLE_NAME, jsonObject);
	}

	public int insert2(JSONObject jsonObject) throws Exception {
		System.out.println("--出错的语句---------");
		Integer.parseInt("aa");
		jsonObject.put("createtime",getCurrentTime());
		return super.insert(SQL_TABLE_NAME, jsonObject);
	}
	
}
