val a1: Array[Int] = Array[Int](0,1,2)
val a2: Array[Int] = Array[Int](0,1,2)
val a3: Array[Int] = a2

//singleton object
object Katharina: //Beschreibe ein neues Objekt
    //Attribute
    //private sorgt dafür, dass die Attribute nur innerhalb des Objekts sichtbar sind
    //-> arbeitsteilung, fehlervermeidung
    private var _age: Int = 20
    private var _job: String = "Dozentin"

    //Methoden
    def getAge: Int = _age
    def getJob: String = _job
    def celebrateBirthday(): Unit =
        _age = _age+1
    def changeJob(newjob: String): Unit =
        _job = newjob
    
    //eigene REPL tostring Methode
    override def toString(): String =
        "Katharina (" + _age.toString + ", " + _job + ")"


//Klasse
class Lampe(private var power: Int):
    //vorraussetzungen von Attributen prüfen
    require(power > 0, "Power muss größer 0 sein")
    //primärer Konstruktor, legt gleich ein Attribut 'power' an
    println("Lampe erstellt: Primärer Konstruktor")
    //Methoden
    //im Default ist die lampe aus
    private var on: Boolean = false

    //Sekundärer Konstruktor
    def this() = this(200)
    println("Lampe erstellt: Sekundärer Konstruktor")

    //2. sekundärer Konstruktor
    def this(power: Int, b:Boolean)=
        this(power)
        this.on = b

    //Methoden
    def isOn: Boolean = this.on
    def getPower: Int = this.power
    def toggle(): Unit=
        this.on = !this.on
    def change(power: Int): Unit = 
        if power>= 0 && !this.on then
            this.power = power
    //cahnge ohne this        
    def change2(pow: Int):Unit = 
        if pow >= 0 && !on then
            power = pow

class Studi(private val name:String):
    private val subject: String = "Bio*Informatik"
    private var ects: Int = 0
    private val matr: Int = Studi.next_matr()

    def study(topic: String): Unit = 
        println(this.name + " reads a book about " + topic)
        this.ects = this.ects + 1

    def finished: Boolean = this.ects >= 180
    def getMatr: Int = this.matr
    def getName: String = this.name

//val s1: Studi = new Studi("Katharina", 12345)
//val s2: Studi = new Studi("Kristin", 12345)

object Studi:
    private var matr_counter: Int = 100

    private def next_matr(): Int = 
        matr_counter = matr_counter+1
        matr_counter-1 //geschamckssache

    def resetMatrCounter(new_counter: Int): Unit =
        matr_counter = new_counter

//Klassenhierarchie
abstract class Person(private val name: String, private val age: Int):
    def isGrownUp: Boolean = age >= 18
    def introduction: String //keine Implementierung: abstrakte Methode
    def work(): Unit //keine Implementierung: abstrakte Methode

class Student(private val name: String, private var age: Int, private val mat: Int) extends Person(name, age):
    def matr_nr: Int = mat
    override def work(): Unit = println("Study, study")
    override def introduction: String = "Hello, I am " + name + " and I am a student!"

class DozentIn(private val name: String, private var age: Int, private var sal: Int) extends Person(name, age):
    def salary: Int = sal
    override def work(): Unit = println("Teach, teach")
    override def introduction: String = "Hello, I am " + name + " and I am a lecturer!"


def test():Unit = 
    var p:Person = new Student("Kim", 20, 12345) //static type: Person, dynamic type: Student
    p.work() //study, study
    //p.matr_nr //Feher, da p als Person deklariert wurde
    p = new DozentIn("Katharina", 30, 1000) //statischer Typ: Person, dynamischer Typ: DozentIn
    p.work() //Teach, teach

