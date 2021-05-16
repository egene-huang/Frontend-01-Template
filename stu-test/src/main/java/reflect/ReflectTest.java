package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/5/3 22:23
 */
public class ReflectTest {
    Map<String, String> map = new HashMap<>();

    public static void main(String[] args)throws Exception {
        /*Field map = ReflectTest.class.getDeclaredField("map");
        Type genericType = map.getGenericType();
        System.out.println("......");*/
        Fun<String> stringFun = new Fun<String>() {
            //
        };
        Class<? extends Fun> aClass = stringFun.getClass();
        Type type = aClass.getGenericSuperclass();
        System.out.println("((ParameterizedType) type).getActualTypeArguments() = " + ((ParameterizedType) type).getActualTypeArguments()[0]);
        System.out.println("((ParameterizedType) type).getRawType() = " + ((ParameterizedType) type).getRawType());
        System.out.println("((ParameterizedType) type).getOwnerType() = " + ((ParameterizedType) type).getOwnerType());

    }
}
