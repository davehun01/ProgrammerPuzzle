void sieveOfEratosthenes(int n) {//1
    boolean prime[] = new boolean[n+1];//2
    for (int i=0;i<n;i++) prime[i]=true;//3
    for (int p = 2; p*p <=n; p++) {//4
        if (prime[p] == true) {//5
            for (int i=p*2; i<=n; i+=p) prime[i]=false;//6
        }//7,8,12,13,14
    }//7,8,12,13,14
    for (int i = 2; i <= n; i++) {//9
        if (prime[i] == true) {//10
			System.out.print(i + " ");//11
		}//7,8,12,13,14
    }//7,8,12,13,14
}//7,8,12,13,14
//DESCRIPTION:
Create a Java method that prints all prime numbers smaller than or equal to n, using Sieve of Eratosthenes.
Examples:
Input : n = 10
Output : 2 3 5 7
Input : n = 20 
Output : 2 3 5 7 11 13 17 19