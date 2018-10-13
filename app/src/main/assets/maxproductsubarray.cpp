int maxSubarrayProduct(int arr[],int n) {//-1
    int max_here=1; int min_here=1;//2
	int maxSoFar = 1;//-3
    for (int i = 0; i < n; i++) {//4
        if (arr[i] > 0) {//-5
            max_here=max_here*arr[i];//6,7
            min_here=min(min_here*arr[i],1);//6,7
        }//8,11,16,18,20
        else if (arr[i] == 0) {//-9
            max_here=1; min_here=1;//-10
        }//8,11,16,18,20
        else {//-12
            int temp = max_here;//13
            max_here=max(min_here*arr[i],1);//14
            min_here=temp*arr[i];//15
        }//8,11,16,18,20
        if (maxSoFar<max_here) maxSoFar=max_here;//-17
    }//8,11,16,18,20
    return maxSoFar;//-19
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