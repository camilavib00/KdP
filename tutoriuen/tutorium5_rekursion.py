def toBin_while(dez_num):
    bin_num = ""
    while dez_num > 0:
        rest = dez_num % 2
        dez_num = dez_num // 2
        bin_num = str(rest) + bin_num
    return bin_num

def toBin_while_2(dez_num):
    h = 1 
    rest = 0
    while dez_num > 0:
        rest = h * (dez_num % 2) + rest
        dez_num //= 2
        h *= 10
    return rest

print("results from using while-loop: \n")
print(toBin_while(42)) # 101010
print(toBin_while(13)) # 1101
print(toBin_while(255)) # 11111111


def toBin_for(dez_num):
    bin_num = ""
    bin_length = dez_num.bit_length()
    for i in range(bin_length):
        rest = dez_num % 2
        dez_num = dez_num // 2
        bin_num = str(rest) + bin_num
    return bin_num

def toBin_rek(dez_num):
    if dez_num == 0: # rekursionsanker
        return 0
    #rekursionsschritt
    rest = dez_num % 2
    dez_num = dez_num // 2
    return toBin_rek(dez_num)* 10 + rest



def oddSum_for(n):
    sum = 0
    for i in range(1, n+1, 2):
        print(i)
        sum += i
    print("sum:", sum)
    return sum

oddSum_for(8)


def oddSum_while(n):
    counter = 1
    sum = 0
    while counter <= n:
        counter += 2
        sum += counter
    return sum

#oddSum_while(10)

def oddSum_rek(n):
    #rekursionsanker
    if n == 0:
        return 0
    if n == 1:
        return 1
    if n % 2 == 0:
        return oddSum_rek(n-1)
    return n + oddSum_rek(n-2)

""" 
(c) Schreiben Sie eine Funktion plattmachen die aus einer Liste, die Listen enth¨alt,
eine Liste macht, die die Elemente aus den Listen enthält.
 """

def plattmachen_for(multiple_liste):
    complete_list = []
    for liste in multiple_liste:
        complete_list += liste
    return complete_list

def plattmachen_while(multiple_liste):
    complete_list = []
    i = 0
    while i < len(multiple_liste):
        complete_list += multiple_liste[i]
        i += 1
    return complete_list

def plattmachen_rek(multiple_liste):
    if not multiple_liste:     #rekursionsanker
        return []
    return multiple_liste[0] + plattmachen_rek(multiple_liste[1:])     #rekursionsschritt

vokale = ['a','e','i','o','u']
def stimmlos(worte):
    if worte == "":
        return ""
    elif worte[0] in vokale:
        return stimmlos(worte[1:])
    else:
        return worte[0]+ stimmlos(worte[1:])
    

