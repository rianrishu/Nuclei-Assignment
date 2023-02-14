package org.example.assignment3;

import java.util.Scanner;

public class DependencyGraphOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        while (true) {
            System.out.println("\n1.Add node\n2.Find immediate parent\n3.Find immediate children\n4.Add dependency\n5." +
                    "Delete dependency\n6.Get ancestors\n7.Get descends\n8.Delete node\n9.Exit");
            System.out.print("Enter option : ");
            int opt = sc.nextInt();
            if (opt == 1) {
                System.out.print("\nEnter nodeId to be added : ");
                int nodeId = sc.nextInt();
                graph.addNode(nodeId);
                System.out.println("Added");
            } else if (opt == 2) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nParent : " + graph.getImmediateParent(nodeId));
            } else if (opt == 3) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nChildren : " + graph.getImmediateChildren(nodeId));
            } else if (opt == 4) {
                System.out.print("\nEnter parentId : ");
                int parentId = sc.nextInt();
                System.out.print("\nEnter childId : ");
                int childId = sc.nextInt();
                graph.addDependency(parentId, childId);
                System.out.println("Dependency Added");
            } else if (opt == 5) {
                System.out.print("\nEnter parentId : ");
                int parentId = sc.nextInt();
                System.out.print("\nEnter childId : ");
                int childId = sc.nextInt();
                graph.deleteDependency(parentId, childId);
                System.out.println("Dependency Deleted");
            } else if (opt == 6) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nAncestors : " + graph.getAncestors(nodeId));
            } else if (opt == 7) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nDescends : " + graph.getDescends(nodeId));
            } else if (opt == 8) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                graph.deleteNode(nodeId);
                System.out.print("\nDeleted");
            } else if (opt == 9) {
                return;
            } else {
                System.out.println("Print select from given options.(ex: 1, 2, etc)");
                sc.nextLine();
            }
        }
    }
}
