def rearrange( A, len):#1
    for i in range(0, len): #2
        if (A[i] != -1 and A[i] != i):#3,4
            x = A[i];#3,4
            while (A[x] != -1 and A[x] != x):#5
                temp = A[x]#6
                A[x] = x#-7
                x = temp#8
            A[x] = x;#-9
            if (A[i] != i) :#10
                A[i] = -1;#11
//DESCRIPTION:
Create a Python function that rearranges an array like this: given an array of elements of length N, ranging from 1 to N. All elements may not be present in the array. If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
Example:
Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]