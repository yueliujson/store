import com.easy.service.impl.SendMailServiceImpl;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        SendMailServiceImpl service=new SendMailServiceImpl();
        String z = service.sendQQEmail( "1239301353@qq.com", "123123", "张三");
        System.out.println(z);

    }
}
