package week05.aop;

import java.lang.reflect.Proxy;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/4/18 21:02
 */
public class InvocationHandlerTest {
    public static void main(String[] args) {
        ServiceImpl handler = new ServiceImpl();
        MyHandler myHandler = new MyHandler(handler);
        ClassLoader classLoader = InvocationHandlerTest.class.getClassLoader();
        IService proxyService = (IService) Proxy.newProxyInstance(classLoader, handler.getClass().getInterfaces(), myHandler);
        proxyService.service();
    }
}
