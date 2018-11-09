public class BinaryHeap {
    private int[] arr;
    private int heapSize;

    public BinaryHeap() {
        arr = new int[10];
        this.heapSize = 0;
    }

    public void add(int num) {
        if (heapSize == arr.length) {
            grow_array();
        }
        arr[heapSize] = num;
        int elem = heapSize;
        int parent = (elem - 1) / 2;
        while (elem > 0) {
            if(arr[elem] < arr[parent]) {
                swap(arr, elem, parent);
                elem = parent;
                parent = (elem - 1) / 2;
            } else {
                return;
            }
        }
        heapSize++;
    }

    public int remove(){
        if (heapSize == 0) {
            return 0;
        }
        int elem = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        bubbleDown(0);
        return elem;
    }

    private void grow_array() {
        int[] new_array = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            new_array[i] = arr[i];
        }
        arr = new_array;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void bubbleDown (int num) {
        int leftChild = (num * 2) + 1;
        int rightChild = (num * 2) + 2;

        if (leftChild >= heapSize) {
            return;
        }

        if (arr[rightChild] < arr[leftChild]){
            leftChild = rightChild;
        }

        if (arr[leftChild] < arr[num]) {
            swap(arr, leftChild, num);
            bubbleDown(leftChild);
        }
    }
}
