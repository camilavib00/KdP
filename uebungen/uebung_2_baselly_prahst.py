""" 
Bei der Caesarverschlusselung einigen die kommunizierenden Personen sich auf ¨
einen Zahlschlussel n. Wenn eine der Personen einen Text verschl ¨ usselt, ersetzt ¨
sie jeden Buchstaben ihres Textes mit dem Buchstaben im Alphabet, der n Positionen nach diesem im Alphabet erscheint. Wenn man w¨ahrend der Verschiebung
bei ’Z’ ankommt, wird an Position ’A’ fortgefahren.
Denken Sie bei Ihren Funktionen an Signaturen und Spezifikationen!

 """

#input: string, ohne sonderzeichen, nur uppercase wie auf dem Übungszettel angegeben, n = Verschlüsselungskey
#output verschlüsselter string
#Funktion nutzt caesar verschlüsselung um den gegebenen String zu verschlüsseln
punctuation_lst = [ord(','), ord('.'), ord('!'), ord('?'), ord(' ')]

def encrypt(text, n):
    text = text.upper()
    caesar_text = ''
    #loop over the text and shift the letters by n
    for char in text:
        #just add the punctuation marks to the text
        if ord(char) in punctuation_lst:
            caesar_text += char
            continue
        caesar = ord(char)+ n
        if caesar > 90:
            #if the letter is shifted beyond Z, start at A again
            caesar -= 26
        caesar_text += chr(caesar)
    return caesar_text
    
#input: verschlüsselter string, n = Versclüsselungskey
#output: entschlüsselter string
#Funktion bekommt mit caesar verschlüsslung dekodierten text und gibt den originaltext zurück
def decrypt(caesar_text, n):
    caesar_text = caesar_text.upper() #bei meinen eingaben sowieso aber für andere nutzer
    text = ''
    #loop over the text and shift the letters back by n
    for char in caesar_text:
        #just add the punctuation marks to the text
        if ord(char) in punctuation_lst:
            text += char
            continue
        caesar = ord(char)- n
        if caesar < 65:
            #if the letter is shifted beyond A, start at Z again
            caesar += 26
        text += chr(caesar)
    return text

#print(decrypt(encrypt("Hallo Welt!")))
    
#Program flow
print("Hi, welcome to our caesar encryption program!")
request = input("Would you like to encrypt or decrypt a message? Please type 'encrypt' or 'decrypt': ")
if request == "encrypt":
    text = input("Please enter your text\n Please only enter alphabetical characters or punctuation marks.")
    shift = int(input("Please enter the shift value."))
    print("The encrypted text is:", encrypt(text, shift))
elif request == 'decrypt':
    caesar_text = input("Please enter the encrypted text. Please only enter alphabetical characters or punctuation marks.")
    shift = int(input("Please enter the shift value."))
    print("The decrypted text is:", decrypt(caesar_text, shift))
else:  
    print("Invalid input. Please try again.")