/* 
Imperative Programmierung in Scala
a) Eine Funktion, die als Eingabe ein Array von Int und einen Int a enthält und
alle Zahlen, die kleiner als a sind aus der Liste entfernt.
 */

 //Voraussetzung: Array von Int und ein Ina a als Input
 //Effekt: keiner
 //Ergebnis: Array von Int, das alle Zahlen enthält, die größer oder gleich a sind
 //einfache Lösung
 def filterArray(arr: Array[Int], a: Int): Array[Int]=
    var counter : Int = 0
    for i <- 0 to arr.length-1 do
        if arr(i) >= a then
            counter = counter +1
    var result: Array[Int] = new Array[Int](counter)
    counter = 0
    for i <- 0 to arr.length-1 do
        if arr(i) >= a then
            result(counter) = arr(i)
    return result

//alternative: weniger ocde, aer öhere Laufzeit weil immer arr kopiert wird
def a1_1(arr:Array[Int], a:Int):Array[Int] = 
    var res = Array[Int]()
    for (elem <- arr)
        if (elem >= a)
            res:+= elem
    return res

//b) Eine Funktion, die die Quersumme der eingegebenen Zahl berechnet.
//Voraussetzung: Eingabe ist ein positiver Integer
//Effekt: Keiner
//Ergebnis: Quersumme der Ziffern des Integers

def Quersumme(a: Int): Int = 
    var num = a
    var qs: Int = 0
    var ziffer: Int = 0
    while (num > 0) do
        ziffer = num % 10
        qs += ziffer
        num = num / 10
    return qs

//c)collect
//Voraussetzung: Input ist ein Array von arrays
//Effekt: Keiner
//Ergebnis: nur ein einzelnes array, welches die werte aller subarrays enthält

import scala.reflect.ClassTag

def collect[A: ClassTag](arr: Array[Array[A]]): Array[A] = 
    var res = Array[A]()
    for subarray <- arr do
        res ++= subarray
    return res
        
//d) Funktionen encrypt und decrypt die einen Text & eine Zahl erhalten und mit caesarverschlüsselung
//Voraussetzung, text enthält keine sonderzeichen & integer ist positiv
//Effekt: keiner
//Ergebnis: Verschlüsselter Text 
def encrypt(text: String, key: Int): String = 
    var res: String = ""
    for char <- text do
        if ((char.toInt >= 65) && (char.toInt <= 122)) then
            if ((char.toInt + key) > 122) then
                res += ((char.toInt + key)%26 + 97).toChar
            else
                res += ((char.toInt + key)).toChar
        else
            res += char
    return res
        
//Invariante
// I = {j >= 0 ODER xs[j-1 <= elem]}
//Invariante für for loop
//I = {i <= len(xs)}


