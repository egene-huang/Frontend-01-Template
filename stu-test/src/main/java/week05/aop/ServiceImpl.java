package week05.aop;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/4/18 20:55
 */
public class ServiceImpl implements IService{
    @Override
    public void service() {
        System.out.println("开始执行真正的业务");
    }
}
