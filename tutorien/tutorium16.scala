/* Aufgabenzettel von gestern: Klammerausdrücke */
/*
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

class DynArrayStack[A:ClassTag] extends MyStack[A]:
    private var array : Array[A] = new Array[A](1)
    private var _size = 0

    def isEmpty : Boolean = _size == 0
    def size:Int = _size
    def top:A = array(_size-1)

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

def Klammern(s:String):Boolean=
    val stack = new DynArrayStack[Char]
    var korrekt = true
    for c <- s do
        if c == '(' then
            stack.push(c)
        else if c == ')' then
            if stack.isEmpty then korrekt = false
            else
                stack.pop()
    return korrekt && stack.isEmpty
            
def alleKlammern(s:String): Boolean = 
    val stack = new DynArrayStack[Char]
    var korrekt = true
    for c <- s do
        if (c == '(') || (c == '{') || (c == '[') then
            stack.push(c)
        else if c == ')' then
            if (stack.isEmpty) || (stack.top != '(') then korrekt = false
            else stack.pop()
        else if c == '}' then
            if (stack.isEmpty) || (stack.top != '{') then korrekt = false
            else stack.pop()
        else if c == ']' then
            if (stack.isEmpty) || (stack.top != '[') then korrekt = false
            else stack.pop()
    return korrekt && stack.isEmpty

*/
/* Abstrakte Datentypen: implementieren Sie die Queue mit einem dynamischen Array */
/*
import scala.reflect.ClassTag
trait MyQueue[A]:
    //Objekte eines beliebig aber festen Typs A sind gespeichert

    //Vor: Keine
    //Erg: Keins
    //Effekt: x ist nun das aktuellste Element in der Queue
    def enqueue(x: A) : Unit

    //Vor: Der Stack ist nicht leer
    //Erg: Das älteste Element der Queue ist geliefert
    //Eff: Das älteste Element aus der Queue entfernt
    def dequeue(): A

    //Vor: Keine
    //Erg: Es ist true geliefert, genau dann wenn die Queue leer ist
    //Eff: Keiner 
    def isEmpty : Boolean

    //Vor: Keine
    //Erg: Die Anzahl der Elemente in der Queue ist geliefert
    //Eff: Keiner
    def size : Int

class DynQueue[T:ClassTag] extends MyQueue[T]:
    private var array: Array[T] = new Array[T](1)
    private var head:Int = 0
    private var tail:Int = 0

    def enqueue(item: T): Unit =
        if (tail == array.length) then
            array = array ++ new Array[T](array.length)
        array(tail) = item
        tail += 1
    
    def dequeue(): T =
        if isEmpty then
            null.asInstanceOf[T]
        else
            val item = array(head)
            head += 1
            CropArray()
            return item
    
    private def CropArray():Unit = 
        if(array.length > 4*(tail-head)) then
            var x = new Array[T](array.length/4)
            for (i <- head to tail) do 
                x(i-head) = array(i)
            array = x
        else
            array= array

*/