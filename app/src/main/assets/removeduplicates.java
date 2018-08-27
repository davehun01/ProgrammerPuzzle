static String removeDupsSorted(String str) {//-1
    int res_ind = 1, ip_ind = 1;//2,3
    char arr[] = str.toCharArray();//2,3
    while (ip_ind != arr.length) {//4
        if(arr[ip_ind] != arr[ip_ind-1]) {//5
            arr[res_ind] = arr[ip_ind];//6
            res_ind++;//7
        }//8,10,13,19
        ip_ind++;//9   
    }//8,10,13,19
    str = new String(arr);//11
    return str.substring(0,res_ind);//12
}//8,10,13,19
static String removeDups(String str) {//14
	char temp[] = str.toCharArray();//15
	Arrays.sort(temp);//16
	str = new String(temp);//17
	return removeDupsSorted(str);//18
}//8,10,13,19