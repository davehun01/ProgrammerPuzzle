def binarySearch (arr, left, right, x):#1
    if right >= left:#2
        mid = left + (right - left)/2#3
        if arr[mid] == x:#4
            return mid#5
        elif arr[mid] > x:#-6
            return binarySearch(arr, left, mid-1, x)#7
        else:#8
            return binarySearch(arr, mid+1, right, x)#9
    else:#10
        return -1#11
//DESCRIPTION:
Create a Python function that implements binary search on an array.
Algorithm:
1.Compare x with the middle element.
2.If x matches with middle element, we return the mid index.
3.Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. So we recur for right half.
4.Else (x is smaller) recur for the left half.