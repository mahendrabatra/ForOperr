package com.cc;

public class MyLinkedList {

    int              size = 0;
    transient MyNode first;

    /**
     * This method appends new node at the end
     * @param e
     * @return
     */
    public boolean append(Integer e) {
        final MyNode newNode = new MyNode(e, null);

        // empty list
        if (first == null) {
            first = newNode;
        } else {
            MyNode last = first;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * This method removed last node from the list
     * @return
     */
    public Integer removeLastNode() {
        Integer value = null;
        if (size == 1) {
            // first node is the last
            first = null;
            size--;
        } else if (size > 1) {
            MyNode prevNode = first;
            MyNode lastNode = first;
            while (lastNode.next != null) {
                prevNode = lastNode;
                lastNode = lastNode.next;
            }

            value = lastNode.node;
            prevNode.next = null;
            lastNode = null;
        }

        return value;
    }

    /**
     * This method deletes all nodes whose value is greater than passed argument
     * @param e
     * @return
     */
    public boolean removeAllValueGreater(Integer e) {
        boolean taskExecuted = false;

        MyNode counter = first;
        MyNode prev = null;
        while (counter.next != null) {
            boolean flag = false;
            if (counter.node > e) {
                if (counter == first) {
                    first = counter.next;
                } else {
                    prev.next = counter.next;
                    flag = true;
                }
            }
            if(!flag)   {
                prev = counter;
                size--;
            }
            counter = counter.next;
        }

        return taskExecuted;
    }

 
    /**
     * This method prints values of all nodes
     */
    public void print() {
        MyNode counter = first;
        while (counter != null) {
            System.out.println(counter.node + " ");
            counter = counter.next;
        }
    }

    public static void main(String args[]) {
    	MyLinkedList list = new MyLinkedList();
    	list.append(200);
    	list.append(100);
    	list.append(300);
    	list.append(50);
    	list.print();
    	list.removeAllValueGreater(100);
    	System.out.println("After Deletion");
    	list.print();
    }
    /**
     * This class represents node in the list 
     */
    private static class MyNode {
        Integer node;
        MyNode  next;

        MyNode(Integer element, MyNode next) {
            this.node = element;
            this.next = next;
        }
    }

}
