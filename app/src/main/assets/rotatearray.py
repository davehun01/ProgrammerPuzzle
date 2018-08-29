def leftRotate(arr, d, n):#-1
    for i in range(d):#2
        leftRotatebyOne(arr, n)#3
def leftRotatebyOne(arr, n):#4
    temp = arr[0]#5
    for i in range(n-1):#6
        arr[i] = arr[i+1]#7
    arr[n-1] = temp#8
//DESCRIPTION:
Create a Python function that rotates an array of size n by d elements.
Example:
Input: arr = {1, 2, 3, 4, 5, 6, 7} d = 2
Output: {3, 4, 5, 6, 7, 1, 2}