public class BinaryToDec {//-1
	public static void main(String[] args) {//2
      	Scanner scanner = new Scanner(System.in);//3,4
      	String bin ="";//3,4
      	System.out.print("Enter binary number: ");//-5
      	if (scanner.hasNextLine()) {//6
      	    bin = scanner.nextLine();//7
      	}//8,14,16,17
        int length = bin.length();//9
        int dec = 0;//-10
        for (int i = 0; i < length; i++) {//11
            int digit = bin.charAt (i) - '0';//12
            dec+=(digit*Math.pow(2,length-1-i));//13
        }//8,14,16,17
        System.out.printf("In decimal:%d\n",dec);//15
	}//8,14,16,17
}//8,14,16,17
//DESCRIPTION:
Create a Java method that takes a binary number as input from user and prints the decimal equivalent on the console.
Example 1:
Enter binary number: 101
In decimal: 5
Example 2:
Enter binary number: 11111
In decimal: 31