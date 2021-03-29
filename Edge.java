package com.company;

class Edge implements Comparable<Edge> {
    int first, second;
    double length;

    public int compareTo(Edge arr) {
        if (this.length > arr.length) {
            return 1;
        } else if (this.length == arr.length) {
            return 0;
        } else {
            return -1;
        }
    }
}
