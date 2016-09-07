package ru.stqa.MyJava.sandbox;

/**
 * Created by Евгения on 07.09.2016.
 */
public class Point {
  public double x,y;
  public  Point (){};
  public Point(double x,double y)
  {
    this.x=x;
    this.y=y;
  }
  public  double distance()
  {
    if( this.y< this.x ){
      System.out.println("Error");
      return 0;}
    double add=this.y+this.x;
    double sub=this.y-this.x;
    return Math.sqrt(Math.pow((sub),2)+Math.pow((add),2));
  }
}
