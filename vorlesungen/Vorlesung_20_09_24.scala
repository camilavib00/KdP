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


class LinkedNodeQueue[A] extends MyQueue[A]:
    private class Node(val item:A, var next: Node)

    private var _size : Int = 0
    private var frontNode : Node = null
    private var backNode :  Node = null

    def isEmpty: Boolean = frontNode == null
    def size: Int = _size
    def dequeue(): A = 
        if isEmpty then
            throw new Exception("Emtpy Queue") 
        else
            val n : Node = frontNode
            frontNode = frontNode.next
            _size -=1
            n.item

    def enqueue(x: A): Unit =
        val n = new Node(x, null)
        if !isEmpty then
            backNode.next = n
        else
            backNode = n
            frontNode = n
        _size += 1

    override def toString(): String = 
        var s : String  = "front<"
        var n : Node = frontNode
        while n != null do
            s += " |" + n.item
            n=n.next
        s+="<back"
        s

class ArrayQUeue[A:ClassTag](private val capacity:Int) extends MyQueue[A]:

    private val n : Int = if capacity < 1 then 1 else capacity
    private val array:Array[A] = new Array[A](n)
    private var front = 0
    private var back = 0

    def isEmpty: Boolean = front == back

    def size: Int = (back-front+n)%n

    def enqueue(x: A): Unit =
        if size >= n-1 then throw new Exception("Queue full")
        array(back) = x
        back = (back+1) % n

    def dequeue(): A =
        if isEmpty then throw new Exception("Empty Queue")
        val result: A = array(front)
        array(front) = null.asInstanceOf[A]
        front = (front+1) % n
        result

// Immutable Queue
trait ImmutableQueue[A]:
    //Gespeichert werden beliebige Daten von einem festen Typ A
    //Vor: Keine
    //Erg: Die Anzahl der Elemente in der Queue ist geliefert
    //Eff: Keiner
    def size:Int

    //Vor: Keine
    //Erg: Es ist true geliefert, genau dann wenn die Queue leer ist
    //Eff: Keiner 
    def isEmpty:Boolean

    //Vor: keine
    //Erg: eine neue ImmutableQueue mit elem als neustem Element ist geliefert
    def enqueue(elem:A) : ImmutableQueue[A]


    //Vor: Die Queue ist nicht leer
    //Erg: ein Tupel aus dem älesten Element und der Queue ohne das älteste Element ist geliefert
    def dequeue:(A, ImmutableQueue[A])

// Mache den primären Konstruktor private, damit eine leere Queue erstellt werden kann
class FunctionalListQueue[A] private
    (private val input:List[A],
    private val output:List[A])
    extends ImmutableQueue[A]:

    def this() = this(Nil, Nil)

    private def reverse : FunctionalListQueue[A] = 
        if input.isEmpty then FunctionalListQueue[A](input.reverse, Nil) else this

    def size : Int = input.length + output.length
    def isEmpty : Boolean = size == 0 // input.isEmpty && output.isEmpty

    def enqueue(elem:A):FunctionalListQueue[A] = 
        new FunctionalListQueue[A](elem::input, output)

    def dequeue:(A, FunctionalListQueue[A])=
        if isEmpty then throw new Exception("Empty Queue")
        val q = this.reverse
        (q.output.head, new FunctionalListQueue[A](q.input, q.output.tail))


trait PrioQueue[K:Ordering]:
    //In einer Prioritätswarteschlage werden Elemente aus einem total geordnetem Universum gespeichert

    //Vor: keine
    //Eff: Das Element key ist zur Prioritätswarteschlange hinzugefügt
    //Erg: kein
    def insert(key:K):Unit

    //Vor: Die Prioritätswarteschlange ist nicht leer
    //Eff: Das kleinste Element ist aus Prioritätswarteschlange entfernt
    //Erg: Das kleinste Element ist geliefert
    def extractMin():K

    //Vor: keine
    //Eff: keiner
    //Erg: true ist geliefert, genau dann, wenn die Prioritätswarteschlange leer ist
    def isEmpty: Boolean

class SortedNodesPrioQueue[K:Ordering] extends PrioQueue[K]:
    private val ord = summon[Ordering[K]]
    import ord.mkOrderingOps

    private class Node(val item:K, var next:Node)

    private var anchor: Node = Node(null.asInstanceOf[K], null)

    def isEmpty: Boolean = anchor.next == null

    def extractMin():K = 
        if isEmpty then throw new Exception("Empty PrioQueue")
        val result:K = anchor.next.item
        anchor.next = anchor.next.next
        result

    def insert(elem:K):Unit =
        var current:Node = anchor
        while(current.next != null && current.next.item < elem) do current = current.next
        current.next=Node(elem, current.next)

def linkedNodeSort[A:Ordering](array: Array[A]): Unit = 
    val n = array.length
    val pq:PrioQueue[A] = new SortedNodesPrioQueue[A]
    for a <- array do pq.insert(a)
    for i <- 0 to n-1 do array(i) = pq.extractMin()

class BinaryHeap[K:Ordering:ClassTag](capacity: Int) extends PrioQueue[K]:
    private val ord = summon[Ordering[K]]
    import ord.mkOrderingOps

    private val array:Array[K] = new Array[K](if capacity <1 then 1 else capacity)
    private val last:Int = -1

    private def parent(i:Int):Int = (i-1)/2
    private def left(i:Int):Int = 2*i +1
    private def right(i:Int):Int = 2*i + 2

    private def swap(i:Int, j:Int):Unit =
        val tmp:K = array(i)
        array(i) = array(j)
        array(j) = tmp