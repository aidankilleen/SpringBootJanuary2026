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

        String springBean = ctx.getBean(String.class);

        System.out.println(springBean);
    }
}
