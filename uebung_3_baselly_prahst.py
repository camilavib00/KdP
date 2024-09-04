"""
Aufgabe 1: Bubblesort Implementierung
Bubblesort Beschreibung:

    1. Go through the array, one value at a time.
    2. For each value, compare the value with the next value.
    3. If the value is higher than the next one, swap the values so that the highest value comes last.
    4. Go through the array as many times as there are values in the array.

Input: Unsortierte Liste von integers
Output: Von klein nach groß sortierte Liste von integers
Signatur: bubblesort(Liste[int]) -> Liste[int]
"""
def swap(val1, val2):
    xs = [val2, val1]
    return xs

def bubblesort(xs):
    xs_len = len(xs)-1                                                           #value amount in list
    for j in range(0, xs_len, 1):                                                #4
        for i in range(0, xs_len, 1):                                            #1
            if xs[i] > xs[i+1]:                                                  #2
                    xs = xs[:i] + swap(xs[i],xs[i+1]) + xs[i+2:]                 #3
                    #print("current sorted list: ", xs)
    return xs


#ls = [1, 77, 8,5,24,9, 8,7,24]
#print(ls)
#print(bubblesort(ls))
"""
Aufgabe 3: Rekursion und Schleifen
a)lovedDigits()

Input: int
Output:int
Signatur: lovedDigits(int) -> int
lovedDigits Ziffern des input ints werden stellenweise gegen ihre verliebte Zahl ausgetauscht, dabei gilt:
    1. n + verliebte_zahl = 10
    2. verliebte_zahl(0) = 0
    keine Umwandlung in Liste oder String
Beispiel: reverseDigits(165702) − > 945308
"""

import math

#(i) for loop Implementierung
def lovedDigits_for(num):
    if num == 0:
        return 0
    verliebte_zahl = ""
    int_len = math.ceil(math.log10(num))
    for i in range(int_len,-1, -1): #rückwärts über int_len ziffern berechnen.
        if num == 0:
            break # alle ziffern berechnet
        rest = num % 10
        num //= 10
        if rest == 0: #2.
            verliebte_ziffer = 0
        else: #1.
            verliebte_ziffer = 10 - rest
        verliebte_zahl = str(verliebte_ziffer) + verliebte_zahl
    return int(verliebte_zahl)

"""
nums= [222, 0, 10, 457532456, 101, 10110]
for i in nums:
    print(lovedDigits_for(i))
"""

#(ii) while loop Implementierung
def lovedDigits_while(num):
    verliebte_zahl = ""
    while num > 0:
        rest = num % 10
        if rest == 0: #2
            verliebte_ziffer = 0
        else: #1
            verliebte_ziffer = 10 - rest
        num //= 10
        verliebte_zahl = str(verliebte_ziffer) + verliebte_zahl #berechnung ohne strings, aber Ausgabe mit
    return verliebte_zahl
"""
nums= [222, 0, 10, 457532456, 101, 10110]
for i in nums:
    print(lovedDigits_while(i))
"""""

#(iii) rekursive Implementierung
def lovedDigits(num):
    #rekursionsanker
    if num == 0:
        return 0
    #rekursionsschritt
    rest = num % 10
    num //= 10
    if (rest == 0): #2
        verliebte_zahl = 0
    else: #1
        verliebte_zahl = 10 - rest
    return lovedDigits(num) * 10 + verliebte_zahl

"""
nums= [222, 0, 10, 457532456, 101, 10110]
for i in nums:
    print(lovedDigits(i))

Aufgabe 3: Rekursion und Schleifen
b)pyTriple()


pyTriple
Eingabe: int
Ausgabe: list(tuple(int,int,int))
Voraussetzung: die Eingabe soll positiv sein
Effekt: keiner
Ergebnis: Liste pythagoreischer Tripel für die Eingegebene Zahl
"""

"""Hilfsfunktionen: """

# pyTriple mit for-Schleife
def pyTripleFor(zahl: int) -> list:
    # leere Liste, in die unsere Tripel kommen
    resultList = []
    # 3 verschachtelte for-Schleifen, um alle Möglichkeiten der Kombination
    # der Zahlen von 1 - Eingabezahl durchzugehen
    for i in range(1,zahl + 1):
        for j in range(1,zahl+1):
            for k in range(1,zahl+1):
                # wenn eine der Möglichkeiten a^2 + b^2 = c^2 erfüllt, wird
                # sie der Ergebnisliste hinzugefügt
                if (i*i + j*j) == (k*k):
                    resultList.append((i,j,k))
                elif (i*i + k*k) == (j*j):
                    resultList.append((i,k,j))
                elif (j*j + k*k) == (i*i):
                    resultList.append((j,k,i))
    # wandle die Ergebnisliste in ein set um, um doppelte Einträge zu entfernen
    # und dann wieder in eine Liste, damit die gewünschte Klasse zurückgegeben wird
    return list(set(resultList))



# pyTriple mit while-Schleife
def pyTripleWhile(zahl: int) -> list:
    # leere Liste, in die unsere Tripel kommen
    resultList = []
    # setze "(i,j,k)" = "(1,1,1)"
    i = 1
    j = 1
    k = 1
    # 3 verschachtelte while-Schleifen, um alle Möglichkeiten der Kombination
    # der Zahlen von 1 - Eingabezahl durchzugehen
    while i <= zahl:
        while j <= zahl:
            while k <= zahl:
                # wenn eine der Möglichkeiten a^2 + b^2 = c^2 erfüllt, wird
                # sie der Ergebnisliste hinzugefügt
                if (i*i + j*j) == (k*k):
                    resultList.append((i,j,k))
                elif (i*i + k*k) == (j*j):
                    resultList.append((i,k,j))
                elif (j*j + k*k) == (i*i):
                    resultList.append((j,k,i))
                # alle k für das aktuelle j durchgehen
                k += 1
            # alle j für das aktuelle i durchgehen
            j += 1
            # 'reset' k
            k = 1
        # alle i bis zur Eingabezahl durchgehen
        i += 1
        # 'reset' j und k
        j = 1
        k = 1
    # wandle die Ergebnisliste in ein set um, um doppelte Einträge zu entfernen
    # und dann wieder in eine Liste, damit die gewünschte Klasse zurückgegeben wird
    return list(set(resultList))



# pyTriple mit Rekursion

""" Vorüberlegungen:
a. Beim Testen der vorherigen Funktionen fällt auf, dass die kleinsten Tripel (3,4,5) bzw. (4,3,5) sind.
b. Außerdem müssen a,b < c sein, da a^2 + b^2 = c^2 mit natürlichen Zahlen nicht aufgeht.
c. Ich gehe davon aus, dass das Tripel (0,2,2) keine korrekte Lösung ist, denn:
    1. wenn eine Seitenlänge 0 ist, ist die Figur kein Dreieck mehr,
    2. wir arbeiten mit natürlichen Zahlen, und da das Problem geometrisch ist, ist es sinnvoll,
        die natürlichen Zahlen als IN = {1,2,3,...} zu betrachten. """

def pyTripleRec(zahl: int) -> list:
    returnList = []
    c = zahl

    # Rekursionsanker
    if c < 5:
        return returnList

    # Rekursionsschritt
    for a in range(1,c):
        for b in range(2,c):
            if (a*a + b*b == c*c):
                returnList.append((a,b,c))
    return returnList + pyTripleRec(c - 1)



"""Hauptfunktion: """
"""
def pyTriple(zahl: int, methode: str) -> list:
    methode = methode.lower()
    if "for" in methode:
        return pyTripleFor(zahl)
    elif "while" in methode:
        return pyTripleWhile(zahl)
    elif "rekurs" in methode  or "recurs" in methode:
        return pyTripleRec(zahl)
    else:
        return "Ungültige Eingabe"

# zum Testen
method = input("Bitte eine Methode eingeben (For-Schleife, While-Schleife, Rekursion): ")
for i in range(1, int(input('Bitte eine natürliche Zahl eingeben: '))+1):
    print(f'{i}: {pyTriple(i, method)}')
"""
