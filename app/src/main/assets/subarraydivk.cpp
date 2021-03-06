int subarrSumDivByK(int arr[],int n,int k) {//-1
    unordered_map<int, int> um;//2,3
    int mod_arr[n], max=0; int curr_sum=0;//2,3
    for (int i = 0; i < n; i++) {//-4
        curr_sum += arr[i];//-5
        mod_arr[i] = ((curr_sum % k) + k) % k;//6
    }//7,11,14,17,18,20
    for (int i = 0; i < n; i++) {//8
        if (mod_arr[i] == 0) {//9
			max = i + 1;//-10
		}//7,11,14,17,18,20
        else if (um.find(mod_arr[i])==um.end()) {//-12
			um[mod_arr[i]] = i;//-13
		}//7,11,14,17,18,20
        else if (max < (i - um[mod_arr[i]])){//15
			max = i - um[mod_arr[i]];//16
		}//7,11,14,17,18,20
    }//7,11,14,17,18,20
    return max;//-19
}//7,11,14,17,18,20
//DESCRIPTION:
Create a C++ function that, given an arr[] containing n integers and a positive integer k, returns the length of the longest subarray with sum of the elements divisible by the given value k.
Example:
Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 4
The subarray is {7, 6, 1, 4} with sum 18,
which is divisible by 3.