package Questions.String_Manipulations;

public class MinInsertionPalin {
    public static void main(String[] args) {
        String x="aa";
        System.out.println(minInsertions(x));
    }
    static int minInsertions(String x){
        StringBuilder sb=new StringBuilder(x).reverse();
        int start=0,end=0,count=0;
        while (true){
            if(isPalindrome(sb.substring(start,end).toString()+x))
                break;
            end++;
            count++;
        }
    return count;
    }
    static boolean isPalindrome(String sb){
        int i=0,j=sb.length()-1;
        while (i<j){
            if(sb.charAt(i)!=sb.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
