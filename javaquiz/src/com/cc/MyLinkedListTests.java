package com.cc;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class MyLinkedListTests {
    
    @Test
    public void addTest() {
        MyLinkedList list = new MyLinkedList();
        
        assertTrue(list.size == 0);
        
        for(int counter = 1; counter <= 100; counter++) {
            list.append(counter);
        }
        
        assertTrue(list.size == 100);        
    }
    
    @Test
    public void removeLastNodeTest() {
        MyLinkedList list = new MyLinkedList();
        for(int counter = 1; counter <= 100; counter++) {
            list.append(counter);
        }
        assertTrue(list.removeLastNode() == 100);
    }

    @Test
    public void removeValuesGreaterThanTest() {
        MyLinkedList list = new MyLinkedList();
        Random r = new Random();
        for(int counter = 1; counter <= 10; counter++) {
            list.append(r.nextInt(100));
        }
        
        System.out.println("Random List ");
        list.print();
        int toberemoved = r.nextInt(100);
        System.out.println("Value greater than " + toberemoved + " to be removed ");
        list.removeAllValueGreater(toberemoved);
        System.out.println("List after removal");
        list.print();
    }

}
