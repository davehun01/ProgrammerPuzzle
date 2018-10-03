int partition(int arr[],int low,int high) {//-1
    int pivot=arr[high]; int i=low-1;//2
    for (int j=low; j<high; j++) {//3
        if (arr[j] <= pivot) {//4
            int temp = arr[++i];//5
            arr[i] = arr[j];//6
            arr[j] = temp;//7
        }//8,9,14,19,20
    }//8,9,14,19,20
    int temp = arr[i+1];//10
    arr[i+1] = arr[high];//11
    arr[high] = temp;//12
    return i+1;//13
}//8,9,14,19,20
void sort(int arr[],int low,int high) {//15
    if (low < high) {//16
        int pi = partition(arr, low, high);//17
        sort(arr,low,pi-1); sort(arr,pi+1,high);//18
    }//8,9,14,19,20
}//8,9,14,19,20
//DESCRIPTION:
Create a Java method that implements quicksort. Quicksort is a Divide & Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
The key process in quicksort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x.