public class GenericMethodDemo {
    public static void main(String [] args){
        Integer [] integers={1,2,3,4,5};
        String [] strings={"London","Paris","New York","Austin"};
        /*调用泛型方法，需要在方法名前用尖括号内的实际类型作为前缀*/
        GenericMethodDemo.<Integer>print(integers);
        GenericMethodDemo.<String>print(strings);
    }
    public static <E> void print(E[] list){
        for(int i=0;i<list.length;i++)
            System.out.print(list[i]+" ");
        System.out.println();
    }


}
