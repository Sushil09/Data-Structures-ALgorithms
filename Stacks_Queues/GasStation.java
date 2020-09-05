package Questions.Stacks_And_Queues_9;

public class GasStation {
    public static void main(String[] args) {
        int []gas={1,2,3,4,5};
        int []cost={3,4,5,1,2};
        System.out.println(minIndex(gas,cost));
    }
    static int minIndex(int[] gas, int[] cost){
        if(!isPossible(gas,cost))
            return -1;
        else{
            int N=gas.length;
            int start=-1,i=0,extraGas=0;
            while(i!=start){
                if(gas[i]+extraGas>=cost[i]){
                    extraGas+=gas[i]-cost[i];
                    if(start==-1)
                        start=i;
                }
                else{
                    start=-1;
                    extraGas=0;
                }

                i=(i+1)%N;
            }
            return start;
        }
    }
    static boolean isPossible(int[] gas, int[] cost){
        int N=gas.length;
        int totalGas=0,totalDis=0;
        for(int i=0;i<N;i++){
            totalGas+=gas[i];
            totalDis+=cost[i];
        }
        return totalGas>=totalDis;
    }
}
