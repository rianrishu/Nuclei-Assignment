package org.example.assignment3;

import java.util.*;

public class Graph {
    private Map<Integer, Set<Integer>> parents;
    private Map<Integer, Set<Integer>> children;

    public Graph() {
        parents = new HashMap<>();
        children = new HashMap<>();
    }

    public Map<Integer, Set<Integer>> getParents() {
        return parents;
    }

    public Map<Integer, Set<Integer>> getChildren() {
        return children;
    }

    public void addNode(int nodeId) {
        parents.put(nodeId, new HashSet<>());
        children.put(nodeId, new HashSet<>());
    }

    public Set<Integer> getImmediateParent(int nodeId) {
        return parents.getOrDefault(nodeId, new HashSet<>());
    }

    public Set<Integer> getImmediateChildren(int nodeId) {
        return children.getOrDefault(nodeId, new HashSet<>());
    }

    public Set<Integer> getAncestors(int nodeId) {
        Set<Integer> ancestor = new HashSet<>();
        Queue<Integer> queueNodeId = new LinkedList<>();
        queueNodeId.add(nodeId);
        while (!queueNodeId.isEmpty()) {
            int curr = queueNodeId.poll();
            ancestor.addAll(parents.getOrDefault(curr, new HashSet<>()));
            queueNodeId.addAll(parents.getOrDefault(curr, new HashSet<>()));
        }
        return ancestor;
    }

    public Set<Integer> getDescends(int nodeId) {
        Set<Integer> descends = new HashSet<>();
        Queue<Integer> queueNodeId = new LinkedList<>();
        queueNodeId.add(nodeId);
        while (!queueNodeId.isEmpty()) {
            int curr = queueNodeId.poll();
            descends.addAll(children.getOrDefault(curr, new HashSet<>()));
            queueNodeId.addAll(children.getOrDefault(curr, new HashSet<>()));
        }
        return descends;
    }

    public void deleteDependency(int parentId, int childId) {
        Set<Integer> parentSet = parents.get(childId);
        Set<Integer> childrenset = children.get(parentId);
        if (parentSet != null) {
            parentSet.remove(parentId);
        }
        if (childrenset != null) {
            childrenset.remove(childId);
        }
    }

    public void deleteNode(int nodeId) {
        parents.remove(nodeId);
        children.remove(nodeId);
        for (var child : children.values()) {
            child.remove(nodeId);
        }
        for (var parent : parents.values()) {
            parent.remove(nodeId);
        }
    }

    public void addDependency(int parentId, int childId) throws IllegalArgumentException{
        Set<Integer> ancestor = getAncestors(childId);
        if (!ancestor.contains(parentId)) {
            Set<Integer> parentSet = parents.get(childId);
            if (parentSet == null) {
                parentSet = new HashSet<>();
                parents.put(childId, parentSet);
            }
            parentSet.add(parentId);
            Set<Integer> childrenSet = children.get(parentId);
            if (childrenSet == null) {
                childrenSet = new HashSet<>();
                children.put(parentId, childrenSet);
            }
            childrenSet.add(childId);
        } else {
            throw new IllegalArgumentException("Adding this dependency will create a cycle");
        }
    }
}
