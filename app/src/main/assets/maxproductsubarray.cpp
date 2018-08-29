int maxSubarrayProduct(int arr[], int n) {//1
    int max_ending_here = 1; int min_ending_here = 1;//2,3
	int max_so_far = 1;//2,3
    for (int i = 0; i < n; i++) {//4
        if (arr[i] > 0) {//5
            max_ending_here = max_ending_here*arr[i];//6,7
            min_ending_here = min (min_ending_here * arr[i], 1);//6,7
        }//8,11,16,18,20
        else if (arr[i] == 0) {//9
            max_ending_here = 1; min_ending_here = 1;//10
        }//8,11,16,18,20
        else {//12
            int temp = max_ending_here;//13
            max_ending_here = max (min_ending_here * arr[i], 1);//14
            min_ending_here = temp * arr[i];//15
        }//8,11,16,18,20
        if (max_so_far < max_ending_here) max_so_far = max_ending_here;//-17
    }//8,11,16,18,20
    return max_so_far;//19
}//8,11,16,18,20
//DESCRIPTION:
Create a C++ function that, given an array that contains both positive and negative integers, returns the product of the maximum product subarray.
Examples:
Input: arr[] = {6, -3, -10, 0, 2}
Output: 180 (The subarray is {6, -3, -10})
Input: arr[] = {-1, -3, -10, 0, 60}
Output: 60 (The subarray is {60})
Utility functions to get minimum and maximum of two integers:
int min (int x, int y) {return x < y? x : y; }
int max (int x, int y) {return x > y? x : y; }