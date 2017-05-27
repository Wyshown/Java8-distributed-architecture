package bhz.sys.service;

import bhz.sys.dao.MemberCenterDao;
import bhz.sys.dao.SysUserDao;
import bhz.sys.facade.MemberCenterFacade;
import bhz.sys.facade.SysUserFacade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service("memberCenterService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass= MemberCenterFacade.class, protocol = {"rest", "dubbo"})
public class MemberCenterService implements MemberCenterFacade {

	@Autowired
	private MemberCenterDao memberCenterDao;

	@Override
	public String generateKey() throws Exception {
		return this.memberCenterDao.generateKey();
	}
	
	@Override
	public JSONObject getById(String id) {
		return this.memberCenterDao.getById(id);
	}

	@Override
	public List<JSONObject> getList(String userId) throws Exception {
		List<JSONObject> list = this.memberCenterDao.getList(userId);
		if(!list.isEmpty()){
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public int insert(JSONObject jsonObject) throws Exception {
		return this.memberCenterDao.insert(jsonObject);
	}


}
