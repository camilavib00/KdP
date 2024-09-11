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


"""
Aufgabe 2: sortieren
Insertionsort
Anfang der liste ist 'sortiert' man setzt nächstes elem an richtige stelle
[66, 2, 98, 42, 76, 54]
[66| 2, 98, 42, 76, 54]
[2, 66| 98, 42, 76, 54]
[2, 66, 98| 42, 76, 54]
[2, 42, 66, 98| 76, 54]
[2, 42, 66, 76, 98| 54]
[2, 42, 54, 66, 76, 98]

Mergesort
Brute rekursiv splitten, sublisten Sortieren
bei ungerader listen größe split bei untere grenze bei division /2 also 5 -> 2, 3->1
[66, 2, 98, 42, 76, 54, 12, 33, 103, 34]
....
[[66], [2], [98], [42], [76], [54], [12], [33], [103], [34]]
[[2, 66], [98], [42,76], [12, 54], [33], [34, 103]]
[[2, 66], [42,76, 98], [12, 54], [33, 34, 103]]
[[2, 42, 66, 76, 98], [12, 33, 34, 54, 103]]
[2, 12, 33, 34, 42, 54, 66, 76, 98, 103]

b) gute implementierung: Bucketsort
"""

def bucketSort(l):
    c = [0,0]
    for i in l:
        c[i] += 1
    res = []
    for i in range(c[0]):
        res.append(0)
    for i in range(c[1]):
        res.append(1)
    return res
    
