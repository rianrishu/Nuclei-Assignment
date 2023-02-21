package org.example.assignment3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void testaddNode(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        Set<Integer> se = new HashSet<>();
        assertEquals(se, graphObject.getParents().get(1));
        assertEquals(se, graphObject.getChildren().get(1));
    }

    @Test
    void testgetImmediateParent(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(1);
        graphObject.addDependency(1,2);
        assertEquals(se, graphObject.getImmediateParent(2));
    }

    @Test
    void testgetImmediateChildren(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(2);
        Set<Integer> se = new HashSet<>();
        se.add(2);
        graphObject.addDependency(1,2);
        assertEquals(se, graphObject.getImmediateChildren(1));
    }

    @Test
    void testgetAncestors(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(3);
        graphObject.addNode(2);
        Set<Integer> expectedResultSet = new HashSet<>();
        expectedResultSet.add(1);
        expectedResultSet.add(3);
        graphObject.addDependency(1,2);
        graphObject.addDependency(3, 2);
        assertEquals(expectedResultSet, graphObject.getAncestors(2));
    }

    @Test
    void testgetDescends(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(3);
        graphObject.addNode(2);
        Set<Integer> expectedResultSet = new HashSet<>();
        expectedResultSet.add(2);
        expectedResultSet.add(3);
        graphObject.addDependency(1,2);
        graphObject.addDependency(1, 3);
        assertEquals(expectedResultSet, graphObject.getDescends(1));
    }

    @Test
    void testdeleteNode(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(3);
        graphObject.addNode(2);
        Set<Integer> expectedResultSet = new HashSet<>();
        graphObject.addDependency(1,2);
        graphObject.addDependency(1, 3);
        graphObject.deleteNode(1);
        assertEquals(expectedResultSet, graphObject.getParents().get(2));
        assertEquals(expectedResultSet, graphObject.getParents().get(3));
    }

    @Test
    void testdeleteDependency(){
        Graph graphObject = new Graph();
        graphObject.addNode(1);
        graphObject.addNode(2);
        graphObject.addNode(3);
        graphObject.addNode(4);
        Set<Integer> expectedResultSet = new HashSet<>();
        expectedResultSet.add(4);
        graphObject.addDependency(1,2);
        graphObject.addDependency(1, 3);
        graphObject.addDependency(4, 2);
        graphObject.deleteDependency(1,2);
        assertEquals(expectedResultSet, graphObject.getParents().get(2));
    }
  
}