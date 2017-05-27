package bhz.sys.facade.CarService;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/appShopService")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Transactional
public interface AppShopFacade {
	
	@POST
	public String generateKey() throws Exception;

	@POST
	@Path("/getList")
	public List<JSONObject> getAppShopList(JSONObject jsonObject) throws Exception;

	@POST
	@Path("/getById/{id}")
	public JSONObject getAppShopDetails(String id) throws Exception;
	
	@POST
	@Path("/insert")
	public int insert(JSONObject jsonObject) throws Exception;

	@POST
	@Path("/insert2")
	public int insert2(JSONObject jsonObject) throws Exception;
	
	
}
