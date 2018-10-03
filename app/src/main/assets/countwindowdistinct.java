int countWindow(int win[], int k) {//1
    int dist_count = 0;//2
    for (int i = 0; i < k; i++) {//3
        int j;//4
        for (j = 0; j < i; j++) {//5
			if (win[i]==win[j]) break;//6
		}//7,9,11,16,17
        if (j == i) dist_count++;//8
    }//7,9,11,16,17
    return dist_count;//14
}//7,9,11,16,17
void countDistinct(int arr[],int n,int k) {//12
    for (int i = 0; i <= n - k; i++) {//13
		System.out.println(countWindow)//-14
		(Arrays.copyOfRange(arr,i,arr.length),k));//-15
	}//7,9,11,16,17
}//7,9,11,16,17
//DESCRIPTION:
Create a Java method that, given an array of size n and an integer k, prints the count of distinct numbers in all windows of size k.
Example:
Input:  arr[] = {1, 2, 1, 3, 4, 2, 3} k = 4
Output:
3
4
4
3