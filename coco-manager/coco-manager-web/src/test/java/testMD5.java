/**
 * Created by Administrator on 2017/3/26 0026.
 */
import org.apache.commons.codec.digest.DigestUtils;
public class testMD5 {
    public static void main(String[] args){
        String str = "1234asdf";
        String md5Str = DigestUtils.md5Hex(str);
        System.out.println(md5Str);
    }
}
