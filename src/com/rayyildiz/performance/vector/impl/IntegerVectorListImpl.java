package com.rayyildiz.performance.vector.impl;

import com.rayyildiz.performance.vector.IVectorList;

import java.util.Vector;

/**
 * User: rayyildiz
 * Date: 10/16/10 - 5:01 PM
 * Description:
 */
public class IntegerVectorListImpl implements IVectorList<Integer>{
    private Vector<Integer> container;

    public IntegerVectorListImpl() {
        container = new Vector<Integer>();
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
        return container.capacity();
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
        return "IntegerVectorListImpl{" +
                "container capacity=" + container.capacity() +
                " container size=" + container.size() +
                " container=" + container +
                '}';
    }
}
