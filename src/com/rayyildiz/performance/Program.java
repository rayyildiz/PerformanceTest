package com.rayyildiz.performance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import com.rayyildiz.performance.arraylist.impl.IntegerArrayListImpl;
import com.rayyildiz.performance.vector.impl.IntegerVectorListImpl;

/**
 * User: rayyildiz
 * */

public  class  Program{
    private final static String AppName = "PerformanceTest";

    public  static  void  main(String[] args){
        searchTest();
        //directAccessTest();
    }


    private  static  void directAccessTest(){
        IList<Integer> vectorList = new IntegerVectorListImpl();
        IList<Integer> arrayList = new IntegerArrayListImpl();
        List<Integer> randomIntegers = getRandomIntegers(100000);
        long start,end;

        for(Integer i : randomIntegers) arrayList.insert(i);
        for(Integer i : randomIntegers) vectorList.insert(i);

        ArrayList<Integer> findObjList = new ArrayList<Integer>();

        Random rnd = new Random();
        for (int i=0; i<2500; i++){
            int number = rnd.nextInt(randomIntegers.size()- 1);
            findObjList.add(number);
        }

        write("Start for direct access ARRAYLIST");
        start = System.currentTimeMillis();
        for(int ind : findObjList) arrayList.get(ind);
        end = System.currentTimeMillis();
        long differenceOfArrayList = end -  start;
        write("ArrayList time difference :" + differenceOfArrayList + " ms");
        write("End for search ARRAYLIST");

        write("Start for search VECTOR");
        start = System.currentTimeMillis();
        for(int ind : findObjList) vectorList.get(ind);
        end = System.currentTimeMillis();
        long differenceOfVector = end -  start;
        write("Vector time difference :" + differenceOfVector + " ms");
        write("End for search VECTOR");
    }

    private  static  void searchTest(){
        IList<Integer> vectorList = new IntegerVectorListImpl();
        IList<Integer> arrayList = new IntegerArrayListImpl();
        List<Integer> randomIntegers = getRandomIntegers(100000);
        long start,end;

        for(Integer i : randomIntegers) arrayList.insert(i);
        for(Integer i : randomIntegers) vectorList.insert(i);

        Integer findObj =  777;

        write("Start for search ARRAYLIST");
        start = System.currentTimeMillis();
        arrayList.search(findObj);
        end = System.currentTimeMillis();
        long differenceOfArrayList = end -  start;
        write("ArrayList time difference :" + differenceOfArrayList + " ms");
        write("End for search ARRAYLIST");

        write("Start for search VECTOR");
        start = System.currentTimeMillis();
        vectorList.search(findObj);
        end = System.currentTimeMillis();
        long differenceOfVector = end -  start;
        write("Vector time difference :" + differenceOfVector + " ms");
        write("End for search VECTOR");
    }

    private  static  void insertTest(){
        IList<Integer> vectorList = new IntegerVectorListImpl();
        IList<Integer> arrayList = new IntegerArrayListImpl();
        List<Integer> randomIntegers = getRandomIntegers(100000);
        long start,end;

        write("Start for inserting ARRAYLIST");
        start = System.currentTimeMillis();
        for(Integer i : randomIntegers) arrayList.insert(i);
        end = System.currentTimeMillis();
        long differenceOfArrayList = end -  start;
        write("ArrayList time difference :" + differenceOfArrayList + " ms");
        write("End for inserting ARRAYLIST");

        write("Start for inserting VECTOR");
        start = System.currentTimeMillis();
        for(Integer i : randomIntegers) vectorList.insert(i);
        end = System.currentTimeMillis();
        long differenceOfVector = end -  start;
        write("Vector time difference :" + differenceOfVector + " ms");
        write("End for inserting VECTOR");
    }

    private static List<Integer> getRandomIntegers(int count){
        List<Integer> randomInts = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i< count; i++){
            int rndNumber =  random.nextInt();
            randomInts.add(rndNumber);
        }

        return randomInts;
    }


    private  static  void usage(){
        write(AppName + " TYPE COUNT");
        write("TYPE= 1 for ArrayList and 2 for Vector. 0 for both");
        write("COUNT= number of integer count.");
        write("For Instance:");
        write(AppName +" 1 20000 --> Run for ArrayList, the number of temporary data is 20000");
        write(AppName +" 2 20000 --> Run for Vector, the number of temporary data is 20000");

    }

    private  static  void write(String msg){
        System.out.println(msg);
    }


}
