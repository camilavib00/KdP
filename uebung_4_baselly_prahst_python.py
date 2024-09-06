"""
Aufgabe 1:
Laufzeitanalyse von foo
geg: foo
"""

def foo(x):
    y = ''
    while x>0:
        y = str(x%2)+y
        x = x//2
    return y

print("Lets find out what this function does :)")
x  =int(input("Please enter your x: "))
print(foo(x))
print("This function calculates the binary number of x!")

#e) umschreiben in Rekursion

def dezToBin(num):
    #rekursionsanker
    if num == 0:
        return ''
    #rekursionsschritt
    y = str(num%2)
    num = num//2
    return dezToBin(num) + y

num  =int(input("Please enter your num for the recursive version: "))
print(dezToBin(num))
