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
import math
#(i) for loop Implementierung
def lovedDigits_for(num):
    if num == 0:
        return 0
    int_len = math.ceil(math.log10(num))
    for digit in range(int_len):

    return loved_num
#(ii) while loop Implementierung

def lovedDigits_while(num):
    while num >= 0:
        digit = num % 10
        if digit == 0:
            loved_num = 0
            continue
        else:
            loved_num = 10 - digit
        num = num //= 10
#(iii) rekursive Implementierung

def lovedDigits(num):
    #rekursionsanker
    if num == 0:
        return 0
    #rekursionsschritt

"""
Aufgabe 3: Rekursion und Schleifen
b)pyTriple()
"""
