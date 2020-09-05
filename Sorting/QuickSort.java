package Questions.Sorting_5;

public class QuickSort {
    public static void main(String[] args) {
        int[]a={1,11,2,49,8,8,7};
        quicksort(a,0,a.length-1);
        for(int x:a)
            System.out.print(x+" ");
    }
    static void quicksort(int []a,int l,int h){
        if(l<h){
            int pivot=findPivot(a,l,h);
            quicksort(a,l,pivot-1);
            quicksort(a,pivot+1,h);
        }
    }
    static int findPivot(int[]a,int l,int h){
        int x=a[h];
        int i=l-1,j=l;
        while (j<h){
            if(a[j]<=x){
                i++;
                swap(a,i,j);
            }
            j++;
        }
        swap(a,i+1,h);
        return i+1;
    }
    static void swap(int[]a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
