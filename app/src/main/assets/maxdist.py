def maxDistance(arr, n):#1
    mp = {}#2,3
    maxDist = 0#2,3
    for i in range(n):#4
        if arr[i] not in mp.keys():#5
            mp[arr[i]] = i#6
        else:#7
            maxDist = max(maxDist, i-mp[arr[i]])#8
    return maxDist#9
//DESCRIPTION:
Create a Python function that, given an array with repeated elements, returns the maximum distance of two occurences of an element.
Example:
Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Output: 10