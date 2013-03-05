package org.conbere.algebra

trait SemiGroup[T] {
  def add(a:T, b:T):T
}

object SemiGroup {
  implicit object IntSemiGroup extends SemiGroup[Int] {
    def add(a:Int, b:Int) = a + b
  }

  implicit object StringSemiGroup extends SemiGroup[String] {
    def add(a:String, b:String) = a + b
  }

  def add[T](a:T, b:T)(implicit adder:SemiGroup[T]) =
    adder.add(a, b)

  implicit class Addable[T](a:T) {
    def +| (b:T)(implicit adder:SemiGroup[T]):T =
      adder.add(a,b)
  }

  implicit def optionSemiGroup[T](implicit adder:SemiGroup[T]):SemiGroup[Option[T]] = {
    new SemiGroup[Option[T]] {
      def add(a:Option[T], b:Option[T]) =
        (a,b) match {
          case (None, None) => None
          case (a@Some(_), None) => a
          case (None, b@Some(_)) => b
          case (Some(a), Some(b)) => Some(adder.add(a,b))
        }
    }
  }

}
