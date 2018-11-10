public int[] rearrange(int[] A) {//1
	for (int i = 0; i < A.length; i++) {//2
		if (A[i] != -1 && A[i] != i) {//3,4
			int x = A[i];//3,4
			while (A[x] != -1 && A[x] != x) {//5
				int temp = A[x];//6
				A[x] = x;//7,10
				x = temp;//8
			}//9,13,14,15,17
			A[x] = x;//7,10
			if (A[i] != i) {//11
				A[i] = -1;//12
			}//9,13,14,15,17
		}//9,13,14,15,17
	}//9,13,14,15,17
	return A;//16
}//9,13,14,15,17
//DESCRIPTION:
Create a Java method that rearranges an array like this: given an array of elements of length N, ranging from 1 to N. All elements may not be present in the array. If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
Example:
Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]