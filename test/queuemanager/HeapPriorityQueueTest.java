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
public class HeapPriorityQueueTest {
    
    public HeapPriorityQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class HeapPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        HeapPriorityQueue instance = null;
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
     * Test of head method, of class HeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        HeapPriorityQueue instance = null;
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        HeapPriorityQueue instance = null;
        instance.remove();
    }

    /**
     * Test of sortHeap method, of class HeapPriorityQueue.
     */
    @Test
    public void testSortHeap() {
        System.out.println("sortHeap");
        HeapPriorityQueue instance = null;
        instance.sortHeap();
    }

    /**
     * Test of buildHeap method, of class HeapPriorityQueue.
     */
    @Test
    public void testBuildHeap() {
        System.out.println("buildHeap");
        HeapPriorityQueue instance = null;
        instance.buildHeap();
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        HeapPriorityQueue instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class HeapPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HeapPriorityQueue instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
