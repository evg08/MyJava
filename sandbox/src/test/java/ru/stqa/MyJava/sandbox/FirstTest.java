package ru.stqa.MyJava.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Евгения on 07.09.2016.
 */@Test
public class FirstTest {
  public void Test1(){
    Point obj2= new Point(5.0,9.0);
    Assert.assertEquals(obj2.distance(),14.560219778561036);
  }


}
