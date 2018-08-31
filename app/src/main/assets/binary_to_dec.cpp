int main (int argc, char *argv []) {//-1
    char binary [12];//2,3
    printf ("Enter binary number: ");//2,3
    scanf ("%s", binary);//4
    size_t length = strlen (binary);//5
    int decimal = 0;//-6
    for (int i = 0; i < length; i++) {//7
        int binaryDigit = binary[i] - '0';//8
        decimal += (binaryDigit * pow(2, length - 1 - i));//9
    }//10,13
    printf ("In decimal: %d\n", decimal);//11
    return 0;//12
}//10,13
//DESCRIPTION:
Create a C function that takes a binary number as input from user and prints the decimal equivalent on the console.
Example 1:
Enter binary number: 101
In decimal: 5
Example 2:
Enter binary number: 11111
In decimal: 31