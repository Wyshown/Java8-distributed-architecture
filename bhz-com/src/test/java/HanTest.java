import java.util.UUID;

/**
 * Created by Administrator on 2017/3/22.
 */
public class HanTest {

    public static void main(String arg[]){
        String pre = "2017-03-22_";
        String uid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String a = pre + uid.substring(11);
        System.out.println(a);
        System.out.println(a.length());

    }

}
