int partition (int arr[], int low, int high) {//-1
    int pivot = arr[high];//2,3
    int i = (low - 1);//2,3
    for (int j = low; j <= high- 1; j++) {//4
        if (arr[j] <= pivot) {//5
            i++;//6
            swap(&arr[i], &arr[j]);//7
        }//8,9,12,17,18
    }//8,9,12,17,18
    swap(&arr[i + 1], &arr[high]);//10
    return (i + 1);//11
}//8,9,12,17,18
void quickSort(int arr[], int low, int high) {//13
    if (low < high) {//14
        int pi = partition(arr, low, high);//15
        quickSort(arr, low, pi - 1); quickSort(arr, pi + 1, high);//16
    }//8,9,12,17,18
}//8,9,12,17,18
//DESCRIPTION:
Create a C++ function that implements quicksort. Quicksort is a Divide & Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
The key process in quicksort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x.
Utility function to swap 2 elements:
void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}