def leftRotate(arr, d, n):#-1
    for i in range(d):#2
        leftRotatebyOne(arr, n)#3
def leftRotatebyOne(arr, n):#4
    temp = arr[0]#5
    for i in range(n-1):#6
        arr[i] = arr[i+1]#7
    arr[n-1] = temp#8