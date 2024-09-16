//Tutorium Zwischenklausur Besprechung
//crazySum Implementierung
def isEven(x:Int):Boolean = (x%2==0)

//Voraussetzung: Zahl is >= 0, Ergebnis: crazySum wird errechnet, Effekt: keiner
def crazySum1(n:Int):Int=
  n match
    case 0 => 1
    case x if (isEven(x)) => x+(x+1)+crazySum1(n-1)
    case a => a + (a-1) + crazySum1(n-1)

def crazySum2(n:Int):Int =
  def help(element:Int, acc:Int):Int =
    element match
      case 0 => acc+1
      case x if (isEven(x)) => help(element-1,x+(x+1)+acc)
      case a => help(element-1, a+(a-1)+acc)
  help(n,0)
