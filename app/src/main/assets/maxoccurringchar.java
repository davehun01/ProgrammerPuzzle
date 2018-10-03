char getMaxOccuringChar(String str) {//1
    int count[] = new int[256];//2,3
    int len = str.length();//2,3
    for (int i=0; i<len; i++) {//-4
		count[str.charAt(i)]++;//5
	}//6,13,14,16
    int max = -1;//-7
    char result = ' ';//-8
    for (int i = 0; i < len; i++) {//9
        if (max < count[str.charAt(i)]) {//10
            max = count[str.charAt(i)];//11,12
            result = str.charAt(i);//11,12
        }//6,13,14,16
    }//6,13,14,16
    return result;//15
}//6,13,14,16
//DESCRIPTION:
Create an efficient Java method to return maximum occurring character in the input string.
Example:
Input: test
Output: t