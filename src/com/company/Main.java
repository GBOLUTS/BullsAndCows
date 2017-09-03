package com.company;


import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        //AutoPlay play = new AutoPlay();//данные 2 строки рассчитывают для автоматического алгоритма
        //System.out.println(AutoPlay.autoPlay(3579));
Play play = new Play();// Данные 2 строки рассчитывают для ручного
play.play();
//
//        AutoPlay play = new AutoPlay();
//        Operations prep = new Operations();
//        Analitics analitics = new Analitics();
//
//        ArrayList<Integer> focusNumbers = prep.findPotentialNumbers();
//        ArrayList<Integer> numberOfAttempts = new ArrayList<Integer>();
//
//
//       for (int i = 0; i < focusNumbers.size(); i++) {
//           Integer n = play.autoPlay(focusNumbers.get(i)); //Заполнил лист с количеством попыток
//          numberOfAttempts.add(n);
//        }
//
//        System.out.println("Максимальное количество попыток = "+analitics.findMax(numberOfAttempts));
//        System.out.println("Среднее количество попыток = "+ analitics.findMiddle(numberOfAttempts));
//        System.out.println("Минимальное количество попыток = "+ analitics.findMin(numberOfAttempts));


  }
}
