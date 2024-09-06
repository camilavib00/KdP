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
    return y
