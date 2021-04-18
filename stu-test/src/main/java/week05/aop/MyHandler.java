package week05.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/4/18 20:52
 */
public class MyHandler  implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object handler;

    public MyHandler(Object handler) {
        this.handler = handler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前...");
        Object invokeResult = method.invoke(handler, args);
        System.out.println("执行方法后...");
        return invokeResult;
    }
}
