package ru.stqa.MyJava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Евгения on 25.07.2017.
 */
public class EquationTests {
  @Test
  public void test0(){
  Equation e=new Equation(1,1,1);
   Assert.assertEquals(e.rootNumber(),0);
    System.out.println("Output" +e.rootNumber());
  }
  @Test
  public void test1(){
    Equation e=new Equation(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
    System.out.println("Output" +e.rootNumber());
  }
  @Test
  public void test2(){
    Equation e=new Equation(1,5,6);
    System.out.println("Output" +e.rootNumber());
    Assert.assertEquals(e.rootNumber(),2);

  }
}
