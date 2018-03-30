/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kieran
 */
public class SortedLinkedPriorityQueueTest {
    
    public SortedLinkedPriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        SortedLinkedPriorityQueue instance = null;
        Object item = "Kieran";
        int priority = 10;
        instance.add(item, priority);
        item = "Jim";
        priority = 40;
        instance.add(item, priority);
        item = "James";
        priority = 50;
        instance.add(item, priority);
        item = "Bob";
        priority = 20;
        instance.add(item, priority);
        item = "Jimmy";
        priority = 30;
        instance.add(item, priority);
    }
    
    /**
     * Test of head method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedLinkedPriorityQueue instance = null;
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        SortedLinkedPriorityQueue instance = null;
        instance.remove();
    }

    /**
     * Test of isEmpty method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedLinkedPriorityQueue instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedLinkedPriorityQueue instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
