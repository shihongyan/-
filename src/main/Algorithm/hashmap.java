/*
import java.util.Map;

public class hashmap {
    public static void main(String [] aa){
        */
/*String a=new String("shihongyan");
        String b=new String("shihongyan");
        System.out.println(a==b);
        System.out.println(a.equals(b));*//*

        Student1 s1=new Student1();
        Student1 s2=new Student1();
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1);
        System.out.println(s2);

        Integer m=new Integer(56);
        Integer m1=new Integer(56);
        System.out.println(m==m1);
        System.out.println(m1  );
        System.out.println(m1);
        System.out.println(m);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class hashmap {
    public static void main(String[] args) {
        Person p1 = new Person("a",1);
        Person p2 = new Person("b",0);

        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);

        Iterator it = set.iterator();
           while(it.hasNext())
               System.out.println(it.next().hashCode());

    }
}
