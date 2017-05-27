package bhz.sys.service.personalMgmt;

import bhz.sys.dao.personalMgmt.MyCarDao;
import bhz.sys.facade.personalMgmt.MyCarFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("myCarService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass =bhz.sys.facade.personalMgmt.MyCarFacade.class, protocol = {"rest","dubbo"})
public class MyCarService implements MyCarFacade {

    @Autowired
    private MyCarDao myCarDao;

   public int insertMyCar(JSONObject jsonParam) throws Exception {
        return this.myCarDao.insert(jsonParam);
    }

    @Override
    public List<JSONObject> findMyCarList(JSONObject jsonParam) throws Exception {
        return this.myCarDao.findMyCarList(jsonParam);
    }

    public int getMyCarTotal(JSONObject jsonParam) throws Exception {
        return this.myCarDao.getMyCarTotal(jsonParam);
    }

    public int updateMyCar(JSONObject json) throws Exception {
        return 0;
    }
}
