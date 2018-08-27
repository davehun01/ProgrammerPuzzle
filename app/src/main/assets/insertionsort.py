def insertionSort(arr):#1
    for i in range(1, len(arr)):#2
        key = arr[i]#3,4
        j = i-1#3,4
        while j >=0 and key < arr[j]:#5
            arr[j+1] = arr[j]#6
			j -= 1#7
        arr[j+1] = key#8