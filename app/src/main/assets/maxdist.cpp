int maxDistance(int arr[], int n) {//1
    unordered_map<int, int> mp;//2,3
    int max_dist = 0;//2,3
    for (int i=0; i<n; i++) {//4
        if (mp.find(arr[i]) == mp.end()) {//5
			mp[arr[i]] = i;//6
		} else {//7
			max_dist = max(max_dist, i - mp[arr[i]]);//8
		}//9,10,12
    }//9,10,12
    return max_dist;//11
}//9,10,12

// C++ program to find maximum distance between two
// same occurrences of a number.