# U5A3b)

def incrementABC(a,b,c,n):
    if (c+1>n):
        c=b
        if (b+1>n):
            b=a
            a+=1
        else:
            b+=1
    else:
        c+=1
    return (a,b,c)

def a3(n):
    def f(n,a,b,c):
        if (a>=n) or (b>=n) or (c>n):
            return []
        if ((a*a+b*b)==c*c):
            r = (a,b,c)
            a,b,c=incrementABC(a,b,c,n)
            return [r] + f(n,a,b,c)
        return
    return f(n,1,1,1)

# an sich das Gleiche, aber kürzer geschrieben:

def A3(n):
    def f(n,a,b,c):
        if(a>n):
            return []
        if(b>n):
            return f(n,a+1,a+1,a+2)
        if(c>n):
            return f(n,a,b+1,b+1)
        if(a*a+b*b==c*c):
            return [(a,b,c)] + f(n,a,b,c+1)
        return f(n,a,b,c+1)
    return f(n,1,1,1)

#print(A3(13))

# zu U5A3a)

def f(x):
    c=1
    res=0
    while x>0:
        res = res + c*(10-(x%10))
        c*=10
        x//=10
    return res

def F(x):
    res=0
    while x>0:
        res = 10*res + (x%10)
        x//=10
    return res

#print(f(123456789))
        
"""
U7A1b)
(i):    (a,b)=(42,13)
(ii):   (a,b)=(17,121)

(i)
erg = 0, a = 42, b = 13, a%2==0 -> / -> a=a//2=21, b=b*2=26
erg = 0, a = 21, b = 26, a%2==1 -> erg = erg + b = 0 + 26 = 26 -> a=a//2=10, b=b*2=52
erg = 26, a = 10, b = 52, a%2==0 -> / -> a=a//2=5, b=b*2=104
erg = 26, a = 5, b = 104, a%2==1 -> erg = erg + b = 26 + 104 = 130 -> a=a//2=2, b=b*2=208
erg = 130, a = 2, b = 208, a%2==0 -> / -> a=a//2=1, b=b*2=416
erg = 130, a = 1, b = 416, a%2=1 -> erg = erg + b = 130 + 416 = 546 -> a=a//2=0, b=b*2=832
erg = 546, a = 0 -> break

(ii)
erg = 0, a = 17, b = 121, a%2==1 -> erg = erg + b = 0 + 121 = 121 -> a//2=8, b*2=242
erg = 121, a = 8, b = 242, a%2==0 -> / -> a//2=4, b*2=484
erg = 121, a = 4, b = 484, a%2==0 -> / -> a//2=2, b*2=968
erg = 121, a = 2, b = 968, a%2==0 -> / -> a//2=1, b*2=1936
erg = 121, a = 1, b = 1936, a%2==1 -> erg = erg + b = 121 + 1936 = 2057 -> a//2=0, b*2=3872
erg = 2057, a = 0 -> break

Selectionsort: O(n**2)
Quicksort: O(n**2) (average case: O(nlog(n)))
Insertionsort: O(n**2)
"""

"""
O(log_a b) = O(log_c b)
Beweis:
log_a b = log_d b / log_d a (da log_a b * log_b a == 1)
= (1 / log_d a) * log_d b ((1 / log_d a) const)
O(log_a b)=O((1 / log_d a) * log_d b)=O(log_d b)
"""

"""
U5A2a)
1000*n**2 + 193 + 10*log**2(n) + 95*1.1**k
    O(1000*n**2 + 193 + 10*log**2(n) + 95*1.1**k)
 =  O(n**2 + log(n)**2 + 1.1**k)
 =  O(n**2 + 1.1**k)

U5A2b)
89*n + 55*n + m*log(n) + n*5m + 46*n! + 4*m*n**(3/2)
    O(89*n + 55*n + m*log(n) + n*5m + 46*n! + 4*m*n**(3/2))
 =  O(2*n + m*log(n) + n*m + n! + m*n*n**(1/2))
 =  O(n + m*log(n) + n*m + n! + m*n)
 =  O(n*(1+2*m) + m*log(n) + n!)
 =  O(n*m + m*log(n) + n!)
 =  O(n! + n*m)
"""
            