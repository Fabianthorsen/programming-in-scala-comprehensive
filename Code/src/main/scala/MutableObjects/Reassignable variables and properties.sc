// Two fundamental operations on re-assignable variables: get and set
// In Scala, all var that is a non-private member of some object get
// implicitly defined a getter and setter
var hour = 12
hour // getter
hour = 13 // Setter

// Can also define getter and setter directly
class Time {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_= (x:Int): Unit = {
    require(0 <= x && x < 24)
    h = x
  }
  def minute: Int = m
  def minute_= (x: Int): Unit = {
    require(0 <= x && x <= 60)
    m = x
  }
  override def toString: String = s"$h:${"%02d".format(m)}"
}

var time = new Time
time.hour = 11
time.minute = 59
time

// Can be useful to define get and setter without associated field
class Thermometer {
  var celsius: Float = _ // Set to default value as initialization
  // 0 for numeric types, false for boolean, null for reference
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float): Unit =
    celsius = (f - 32) * 5 / 9

  override def toString = fahrenheit + "F/" + celsius + "C"
}

var thermo = new Thermometer
thermo.celsius = 36
thermo
thermo.fahrenheit = -40
thermo
