/**
 * Passen Sie den Trait und die Spezifikation von PrioQueue an,
 *  sodass Schlüssel-Werte Paaren anstatt nur der der Schlüssel betrachet wird
*/

// ADT PrioQueue
import scala.reflect.ClassTag

trait PrioQueue[K:Ordering, A:Ordering]:
    //In einer Prioritätswarteschlage werden Elemente aus einem total geordnetem Universum gespeichert

    //Vor: keine
    //Eff: Das Element key mit Wert ist zur Prioritätswarteschlange hinzugefügt
    //Erg: kein
    def insert(key:K, value:A):Unit

    //Vor: Die Prioritätswarteschlange ist nicht leer
    //Eff: Das kleinste Element nach Ordering von A ist aus Prioritätswarteschlange entfernt
    //Erg: Das kleinste Element nach value ist geliefert
    def extractMin():(K,A)

    //Vor: keine
    //Eff: keiner
    //Erg: true ist geliefert, genau dann, wenn die Prioritätswarteschlange leer ist
    def isEmpty: Boolean

/**
 * Passen Sie die Implementierung von Binary Heap so an,dass der neue Trait implementiert wird
*/
/*
class BinaryHeap[K:Ordering:ClassTag, A: Ordering:ClassTag](capacity:Int) extends PrioQueue[K,A]:
    private val ord = summon[Ordering[A]]
    import ord.mkOrderingOps

    private val array:Array[A] = new Array[A](if capacity < 1 then 1 else capacity)
    private var last:Int = -1

    private def parent(i:Int):Int = (i-1)/2
    private def left(i:Int):Int = 2*i + 1
    private def right(i:Int):Int = 2*i +2

    private def swap(i:Int, j:Int):Unit =
        val tmp:A = array(i)
        array(i) = array(j)
        array(j) = tmp

    def isEmpty: Boolean = last == -1


    private def bubbleUp(i:Int) : Unit =
        if array(parent(i)) > array(i) then //parent(0)=0
            swap(i,parent(i))
            bubbleUp(parent(i))

    def insert(key: K, value: A): Unit = 
        if last == array.size-1 then throw new Exception("Heap is full")
        last = last + 1
        array(last) = value
        bubbleUp(last)

    private def bubbleDown(i:Int):Unit = 
        // && ist lazy, daher wird der Vergleich der Werte nur ausgeführt, wenn das Kind existiert
        // Wenn eines der existierenden Kinder kleiner ist als der aktuelle Wert, wird rekursiv weiter gegangen
        if left(i) <= last && array(left(i))< array(i) || right(i) <= last && array(right(i))<array(i) then
            // Wenn das rechte Kind existiert und ein Minimum ist, wird rekursiv mit diesem weitegemacht.
            // Ansonsten existiert wegen der if Bedingung das linke Kind und es ist kleiner als das aktuelle Element
            val child : Int = if right(i) <= last && array(right(i)) < array(left(i)) then right(i) else left(i)
            swap(i,child)
            bubbleDown(child)

    def extractMin():(K,A) = 
        if isEmpty then throw new Exception("Empty Heap")
        val result:(K,A) = array(0)
        array(0)= null.asInstanceOf[(K,A)]
        swap(0,last)
        last =  last - 1
        bubbleDown(0)
        result

    override def toString(): String = array.mkString("(",", ", ")")*/


//löschungsbesprechung: anstatt string boolean für vip true false
//man kann auch im vip stack 2 stacks machen und dann 2 push/pop für die jeweiligen stacks definierenen
trait TutoriumStack[A, String]:
    //Objekte eines belibig aber festen Typs A sowie deren Prioritätsstatus sind gespeichert

    //Vor: Keine
    //Erg: Keins
    //Eff: x ist nun das oberste Element auf dem Stack, wir wissen durch B welche Elemete Priorität haben
    def push(x:(A,String)):Unit

    //Vor: Der Stack ist nicht leer
    //Erg: Das oberste Element bzw. das oberste Prioritätselement des Stacks ist geliefert
    //Eff: Das oberste ELement bzw. das oberste Prioritätselement ist von Stack entfernt
    def pop():(A, String)

    // Vor: Keine
    // Erg: true ist geliefert, genau dann wenn der Stack leer ist
    // Eff: keiner
    def isEmpty: Boolean

    // Vor: keine
    // Erg: Die Anzahl der Elemente auf dem Stack ist geliefert
    // Eff: keiner
    def size: Int

class VipStack[A, String](capacity:Int) extends TutoriumStack[A,String]:
    private val stack:Array[(A, String)] = new Array[(A,String)](if capacity < 1 then 1 else capacity)
    private var last:Int = -1
    private  var last_priority:Int = -1

    def isEmpty: Boolean = last == -1

    def push(x:(A,String)):Unit = 
        if last == stack.size-1 then throw new Exception("Stack is full")
        last = last + 1
        if x._2 == "VIP" then last_priority = last
        stack(last) = x

    def pop():(A,String) = 
        if isEmpty then throw new Exception("Empty Stack")
        if last_priority == -1 then
            val result:(A,String) = stack(last)
            stack(last)= null.asInstanceOf[(A,String)]
            last =  last - 1
            return result
        else
            val result:(A,String) = stack(last_priority)
            stack(last_priority)= null.asInstanceOf[(A,String)]
            last =  last - 1
            last_priority = -1
            return result

    def size: Int = last + 1