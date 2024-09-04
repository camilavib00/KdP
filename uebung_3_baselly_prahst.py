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
    n + verliebte_zahl = 10
    rekursionsanker verliebte_zahl(0) = 0
    keine Umwandlung in Liste oder String
Beispiel: reverseDigits(165702) − > 945308
"""

"""
Aufgabe 3: Rekursion und Schleifen
b)pyTriple()

# pyTriple
# Eingabe: int
# Ausgabe: list(tuple(int,int,int))
# Voraussetzung: die Eingabe soll positiv sein
# Effekt: keiner
# Ergebnis: Liste pythagoreischer Tripel für die Eingegebene Zahl


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

# zum Testen
#for i in range(1, int(input('Aufgabe 3b) for-Schleife: \nBitte eine natürliche Zahl eingeben: '))+1):
#    print(f'{i}: {pyTripleFor(i)}')


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

# zum Testen
#for i in range(1, int(input('Aufgabe 3b) while-Schleife: \nBitte eine natürliche Zahl eingeben: '))+1):
#    print(f'{i}: {pyTripleWhile(i)}')
"""
