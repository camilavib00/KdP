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