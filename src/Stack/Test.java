package cn.qzl.Excise.Excetion_1.Stack;

/**
 * @description:
 * @author: qzl
 * @created: 2020/06/27 09:49
 */

public class Test {
    public static void main(String[] args) {
        MyStack <Integer>stack = new MyStack<>(6);

        for(int i = 0;i < 6;++i)
            stack.push(i);
        for(int i = 0;i < 6;++i)
            System.out.print(stack.pop()+"-");
    }
}
