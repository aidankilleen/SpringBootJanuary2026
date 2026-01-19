package ie.rc;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var ascii = FigletFont.convertOneLine("Hello World");
        System.out.println(ascii);

        // new since java 10 - the var keyword
        var i = 99;
        // var j;      // var type must be initialised
        // j = 99;


        @SuppressWarnings("unused")
        var j = 99;

        @SuppressWarnings("unused")
        var abdeee = 99;



        OriginalUser u = new OriginalUser(1, "Alice", "alice@gmail.com", true);

        System.out.println(u);

        IntellijGeneratedUser user = new IntellijGeneratedUser(1, "Alice", "alice@gmail.com", true);

        System.out.println(user);

        LombokUser luser1 = new LombokUser(1, "Alice", "alice@gmail.com", true);
        LombokUser luser2 = new LombokUser(1, "Alice", "alice@gmail.com", true);

        System.out.println(luser1);

        if (luser1.equals(luser2)) {
            System.out.println ("same");
        } else {
            System.out.println ("different");
        }

        System.out.println(luser1.getName());
        //LombokUser luser3 = new LombokUser(1, null, null, false);

        //System.out.println (luser3);


        LombokDataUser ldUser1 = new LombokDataUser(1, "Alice", "alice@gmail.com", false);
        LombokDataUser ldUser2 = new LombokDataUser(1, "Alice", "alice@gmail.com", false);

        System.out.println(ldUser1);

        if (ldUser1.equals(ldUser2)) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }

        System.out.println(ldUser1.getName());

        User rUser = new User(1, "Alice", "alice@gmail.com", true);
        User rUser2 = new User(1, "Alice", "alice@gmail.com", true);

        System.out.println(rUser);

        System.out.println(rUser.name());

        if (rUser.equals(rUser2)) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }



    }
}