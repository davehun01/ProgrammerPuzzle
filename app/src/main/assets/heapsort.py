def heapify(arr, n, i):#-1
    largest = i#2,3,4
    l = 2 * i + 1#2,3,4
    r = 2 * i + 2#2,3,4
    if l < n and arr[i] < arr[l]:#5
        largest = l#6
    if r < n and arr[largest] < arr[r]:#-7
        largest = r#8
    if largest != i:#9
        arr[i],arr[largest] = arr[largest],arr[i]#-10
        heapify(arr, n, largest)#11
def heapSort(arr):#-12
    n = len(arr)#13
    for i in range(n, -1, -1):#-14
        heapify(arr, n, i)#15
    for i in range(n-1, 0, -1):#16
        arr[i], arr[0] = arr[0], arr[i]#17
        heapify(arr, i, 0)#18
//DESCRIPTION:
Create a Python function that implements heap sort on an array.
Algorithm:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.