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
def swap(val1, val2):
    xs = [val2, val1]
    return xs

def bubblesort(xs):
    xs_len = len(xs)-1
    print("Our List has ", xs_len+1, " elements in it! \n")                                     #value amount in list
    for j in range(0, xs_len, 1):
        print("We're at element: ", j, "\n")                               #4
        for i in range(0, xs_len-1, 1):
            print("comparing: ", xs[i], " with: ", xs[i+1], "\n")                         #1
            if xs[i] > xs[i+1]:
                print("xs[i] > xs[i+1]")                              #2
                xs = xs[:i-1] + swap(xs[i+1],xs[i]) + xs[i+2:]  #3
                print("current sorted list: ", xs)
    return xs

ls = [1, 8,5,9]
print(ls)
print(bubblesort(ls))
"""
Aufgabe 3: Rekursion und Schleifen
a)lovedDigits()
b)pyTriple()
"""
