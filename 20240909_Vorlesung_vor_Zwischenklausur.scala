// Zwischenklausur:

// - Endrekursion und Listen für Scala letztes Thema, das rein kommt
// - es kommen sowohl Scala als auch Python ran
// - in jeder Aufgabe wird in irgendeiner Weise Code vorkommen

// Wiederholung:
// - Einführung Scala & fkt. Programmierung
//     - primitive Datentypen
//     - Tupel
//     - Strings
//     - Methoden / Funktionen
//     - if ... then ... else
//     - match-Konstruktion
// - Endrekursion:
//     - benutzen Hilfsfunktion
//     - benutzen Akkumulator (transportiert Ergebnis / Zwischenschritte)

// ----------------------------------------------------------------------
// Vorlesung 1

// def quickfib(n:Int):Int=
//     def help(a:Int,b:Int,m:Int)=
//         m match
//             case 0 => b
//             case _ => help(a+b,a,n-1)   // "(i+1, i,n-1)"
//     help(1,0,n) // "1,0" Akkumulator


// Endrekursion hat zwei Vorteile:
//     1.  Werte werden nicht mehrfach berechnet
//     2.  Ergebnis der Rekursion nicht weiter für Berechnung gebraucht
//         wird, also um vorherige Schritte auszuwerten

// Definition:
//     Eine rekursive Funktion, deren letzter Schritt zur Berechnung der
//     rekursive Aufruf selbst ist, nennt man endrekursive Funktion.

// Fakultätsfunktion:

def myFacult(n:Int):Int=
    def facultHelp(res:Int,m:Int):Int=
        m match
            case 0 => res
            case x => facultHelp(x*res,m-1)     // Akkumulator
    facultHelp(1,n)


// Gausssumme

// meine:
def gauss(n:Int):Int=
    def gaussHelp(res:Int,m:Int):Int=
        m match
            case 1 => res
            case i => gaussHelp(res+i,m-1)
    gaussHelp(1,n)
        
// in VL:
def gauss2(n:Int):Int=
    def gaussHelp(res:Int,m:Int):Int=
        if (m==0) then
            res
        else
            gaussHelp(res+m,m-1)
    gaussHelp(0,n)

// -   Scala erkennt endrekursive Funktionen und wandelt diese intern,
//     beim Kompilieren, in Schleifen um 
// =>  Lesbarkeit der Rekursion 
//     vs.
//     Performance / Stackvorteil von Schleifen

// ----------------------------------------------------------------------

// Listen in Scala

// Unterschiede zwischen Python und Scala:
//     Python
//         -   veränderbar -> Elemente können geändert werden
//         -   Liste kann Elemente verschiedener Typen enthalten
//         -   Zugriff auf ein beliebiges Element list[i] geht in O(1)
//             (jedes Element hat seinen Platz im Speicher reserviert, kann
//             mit minimalen Operationen gefunden werden)

//     Scala
//         -   nicht veränderbar -> Elemente können nicht geändert werden
//         -   alle Elemente haben den gleichen beim Kompilieren bekannten Typ
//         -   Zugriff auf i-tes Element list(i) in O(i)
//             (jedes Element hat einen Pointer auf den Nachfolger)

// -   Listen sind in Scala rekursiv definiert
//     -   Rekursionsanker ist die leere Liste Nil
//     -   sonst Element x vor eine Liste xs gesetzt
//         (vor eine Liste setzen: Cons-Operator ::)

def makeList(n:Int):List[Int]=
    def helpList(y:Int,ys:List[Int]):List[Int]=
        y match
            case 1 => y::ys
            case x => helpList(x-1,x::ys)
    helpList(n,Nil)

// -   können Listen auf zwei Arten erzeugen:
//     (i)     val list1:List[Int] = 1::2::3::4::Nil
//     (ii)    val list2:List[Int] = List(1,2,3,4)     // Constructor Methode

// -   grundlegende Funktionen für Listen (<listenname>.<funktion>)
//     -   head                ->  erstes Element der Liste
//     -   tail                ->  Liste ohne das erste Element
//     -   length              ->  Länge der Liste
//     -   isEmpty             ->  prüft, ob Liste leer ist 
//     -   contains(x)         ->  prüft, ob x in der Liste enthalten ist 
//     -   min / max           ->  gibt Minimum / Maximum der Liste zurück
//     -   reverse             ->  gibt neue Liste mit Elementen in umgekehrter
//                                 Reihenfolge zurück
//     -   take(n) / drop(n)   ->  gibt Liste der ersten n Elemente bzw. ohne
//                                 erste n Elemente zurück 
//     -   :::                 ->  konkateniert zwei Listen
//     -   zip                 -> Übung
//     -   splitAt             -> Übung


// -   eigene Listenfunktionen:
//     -   Listen lassen sich gut mit Rekursion und Pattern Matching behandeln
//     -   Pattern Matching geht auf Nil, Listen mit fester Größe (List(x,y))
//         und allgemeine Listen x::xs

def myHeadInt(l:List[Int]):Int=
    l match
        case Nil => throw Exception("Leere Liste")
        case x::xs => x

def myReverse(l:List[Int]):List[Int]=
    l match
        case Nil => Nil
        case x::xs => myReverse(xs):::List(x)   // Konkatenation ist unschön implementiert
                                                // daher ungünstig

def myReverseTail(l:List[Int]):List[Int]=
    def reverseHelp(lAcc:List[Int],list:List[Int]):List[Int]=
        list match
            case Nil => lAcc
            case x::xs => reverseHelp(x::lAcc,xs)
    reverseHelp(Nil,l)
    

// bis hier relevant für Zwischenklausur
// ----------------------------------------------------------------------
// Vorlesung 2

// Problem:    wollen Funktionen für allgemeinere Listen, also nicht nur 
//             Int, String etc.
//             =>  Polymorphie
// -   eine polymorphe Funktion hat einen Typparameter, welcher für jeden 
//     festen Typen stehen kann.

def myHead[A](l:List[A]):A=
    l match
        case Nil => throw Exception("leere Liste")
        case x::xs => x

def myMin(l:List[Int]):Int=
    l match
        case Nil => throw Exception("leere Liste")
        case x::Nil => x        // case List(x) => x
        case x::xs => x min (myMin(xs))

def myMinTail(l:List[Int]):Int=
    def minHelp(mini:Int, lh:List[Int]):Int=
        lh match
            case Nil => mini
            case x::xs => minHelp((x min mini), xs)
    l match
        case Nil => throw Exception("kein Element")
        case x::xs => minHelp(x,xs)
    
// -   intern werden Listen speichereffizient implementiert, bei
//     Funktionen wie:
//         val l1 = List(1,2,3)
//         val l2 = 4::l1
//     Dann werden Elemente von l1 nicht kopiert, sondern weiter
//     verwendet

// ----------------------------------------------------------------------
// Sortieralgorithmen in Scala

// Selectionsort

def remove(l:List[Int],k:Int):List[Int]=
    l match
        case Nil => Nil
        case x::xs if x==k => xs
        case x::xs => x::remove(xs,k) 

def selectionSort(l:List[Int]):List[Int]=
    l match
        case Nil => Nil
        case x::xs =>
            val m = l.min
            val ys = remove(x::xs,m)
            m::(selectionSort(ys))

// Insertionsort

def insert(l:List[Int],k:Int):List[Int]=
    l match
        case Nil => k::Nil      // List(k)
        case x::xs if (k<x) => k::x::xs
        case x::xs => x::insert(xs,k)

def insertSort(l:List[Int]):List[Int]=
    l match
        case Nil => Nil
        case x::xs => 
            insert(insertSort(xs),x)
    
// Mergesort

def merge(l1:List[Int],l2:List[Int]):List[Int]=
    (l1, l2) match
        case (Nil, l2) => l2
        case (l1, Nil) => l1
        case (x::xs, y::ys) if (x<=y) => x::merge(xs,y::ys)
        case (x::xs, y::ys) => y::merge(x::xs,ys)

def mergeSort(l:List[Int]):List[Int]=
    l match
        case Nil => Nil
        case x::Nil => x::Nil
        case _ => 
            val (left, right) = l.splitAt((l.length)/2)
            merge((mergeSort(left)),(mergeSort(right)))
    

// Randnotiz:   Ein Sortieralgorithmus ist stabil, wenn
//              bei gleichen Werten die Reihenfolge dieser in
//              Eingabe- und Ausgabeliste die gleiche ist
//              (s. Tafelbild)
    
// Evaluationsstrategien anschauen


    