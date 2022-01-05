// zipped method on tuples generalizes several common operations to work on multiple
// lists instead of just one
// zipped is deprecated, lazyZip is the new method

List(10, 20).lazyZip(List(3,4,5)) map (_ * _)
// Third element of second list is discarded
// returns List(10 * 3, 20 * 4)
List("abc", "de").lazyZip(List(3,2)) forall (_.length == _)
// checks if length of string is equal to number in second list
// true if all ("abc".length == 3, "de".length == 2)
List("abc", "de") lazyZip List(3,2) exists (_.length != _)
// checks if there exists a string that is not equal to the number
// true if one or more ("abc".length != 3, "de".length != 2)
