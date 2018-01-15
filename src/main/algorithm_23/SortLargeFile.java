import java.io.*;

public class SortLargeFile {
    /*定义数组长度*/
    public static final int MAX_ARRAY_SIZE=100000;
    public static final int BFFER_SIZE=100000;

    public static void main(String [] args) throws Exception{
        int numberOfSegments=initializeSegments(MAX_ARRAY_SIZE,"largedata.dat","f1.dat");
        merge(numberOfSegments,MAX_ARRAY_SIZE,"f1.dat","f2.dat","f3.dat");
    }
    private static int initializeSegments(int segmentSize,String originalFile,String f1) throws Exception{
        int [] list=new int[segmentSize];
        DataInputStream input=new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        DataOutputStream output=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("f1")));

        int numberOfSegments=0;
        while(input.available()>0){
            numberOfSegments++;
            int i=0;
            for(;input.available()>0&&i<segmentSize;i++){
                list[i]=input.readInt();
            }
            java.util.Arrays.sort(list,0,i);
            for(int j=0;j<i;j++){
                output.writeInt(list[j]);
            }
        }
        input.close();
        output.close();
        return numberOfSegments;
    }
    private static void merge(int numberOfSegments,int segmentSize,String f1,String f2,String f3) throws Exception{

    }

}
