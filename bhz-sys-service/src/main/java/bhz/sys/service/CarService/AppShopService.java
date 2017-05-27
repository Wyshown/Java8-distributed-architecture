package bhz.sys.service.CarService;

import bhz.sys.dao.CarService.AppShopDao;
import bhz.sys.facade.CarService.AppShopFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service("appShopService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass= AppShopFacade.class, protocol = {"rest", "dubbo"})
@Transactional
public class AppShopService implements AppShopFacade {

	@Autowired
	private AppShopDao appShopDao;

	@Override
	public String generateKey() throws Exception {
		return this.appShopDao.generateKey();
	}

	@Override
	public List<JSONObject> getAppShopList(JSONObject jsonObject) throws Exception {
		List<JSONObject> list = this.appShopDao.getAppShopList(jsonObject);
		if(!list.isEmpty()){
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	public JSONObject getAppShopDetails(String id) {
		return this.appShopDao.getAppShopDetails(id);
	}

	public int insert(JSONObject jsonObject) throws Exception {
		return this.appShopDao.insert(jsonObject);
	}

	public int insert2(JSONObject jsonObject) throws Exception {
		return this.appShopDao.insert2(jsonObject);
	}

}
