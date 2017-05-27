package bhz.sys.facade.personalMgmt;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import oracle.jdbc.proxy.annotation.Post;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Return:
 * @Author: 韩武洽 @Wyshown
 * @Date: 2017/3/22 13:43
 * @Version 2.0
 */
@Path("/myCarService")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface MyCarFacade {

    @POST
    @Path("/findMyCarList")
    List<JSONObject> findMyCarList(JSONObject jsonParam) throws Exception;

}
