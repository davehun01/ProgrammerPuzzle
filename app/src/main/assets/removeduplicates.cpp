char *removeDupsSorted(char *str) {//-1
    int res_ind = 1, ip_ind = 1;//2
    while (*(str + ip_ind)) {//3
        if (*(str + ip_ind) != *(str + ip_ind - 1)) {//4
            *(str + res_ind) = *(str + ip_ind);//5
            res_ind++;//6
        }//7,9,12,17
        ip_ind++;//8
    }//7,9,12,17
    *(str + res_ind) = '\0';//10
    return str;//11
}//7,9,12,17
char *removeDups(char *str) {//13
   int n = strlen(str);//14
   sort(str, str+n);//15
   return removeDupsSorted(str);//16
}//7,9,12,17
//DESCRIPTION:
Create a C function that removes duplicates from a string.
Algorithm:
1.Sort the elements.
2.Now in a loop, remove duplicates by comparing the current character with previous character.
3.Remove extra characters at the end of the resultant string.