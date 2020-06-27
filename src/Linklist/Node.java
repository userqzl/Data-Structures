package cn.qzl.Excise.Excetion_1.Linklist;

/**
 * @description: 链表实现
 * @author: qzl
 * @created: 2020/06/27 14:15
 */

public class Node<T> {
    T data;     //数据
    Node next;   //指向下一个节点

    Node(){
        next = null;
    }

    //遍历输出链表
    public void display(Node head) {
        for (Node i = head; i != null; i = i.next)
            System.out.print(i.data + "-");
        System.out.println();
    }

    public static void main(String[] args) {

        //创建节点
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();

        //初始化节点数据
        first.data = "节点一";
        second.data = "节点二";
        third.data = "节点三";

        //将节点串联成链表
        first.next = second;
        second.next = third;

        //打印
        first.display(first);

        ///////////////////////////////////////////////////

        //表头插入节点
        Node oldfirst = first;  //保存指向链表的链接
        first = new Node<>();  //创建新的首节点
        first.data = "新首节点";
        first.next = oldfirst;

        //打印
        first.display(first);

        //////////////////////////////////////////////////

        //删除首节点
        Node delete;  //保存被删除的节点
        delete = first;
        first = first.next;

        System.out.println(delete.data+"被删除");
        delete = null;  //释放被删除的节点

        //打印
        first.display(first);

        ////////////////////////////////////////////////

        //表尾添加节点
        Node oldLast = third;    //保存原尾节点
        third = new Node<>();    //创建新的尾节点
        third.data = "新尾节点";
        oldLast.next = third;    //尾节点指向新节点

        //打印
        first.display(first);
    }
}
