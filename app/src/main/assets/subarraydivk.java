static int longSubarrWthSumDivByK(int arr[], int n, int k) {//1
    HashMap<Integer, Integer> um = new HashMap<Integer, Integer>();//2,3
    int mod_arr[] = new int[n]; int max = 0; int curr_sum = 0;//2,3
    for (int i = 0; i < n; i++) {//4
        curr_sum += arr[i];//5
        mod_arr[i] = ((curr_sum % k) + k) % k;//6
    }//7,11,14,17,18,20
    for (int i = 0; i < n; i++) {//8
        if (mod_arr[i] == 0) {//9
			max = i + 1; //10
		}//7,11,14,17,18,20
        else if (um.containsKey(mod_arr[i]) == false) {//-12
			um.put(mod_arr[i] , i);//13
		}//7,11,14,17,18,20
        else if (max < (i - um.get(mod_arr[i]))) {//15
			max = i - um.get(mod_arr[i]);//16
		}//7,11,14,17,18,20
    }//7,11,14,17,18,20
    return max;//19
}//7,11,14,17,18,20