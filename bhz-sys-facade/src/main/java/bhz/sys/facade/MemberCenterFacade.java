package bhz.sys.facade;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;


@Path("/memberCenterService")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface MemberCenterFacade {
	
	@POST
	public String generateKey() throws Exception;
	
	@GET
	@Path("/getById/{id}")
	public JSONObject getById(@PathParam(value = "id") String id) throws Exception;
	
	@POST
	@Path("/getList")
	public List<JSONObject> getList(String userId) throws Exception;
	
	@POST
	@Path("/insert")
	public int insert(JSONObject jsonObject) throws Exception;
	
	
}
