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
 
//Part of description:
void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}