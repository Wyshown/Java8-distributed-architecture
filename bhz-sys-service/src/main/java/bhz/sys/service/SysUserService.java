package bhz.sys.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhz.sys.dao.SysUserDao;
import bhz.sys.facade.SysUserFacade;

import com.alibaba.fastjson.JSONObject;


@Service("sysUserService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass=bhz.sys.facade.SysUserFacade.class, protocol = {"rest", "dubbo"})
public class SysUserService implements SysUserFacade {

	@Autowired
	private SysUserDao sysUserDao;
/*	
	public String getUser() {
		//http://localhost:8888/bhz-sys-service/sysUserService/getUser
		System.out.println("http://localhost:8888/bhz-sys-service/sysUserService/getUser");
    	return "{'han':1111}";
	}
*/
/*	public String getUser(Integer id) {
		//http://localhost:8888/bhz-sys-service/sysUserService/get/1001
		System.out.println(id);
		System.out.println("测试...get");
		System.out.println("http://localhost:8888/bhz-sys-service/sysUserService/get/1001");
    	return "{'han':  ge1\\\"}";
	}
	*/
	@Override
	public String generateKey() throws Exception {
		return this.sysUserDao.generateKey();
	}
	
	@Override
	public JSONObject getById(String id) {
		//get
		// http://localhost:8888/bhz-sys-service/sysUserService/getById/{id}
		System.out.println("调用: http://localhost:8888/bhz-sys-service/sysUserService/getById/{id}----- ");
		return this.sysUserDao.getById(id);
	}

	@Override
	public List<JSONObject> getList() throws Exception {
		System.out.println("调用: http://localhost:8888/bhz-sys-service/sysUserService/getById/getList----- ");
		//post
		// http://localhost:8888/bhz-sys-service/sysUserService/getById/getList
		List<JSONObject> list = this.sysUserDao.getList();
		if(!list.isEmpty()){
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public int insert(JSONObject jsonObject) throws Exception {
		return this.sysUserDao.insert(jsonObject);
	}


}
