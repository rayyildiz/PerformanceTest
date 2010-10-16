package com.rayyildiz.performance;

/**
 * User: rayyildiz
 * Date: 10/16/10 - 4:56 PM
 * Description:
 */
public interface IList<T> {
    void insert(T data);
    void bulkInsert(T[] dataList);
    void remove(T data);
    void remove(T[] dataList);
    T search(T data);
    T get(int index);
    int length();
    int capacity();
}
