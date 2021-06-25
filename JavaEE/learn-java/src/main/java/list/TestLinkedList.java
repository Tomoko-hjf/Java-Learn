package list;

import entity.Hero;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试双向链表LinkedList
 */
public class TestLinkedList {
    public static void main(String[] args) {
        testDupLinkedList();
        testQueue();
    }

    /**
     * 测试双向链表接口
     */
    public static void testDupLinkedList() {
        LinkedList<Hero> linkedList = new LinkedList<>();
        linkedList.add(new Hero("hero1"));
        System.out.println(linkedList);
        //在双向链表的最前面插入元素
        linkedList.addFirst(new Hero("hero2"));
        //在双向链表的最后面插入元素
        linkedList.addLast(new Hero("hero3"));
        System.out.println(linkedList);
    }

    /**
     * 测试Queue接口
     */
    public static void testQueue() {
        Queue<Hero> q = new LinkedList<>();
        //向队列中添加元素
        System.out.println("初始化队列");
        q.offer(new Hero("hero1"));
        q.offer(new Hero("hero2"));
        System.out.println(q);

        //查看队首元素
        System.out.println(q.peek());
        //取出第一个队首元素
        System.out.println(q.poll());
        System.out.println(q);
    }
}
