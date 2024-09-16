def isEmpty(l:List[Any]):Boolean=
    l match
        case Nil => true
        case _ => false


def bubbleSort(xs:List[Int]):List[Int]=
    def help(list:List[Int]):List[Int]=
        list match
            case Nil => list
            case x::Nil => list
            case x::y::xs =>
                if(x>y) then
                    y::help(x::xs)
                else
                    x::help(y::xs)
    def h(list:List[Int], n:Int):List[Int]=
        n match
            case 0 => list
            case _ => h(help(list),n-1)
    h(xs,xs.length)

// Laufzeit bubbeSort = O(n*n)

def sumListER(l:List[Int]):Int=
    def sumHelp(list:List[Int],res:Int):Int=
        list match
            case Nil => res
            case x::xs => sumHelp(xs, res+x)    // Akkumulator (darf nur Funktionsaufruf sein und nicht außen etwas ranaddieren)
    sumHelp(l,0)                                // letzter Schritt: rekursiver Aufruf

def sumList(l:List[Int]):Int=
    l match
        case Nil => 0
        case x::xs => sumList(xs) + x           // letzter Schritt: nicht nur der rekursive Aufruf


def myZip(l1:List[Any],l2:List[Any]):List[(Any,Any)]=
    def helpZip(lAcc:List[(Any,Any)], list1:List[Any], list2:List[Any]):List[(Any,Any)]=
        (list1, list2) match
            case (Nil, ys) => lAcc
            case (xs, Nil) => lAcc
            case (x::xs, y::ys) => helpZip(lAcc:::List((x,y)), xs, ys)
    helpZip(Nil,l1,l2)

// def mySplitAt(l1:List[Any], i:Int):(List[Any],List[Any])=
    