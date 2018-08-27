static int maxLen(int arr[], int n) {//1
    int max_len = 0;//2
    for (int i = 0; i < n; i++) {//3
        int curr_sum = 0;//4
        for (int j = i; j < n; j++) {//5
            curr_sum += arr[j];//6
            if (curr_sum == 0) {//7
				max_len = Math.max(max_len, j-i+1);//8
			}//9,10,11,13
        }//9,10,11,13
    }//9,10,11,13
    return max_len;//12
}//9,10,11,13