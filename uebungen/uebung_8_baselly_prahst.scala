/**
  * Aufgabe 1 Objektorientierte Programmierung
Definieren Sie eine Klasse Geom3D und eine Hierarchie, in der als Unterklassen 
von Geom3D geeignete Klassen Wuerfel, Quader, Kugel und Tetraeder vorkommen. 
Definieren Sie fu ̈r die einzelnen Klassen sinnvolle Attribute, Konstruktoren 
sowie Methoden volume() und surfaceArea(), die das Volumen bzw. die Oberfla ̈che 
bestimmen.
Schreiben Sie dann ein Programm, das fu ̈r ein Array von verschiedenen solchen 
geometrischen Ko ̈rpern das Gesamtvolumen bzw. die Gesamtoberfla ̈che berechnet.
Mit einer main-Funktion geom3Demo soll das Ganze dann getestet werden. */
//import scala.compiletime.ops.double

trait Geom3D[A]:
    // Geometrische Figur und einige ihrere Parameter sind gespeichert

    // ungefähre Werte von pi, sqr(2) und sqr(3)
    val pi = 3.14159265359
    val sqRootTwo = 1.41421356237
    val sqRootThree = 1.73205080757

    // Vor: die gegebenen Größen müssen nicht-negativ sein
    // Eff: keiner
    // Erg: das Volumen des Körpers ist geliefert
    def volume(): A

    // Vor: die gegebenen Größen müssen nicht-negativ sein
    // Eff: keiner
    // Erg: die Oberfläche des Körpers ist geliefert
    def surfaceArea(): A

class Wuerfel(private val seite:Double) extends Geom3D[Double]:

    def volume(): Double =
        seite*seite*seite
    
    def surfaceArea(): Double =
        seite*seite*6

class Quader(private val s1:Double, private val s2:Double, private val s3:Double) extends Geom3D[Double]:
    
    def volume(): Double =
        s1*s2*s3

    def surfaceArea(): Double =
        s1*s2*2 + s1*s3*2 + s2*s3*2

class Kugel(private val radius:Double) extends Geom3D[Double]:

    def volume(): Double = 
        pi * (4.0/3.0) * (radius*radius*radius)

    def surfaceArea(): Double = 
        pi * 4.0 * (radius*radius)

class Tetraeder(private val seite:Double) extends Geom3D[Double]:

    def volume(): Double = 
        sqRootTwo * (1.0/12.0) * (seite*seite*seite)

    def surfaceArea(): Double = 
        sqRootThree * (seite*seite)


// Vor: keine
// Eff: das Programm wird Schritt für Schritt durchgegangen
// Erg: ein Tupel aus dem angegebenen Körper und dem zugehörigrn 
//      Tupel aus dessen Volumen und dessen Oberflächeninhalt
//      ist geliefert
def koerperGeom3D():(String,(Double,Double)) =
    // User-Abfrage zum Körper
    println("Gib einen geometrischen Körper ein:")
    val koerper: String = scala.io.StdIn.readLine() 

    // setze Volumen und Oberfläche auf 0.0
    var vol: Double = null.asInstanceOf[Double]
    var surf: Double = null.asInstanceOf[Double]

    // if-Abfragen, welcher Körper genannt wurde
    if (koerper.toLowerCase() == "würfel" || koerper.toLowerCase() == "wuerfel") then
        // User-Abfrage zur Seitenlänge
        println("Gib die Seitenlänge des Würfels an:")
        val sl: Double = scala.io.StdIn.readLine().toDouble 

        // erstelle ein Element der Klasse Wuerfel und wende die
        // Funktionen der Klasse darauf an
        val k: Geom3D[Double] = new Wuerfel(sl)
        vol = k.volume()
        surf = k.surfaceArea()

    else if (koerper.toLowerCase() == "quader") then
        // User-Abfrage zu den Seitenlängen
        println("Gib die 3 Seitenlängen des Quaders an:")
        println("1.: ")
        val sl1: Double = scala.io.StdIn.readLine().toDouble 
        println("2.: ")
        val sl2: Double = scala.io.StdIn.readLine().toDouble
        println("3.: ")
        val sl3: Double = scala.io.StdIn.readLine().toDouble

        // erstelle ein Element der Klasse Quader und wende die
        // Funktionen der Klasse darauf an
        val k: Geom3D[Double] = new Quader(sl1,sl2,sl3)
        vol = k.volume()
        surf = k.surfaceArea()

    else if (koerper.toLowerCase() == "kugel") then
        // User-Abfrage zum Radius
        println("Gib den Radius der Kugel an:")
        val rad: Double = scala.io.StdIn.readLine().toDouble 

        // erstelle ein Element der Klasse Kugel und wende die
        // Funktionen der Klasse darauf an
        val k: Geom3D[Double] = new Kugel(rad)
        vol = k.volume()
        surf = k.surfaceArea()

    else if (koerper.toLowerCase() == "tetraeder") then
        // User-Abfrage zur Seitenlänge
        println("Gib die Seitenlänge des Tetraeders an:")
        val sl: Double = scala.io.StdIn.readLine().toDouble 

        // erstelle ein Element der Klasse Tetraeder und wende die
        // Funktionen der Klasse darauf an
        val k: Geom3D[Double] = new Tetraeder(sl)
        vol = k.volume()
        surf = k.surfaceArea()

    // falls anderer Körper oder falsch geschrieben    
    else
        println("Dieser Körper ist nicht implementiert oder falsch geschrieben.")

    (koerper, (vol, surf))
    //println(s"Dein $koerper hat ein Volumen von $vol und eine Oberfläche von $surf.")


// Vor: keine
// Eff: das Programm wird Schritt für Schritt durchgegangen und 
//      koerperGeom3D dabei mehrmals aufgerufen
// Erg: ein Tupel aus der Summe aller Volumina und der Summe aller Oberflächeninhalte
//      der eingegebenen Körper ist geliefert
def programmGeom3D:(Double,Double) =
    var list: List[(String,(Double,Double))] = Nil
    var goOn: Boolean = true
    while goOn do
        val add: (String,(Double,Double)) = koerperGeom3D()
        list = add :: list
        // println("List: " + list)
        println("Möchtest du noch einen Körper hinzufügen? (Ja / Nein)")
        var more: String = scala.io.StdIn.readLine().toLowerCase()
        if (more == "nein") then
            goOn = false
    val array: Array[(Double,Double)] = new Array(list.length)
    for i <- 0 to list.length-1 do
        array(i) = (list(i)(1)(0),list(i)(1)(1))
    var res1 = 0.0
    var res2 = 0.0
    for elem <- array do
        res1 = res1 + elem(0)
        res2 = res2 + elem(1)
    (res1, res2)
    // println(s"Das Volumen aller Körper ist: $res1,\n die Oberfläche aller Körper ist $res2")

@main
// Vor: keine
// Eff: keiner
// Erg: das Ergebnis aus programmGeom3D wird im Terminal ausgegeben
def geom3Demo = 
    val result = programmGeom3D
    println(s"Das Volumen aller Körper ist: " + result(0) + ",\n die Oberfläche aller Körper ist: " + result(1))


/**
  * Aufgabe 3 Abstrakte Datentypen II
  * Ein Dequeue (double ended queue) ist eine Mischung aus einem Stack und einer
  * Queue. Hier können Elemente jeweils vorne und hinten angehängt werden können.
  * Die Operationen heißen addFront, addBack, removeFront und removeBack zusätzlich zur isEmpty Funktion
  * a) Spezifikationen
  * b) Beschreibung der Implementierung
  * Zuerst müssen wir eine private class von Nodes erzeugen, 
  * die Infomationen über das gespeicherte item und den 'pointer' zur nächsten, 
  * sowie zu einen zu vorherigen Node enthält, -> Liste ist doppelt verlinkt um zugriff auf letzten Knoten effizienter zu machen
  * Insbesondere müssen wir den Verwaltungskopf implementieren, 
  * der die Anzahl der Elemente enthält und einen Pointer zum ersten und einen zum letzten Element speichert.
  * Implementierte Methoden triviale isEmpty Funktion 
  * addBack(x) sollte enqueue(x) entsprechen. ähnliches gilt für:
    removeFront() ~ dequeue
    addFront(x) ~ push(x), removeBack ~ pop()
  * c) Implementierung
  */

import scala.reflect.ClassTag

trait MyDeQueue[A]:
    //Objekte eines beliebig aber festen Typs A sind gespeichert

    //Vor: Keine
    //Erg: Keins
    //Effekt: x ist nun das letzte Element in der DeQueue
    def addBack(x: A) : Unit

    //Vor: Die DeQueue ist nicht leer
    //Erg: Das letzte Element der DeQueue ist geliefert
    //Eff: Das letzte Element aus der DeQueue entfernt
    def removeBack(): A

    //Vor: Keine
    //Erg: Keins
    //Eff: x ist nun das erste Element in der Dequeue
    def addFront(x:A):Unit

    //Vor: Die DeQueue ist nicht leer
    //Erg: Das erste Element der DeQueue ist geliefert
    //Eff: Das erste ELement is aus der DeQueue entfernt
    def removeFront():A

    //Vor: Keine
    //Erg: Es ist true geliefert, genau dann wenn die DeQueue leer ist
    //Eff: Keiner 
    def isEmpty : Boolean

    //Vor: Keine
    //Erg: Die Anzahl der Elemente in der DeQueue ist geliefert
    //Eff: Keiner
    def size : Int

class LinkedNodeDeQueue[A] extends MyDeQueue[A]:
    //Node Definition als double linked
    private class Node(val item: A, var prev: Node, var next: Node)

    //Verwaltungskopf
    private var _size: Int = 0
    private var frontNode: Node = null
    private var backNode: Node = null

    //Hilfs Memberfunktionen
    def isEmpty: Boolean = frontNode == null
    def size: Int = _size

    //adapted dequeue
    //added additional case for one elem Lists
    def removeFront(): A =
        if isEmpty then throw new Exception("DeQueue cannot be empty!")
        else
            val n: Node = frontNode
            if frontNode == backNode then
                frontNode = null
                backNode = null
            else
                frontNode = frontNode.next
                frontNode.prev = null
            _size -= 1
            return n.item

    //adapted pop
    //added additional case for one elem List
    def removeBack(): A =
        if isEmpty then throw new Exception("DeQueue cannot be empty!")
        else
            val n: Node = backNode
            if frontNode == backNode then
                frontNode = null
                backNode = null
            else
                backNode = backNode.prev
                backNode.next = null
            _size -= 1
            return n.item
            
    //adapted enqueue
    def addBack(x: A): Unit =
        var n = new Node(x, backNode, null)
        if !isEmpty then
            backNode.next = n
        else
            frontNode = n
        backNode = n
        _size += 1

    //adapted push(x)
    def addFront(x: A): Unit =
        var n = new Node(x, null, frontNode)
        if !isEmpty then
            frontNode.prev = n
        else
            backNode = n
        frontNode = n
        _size += 1

    //override REPL thing for readable output
    override def toString(): String = 
        var s : String  = "top<"
        var n : Node = frontNode
        var m : Node = backNode
        while n != null do
            s += " |" + n.item
            n=n.next
        s+="<bottom"
        s+= " head: " + (if frontNode != null then frontNode.item else "null")
        s+= " tail: " + (if backNode != null then backNode.item else "null")
        s