package org.example.assignment3;

import java.util.Scanner;

public class DependencyGraphOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graphObject = new Graph();
        while (true) {
            System.out.println("\n1.Add node\n2.Find immediate parent\n3.Find immediate children\n4.Add dependency\n5." +
                    "Delete dependency\n6.Get ancestors\n7.Get descends\n8.Delete node\n9.Exit");
            System.out.print("Enter option : ");
            int choosenOption = sc.nextInt();
            if (choosenOption == 1) {
                System.out.print("\nEnter nodeId to be added : ");
                int nodeId = sc.nextInt();
                graphObject.addNode(nodeId);
                System.out.println("Added");
            } else if (choosenOption == 2) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nParent : " + graphObject.getImmediateParent(nodeId));
            } else if (choosenOption == 3) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nChildren : " + graphObject.getImmediateChildren(nodeId));
            } else if (choosenOption == 4) {
                System.out.print("\nEnter parentId : ");
                int parentId = sc.nextInt();
                System.out.print("\nEnter childId : ");
                int childId = sc.nextInt();
                graphObject.addDependency(parentId, childId);
                System.out.println("Dependency Added");
            } else if (choosenOption == 5) {
                System.out.print("\nEnter parentId : ");
                int parentId = sc.nextInt();
                System.out.print("\nEnter childId : ");
                int childId = sc.nextInt();
                graphObject.deleteDependency(parentId, childId);
                System.out.println("Dependency Deleted");
            } else if (choosenOption == 6) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nAncestors : " + graphObject.getAncestors(nodeId));
            } else if (choosenOption == 7) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                System.out.print("\nDescends : " + graphObject.getDescends(nodeId));
            } else if (choosenOption == 8) {
                System.out.print("\nEnter nodeId : ");
                int nodeId = sc.nextInt();
                graphObject.deleteNode(nodeId);
                System.out.print("\nDeleted");
            } else if (choosenOption == 9) {
                return;
            } else {
                System.out.println("Print select from given options.(ex: 1, 2, etc)");
                sc.nextLine();
            }
        }
    }
}
