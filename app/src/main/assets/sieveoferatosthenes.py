def SieveOfEratosthenes(n):#1
    prime = [True for i in range(n+1)]#2,3
    p = 2#2,3
    while (p * p <= n):#4
        if (prime[p] == True):#5
            for i in range(p * 2, n+1, p):#6
                prime[i] = False#7
        p += 1#8
    for i in range(2, n):#9
        if prime[i]:#10
			print i#11
//DESCRIPTION:
Create a Python function that prints all prime numbers smaller than or equal to n, using Sieve of Eratosthenes.
Examples:
Input : n = 10
Output : 2 3 5 7
Input : n = 20 
Output : 2 3 5 7 11 13 17 19