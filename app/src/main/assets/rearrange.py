def fix( A, len):#1
    for i in range(0, len): #2
        if (A[i] != -1 and A[i] != i):#3,4
            x = A[i];#3,4
            while (A[x] != -1 and A[x] != x):#5
                temp = A[x]#6
                A[x] = x#7
                x = temp#8
            A[x] = x;#9
            if (A[i] != i) :#10
                A[i] = -1;#11