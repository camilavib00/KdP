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


#Aufgabe 4
"""
b) Wahr oder Falsch: Falsch, es gibt nicht vergleichsbasierte Sortiergorithmen
die Listen in O(n) sortieren können. Zum beispiel Bucketsort,
welcher gut für die Binärsortierung gut gewesen wäre

c) Falsch: Untere Schranke <-> kein Lagorithmus existiert,
der das Problem schneller lösen könnte

a)
f2('Einhorn', 'Drache')
-> if a: -> solange a korrekt ist, also Zahl, non-empty string etc wird
if immer ausgewertet. bei if "":, if 0: wird zu else ausgewertet
z ist lokal, z = 'Hallo Einhorn'

print(x)
print(z)
z = f1(z)
-> verdoppelt z
print(z)
print(y)
f2('', 'Papagei') -> da empty string wird else ausgewertet
print(y)

Output:
'Hallo Einhorn'
'Hallo'
'wie geht es so?'
'Wie geht es so?Wie geht es so?'
'Bye'
'Bye Bye Papagei'


d)
call by value: ver immer direkt ausgewertet
call by name: var immer erst ausgewertet wenn nötig,
 merkt sich den einmal ausgewerteten ausgewert
-> call by value ist schneller
"""
