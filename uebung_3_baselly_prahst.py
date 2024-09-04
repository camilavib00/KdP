"""
Aufgabe 1: Bubblesort Implementierung
Bubblesort Beschreibung:

    1. Go through the array, one value at a time.
    2. For each value, compare the value with the next value.
    3. If the value is higher than the next one, swap the values so that the highest value comes last.
    4. Go through the array as many times as there are values in the array.

Input: Unsortierte Liste von integers
Output: Von klein nach groß sortierte Liste von integers
Signatur: bubblesort: Liste[int] -> Liste[int]
"""
def is_sorted(xs):
    for num in range(0, len(xs)-1,1):
        if xs[num] > xs[num+1]:
            return False
    return True


def bubblesort(xs):
    while not is_sorted(xs):                                    #incorrect #1 switch to amt of values in array
        for i in range(0, len(xs)-1, 1):                        #4
            if xs[i] > xs[i+1]:                                 #2
                xs = xs[:i-1] + xs[i+1] + xs[i] + xs[i+2:]      #3


"""
Aufgabe 3: Rekursion und Schleifen
a)lovedDigits()
b)pyTriple()
"""
