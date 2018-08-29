void insertionSort(int arr[], int n) {//1
   int i, key, j;//2
   for (i = 1; i < n; i++) {//3
       key = arr[i];//4,5
       j = i-1;//4,5
       while (j >= 0 && arr[j] > key) {//6
           arr[j+1] = arr[j];//7
           j = j-1;//8
       }//9,11,12
       arr[j+1] = key;//10
   }//9,11,12
}//9,11,12
//DESCRIPTION:
Create a C++ function that implements insertion sort on an array.
Algorithm:
Loop from i = 1 to n-1.
	Pick element arr[i] and insert it into sorted sequence arr[0…i-1]