void bucketSort(float arr[], int n) {//1
    vector<float> b[n];//2
    for (int i=0; i<n; i++) {//-3
       int bi = n*arr[i];//4
       b[bi].push_back(arr[i]);//5
    }//6,9,14,15,16
    for (int i=0; i<n; i++) {//7,11
		sort(b[i].begin(), b[i].end());//8
	}//6,9,14,15,16
    int index = 0;//-10
    for (int i = 0; i < n; i++) {//7,11
		for (int j = 0; j < b[i].size(); j++) {//12
			arr[index++] = b[i][j];//13
		}//6,9,14,15,16
	}//6,9,14,15,16
}//6,9,14,15,16
//DESCRIPTION:
Create a C++ function that sorts an array using bucket sort.
Algorithm:
1.Create n empty buckets (Or lists).
2.Do following for every array element arr[i] : insert arr[i] into bucket[n*array[i]]
3.Sort individual buckets.
4.Concatenate all sorted buckets.