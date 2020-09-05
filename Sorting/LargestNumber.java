package Questions.Sorting_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);list.add(30);list.add(34);list.add(5);list.add(9);
        System.out.println(largestNumber(list));
    }
    static String largestNumber(List<Integer> list){
        Collections.sort(list,new MyComparator());
        StringBuilder sb=new StringBuilder();
        for(int x:list)
            sb.append(x);
         return new String(sb);
    }
}
class MyComparator implements Comparator<Integer>{
    public int compare(Integer o1,Integer o2) {
        String i1=String.valueOf(o1);
        String i2=String.valueOf(o2);
        String s1=i1+i2;
        String s2=i2+i1;
        return -s1.compareTo(s2);
    }
}
