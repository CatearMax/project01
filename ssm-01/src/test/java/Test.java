import com.xwc.mapper.AdminMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shkstart
 * @create 2020-04-10 16:11
 * @name Test
 * @description
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-dao.xml");
        AdminMapper adminMapper = ctx.getBean("userMapper", AdminMapper.class);
        System.out.println(adminMapper.findAll());
    }
}
