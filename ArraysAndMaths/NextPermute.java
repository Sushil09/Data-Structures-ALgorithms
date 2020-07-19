package Questions.Maths_And_Arrays_1;

import java.util.Arrays;

public class NextPermute {
    public static void main(String[] args) {
        int[]a={1, 3,4,2};
        System.out.println(Arrays.toString(printNext(a)));
    }
    static int[] printNext(int[]a){
        int N=a.length;
        if(N<=1)
            return a;
        int i=N-2;
        while(a[i]>a[i+1]){
            i--;
        }
        int j=N-1;
        while(a[i]>a[j]){
            j--;
        }
        swap(a,i,j);
        reverse(a,i+1,N);
        return a;
    }
    static void swap(int[]a,int i,int j){
        int temp=a[i];a[i]=a[j];a[j]=temp;
    }
    static void reverse(int []a,int l,int N){
        int i=l,j=N-1;
        while(i<j){
            int temp=a[i];a[i]=a[j];a[j]=temp;
            i++;j--;
        }
    }
}
