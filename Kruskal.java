package com.company;

import java.util.*;

public class Kruskal {
    public static double MST(ArrayList<Node> arr, ArrayList<Edge> edges) {
        Collections.sort(edges);
        int i = 0;
        double result = 0;
        while (i <  edges.size()) {
            int x = edges.get(i).first;
            int y = edges.get(i).second;
            Node rX = find(arr.get(x));
            Node rY = find(arr.get(y));
            if (rX != rY) {
                result += edges.get(i).length;
                if (rX.z < rY.z) {
                    rX.parent = rY;
                } else {
                    rY.parent = rX;
                    if (rY.z == rX.z && rX != rY) {
                        rX.z++;
                    }
                }
            }
            i++;
        }
        return result;
    }

    public static Node find(Node x) {
        if (x.parent == x) {
            return x;
        } else {
            return x.parent = find(x.parent);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please pace input values here...");
        System.out.println("Matrix size:");

        int n = in.nextInt();
        System.out.println("Matrix:");
        int i, j, count = 0;



        ArrayList<Node> result = new ArrayList<>();

        for (i = 0; i < n; i++) {
            result.add(new Node());
            result.get(i).x = in.nextInt();
            result.get(i).y = in.nextInt();
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                edges.add(new Edge());
                edges.get(count).first = i;
                edges.get(count).second = j;
                edges.get(count).length = Math.sqrt((result.get(j).x-result.get(i).x)*(result.get(j).x-result.get(i).x)+(result.get(j).y-result.get(i).y)*(result.get(j).y-result.get(i).y));
                count++;
            }
        }

        System.out.println("Minimum total weight:");
        System.out.printf("%.2f", MST(result, edges));

    }
}