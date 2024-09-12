//Höhere Funktionen in Scala: Nachbesprechung Übung 5
/**
val a = List(1,2,3,4,5,6)
println(a.map((i:Int) => if(i%2 == 0) i/2 else i*2))

def firstTwo(lst:List[List[A]]):List[List[A]]= if lst.exists()
    //Rekursionsanker
    

//Im tutorium sollen wir Typklassen üben
enum Form:
    case Rechteck(laenge:Double, hoehe:Double)
    case Kreise(radius:Double)

def flaeche(s:Form):Double = 
    import Form.*
    s match
        case Rechteck(a,b) => a * b
        case Kreise(r) => math.Pi * r * r

def myZipWith[A](l1:List[A], l2:List[A], f: A => A):List[A]=
    (l1, l2) match
        case (Nil,_) => Nil
        case (_,Nil) => Nil
        case (x::xs, y::ys) => f(x,y) :: myZipWith(xs,ys, f)
*/


//Aufgabe 1 Listen von Listen und Rekursion
def oneElemList[A](lst:List[List[A]]): Boolean =
    lst.exists(sublist => sublist.length == 1)

def get2Elems[A](l:List[A]):List[A]=
    l match
        case Nil => Nil
        case x::y::xs =>List(x,y)
        case x::xs => List(x)

//rekursive implementierung
def firstTwoR[A](l:List[List[A]]):List[List[A]]=
    l match
        case Nil => Nil
        case x::xs => get2Elems(x)::firstTwoR(xs)

//endrekursive version
def firstTwoER[A](l:List[List[A]]):List[List[A]]=
    def help(l:List[List[A]], acc:List[List[A]]):List[List[A]]=
        l match
            case Nil => acc
            case x::xs => help(xs, acc:::List(get2Elems(x)))
    help(l,Nil)

//mit Funktion hoeherer Ordnung: man koennte auch fold verwenden, aber ir nutzen map
def firstTwo2[A](l:List[List[A]]):List[List[A]]= l.map(get2Elems)
//Version 2
def firstTwo3[A](l:List[List[A]]):List[List[A]]= l.map(_.take(2))
