// Example of a value class
class Dollars(val amount: Int) extends AnyVal {
  override def toString = "$" + amount
}

val money = new Dollars(100000)
money.amount
println(money)

class SwissFrancs(val amount: Int) extends AnyVal {
  override def toString = amount + "CHF"
}

val francs = new SwissFrancs(1000)
val dollars = new Dollars(1000)
println(francs)
println(dollars)

// Avoiding type monoculture
// Try to define a new class for each domain concept
def title(text: String, anchor: String, style: String): String =
  s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

title("chap:vcls", "bold", "Value Classes")
// HTML is mangled, inteded to display text "Value Classes" is
// being used as a style, and wrong text shown

class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal

def newTitle(text: Text, anchor: Anchor, style: Style): Html =
  new Html(
    s"<a id='$anchor'>" +
      s"<h1 class='$style'>" +
      text.value +
      "</h1></a>"
  )

// This will now result in type mismatches
newTitle(new Anchor("chap:vcls"), new Style("bold"), new Text("Value Classes"))

newTitle(new Text("Value Classes"), new Anchor("chap:vcls"), new Style("bold"))
// Above will work fine