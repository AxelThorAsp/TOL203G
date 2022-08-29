
import sys

def getProb(n,m):
    #prob m roll > n roll
    if n >= m:
        return (m*(m-1)/2)/(m*n)
    elif n < m:
        return (m*n-n/2*(n+1))/(m*n)
    else:
         return "unreachable"

def Main():
    lines =[]
    for line in sys.stdin:
        lines.append(line)

    m,n = lines[0].split()

    p = int(lines[1])

    p = p / 100

    m=int(m)
    n=int(n)

    l= [3,4,5,6,7,8,10,12,14,16,20,24,30]
    startIndex = l.index(m)
    counter = 0
    if getProb(n,m) >= p:
        return 0

    for i in range(startIndex+1,len(l)):
        counter = counter + 1
        if getProb(n,l[i]) >= p:
            return counter
        if i == len(l)-1:
            return "Vonlaust!"
        else:
            m = l[i]
print(Main(),end="")
