package bhz.sys.dao;

import bhz.com.dao.BaseJdbcDao;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
@Repository("hanDao")
public class HanDao extends BaseJdbcDao {

    public List<JSONObject> getHanList() throws Exception {
        String sql = "";
        super.queryForJsonList(sql);
        List<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","韩武洽");
        list.add(jsonObject);
        return list;
    }
}
