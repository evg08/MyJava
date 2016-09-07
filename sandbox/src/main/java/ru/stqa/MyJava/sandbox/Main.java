package ru.stqa.MyJava.sandbox;
//import  java.lang.Math;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
      int a=4;
      System.out.println(a);
      Point obj= new Point();
      obj.x= 5.0;
      obj.y=9.0;
      System.out.println("Peзультат "+ distance(obj));
      Point obj2= new Point(5.0,9.0);
      System.out.println("Peзультат2 "+obj2.distance() );
    }
  public static double distance(Point p)

  { if(p.y < p.x){
    System.out.println("Error");
    return 0;}
    double add=p.y+p.x;
    double sub=p.y-p.x;
    return Math.sqrt(Math.pow((sub),2)+Math.pow((add),2));
  }
}