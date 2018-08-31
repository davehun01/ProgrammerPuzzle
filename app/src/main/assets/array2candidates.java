boolean hasTwoCandidates(int A[], int arr_size, int sum) {//1
    int left, right;//2
    Arrays.sort(A);//-3
    left = 0;//4,5
    right = arr_size-1;//4,5
    while (left < right) {//6
        if(A[left] + A[right] == sum) {//7
			return true;//8
		}//9,12,15,16,18
        else if(A[left] + A[right] < sum) {//10
			left++;//11
		}//9,12,15,16,18
        else {//13
			right--;//14
		}//9,12,15,16,18
    }//9,12,15,16,18
    return false;//17
}//9,12,15,16,18
//DESCRIPTION:
Create a Java method that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in the array whose sum is exactly x.
Example 1 input: A = {1, 10, 5, 3, 17} sum = 18
output: true
Example 2 input: A = {1, 10, 5, 3, 17} sum = 9
output: false