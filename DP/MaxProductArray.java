package Questions.DP_15;

public class MaxProductArray {
    public static void main(String[] args) {
        int[]a={-3, 0, -5, 0};
        System.out.println(maxProdSubArray(a));
    }
    static int maxProdSubArray(int[]a){
        int maxX=a[0],minX=a[0],ans=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<0){
                int x=minX;
                minX=maxX;
                maxX=x;
            }
            if(a[i]==0){
                minX=1;
                maxX=1;
                continue;
            }
            maxX=Math.max(maxX,a[i]*maxX);
            minX=Math.min(minX,a[i]*minX);
            ans=Math.max(maxX,ans);
        }
        if(ans==1){
            for(int i=0;i<a.length;i++){
                if(a[i]==1)
                    return 1;
            }
            return 0;
        }
        return ans;
    }
}
