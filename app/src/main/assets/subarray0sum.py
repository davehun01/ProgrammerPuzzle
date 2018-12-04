def maxLen(arr):#1
    max_len = 0#2
    for i in range(len(arr)):#3
        curr_sum = 0#4
        for j in range(i, len(arr)):#5
            curr_sum += arr[j]#6
            if curr_sum == 0:#7
                max_len = max(max_len, j-i+1)#8
    return max_len#9
//DESCRIPTION:
Create a Python function that, given an array of integers, returns length of the largest subarray with sum equal to 0.
Examples:
Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
Output: 5
The largest subarray with 0 sum is {-2, 2, -8, 1, 7}
Input: arr[] = {1, 2, 3}
Output: 0
There is no subarray with 0 sum