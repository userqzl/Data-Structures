package Linklist;

import java.util.LinkedList;

/**
 * @description: 带头结点单链表的实现
 * @author: qzl
 * @created: 2020/06/27 15:17
 */

public class Linklist<T> {

    Node head = null;   //保存头结点

    private int size;

    Linklist(){
        head = new Node();
        head.next = null;
        size = 0;
    }


    //表头添加节点
    public void addFirst(T t){

        Node node = new Node();     //创建要插入节点

        node.data = t;        //初始化节点
        node.next = head.next;    //新节点指点首节点
        head.next = node;    //头结点指向新节点
        size++;
    }

    //向表尾添加节点
    public void addLast(T t){
        Node node = new Node();     //创建要插入的节点

        node.data = t;    //初始化节点

        Node p;
        p = head;
        //找到表尾
        while(p.next != null){
            p = p.next;
        }
        //添加节点
        p.next = node;
        node.next = null;

        size++;
    }

    //在指定节点前插入节点
    public void insertAny(T t,int n){
        if(n > size){
            System.out.println("没有第"+n+"个节点");
        }
        else {
            Node p = head;    //遍历指针，指向头结点
            //创建新结点
            Node newNode = new Node();
            newNode.data = t;
            //扫描链表，让p指向第n个节点的前一个节点
            for (int i = 1; i < n; i++) {
                p = p.next;
            }
            //在第n个节点前插入新节点
            newNode.next = p.next;
            p.next = newNode;
            size++;    //表长加一
        }
    }

    //删除表头节点
    public T removeFirst(){
        T temp = null;
        if(!isEmpty()) {
            temp = (T) head.next.data;
            head.next = head.next.next;
            size--;
        }
        return temp;
    }

    //删除最后一个节点
    public T removeLast(){
        Node p;
        p = head;
        //找到倒数第二个节点
        while(p.next.next != null){
            p = p.next;
        }

        //倒数第二个节点指向空，并返回最后一个节点的数据
        T t = (T)p.next.data;
         p.next = null;
         size--;
        return t;
    }

    //删除指定节点
    public T removeAny(int n){
        if(n > size || n < 1 || isEmpty()){
            System.out.println("第"+n+"个节点不存在");
            return null;
        }
        else {
            //两个指针扫描链表，扫描至第n的节点和第n-1个节点
            Node p,r;
            p = head;
            r = head.next;
            for(int i = 1;i < n;i++){
                p = p.next;
                r = r.next;
            }
            //删除第n个节点并返回节点上的数据
            p.next = r.next;
            size--;  //表长减一
            return (T)r.data;
        }
    }

    //获取链表长度
    public int getSize(){
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        if(size == 0)  return "链表为空！";
        else {
            StringBuilder list = new StringBuilder();
            for(Node i = head.next;i != null;i = i.next)
                list.append(i.data+"-");
            return list.toString();
        }
    }

    public static class Node<T>{
        T data;    //数据域
        Node next;    //指向下一个节点
        Node(){
            next = null;
        }
    }

    public static void main(String[] args) {
        Linklist<Integer> linklist = new Linklist<Integer>();
        for (int i = 0; i < 10; i++) {
            linklist.addFirst(i);
        }
        System.out.println(linklist+"  长度："+linklist.getSize());

        System.out.println("第一个节点已删除，数据为"+linklist.removeFirst());
        System.out.println(linklist+"  长度："+linklist.getSize());

        System.out.println("最后一个节点已删除，数据为"+linklist.removeLast());
        System.out.println(linklist+"  长度："+linklist.getSize());

        System.out.println("在第3个节点前插入新节点");
        linklist.insertAny(100,3);
        System.out.println(linklist+"  长度："+linklist.getSize());

        System.out.println("第"+5+"个节点已删除，数据为"+linklist.removeAny(5));
        System.out.println(linklist+"  长度："+linklist.getSize());

    }
}
