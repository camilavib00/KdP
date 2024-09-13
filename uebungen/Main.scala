/*
Aufgabe 3
a) Was tut zipWith?
Signatur: 
  Funktionsname: myZipWith, Input: 2 oder mehr Listen, Output: Eine Liste
Spezifikation:
  Voraussetzung: 
    1.DT beliebig, aber sollten kombinierbar sein. Idealerweise selber DT
      z.B. Char + Int = Int etc
    2. Listen müssen in dieser implementierung gleich lang sein
  Effekt: Keiner, da Listen in  Scala Immutable sind
  Ergebnis: Kombiniert oder 'zippt' die Funktionswerte aus unterschiedlichen Quellen (hier Listen)
  indem sie diese mit einer Funktion kombiniert -> returned eine Liste

b) Implementierung
def myZipWith[A](list1: List[A], list2: List[A])(f: (A, A) => A): List[A] =
  list1.foldRight((list2, Nil: List[A])) case (a, (remaining, acc)) =>
    remaining match
      case Nil => acc
      case x::xs => f(a, x) :: myZipWith(Nil, xs)(f)

//???????????

def myZipWith[A](list1: List[A], list2: List[A])(f: (A, A) => A): List[A] =
  list1.foldRight((list2, Nil: List[A]))()
*/
/* //Aufgabe 4a

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
*/