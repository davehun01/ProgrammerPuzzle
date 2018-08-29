public void heapSort(int arr[]) {//-1
    int n = arr.length;//2
    for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);//3
    for (int i=n-1; i>=0; i--) {//4
        int temp = arr[0];//5
        arr[0] = arr[i];//6
        arr[i] = temp;//7
        heapify(arr, i, 0);//8
    }//9,10,19,20
}//9,10,19,20
void heapify(int arr[], int n, int i) {//11
    int largest = i; int l = 2*i + 1; int r = 2*i + 2;//12
    if (l < n && arr[l] > arr[largest]) largest = l;//13
    if (r < n && arr[r] > arr[largest]) largest = r;//-14
    if (largest != i) {//15
        int swap = arr[i];//16
        arr[i] = arr[largest];//17
        arr[largest] = swap; heapify(arr, n, largest);//18
    }//9,10,19,20
}//9,10,19,20
//DESCRIPTION:
Create a Java method that implements heap sort on an array.
Algorithm:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.