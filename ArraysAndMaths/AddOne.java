package Questions.Maths_And_Arrays_1;

import java.util.Arrays;

public class AddOne {
    public static void main(String[] args) {
        int[]a={9,9,9};
        System.out.println(Arrays.toString(addOne(a)));
    }
    static int[] addOne(int[]a){
        int carry=0;
        int N=a.length;
        int sum=a[N-1]+1;
        a[N-1]=sum%10;
        carry=sum/10;
        int i=N-2;
        while (carry>0 && i>=0){
            sum=a[i]+carry;
            a[i]=sum%10;
            carry=sum/10;
            i--;
        }

        if(carry>0){
            int []ans=new int[N+1];
            ans[0]=carry;
            for(int x=0;x<N;x++)
                ans[x+1]=a[x];
        return ans;
        }
        return a;

    }
}
