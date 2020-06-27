package cn.qzl.Excise.Excetion_1.Stack;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: 栈的实现
 * @author: qzl
 * @created: 2020/06/27 09:40
 */

public class MyStack<T> {
    private LinkedList<T> a;     //栈空间
    private int N;      //栈大小

    MyStack(int n){
        a = new LinkedList<>();
        N = 0;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return N == 0;
    }
    //获取栈大小
    public int size(){
        return N;
    }
    //入栈
    public void push(T s){
        a.addLast(s);
        N++;
    }
    //出栈
    public T pop(){
        N--;
        return a.removeLast();
    }
}
