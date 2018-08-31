int minSwaps(int arr[], int n) {//1
    pair<int, int> arrPos[n];//2
    for (int i = 0; i < n; i++) {//3
        arrPos[i].first = arr[i];//4,5
        arrPos[i].second = i;//4,5
    }//6,16,18,20
    sort(arrPos, arrPos + n);//7,8
    vector<bool> vis(n, false); int ans = 0;//7,8
    for (int i = 0; i < n; i++) {//9
        if (vis[i] || arrPos[i].second == i) continue;//10
        int cycle_size = 0; int j = i;//11
        while (!vis[j]) {//12
            vis[j] = 1;//13
            j = arrPos[j].second;//14
            cycle_size++;//-15
        }//6,16,18,20
        ans += (cycle_size - 1);//17
    }//6,16,18,20
    return ans;//19
}//6,16,18,20
//DESCRIPTION:
Create a C++ function that, given an array of n distinct elements, returns the minimum number of swaps required to sort the array.
Examples:
Input : {4, 3, 2, 1}
Output : 2
Input : {1, 5, 4, 3, 2}
Output : 2