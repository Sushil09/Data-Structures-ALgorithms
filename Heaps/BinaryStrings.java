package Questions.Heaps_14;

public class BinaryStrings {
    public static void main(String[] args) {
        String s="011";
        int B=3;
        System.out.println(minSteps(s,B));
    }
    static int minSteps(String s,int B){
        StringBuilder sb=new StringBuilder(s);
        int c=0;
        for(int i=0;i<sb.length()-B+1;i++){
            if(sb.charAt(i)=='0'){
                inverseStrings(sb,i,i+B);
                c++;
            }
        }
        if(sb.indexOf("0")>0)
            return -1;
        return c;
    }
    static void inverseStrings(StringBuilder sb,int low,int high){
        for(int i=low;i<high;i++){
            if(sb.charAt(i)=='0')
                sb.setCharAt(i,'1');
            else
                sb.setCharAt(i,'0');
        }
    }
}
