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