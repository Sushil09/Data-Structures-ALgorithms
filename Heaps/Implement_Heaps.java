package Questions.Heaps_14;

public class Implement_Heaps {
    public static void main(String[] args) {
        MinHeap minHeap=new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(23);
        minHeap.insert(9);
        System.out.println(minHeap.getMin());

        minHeap.deleteMin();
        System.out.println(minHeap.getMin());
        minHeap.deleteMin();

        System.out.println(minHeap.getMin());
    }
}
class MinHeap{
    int size;
    int[] heap;
    MinHeap(int N){
        size=0;
        heap=new int[N+1];
    }
    public void insert(int x){
        if(size>=heap.length)
            return;
        heap[++size]=x;
        int curr=size;
        while (curr>=1 && heap[curr]<heap[curr/2]) {
            swap(curr,curr / 2);
            curr /= 2;
        }
    }
    public void swap(int x,int y){
        int temp=heap[x];
        heap[x]=heap[y];
        heap[y]=temp;
    }
    public void heapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[pos * 2] || heap[pos] > heap[pos * 2 + 1])//left or right check
            {
                if (heap[pos * 2 + 1] > heap[pos * 2]) {
                    swap(pos, pos * 2);
                    heapify(pos * 2);
                } else {
                    swap(pos, pos * 2 + 1);
                    heapify(pos * 2 + 1);
                }
            }
        }
    }
    public boolean isLeaf(int pos){
        if(pos>=(size/2) && pos<=size)
            return true;
        return false;
    }
    public int getMin(){
        return heap[1];
    }
    public void deleteMin(){
        heap[1]=heap[size];
        size--;
        heapify(1);
    }
}
