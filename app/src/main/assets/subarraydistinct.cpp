int sumoflength(int arr[], int n) {//1
    unordered_set<int> s;//2,3
    int j = 0, ans = 0;//2,3
    for (int i=0; i<n; i++) {//4
        while (j < n && s.find(arr[j]) == s.end()) {//5
            s.insert(arr[j]);//6
            j++;//7
        }//8,11,13
        ans += ((j - i) * (j - i + 1))/2;//9,10
        s.erase(arr[i]);//9,10
    }//8,11,13
    return ans;//12
}//8,11,13

// Returns sum of lengths of all subarrays with distinct
// elements.