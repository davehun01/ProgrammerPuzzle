void leftRotate(int arr[], int d, int n) {//-1
    for (int i = 0; i < d; i++) {//2
		leftRotatebyOne(arr, n);//3
	}//4,5,11,13
}//4,5,11,13
void leftRotatebyOne(int arr[], int n) {//6
    int i, temp;//7
    temp = arr[0];//8
    for (i = 0; i < n - 1; i++) {//9
		arr[i] = arr[i + 1];//10
	}//4,5,11,13
    arr[i] = temp;//12
}//4,5,11,13
//DESCRIPTION:
Create a Java method that rotates an array of size n by d elements.
Example:
Input: arr = {1, 2, 3, 4, 5, 6, 7} d = 2
Output: {3, 4, 5, 6, 7, 1, 2}