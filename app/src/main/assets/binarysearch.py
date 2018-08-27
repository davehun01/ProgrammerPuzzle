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