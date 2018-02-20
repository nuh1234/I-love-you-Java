//Nuh Mohamud
//This is a problem we did in class, I edited my version and made it a bit better by changing the class constants to private and changing the variables to abc...etc
import java.util.*;
public class P11_2 {
	public static void main(String[] args) {
        Person nuh = new Person("Nuh");
        Student a = new Student("A");
        Employee b = new Employee("B");
        Faculty c = new Faculty("C");
        Staff d = new Staff("D");

        System.out.println(nuh);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }

}
/* Person
String: name
String: address
String: phoneNumber
String: emailAddress

Person(name: String)
toString(): String 

*/
class Person {
   public String name;
   public String address;
   public String phoneNumber;
   public String emailAddress;

   public String toString() {
       return "person" + " " + name;

   }

   public Person(String name) {
       this.name = name;
   }

}
/* Student
-int: freshman
-int: sophomore
-int: junior
-int: senior
------
+Studen(name: String)
+toString(): String 

*/
class Student extends Person {
   private static int FRESHMAN = 1;
   private static int SOPHMORE = 2;
   private static int JUNIOR = 3;
   private static int SENIOR = 4;

   public Student(String name) {
       super(name);
   }
   @Override
   public String toString() {
       return "Student" + " " + super.name;
   }

}
/* Employee
-int: office
-int: salary
-int: dateHired

-----
+Employee(name: String)
+toString(): String 

*/
class Employee extends Person {
  private int office;
  private int salary;
  private int dateHired;

  public Employee(String name) {
      super(name);
  }

  @Override
  public String toString() {
      return "Employee" + " " + super.name;
  }
}
/* Faculty
-int: officeHours
-int: rank
-----
+Faculty(name: String)
+toString(): String 

*/
class Faculty extends Employee {
    
   private int officeHours;
   private int rank;

   public Faculty(String name) {
       super(name);
   }

   @Override
   public String toString() {
       return "Faculty" + " " + super.name;
   }
}
/* Staff
-String: title

------
+Staff(name: String)
+toString(): String 

*/
class Staff extends Employee {
  private String title;

  public Staff(String name) {
      super(name);
  }

  @Override
  public String toString() {
      return "Staff" + " " + super.name;
  }

}


