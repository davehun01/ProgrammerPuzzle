def getMaxOccuringChar(str):#1
    count = [0] * 256#2,3,4
    max = -1#2,3,4
    c = ''#2,3,4
    for i in str:#5
        count[ord(i)]+=1;#6
    for i in str:#7
        if max < count[ord(i)]:#8
            max = count[ord(i)]#9,10
            c = i#9,10
    return c#11
//DESCRIPTION:
Create an efficient Python function to return maximum occurring character in the input string.
Example:
Input: test
Output: t