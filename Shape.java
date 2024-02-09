public class Shape {
 private String colour;
 private String name;

 
 public Shape(Shape other){
  this.colour = other.colour;
  this.name = other.name;
        }

  public Shape(String name, String colour){
   this.name = name;
    this.colour = colour;
}
       
  public String toString() {
   return name + " " + colour ;   }
}
