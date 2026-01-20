package ie.rc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Annotated Spring Hello World!" );

        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        String message = ctx.getBean(String.class);

        System.out.println(message);


        User u = ctx.getBean(User.class);

        System.out.println(u);


        UserDisplay ud = ctx.getBean(UserDisplay.class);

        ud.display();

    }
}
