import java.util.ArrayList;

import static javafx.application.Platform.exit;

/**
 * 实现堆的类
 * 使用线性数组实现
 */
public class Heap {
    /*使用线性数组存储堆中数据*/
    private java.util.ArrayList list=new java.util.ArrayList<Object>();
    public Heap(){}
    public Heap(Object [] objects){
        for(int i=0;i<objects.length;i++)
            add(objects[i]);
    }
    /*向堆中添加元素*/
    public void add(Object object){
        list.add(object);
        if(list.size()!=0){
            int temp=list.size()-1;
            while(((Comparable)object).compareTo(list.get((temp-1)/2))>0&&temp>0){
                Object x=list.get((temp-1)/2);
                list.set((temp-1)/2,object);
                list.set(temp,x);
                temp=(temp-1)/2;
            }
        }

    }
    /*输出堆中元素*/
    public void out(){
        out(list);
    }
    public void out(ArrayList list){
        for(Object o:list) System.out.print(o+" ");
    }
    /*获取堆的长度*/
    public int size(){
        return list.size();
    }
    /*删除堆的某一指定元素*/
    public Object remove(Object o){
        /*删除元素*/
        boolean bool=false;
        for(int i=0;i<list.size();i++){
            if(o==list.get(i)){
                /*删除目标元素*/
                Object last=list.get(list.size()-1);
                list.set(list.size()-1,list.get(i));
                list.set(i,last);
                list.remove(list.size()-1);
                /*重建堆*/
                int tem=0;
                while(tem<list.size()){
                    //System.out.println(tem);
                    if(tem*2+2<list.size()){
                        if(((Comparable)list.get(2*tem+1)).compareTo(list.get(tem*2+2))>0&&((Comparable)list.get(2*tem+1)).compareTo(list.get(tem))>0){
                            Object ob=list.get(2*tem+1);
                            list.set(2*tem+1,list.get(tem));
                            list.set(tem,ob);
                            tem=tem*2+1;
                        }else if(((Comparable)list.get(2*tem+2)).compareTo(list.get(tem*2+1))>0&&((Comparable)list.get(2*tem+2)).compareTo(list.get(tem))>0){
                            Object ob=list.get(2*tem+2);
                            list.set(2*tem+2,list.get(tem));
                            list.set(tem,ob);
                            tem=tem*2+2;
                        }
                    }else if(tem*2+1<list.size()&&((Comparable)list.get(2*tem+1)).compareTo(list.get(tem))>0){
                        Object ob=list.get(2*tem+1);
                        list.set(2*tem+1,list.get(tem));
                        list.set(tem,ob);
                        tem=tem*2+1;
                    }else
                        break;
                }
                return o;
            }
        }
        if(bool==false)
            System.out.println("不存在该数据！");
        return null;
    }
    /*获取第一个元素*/
    public Object first(){
        return list.get(0);
    }
    /*删除根元素*/
    public Object remove(){
        /*删除根结点*/
        Object temp=list.get(list.size()-1);
        list.set(list.size()-1,list.get(0));
        list.set(0,temp);
        Object x=list.remove(list.size()-1);
        /*重建堆*/
        int tem=0;
        while(tem<list.size()){
            //System.out.println(tem);
            if(tem*2+2<list.size()){
                if(((Comparable)list.get(2*tem+1)).compareTo(list.get(tem*2+2))>0&&((Comparable)list.get(2*tem+1)).compareTo(list.get(tem))>0){
                    Object ob=list.get(2*tem+1);
                    list.set(2*tem+1,list.get(tem));
                    list.set(tem,ob);
                    tem=tem*2+1;
                }else if(((Comparable)list.get(2*tem+2)).compareTo(list.get(tem*2+1))>0&&((Comparable)list.get(2*tem+2)).compareTo(list.get(tem))>0){
                    Object ob=list.get(2*tem+2);
                    list.set(2*tem+2,list.get(tem));
                    list.set(tem,ob);
                    tem=tem*2+2;
                }
            }else if(tem*2+1<list.size()&&((Comparable)list.get(2*tem+1)).compareTo(list.get(tem))>0){
                Object ob=list.get(2*tem+1);
                list.set(2*tem+1,list.get(tem));
                list.set(tem,ob);
                tem=tem*2+1;
            }else
            break;
        }
        return x;

    }
}
