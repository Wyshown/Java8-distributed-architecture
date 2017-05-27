package bhz.sys.dao.personalMgmt;

import bhz.com.constant.Const;
import bhz.com.dao.BaseJdbcDao;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Repository("myCarDao")
public class MyCarDao  extends BaseJdbcDao {
    private static final String SQL_TABLE_NAME = "gch_app_mycar";

    public int insert(JSONObject jsonParam) throws Exception {
        return super.insert(SQL_TABLE_NAME, jsonParam);
    }

    /**
     * @Return: 找到我的车的总数
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/23 16:33
     * @Version 2.0
     */
    public int getMyCarTotal(JSONObject jsonParam){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT COUNT(*) FROM gch_app_mycar mycar WHERE 1=1 ");
        List<Object> sqlArgs = new ArrayList<Object>();
        addMyCarWhereCondition(sql, sqlArgs, jsonParam);
        return super.getJdbcTemplate().queryForObject(sql.toString(), Integer.class, sqlArgs.toArray());
    }

    /**
     * @Description:
     * @Return: 封装方法  方便查询用
     * @Author: 韩武洽 @Wyshown
     * @Date: 2017/3/23 16:33
     * @Version 2.0
     */
    private void addMyCarWhereCondition(StringBuffer sql, List<Object> sqlArgs, JSONObject jsonParam) {
        System.out.println(jsonParam);
        String isDefault = jsonParam.getString("isDefault");
        String userId = jsonParam.getString("userId");

        if (!StringUtils.isBlank(isDefault)) {
            sql.append(" AND mycar.is_default = ? ");
            sqlArgs.add("%" + isDefault + "%");
        }
        if (!StringUtils.isBlank(userId)) {
            sql.append(" AND mycar.user_id = ? ");
            sqlArgs.add(userId);
        }
    }

    public List<JSONObject> findMyCarList(JSONObject jsonParam) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT \n");
        sql.append(" brand.id AS brandId, \n");

        sql.append(" CASE \n");
        sql.append(" WHEN brand.logo IS NULL THEN NULL \n");
        sql.append(" ELSE CONCAT('" + Const.OSS + "',REPLACE(brand.logo ,\"type\",\"center\")) \n");
        sql.append(" END AS brandImage, \n");

        sql.append(" mycar.brand_name AS brandName, \n");
        sql.append(" mycar.car_model_name AS carModelName, \n");
        sql.append(" mycar.id AS myCarId, \n");
        sql.append(" mycar.car_number AS carNumber, \n");
        sql.append(" mycar.createtime AS createTime, \n");
        sql.append(" mycar.is_default AS isDefault \n");
        sql.append(" FROM gch_app_mycar mycar \n");
        sql.append(" LEFT JOIN gch_brand AS brand ON mycar.brand_id = brand.id \n");
        sql.append(" WHERE 1=1 \n");

        System.out.println(sql);

        List<Object> sqlArgs = new ArrayList<Object>();
//        addMyCarWhereCondition(sql, sqlArgs, jsonParam);
        return this.queryForJsonList(sql.toString(), sqlArgs.toArray());
    }
}
