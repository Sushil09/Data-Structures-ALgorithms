package Questions.String_Manipulations;

public class Z_Algo {
    private static int index_Find(char[] text,char[] pattern){
        String entireText=String.valueOf(pattern)+"$"+String.valueOf(text);
        int[] z_array=populate(entireText.toCharArray());
        for(int i=pattern.length;i<z_array.length;i++){
            if(z_array[i]==pattern.length)
                return i-pattern.length;
        }
        return -1;
    }
    private static int[] populate(char[]x){
        int[]z=new int[x.length];
        int left=0,right=0;
        for(int k=1;k<x.length;k++){
            //if no z boundary case is encountered
            if(k>right){
                left=right=k;
                while(right<x.length && x[right-left]==x[right])
                    right++;
             z[k]=right-left;
             right--;
            }
            //operating inside z box
            else{
                int k1=k-left;
                if(z[k1]<right-k+1)
                     z[k]=z[k1];
                else{
                    left=k;
                    while(right<x.length && x[right-left]==x[right])
                        right++;
                    z[k]=right-left;
                    right--;
                }
            }
        }
        return z;
    }
    public static void main(String[] args) {
        String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aabcz";
        Z_Algo matcher=new Z_Algo();
        int index=matcher.index_Find(text.toCharArray(),pattern.toCharArray());
        System.out.println(index);
    }
}
