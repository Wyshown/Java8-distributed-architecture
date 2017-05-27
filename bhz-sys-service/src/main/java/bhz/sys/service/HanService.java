package bhz.sys.service;

import bhz.sys.dao.HanDao;
import bhz.sys.facade.HanFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
@Service("hanService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass=bhz.sys.facade.HanFacade.class, protocol = {"rest", "dubbo"})
public class HanService implements HanFacade {

    @Autowired
    private HanDao hanDao;

    @Override
    public List<JSONObject> getHanList() throws Exception {
        return this.hanDao.getHanList();
    }
}
