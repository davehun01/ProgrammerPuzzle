def maxLen(arr):#1
    max_len = 0#2
    for i in range(len(arr)):#3
        curr_sum = 0#4
        for j in range(i, len(arr)):#5
            curr_sum += arr[j]#6
            if curr_sum == 0:#7
                max_len = max(max_len, j-i+1)#8
    return max_len#9