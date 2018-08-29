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
//DESCRIPTION:
Create a C++ function that, given an array with repeated elements, returns the maximum distance of two occurences of an element.
Example:
Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Output: 10