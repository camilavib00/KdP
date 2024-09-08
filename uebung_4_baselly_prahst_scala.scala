// aufgabe 3 e)

// Signatur:
    // alphaOmega
    // Eingabe: String
    // Ausgabe: (Int,Int)

// Spezifikation:
    // Voraussetzungen: keine
    // Effekt: keiner
    // Ergebnis: ein Tupel mit der Anzahl der a's und der z's in einem String (nicht case sensitive)

// Hilfsfunktion:
def countLetter(m:Char,str:String):Int=
    // damit große und kleine Buchstaben gezählt werden
    val s:String = str.toLowerCase
    // Rekursionsanker
    if (s=="") then
        0
    // Rekursionsschritt
    // wenn der erste Buchstabe dem gegebenen Character
    // entspricht, erhöhe um 1
    else if (m==(s.head)) then
        1 + countLetter(m,(s.tail))
    // wenn nicht, erhöhe nicht und überpfrüfe den
    // restlichen String
    else
        countLetter(m,(s.tail))

// alphaOmega
def alphaOmega(str:String):(Int,Int)=
    // wende Hilfsfunktion auf String und a bzw. z an
    // und bilde daraus ein Tupel
    (countLetter('a',str),countLetter('z',str))




// Aufgabe 4 a - c)

// julianDate
// Eingabe:         (Int,Int,Int)
// Ausgabe:         (Int,Int,Int)
// Voraussetzung:   es muss ein gültiges Datum angegeben werden
// Effekt:          keiner
// Ergebnis:        das gegebene Datum wurde in das entsprechende Datum des
//                  julianischen Kalenders umgewandelt
def julianDate(date:(Int,Int,Int)):(Int,Int,Int)= 
    val (d,m,j) = date
    if (m==1 || m==2) then 
        // ich musste die Zahlen neu definieren, da
        // scala sonst gemeckert hat, da es "-" nicht 
        // als Int angesehen hat
        val nm:Int = m + 10
        val nj:Int = j - 1
        (d,nm,nj)
    else
        // hier wieder Umwandeln in Variable, damit
        // scala nicht meckert
        val nm:Int = m - 2
        ( d , nm , j )


// numberToDay
// Eingabe:         Int
// Ausgabe:         String
// Voraussetzung:   n muss ein positiver Integer mod 7 sein
// Effekt:          keiner
// Ergebnis:        es wird der Name des zur Eingabe gehörenden Wochentags ausgegeben,
//                  wobei 0 -> Sonntag, 1 -> Montag usw.
def numberToDay(n:Int):String=
    n match
        case 0 => "Sonntag"
        case 1 => "Montag"
        case 2 => "Dienstag"
        case 3 => "Mittwoch"
        case 4 => "Donnerstag"
        case 5 => "Freitag"
        case 6 => "Samstag"


// makePositive
// Eingabe:         Int
// Ausgabe:         Int
// Voraussetzung:   keine
// Effekt:          keiner
// Ergebnis:        es wird die der Eingabe entsprechende positive Zahl bzgl. mod 7
//                  ausgegeben
def makePositive(n:Int):Int=
    // Rekursionsanker
    if (n>=0) then
        n
    // Rekusrsionsschritt
    else
        7 + makePositive(n+7)
    

// wDay
// Eingabe:         (Int,String,Int) oder (Int,Int,Int)
// Ausgabe:         String
// Voraussetzung:   es muss ein gültiges Datum eingetragen werden; der Monat
//                  muss komplett ausgeschrieben, deutsch und mit großem
//                  Anfangsbuchstaben sein, sofern es ein String ist
// Effekt:          keiner
// Ergebnis:        der Wochentag des gegebenen Datums wird ausgegeben
def wDay(d:Int,m:String|Int,y:Int):String=
    // erstelle mm, um die Sring-Eingabe und die Int-Eingabe
    // anzugleichen
    val mm:Int = m match {
        case jan if m=="Januar" || m==1 => 1
        case feb if m=="Februar" || m==2 => 2
        case mar if m=="März" || m==3 => 3
        case apr if m=="April" || m==4 => 4
        case may if m=="Mai" || m==5 => 5
        case jun if m=="Juni" || m==6 => 6
        case jul if m=="Juli" || m==7 => 7
        case aug if m=="August" || m==8 => 8
        case sep if m=="September" || m==9 => 9
        case oct if m=="Oktober" || m==10 => 10
        case nov if m=="Novermber" || m==11 => 11
        case dez if m=="Dezember" || m==12 => 12
        case _ => 0
    }
    // wenn m nicht wie vorausgesetzt eingegeben wurde, ist
    // die Eingabe ungültig
    if (m==0) then
        "Ungültige Eingabe"
    else
        // wandle das Datum in ein julianisches Datum um
        val date = julianDate(d, mm, y)
        // wende die Formel (außer mod 7) an
        val result = ((date(0).toDouble + (2.6*date(1).toDouble-0.2).floor + (date(2)%100) + (((date(2)%100)/4).toDouble).floor + (((date(2)/100)/4).toDouble).floor - (2*(date(2)/100))).toInt)
        // falls die Formel ohne mod 7 ein negatives Ergebnis hat 
        // (denn scala kann scheinbar kein Modulo auf negative Zahlen anwenden)
        if (result < 0)
            // wende jetzt mod 7 an und wandle in einen String um
            numberToDay(makePositive(result)%7)
        else
            // wende jetzt mod 7 an und wandle in einen String um
            numberToDay(result%7)