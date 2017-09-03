package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Nalika on 22.01.2017.
 */
public class Analitics {

    public double findMiddle(ArrayList<Integer> arr){
        int whole = 0;
        for (int i = 0; i <arr.size() ; i++) {
            whole+=arr.get(i);
        }
        double middle = (double) whole/arr.size();
        return middle;
    }


    public int findMin(ArrayList<Integer> arr){
        int min = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (min > arr.get(i)){
                min = arr.get(i);
            }

        }
        return min;
    }

    public int findMax(ArrayList<Integer> arr){
        int max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (max < arr.get(i)){
                max = arr.get(i);
            }

        }
        return max;
    }

    public ArrayList<String> createListOfAllVariables(){
        String[] list = {"40","30","20","10","00","21","22","11","12","13","01","02","03","04"};
        ArrayList<String> array =new ArrayList<String>();

        for (int i = 0; i < list.length ; i++) {//Заполнение аррай из массива
           array.add(list[i]);
        }
        return array;
    }


    public String userRightAnswer(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> normalAnswers = createListOfAllVariables();

        try {
            String userAnswer = reader.readLine();

            while (true) {

                if (normalAnswers.contains(userAnswer)) {//Запускаем пока не будет верное число ответ
                    return userAnswer;
                } else {
                    System.out.println("Введите верное число");
                    userAnswer = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Заглушка";
    }
}
