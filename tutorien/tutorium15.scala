class Place:
    def printMe = println("Buy it.")
class Region extends Place:
    override def printMe = println("Box it.")
class State extends Region:
    override def printMe = println("Ship it.")
class Maryland extends State:
    override def printMe = println("Read it.")

@main
def testt:Unit=
    var mid: Region = State()
    var md: State = Maryland()
    var obj: Any = Place()
    var usa: Place = Region()
    md.printMe
    mid.printMe
    obj.asInstanceOf[Place].printMe
    obj = md
    obj.asInstanceOf[Maryland].printMe
    obj = usa
    obj.asInstanceOf[Place].printMe

class makeup(private val name:String, private val brand: String, private var price: Double):
    private val serialNumber: Int = makeup.nextSerial()
    private var finish: String

    def getSerialNumber: Int = this.serialNumber
    def getBrand = this.brand
    def getPrice = this.price
    def printMe = println(s"Brand: $brand, Price: $price")
    def getLocation:String =
        if this.name == ("Lipstick") || (this.name == "Lipgloss") ||(this.name == "Lipliner") || (this.name =="Lipbalm") then
            "Lip"
        else if (this.name == "Eyeshadow") || (this.name =="Eyeliner") || (this.name =="Mascara") || (this.name =="Eyebrowpencil") then
            "Eye"
        else if (this.name == "Primer") || (this.name == "Foundation") || (this.name == "Concealer") || (this.name == "Powder") then
            "Face Base"
        else if (this.name == "Blush") || (this.name == "Bronzer") || (this.name == "Highlighter") || (this.name == "Setting Spray") then
            "Face Finish"
        else if (this.name == "Brushes") || (this.name == "Sponges") || (this.name == "Eyelashcurler") then
            "Tools"
        else
            throw Exception("We don't use that stuff around here")

    def isExpensive: Boolean =
        val expensive: Set[String] = Set("Dior", "Chanel", "Gucci", "YSL", "Tom Ford", "Natasha Denona", "Bobi Brown", "Haus Labs", "Charlotte Tilbury", "Pat McGrath")
        if (expensive.contains(this.brand)) || (this.price >= 60) then
            true
        else
            false
    
    def isCool: Boolean =
        val cool: Set[String] = Set("Dior", "Colourpop", "Huda Beauty", "Fenty Beauty", "Anastasia Beverly Hills", "Urban Decay", "Haus Labs", "Charlotte Tilbury", "Pat McGrath")
        if cool.contains(this.brand) then
            true
        else
            false
    
object makeup:
    private var ser_counter: Int = 1000000
    private def nextSerial(): Int =
        ser_counter = ser_counter+1
        ser_counter-1
    
    

class face extends makeup(private val name:String, private val brand: String, private var price: Double)=
