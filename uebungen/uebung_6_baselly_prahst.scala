// Aufgabe 1

enum Link: 
    case G,S,P
enum Chain: 
    case Empty
    case Join(left:Chain, l:Link, right:Chain)

import Chain.*, Link.* 

// a)
/* 
Vor:    keine
Eff:    keiner
Erg:    gibt eine Liste aller Links der Chain von links nach rechts aus
 */
def list(chain:Chain):List[Link]=
    // import Chain.*, Link.*
    chain match
        case Empty => Nil
        // konkateniert alle Links von der Mitte nach Außen
        case Join(left,x,right) => list(left):::List(x):::list(right)


// b)
/* 
Vor:    keine
Eff:    keiner
Erg:    gibt den Preis des gegebenen Links aus
 */
def kosten(l:Link):Int=
    // import Link.*
    l match
        case G => 2328
        case S => 28
        case P => 901

// (i)
/* 
Vor:    keine
Eff:    keiner
Erg:    gibt den Preis für alle Links der Chain summiert aus
 */
def price1(chain:Chain):Int=
    // import Chain.*, Link.*
    chain match
        case Empty => 0
        // summiert Preise von der Mitte nach Außen
        case Join(left,x,right) => price1(left) + kosten(x) + price1(right)
    
// (ii)
/* 
Vor:    keine
Eff:    keiner
Erg:    gibt den Preis für alle Links der Chain summiert aus
 */
def price2(chain:Chain):Int=
    // import Chain.*, Link.*
    list(chain:Chain).foldRight(0)((a:Link,b:Int) => kosten(a)+b)


// c)
/* 
Vor:    keine
Eff:    keiner
Erg:    gibt aus, ob Link in Chain enthalten ist
 */
def containsLink(l:Link, c:Chain):Boolean=
    list(c).contains(l)

/* 
Vor:    keine
Eff:    keiner
Erg:    Tupel der Chains, die am ersten Vorkommen des gegebenen Links getrennt wurden
 */
def firstSplit(l:Link, c:Chain):(Chain,Chain)=
    c match
        // bei leerer Kette wird ein leeres Tupel ausgegeben
        case Empty => (Empty,Empty)
        // wenn der angeschaute Link, dem gesuchten entspricht, trenne die Chains dort
        case Join(ch1,x,ch) if (x==l) => (ch1, ch)
        // wenn der gesuchte Link in der linken Chain ist, durchsuche firstLink(l,ch1) sowohl im ersten Teil des
        // Tupels als auch im zweiten Teil
        case Join(ch1,x,ch) if (containsLink(l,ch1)) => (firstSplit(l,ch1)(0), Join(firstSplit(l,ch1)(1),x,ch))
        // wenn der gesuchte Link in der rechten Chain ist, durchsuche firstLink(l,ch) sowohl wie zuvor bei ch1,
        // allerdings muss hier der Index herumgedreht werden, damit das erste Vorkommen gefunden wird und nicht
        // das letzte
        case Join(ch1,x,ch) if (containsLink(l,ch)) => (Join(ch1,x,(firstSplit(l,ch))(1)), firstSplit(l,ch)(0))
        // wenn der gesuchte Link weder rechts, noch links, noch in der Mitte ist, enthält die Chain diesen Link 
        // nicht
        case _ => firstSplit(l, Empty)
    
// zum Testen:
def testU6=
    val chain1:Chain = Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty))
    println("Testchain:\n" + chain1)
    println("Funktion list:\n" + list(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty))))
    println("Funktion price ohne fold:\n" + price1(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty))))
    println("Funktion price mit fold:\n" + price2(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty))))
    println("Funktion: firstSplit mit G:\n" + firstSplit(G,(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty)))))
    println("Funktion: firstSplit mit S:\n" + firstSplit(S,(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty)))))
    println("Funktion: firstSplit mit P:\n" + firstSplit(P,(Join(Join(Empty,G,Join(Empty,G,Empty)),S,Join(Join(Empty,P,Empty),P,Empty)))))
