public class Rectangle extends Shape {
 private double length;
 private double width;

 public Rectangle(Rectangle other){
   super(other);
    this.length = other.length ;
    this.width = other.width ;
 }

 public Rectangle(String name, String colour, double length, double width) {
   super(name, colour) ;
    this.length = length;
   this.width = width ;
    }

    public String toString(){
     return super.toString()+ " Length " + length+ " Width " +width;
  }
}
