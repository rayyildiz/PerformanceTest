package com.rayyildiz.performance.arraylist.impl;

import com.rayyildiz.performance.arraylist.IArrayList;

import java.util.ArrayList;

/**
 * User: rayyildiz
 * Date: 10/16/10 - 5:12 PM
 * Description:
 */
public class IntegerArrayListImpl implements IArrayList<Integer>{
    private ArrayList<Integer> container;

    public IntegerArrayListImpl() {
        container = new ArrayList<Integer>();
    }

    public void insert(Integer data) {
        container.add(data);
    }

    public void bulkInsert(Integer[] dataList) {
        for(Integer data : dataList){
            insert(data);
        }
    }

    public Integer search(Integer data) {
        int index = container.lastIndexOf(data);
        if ( index<1) return null;

        return get(index);
    }

    public Integer get(int index) {
        return container.get(index);
    }

    public int length() {
        return container.size();
    }

    public int capacity() {
        return -1;
    }

    public void remove(Integer data) {
        container.remove(data);
    }

    public void remove(Integer[] dataList) {
        for(Integer  data : dataList){
            remove(data);
        }
    }

    @Override
    public String toString() {
        return "IntegerArrayListImpl{" +
                "container size=" + container.size() +
                " container=" + container +
                '}';
    }
}
