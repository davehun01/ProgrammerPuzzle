public class ArrayFixer {//1
    public static int[] rearrange(int[] A) {//2
        for (int i = 0; i < A.length; i++) {//3
            if (A[i] != -1 && A[i] != i) {//4,5
                int x = A[i];//4,5
                while (A[x] != -1 && A[x] != x) {//6
                    int temp = A[x];//7
                    A[x] = x;//8
                    x = temp;//9
                }//10,14,15,16,18,19
                A[x] = x;//11
                if (A[i] != i) {//12
                    A[i] = -1;//13
                }//10,14,15,16,18,19
            }//10,14,15,16,18,19
        }//10,14,15,16,18,19
        return A;//17
    }//10,14,15,16,18,19
}//10,14,15,16,18,19

// Java program for rearrange an 
// array such that arr[i] = i.