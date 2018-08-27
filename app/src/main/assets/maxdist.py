def maxDistance(arr, n):#1
    mp = {}#2,3
    maxDict = 0#2,3
    for i in range(n):#4
        if arr[i] not in mp.keys():#5
            mp[arr[i]] = i#6
        else:#7
            maxDict = max(maxDict, i-mp[arr[i]])#8
    return maxDict#9