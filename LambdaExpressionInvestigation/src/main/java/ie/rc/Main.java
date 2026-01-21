package ie.rc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void printItem(Integer n) {
        System.out.println(n);
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Lambda Expression Investigation");
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        numbers.add(7);
        numbers.add(1);
        numbers.add(8);

        // ()->{} is the "lambda" syntax
        // it creates a function
        // anonymous (no name)
        // inline (declared as it's being used
        numbers.forEach((n) -> {
            System.out.println(n);
        });

        numbers.forEach(Main::printItem);

        List<Integer> evenNumbers = numbers.stream()
                .filter((n) -> {
                    System.out.printf("Checking %d\n", n);
                    if (n % 2 == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println("================================");
        System.out.println(evenNumbers);

        System.out.println("================================");

        // if lambda has only 1 parameter you don't need ()
        // tighten up the logic
        // if you lambda has only 1 line you don't need {}, return or ;
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);


        List<User> users = new ArrayList<>();

        users.add(new User(55, "Fred", "fred@gmail.com", false));
        users.add(new User(15, "Alice", "alice@gmail.com", true));
        users.add(new User(53, "Zoe", "zoe@gmail.com", false));
        users.add(new User(87, "Bob", "bob@gmail.com", true));
        users.add(new User(5, "Eve", "eve@gmail.com", false));


        var activeUsers = users.stream()
                .filter(user -> user.active())
                .collect(Collectors.toList());

        System.out.println(activeUsers);

        users.sort((a, b) -> {
            System.out.printf("Comparing %s and %s\n", a.name(), b.name());
            if (a.id() < b.id()) {
                return -1;
            } else if (a.id() == b.id()) {
                return 0;
            } else {
                return 1;
            }
        });

        System.out.println(users);

        users.sort((a, b) -> b.id() - a.id());

        System.out.println(users);


    }
}