package org.example.assignment3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void testaddNode(){
        Graph g = new Graph();
        g.addNode(1);
        Set<Integer> se = new HashSet<>();
        assertEquals(se, g.parents.get(1));
        assertEquals(se, g.children.get(1));
    }

    @Test
    void testgetImmediateParent(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(1);
        g.addDependency(1,2);
        assertEquals(se, g.getImmediateParent(2));
    }

    @Test
    void testgetImmediateChildren(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(2);
        g.addDependency(1,2);
        assertEquals(se, g.getImmediateChildren(1));
    }

    @Test
    void testgetAncestors(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(3);
        g.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(1);
        se.add(3);
        g.addDependency(1,2);
        g.addDependency(3, 2);
        assertEquals(se, g.getAncestors(2));
    }

    @Test
    void testgetDescends(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(3);
        g.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(2);
        se.add(3);
        g.addDependency(1,2);
        g.addDependency(1, 3);
        assertEquals(se, g.getDescends(1));
    }

    @Test
    void testdeleteNode(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(3);
        g.addNode(2);
        Set<Integer> se = new HashSet<>();
        g.addDependency(1,2);
        g.addDependency(1, 3);
        g.deleteNode(1);
        assertEquals(se, g.parents.get(2));
        assertEquals(se, g.parents.get(3));
    }

    @Test
    void testdeleteDependency(){
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        Set<Integer> se = new HashSet<>();
        se.add(4);
        g.addDependency(1,2);
        g.addDependency(1, 3);
        g.addDependency(4, 2);
        g.deleteDependency(1,2);
        assertEquals(se, g.parents.get(2));
    }
  
}