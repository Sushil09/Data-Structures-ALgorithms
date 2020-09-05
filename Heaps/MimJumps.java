package Questions.Heaps_14;

public class MimJumps {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5};
        System.out.println(minJumps(a));
    }
    static int minJumps(int[]a){
        if(a.length==1)
            return 0;//already at end of array
        int ladder=a[0],stairs=a[0],jumps=1;
        for(int i=1;i<a.length;i++){
            if(i==a.length-1)
                return jumps;
            if(i+a[i]>ladder)
                ladder=i+a[i];
            stairs--;
            if(stairs==0){
                jumps++;
                stairs=ladder-i;
            }
        }
        return jumps;
    }
}
