package test.spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/5/2 22:54
 */
public class SpringBeanInit implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行-- afterPropertiesSet--");
    }

    public void init() {
        System.out.println("执行 -- init--");
    }
}
