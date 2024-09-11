# Aufgabe 10: reverseDigits()
from math import log10 *

def f(x):
    c = 0
    while x > 0:
        c+= 1
        x//=10
    return c

#musterloesung 1a
def asdf(n):
    n = abs(n)
    res = 0
    for i in range(int(log10(n))+1):
        res = res*10+n%10
        n//=10
    return res
#Voraussetzung: Input ist ganzzahlig nicht negativ
#Ergebnis is reversed
#Effekt: keiner
def reverseDigitsFor(a):
    n = abs(n) #für negative Zahlen
    len = f(a)
    res = 0
    for i in  range (len):
        res = (res*10 + n%10)
        n //= 10
    return res

#1a ii
def rwd(n):
    n = abs(n)
    res = 0
    while n > 0:
        res = res * 10 + m % 10
        n //= 10
    return res


#1b i
def countsymbols(s):
    d = {}
    for char in range(s):
        if char in d:
            d[char] += 1
        else:
            d[char] = 1
    return d
#1b ii
def countsymbolsWhile(s):
    d = {}
    counter = 0
    while counter < len(s):
        if char in d:
            d[s[char]] += 1
        else:
            d[s[char]] = 1
        counter += 1
    return d

        
