package appPack;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UseSet {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("Ali");
        set.add("Ali");
        set.add("Hasan");
        set.add("Zehra");
        set.add("Ömer");
        set.add("Burak");
        set.add("Burak");
        set.add("Selin");
        System.out.println( set );

        Set<String> setOrder = new LinkedHashSet<>();

        setOrder.add("Ali");
        setOrder.add("Ali");
        setOrder.add("Hasan");
        setOrder.add("Zehra");
        setOrder.add("Ömer");
        setOrder.add("Burak");
        setOrder.add("Burak");
        setOrder.add("Selin");
        System.out.println( setOrder );


        Set<User> userSet = new LinkedHashSet<>();
        User u1 = new User();
        u1.setName("Ali");
        u1.setAge(30);
        userSet.add(u1);
        System.out.println(u1.hashCode());

        u1 = new User();
        u1.setName("Erkan");
        u1.setAge(35);
        userSet.add(u1);
        System.out.println(u1.hashCode());

        System.out.println( userSet.size() );

    }
}
