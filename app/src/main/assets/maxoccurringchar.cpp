char getMaxOccuringChar(char* str) {//1
    int count[256] = {0};//2,3
    int len = strlen(str);//2,3
    for (int i=0; i<len; i++) {//-4
		count[str[i]]++;//5
	}//6,13,14,16
    int max = -1;//-7
    char result;//-8
    for (int i = 0; i < len; i++) {//9
        if (max < count[str[i]]) {//10
            max = count[str[i]];//11,12
            result = str[i];//11,12
        }//6,13,14,16
    }//6,13,14,16
    return result;//15
}//6,13,14,16
//DESCRIPTION:
Create an efficient C function to return maximum occurring character in the input string.
Example:
Input: test
Output: t