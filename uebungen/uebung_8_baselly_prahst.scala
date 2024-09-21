/**
  * Aufgabe 1 Objektorientierte Programmierung
  */

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