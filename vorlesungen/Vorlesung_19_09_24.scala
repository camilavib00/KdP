// Beispiele zu Traits

trait WorkingPerson2:
    def work():Unit
    def salary : Int

trait LearningPerson2:
    def learn(topic:String):Unit

class Person2(private val name:String, private var age:Int):
    def isGrownUp:Boolean = age >= 18
    override def toString() = name

class Studi2(name:String, age:Int, mat:Int) extends Person2(name, age), LearningPerson2:
    def matrNr:Int = mat
    def learn(topic: String): Unit = println("I learn about " + topic)

class DozentIn2(name:String, age:Int, sal:Int) extends Person2(name, age), LearningPerson2, WorkingPerson2:
    def salary:Int = sal
    def work(): Unit = println("Prepare Lecture")
    def learn(topic: String): Unit = println("I research about "+ topic)

//Typparameter
class Box[A]:
    private var elements: List[A] = Nil

    def add(elem: A): Unit =
        elements = elem :: elements
    def get():A=
        val rand = new scala.util.Random
        val i:Int = rand.nextInt(elements.size)
        val elem = elements(i)
        elements=elements.take(i) ::: elements.drop(i+1)
        return elem

// ADT Stack - Trait und Implementierung mit verketteten Knoten

trait MyStack[A]:
    //Objekte eines belibig aber festen Typs A sind gespeichert

    //Vor: Keine
    //Erg: Keins
    //Eff: x ist nun das oberste Element auf dem Stack
    def push(x:A):Unit

    //Vor: Der Stack ist nicht leer
    //Erg: Das oberste Element des Stacks ist geliefert
    //Eff: Das oberste ELement ist von Stack entfernt
    def pop():A

    // Vor: Keine
    // Erg: true ist geliefert, genau dann wenn der Stack leer ist
    // Eff: keiner
    def isEmpty: Boolean

    // Vor: keine
    // Erg: Die Anzahl der Elemente auf dem Stack ist geliefert
    // Eff: keiner
    def size: Int


class LinkedNodeStack[A] extends MyStack[A]:

    private class Node(val item:A, val next:Node)

    private var _size : Int = 0
    private var topNode : Node = null

    def isEmpty: Boolean = size == 0
    def size :Int = _size

    def push(elem:A):Unit=
        val n = new Node(elem, topNode)
        topNode = n
        _size = _size + 1

    def pop():A =
        if isEmpty then throw new Exception("Empty Stack")
        val n : Node = topNode
        topNode = topNode.next
        _size = _size -1
        n.item

    override def toString(): String = 
        var s : String  = "top<"
        var n : Node = topNode
        while n != null do
            s += " |" + n.item
            n=n.next
        s+="<bottom"
        s

import scala.reflect.ClassTag

class ArrayStack[A: ClassTag](private val capacity:Int) extends MyStack[A]:
    private var array: Array[A] = new Array[A](if capacity < 1 then 1 else capacity)
    private var _size : Int = 0

    def isEmpty: Boolean = _size == 0
    def size: Int = _size

    def pop(): A =
        if isEmpty then throw new Exception("Empty Stack")
        val result = array(_size-1)
        array(_size-1) = null.asInstanceOf[A]
        _size -= _size
        result

    def push(x: A): Unit =
        if _size == array.length then throw new Exception("Stack is full")
        array(_size) = x
        _size += 1

class DynArrayStack[A:ClassTag] extends MyStack[A]:
    private var array : Array[A] = new Array[A](1)
    private var _size = 0

    def isEmpty : Boolean = _size == 0
    def size:Int = _size

    private def resize():Unit = 
        if _size < array.length/4 || _size >= array.length then
            val newCapacity:Int = if _size < array.length/4 
                                    then array.length/2 else
                                    2*array.length
            var newA : Array[A] = new Array[A](newCapacity)
            for i <- 0 to _size -1 do
                newA(i) = array(i)
            array = newA
            

    def pop(): A =
        if isEmpty then throw new Exception("Empty Stack")
        val result:A = array(_size-1)
        array(_size-1) = null.asInstanceOf[A]
        _size -= 1
        resize()
        result


    def push(x:A):Unit = 
        array(_size) = x
        _size += 1
        resize()

    override def toString(): String = 
        var s : String  = "bottom<"
        var i : Int = 0
        while i<= _size-1  do
            s += " |" + array(i)
            i=i+1
        s+="<top"
        s


    
