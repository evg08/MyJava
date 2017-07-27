package ru.stqa.MyJava.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Евгения on 27.07.2017.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"a", "b", "c", "d"};
    /*for (String l : langs) {
      System.out.println(l);
    }*/
    //List<String> mas =new ArrayList<>();
    //mas.add("e");
    //mas.add("f");
    List<String> mas = Arrays.asList(langs);
    //added new string to array list

    for (int i=0;i<mas.size();i++)
    {
      System.out.println(mas.get(i));
    }
    System.out.println("test");

    for (String l : mas) {
      System.out.println(l);
    }

  }
}
