static int countWindowDistinct(int win[], int k) {//1
    int dist_count = 0;//2
    for (int i = 0; i < k; i++) {//3
        int j;//4
        for (j = 0; j < i; j++) {//5
			if (win[i] == win[j]) {//6
				break;//7
			}//8,9,12,13,15
		}//8,9,12,13,15
        if (j == i) {//10
			dist_count++;//11
		}//8,9,12,13,15
    }//8,9,12,13,15
    return dist_count;//14
}//8,9,12,13,15