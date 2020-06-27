package cn.qzl.Excise.Excetion_1.Linklist;

/**
 * @description: 单链表实现
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


        size++;
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
    }

    public static void main(String[] args) {
        Linklist<Integer> linklist = new Linklist<>();
        for (int i = 0; i < 10; i++) {
            linklist.addFirst(i);
        }
        System.out.println("链表长度为："+linklist.getSize());
        System.out.println(linklist);

        System.out.println("第一个节点已删除，数据为"+linklist.removeFirst());

        System.out.println("链表长度为："+linklist.getSize());
        System.out.println(linklist);

    }
}
