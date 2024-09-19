// Aufgabe 2

// es müssen Führerscheinklasse für das Fahrzeug (fklasse), die Marke des Herstellers (marke) und
// die bereits gefahreren km (km) angegegeben werden
class Fahrzeug(private val fklasse:String, private val marke:String, private var km:Int):
    // die eindeutige Seriennummer wird erstellt
    private val seriennummer: Int = Fahrzeug.next_ser()

    // gibt das Mindestalter für die gegebene Führerscheinklasse wieder, sofern sie in der Menge:
    // {"AM", "A1", "A2", "B", "BE", "B96"} enthalten ist
    def getMindestalter: Int = 
        if this.fklasse == "AM" then
            15
        else if this.fklasse == "A1" then
            16
        else if this.fklasse == "A2" then
            18
        else if (this.fklasse == "B") || (this.fklasse == "BE") || (this.fklasse == "B96") then
            18
        else
            throw Exception("keine implementierte Führerscheinklasse")

    // gibt eine kurze Erklärung wieder, welche Fahrzeuge die Bezeichnung der Führerscheinklasse
    // beinhaltet
    def getBezKlasse: String =
        if this.fklasse == "AM" then
            "Kleinkrafträder (bis 50 ccm) und vierrädrige Leichtkraftfahrzeuge"
        else if this.fklasse == "A1" then
            "Krafträder mit einem Hubraum von bis zu 125 ccm und einer Motorleistung von max. 11 kW"
        else if this.fklasse == "A2" then
            "Motorräder mit einer Motorleistung von bis zu 35 kW"
        else if (this.fklasse == "B") || (this.fklasse == "BE") || (this.fklasse == "B96") then
            "Kraftfahrzeuge bis 3,5 Tonnen zulässigem Gesamtgewicht (mit Anhänger)"
        else
            throw Exception("keine implementierte Führerscheinklasse")

    // gibt die unique Seriennummer aus
    def getSeriennummer: Int = this.seriennummer

    // gibt den km-Stand aus
    def getKm: Int = this.km

    // zeigt an, ob die Fahrzeugmarke cool ist (laut einer von Google gegebenen List)
    def isCool: Boolean =
        val cool: Set[String] = Set("Bugatti", "BMW", "Ford", "Audi", "Ferrari", "Mercedes", "Toyota", "Porsche", "Lamborghini", "Jeep")
        if cool.contains(this.marke) then
            true
        else
            false
    

object Fahrzeug:
    // starte Seriennnummern bei 100 
    private var ser_counter: Int = 100

    // erhöht den Counter für die Seriennummer um 1
    private def next_ser(): Int =
        ser_counter = ser_counter+1
        ser_counter-1   // damit bei 100 gestartet wird
    