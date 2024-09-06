"""
Aufgabe 1:
Laufzeitanalyse von foo
geg: foo
e) umschreiben in Rekursion
"""

def foo(x):
    y = ''
    while x>0:
        y = str(x%2)+y
        x = x//2
        print("updated y: ", y)
        print("updated x: ", x)
    return y

print("Lets find out what this function does :)")
x  =int(input("Please enter your x: "))
print(foo(x))
