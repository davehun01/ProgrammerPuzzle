static int maxLen(int arr[], int n) {//1
    int max_len = 0;//2
    for (int i = 0; i < n; i++) {//3
        int curr_sum = 0;//4
        for (int j = i; j < n; j++) {//5
            curr_sum += arr[j];//6
            if (curr_sum == 0) {//7
				max_len = Math.max(max_len, j-i+1);//8
			}//9,10,11,13
        }//9,10,11,13
    }//9,10,11,13
    return max_len;//12
}//9,10,11,13
//DESCRIPTION:
Create a Java method that, given an array of integers, returns length of the largest subarray with sum equal to 0.
Examples:
Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
Output: 5
The largest subarray with 0 sum is {-2, 2, -8, 1, 7}
Input: arr[] = {1, 2, 3}
Output: 0
There is no subarray with 0 sum