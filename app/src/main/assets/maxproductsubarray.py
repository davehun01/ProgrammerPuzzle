def maxsubarrayproduct(arr):#1
    n = len(arr)#2,3,4,5
    max_ending_here = 1#2,3,4,5
    min_ending_here = 1#2,3,4,5
    max_so_far = 1#2,3,4,5
    for i in range(0,n):#6
        if arr[i] > 0:#7
            max_ending_here = max_ending_here*arr[i]#8,9
            min_ending_here = min (min_ending_here * arr[i], 1)#8,9
        elif arr[i] == 0:#10
            max_ending_here = 1#11,12
            min_ending_here = 1#11,12
        else:#13
            temp = max_ending_here#14
            max_ending_here = max (min_ending_here * arr[i], 1)#15
            min_ending_here = temp * arr[i]#16
        if (max_so_far < max_ending_here):#-17
            max_so_far  =  max_ending_here#18
    return max_so_far#19
//DESCRIPTION:
Create a Python function that, given an array that contains both positive and negative integers, returns the product of the maximum product subarray.
Examples:
Input: arr[] = {6, -3, -10, 0, 2}
Output: 180 (The subarray is {6, -3, -10})
Input: arr[] = {-1, -3, -10, 0, 60}
Output: 60 (The subarray is {60})