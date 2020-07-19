package Questions.Bits_Maipulation_2;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[]a={1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleEle(a));
    }
    static int singleEle(int[]a){
        int ans=0;
        int N=a.length;
        for(int i=0;i<=31;i++){
            int count=0;
            for(int j=0;j<N;j++){
                if(checkBit(a[j],i))
                    count++;
            }
            if(count%3!=0)
                ans=ans^(1<<i);
        }
        return ans;
    }
    static boolean checkBit(int a,int i){
        a=a>>i;
        return ((a&1)==1)?true:false;
    }
}
