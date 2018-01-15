import java.util.HashSet;

public class test22_1 {
    public static void main(String [] args){

        HashSet<String> set=new HashSet<String>();
        HashSet<String> set1=new HashSet<String>();
        HashSet<String> set2=new HashSet<String>();
        set.add("George");
        set.add("Jim");
        set.add("John");
        set.add("Blake");
        set.add("Kevin");
        set.add("Michael");

        set1.add("George");
        set1.add("Katie");
        set1.add("Kevin");
        set1.add("Michael");
        set1.add("Ryan");
        /*集合-->差积*/
        set2=(HashSet<String>) set.clone();
        set2.removeAll(set1);
        System.out.println("差积："+set2);

        /*集合-->并集*/
        set2=(HashSet<String>) set.clone();
        set2.addAll(set1);
        System.out.println("并集："+set2);

        /*集合-->交集*/
        set2=(HashSet<String>) set.clone();
        set2.retainAll(set1);
        System.out.println("交集："+set2);

    }
}
