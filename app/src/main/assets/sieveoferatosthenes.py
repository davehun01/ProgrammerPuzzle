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