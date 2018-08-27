public class BinaryToDec {//-1
	public static void main(String[] args) {//2
      	Scanner scanner = new Scanner(System.in);//3,4
      	String binary = "";//3,4
      	System.out.print("Enter binary number: ");//-5
      	if (scanner.hasNextLine()) {//6
      	    binary = scanner.nextLine();//7
      	}//8,14,16,17
        int length = binary.length();//9
        int decimal = 0;//-10
        for (int i = 0; i < length; i++) {//11
            int binaryDigit = binary.charAt (i) - '0';//12
            decimal += (binaryDigit * Math.pow(2, length - 1 - i));//13
        }//8,14,16,17
        System.out.printf("In decimal: %d\n", decimal);//15
	}//8,14,16,17
}//8,14,16,17