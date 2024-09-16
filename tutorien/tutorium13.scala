import scala.compiletime.ops.double
/**
 * Tutorium 13
 * Aufgabe : Korrektheit von eigenen Funktionen beweisen
 * a) Bestimmen des Duchschnitts einer Liste
*/
def durchschnitt(lst:List[Int]):Int =
    val sum = lst.foldRight(0)(_ + _)
    val len = lst.length
    return sum/ len

def ifExample():Unit=
    var i: Int = 0
    i = i+1
    println(i)

def whileExample(): Unit = 
    var i:Int = 1
    while (i<= 10) do
        println(i)
        i = i + 1

//alternative: Do-While loop, beingung wird am Ende der Schleife überprüft
//dowhile(1) => 1 2 4 8, doWhile(20) => 20	
def doWhile(i:Int):Unit = 
    var num = i
    while
        println(num)
        num = num*2
        num < 10
    do()

//for loop
//Iterieren über Zahlenbeeiche, end of rangeist in Scala inklusive!!
//Weitere Varianten in der Scala Dokumentation

def forExample(list:List[Int]): Unit =
    for x <- list do
        println(x)
    println("For Range")
    for x <- 1 to 10 do
        println(x)


def arrayExample():Unit=
    var array:Array[Int] = Array[Int](1,2,3,4,5)
    for i <- 0 to array.length-1 do
        println(array(i))
    
    //schöner
    for x <- array do
        println(x)
    
    //schreiben
    val array2 = new Array[Int](4)
    var i = 0
    for a <- 2 to 5 do
        array(i) = a
        i = i +1
    for x <- array2 do
        println(x)
//Vorraussetzung: n >= 1
//Effekt: Keiner
//ergebnis:: ein Array von Arrays mit n Zeilen und n Spalten bei den an Index (i-1)(j-1) das Produkt i*j steht
def multTable(n:Int):Array[Array[Int]] =
    var table: Array[Array[Int]] = new Array[Array[Int]](n)
    for i <- 0 to table.length-1 do
        table(i) = new Array[Int](n)
    for i <- 0 to n-1 do
        for j <- 0 to n-1 do
            table(i)(j) = (i+1)*(j+1)
    table

