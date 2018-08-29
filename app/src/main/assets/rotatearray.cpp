void leftRotatebyOne(int arr[], int n) {//-1
   int temp = arr[0], i;//2
   for (i = 0; i < n-1; i++) {//3
	   arr[i] = arr[i+1];//4
   }//5,7,11,12
   arr[i] = temp;//6
}//5,7,11,12
void leftRotate(int arr[], int d, int n) {//8
    for (int i = 0; i < d; i++) {//9
		leftRotatebyOne(arr, n);//10
	}//5,7,11,12
}//5,7,11,12
//DESCRIPTION:
Create a C++ function that rotates an array of size n by d elements.
Example:
Input: arr = {1, 2, 3, 4, 5, 6, 7} d = 2
Output: {3, 4, 5, 6, 7, 1, 2}