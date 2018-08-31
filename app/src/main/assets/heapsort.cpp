void heapify(int arr[], int n, int i) {//-1
    int largest = i;//2,3,4
    int l = 2*i + 1;//2,3,4
    int r = 2*i + 2;//2,3,4
    if (l < n && arr[l] > arr[largest]) largest = l;//5,6
    if (r < n && arr[r] > arr[largest]) largest = r;//5,6
    if (largest != i) {//-7
        swap(arr[i], arr[largest]);//8
        heapify(arr, n, largest);//9
    }//10,11,17,18
}//10,11,17,18
void heapSort(int arr[], int n) {//12
    for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);//13
    for (int i=n-1; i>=0; i--) {//14
        swap(arr[0], arr[i]);//15
        heapify(arr, i, 0);//16
    }//10,11,17,18
}//10,11,17,18
//DESCRIPTION:
Create a C++ function that implements heap sort on an array.
Algorithm:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.