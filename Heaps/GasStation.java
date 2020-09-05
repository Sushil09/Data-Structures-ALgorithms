package Questions.Heaps_14;

public class GasStation {
    public static void main(String[] args) {
        int[] a = { 2,0};//gas
        int[] b = {2, 1};//distances
        int availableGases = 0;
        int totalDistances = 0;
        for (int x : a)
            availableGases += x;
        for (int x : b)
            totalDistances += x;
        if (availableGases < totalDistances)
            System.out.println(-1);
        else {
            int i = 0, start = -1, reserve = 0, N = a.length;
            while (i != start) {
                if (reserve + a[i] >= b[i]) {
                    reserve = reserve + a[i] - b[i];
                    if (start == -1)
                        start = i;
                    i = (i + 1) % N;
                } else {
                    i = (i + 1) % N;
                    if (start != -1) {
                        start = -1;
                        reserve = 0;
                    }
                }
            }
            System.out.println(start);
        }
    }
}
