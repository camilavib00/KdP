""" import getpass

print("Hi, wie heißt du?")
name = input()
print("Hallo", name, "schön dich zu treffen! \n Das ist ein Zahlen Ratespiel. Denk dir eine Zahl zwischen 1 und 1000 aus und geb sie ein.")
zahl = int(getpass.getpass("Enter a number: "))
if zahl >0 and zahl <= 1000:
    print("Spiel beginnt! SpielerIn 2 darf nun raten.")
    ratezahl = int(input())
    trycount = 1
    while trycount <= 10:
        if ratezahl == zahl:
            print("Gratuliere! Du hast die Zahl erraten!")
            break
        elif ratezahl > zahl:
            print("Die gesuchte Zahl ist kleiner. Versuch es nochmal.")
            ratezahl = int(input())
            trycount += 1
        elif ratezahl < zahl:
            print("Die gesuchte Zahl ist größer. Versuch es nochmal.")
            ratezahl = int(input())
            trycount += 1
    print("Du hast 10 Versuche verbraucht. Die gesuchte Zahl war:",zahl)
else:
    print("Deine Zahl ist nicht zwischen 1 und 1000. Bitte versuch es nochmal.")
 """

# 2b) 

import string
import getpass

print("Hi, das ist ein Galgenmännchenspiel :-)\n Nennt mir eure beiden Namen.")
SpielerIn1 = input()
SpielerIn2 = input()

#der while loop iteriert so lange, bis der Spieler ein Wort eingibt, welches nur Buchstaben enthält & sorgt dafür, dass der for loop für jede wort eingabe neu gesartet wird
istwort = False
while istwort == False:
    wort = getpass.getpass(f"{SpielerIn1} darf nun ein Wort eingeben. Beachte, dass Umlaute nicht erlaubt sind: ")
    for i in wort:
        if ord(i) < 65 or ord(i) > 122:
            print("Der Input entspricht nicht den Vorgaben :(.")
            break
    else:
        #nur aufgerufen wenn die for schleife ohne break durchgelaufen ist
        istwort = True

wort = wort.lower()
current_guess = list("_" * len(wort))
erraten = False

print("Das eingegebene Wort hat die Länge von", len(wort), ": ",current_guess, "\n", SpielerIn2, "darf nun einzelne Buchstaben raten.")
guess = input().lower()
trycount = 1
while trycount <= 10:
    index = wort.find(guess)
    if index == -1:
        print("Leider falsch. Versuch es nochmal.")
        guess = input().lower()
        trycount += 1
    else:
        print("Richtig geraten!")
        indices = []
        while index != -1:
            indices.append(index)
            index = wort.find(guess, index + 1)
        print("Das Wort hat den Buchstaben", guess, "an den Stellen", indices)
        for index in indices:
            current_guess[index] = guess
        print("Aktueller Stand: ", current_guess)
        if "_" not in current_guess:
            print("Glückwunsch! Du hast das Wort erraten.")
            erraten = True
            break
        else:
            print("Rate weiter!")
            guess = input().lower()
            trycount += 1
if erraten == False:
    print("Du hast 10 Versuche verbraucht und leider verloren. :( \n Das gesuchte Wort war:", wort)
    

""" 
#Alternative für 2b) von Rebecca:

from getpass import getpass
name1 = input('Name Spieler 1: ')
name2 = input('Name Spieler 2: ')

ungueltig = True
while ungueltig:
    wort = getpass(f'{name1}. Nenne ein Wort: ')

    for char in wort:
        umlaute = [196, 214, 220, 223, 228, 246, 252]
        if not(64 < ord(char) < 91 or 96 < ord(char) < 123 or ord(char) in umlaute):
            print(f'{wort} ist ungültig. Die Eingabe muss ein String aus Buchstaben des deutschen Alphabets sein.')
            wort = None        
            break
        ungueltig = False
        
if wort is not None:
    wort = wort.lower()
    laenge = len(wort)
    print(f'Das Wort hat {laenge} Buchstaben.')
    loesung = list("_"*laenge)
    final = ""
    i = 1
    while i <= 10:
        guess = input(f'{name2}, nenne einen Buchstaben: ')
        current = ""
        if guess in wort:
            letterlist = []
            for j in range(laenge):
                if list(wort)[j] == guess:
                    letterlist.append(j)
            for k in letterlist:
                loesung[k] = guess
            for l in loesung:
                current += l
            print(current)
            final = current
        else:
            print('Buchstabe ist nicht im Wort.')
        if final == wort:
            print(f"Richtig, das wort ist {wort}")
            break
        i += 1
    if final != wort:
        print(f"10 Versuche sind vorbei. Das Wort war {wort}") """