package bhz.com.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

/**
 * Created by panyuting on 2017/3/23.
 */
public final class BaseUtils {

    /**
     * <B>构造方法</B><BR>
     */
    private BaseUtils() {

    }

    public final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    // 定义父级公共参数 供子类使用
    public JsonObject jsonObject = new JsonObject();
    public JsonArray jsonArray = new JsonArray();

    @Context
    public HttpServletRequest req;
    @Context
    HttpServletResponse res;


    public class reqResult<T> {
        public int code;
        public String desc;
        public T data;

        public reqResult(){
            code=0;
            desc="";
            data=null;
        }

        public  reqResult(int _e,String _desc,T _data){
            code=_e;
            desc=_desc;
            data=_data;
        }
        public  reqResult(T _data){
            code=0;
            desc="";
            data=_data;
        }
    }


    public String error() {


        return new Gson().toJson(new reqResult(-1,"",""));
    }

    public String error(int _e,String _err) {


        return new Gson().toJson(new reqResult(_e,_err,""));
    }

    public String success() {
        Gson g= new GsonBuilder().serializeNulls().create();

        return g.toJson(new reqResult());

    }

    public String success( int _code,Object _data) {
        Gson g= new GsonBuilder().serializeNulls().create();

        return g.toJson(new reqResult(_code,"",_data));
    }

    public String success( int _code,String msg,Object _data) {
        Gson g= new GsonBuilder().serializeNulls().create();
        return g.toJson(new reqResult(_code,msg,_data));
    }

    public String success(Object _data) {
        Gson g= new GsonBuilder().serializeNulls().create();

        return g.toJson(new reqResult(0,"",_data));
    }


    public String successJson(String _data) {

        return "{\"code\":0,\"desc\":\"\",\"data\":"+_data+"}";
    }



    public class ResponseData {
        public e e=new e();

        class e {

            public int code;

            public String desc;
        }
        public String data;

        public  ResponseData(){
            e.code=0;
            e.desc="";
            data="";
        }

        public  ResponseData(int _e,String _desc,String _data){
            e.code=_e;
            e.desc=_desc;
            data=_data;
        }

        public  ResponseData(String _data){
            e.code=0;
            e.desc="";
            data=_data;
        }
    }


    public String errorRespond() {


        return new Gson().toJson(new ResponseData(-1,"",""));
    }

    public String errorRespond(int _e,String _err) {


        return new Gson().toJson(new ResponseData(_e,_err,""));
    }

    public String successRespond() {


        Gson g= new GsonBuilder().serializeNulls().create();

//        return g.toJson(new ResponseData());


        return g.toJson(new ResponseData());


        //return "{e:{code:0,desc:\"\"}}";
    }

    public String successRespond( int _code,String _data) {
        return new Gson().toJson(new ResponseData(_code,"",_data));
    }

    public String successRespond(String _data) {
        log.info(_data);
        return new Gson().toJson(new ResponseData(0,"",_data));
    }

}
