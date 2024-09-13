// Abgabe 5

// Aufgabe 1
// a)
// Voraussetzungen:    keine
// Effekt:             keiner
// Ergebnis:           Liste aller Elemente der enthaltenen Listen
def flattenA[A](l:List[List[A]]):List[A]=
    l match
        case Nil => Nil
        case x::xs => x:::flattenA(xs)

// b)
// Voraussetzungen:    keine
// Effekt:             keiner
// Ergebnis:           Liste aller Elemente der enthaltenen Listen
def flattenB[A](l:List[List[A]]):List[A]=
    def helpFlattenB[A](list:List[List[A]], acc:List[A]):List[A]=
        list match
            case Nil => Nil:::acc
            case x::xs => helpFlattenB(xs,acc:::x)
    helpFlattenB(l,Nil)

// c)
// Voraussetzungen:    keine
// Effekt:             keiner
// Ergebnis:           Liste aller Elemente der enthaltenen Listen
def flattenC[A](l:List[List[A]]):List[A]=
    l.foldLeft(Nil)(_:::_)

// d)
/* 
flattenC ist endrekursiv, da es eine Linksfaltung ist und somit
(((acc ::: l1) ::: l2) ::: ... ::: ln) 
für acc: neutrales Element und l1,...,ln Listen in Liste 
*/

/*
Aufgabe 3
a) Was tut zipWith?
Signatur: 
  Funktionsname: myZipWith, Input: 2 oder mehr Listen, Output: Eine Liste
Spezifikation:
  Voraussetzung: 
    1. DT beliebig, aber sollten kombinierbar sein. Idealerweise selber DT
       z.B. Char + Int = Int etc
    2. Funktion muss selben DT wie Listenelemente der Eingabe akzeptieren
       und ausgeben
  Effekt: Keiner, da Listen in  Scala Immutable sind
  Ergebnis: Kombiniert oder 'zippt' die Funktionswerte aus unterschiedlichen Quellen (hier Listen)
  indem sie diese mit einer Funktion kombiniert -> returned eine Liste

b) Implementierung
*/
def myZipWith[A](f:(A,A)=>A, l1:List[A], l2:List[A]):List[A]=
    def helpZip[A](f:(A,A)=>A, l1:List[A], l2:List[A], acc:List[A]):List[A]=
        (l1, l2) match
            case (Nil, l2) => acc
            case (l1, Nil) => acc
            case (x::xs, y::ys) => helpZip(f,xs,ys,acc:::List(f(x,y)))
    helpZip(f,l1,l2,Nil)


//Aufgabe 4a

//reverse mittels Linksfaltung
//Signatur: List[A] -> List[A]
//Voraussetzung: keine
//Ergebnis: Liste in umgekehrter Reihenfolge
def myReverse[A](l: List[A]): List[A] = l.foldRight(Nil: List[A])((x, acc) => acc :+ x)

//Aufgabe 4b
//Signatur: List[Char] -> List[Char]
//Voraussetzung: Input sollte Liste von Strings sein
//Ergebnis: alle uppercase Chars wurden entfernt
def withoutUpper(l: List[Char]):List[Char] = l.foldRight(Nil: List[Char])((x, acc) => if x.isUpper then acc else x :: acc)


//Aufgabe 4c

def quersumme(zahl:Int):Int =
    zahl match
    case 0 => 0
    case _ => zahl%10 + quersumme(zahl/10)

//Signatur: List[Int], Int -> List[Int]
//Voraussetzung: nichtnegative Ints als Input
//Ergebnis: Liste alle Zahlen dessen Quersumme größer als der Parameter v ist
def querV(l:List[Int],v:Int):List[Int] =
  l match
    case Nil => Nil
    case x::xs if quersumme(x) > v => x::querV(xs,v)
    case x::xs => querV(xs,v)