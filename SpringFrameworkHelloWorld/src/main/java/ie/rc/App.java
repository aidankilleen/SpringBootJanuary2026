package ie.rc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Framework Hello World!" );

        var ctx = new ClassPathXmlApplicationContext("beans.xml");

        String springBean = ctx.getBean("mainMessage", String.class);

        System.out.println(springBean);

        //Connection conn = DriverManager.getConnection(url);
        //User u = new user(1, "Fred", "fred@gmail.com", false);

        //User springUser = ctx.getBean(User.class);

        //System.out.println(springUser);


        ShowUser showUser = ctx.getBean(ShowUser.class);
        showUser.display();



    }
}
