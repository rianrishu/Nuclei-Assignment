package org.example.assignment3;

import java.util.*;

public class Graph {
    Map<Integer, Set<Integer>> parents;
    Map<Integer, Set<Integer>> children;


    public Graph(){
        parents = new HashMap<>();
        children = new HashMap<>();
    }
    public void addNode(int nodeId){
        parents.put(nodeId, new HashSet<>());
        children.put(nodeId, new HashSet<>());
    }

    public Set<Integer> getImmediateParent(int nodeId){
        return parents.getOrDefault(nodeId, new HashSet<>());
    }

    public Set<Integer> getImmediateChildren(int nodeId){
        return children.getOrDefault(nodeId, new HashSet<>());
    }

    public Set<Integer> getAncestors(int nodeId){
        Set<Integer> ancestor = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(nodeId);
        while(!q.isEmpty()){
            int curr = q.poll();
            ancestor.addAll(parents.getOrDefault(curr, new HashSet<>()));
            q.addAll(parents.getOrDefault(curr, new HashSet<>()));
        }
        return ancestor;
    }

    public Set<Integer> getDescends(int nodeId){
        Set<Integer> descends = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(nodeId);
        while(!q.isEmpty()){
            int curr = q.poll();
            descends.addAll(children.getOrDefault(curr, new HashSet<>()));
            q.addAll(children.getOrDefault(curr, new HashSet<>()));
        }
        return descends;
    }

    public void deleteDependency(int parentId, int childId){
        Set<Integer> ps = parents.get(childId);
        Set<Integer> cs = children.get(parentId);
        if(ps != null){
            ps.remove(parentId);
        }
        if(cs != null){
            cs.remove(childId);
        }
    }

    public void deleteNode(int nodeId){
        parents.remove(nodeId);
        children.remove(nodeId);
        for(var cs : children.values()){
            cs.remove(nodeId);
        }
        for(var ps : parents.values()){
            ps.remove(nodeId);
        }
    }

    public void addDependency(int parentId, int childId){
        Set<Integer> ancestor = getAncestors(childId);
        if(!ancestor.contains(parentId)){
            Set<Integer> ps = parents.get(childId);
            if(ps == null){
                ps = new HashSet<>();
                parents.put(childId, ps);
            }
            ps.add(parentId);
            Set<Integer> cs = children.get(parentId);
            if(cs == null){
                cs = new HashSet<>();
                children.put(parentId, cs);
            }
            cs.add(childId);
        }
        else{
            throw new IllegalArgumentException("Adding this dependency will create a cycle");
        }
    }
}
