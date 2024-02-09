public class Circle extends Shape {
 private double radius;

  public Circle(Circle other)   {
   super(other);
   this.radius = other.radius ; }

  public Circle(String name, String colour, double radius){
   super(name, colour);
     this.radius = radius ;
    }


 public String toString() {
  return super.toString() + " Radius " + radius; }
}
