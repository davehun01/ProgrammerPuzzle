int rearrange(int A[], int len) {//1
    for (int i = 0; i < len; i++) {//2
        if (A[i] != -1 && A[i] != i) {//3,4
            int x = A[i];//3,4
            while (A[x] != -1 && A[x] != x) {//5
                int temp = A[x];//6
                A[x] = x;//7
                x = temp;//8
            }//9,13,14,15,16
            A[x] = x;//10
            if (A[i] != i) {//11
                A[i] = -1;//12
            }//9,13,14,15,16
        }//9,13,14,15,16
    }//9,13,14,15,16
}//9,13,14,15,16

// Function to rearrange an array
// such that arr[i] = i.