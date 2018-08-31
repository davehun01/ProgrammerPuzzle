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
//DESCRIPTION:
Create a C++ function that, given an array, returns the sum of lengths of contiguous subarrays having all elements distinct.
Example:
Input :  arr[] = {1, 2, 3}
Output : 10
{1, 2, 3} is a subarray of length 3 with distinct elements. Total length of length three = 3.
{1, 2}, {2, 3} are 2 subarray of length 2 with distinct elements. Total length of lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1 with distinct element. Total lengths of length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10