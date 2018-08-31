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
//DESCRIPTION:
Create a Java method that rearranges an array like this: given an array of elements of length N, ranging from 1 to N. All elements may not be present in the array. If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
Example:
Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]