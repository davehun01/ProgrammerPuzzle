int countWindow(int window[], int k) {//-1
    int dist_count = 0;//2
    for (int i=0; i<k; i++) {//3
        int j;//4
        for (j=0; j<i; j++) {//5
			if (window[i] == window[j]) {//6
				break;//7
			}//8,9,12,13,15,19
		}//8,9,12,13,15,19
        if (j==i) {//10
			dist_count++;//11
		}//8,9,12,13,15,19
    }//8,9,12,13,15,19
    return dist_count;//14
}//8,9,12,13,15,19
void countDistinct(int arr[], int n, int k) {//16
    for (int i=0; i<=n-k; i++)//17
       cout<<countWindow(arr+i, k)<<endl;//18
}//8,9,12,13,15,19
//DESCRIPTION:
Create a C++ function that, given an array of size n and an integer k, prints the count of distinct numbers in all windows of size k.
Example:
Input:  arr[] = {1, 2, 1, 3, 4, 2, 3} k = 4
Output:
3
4
4
3