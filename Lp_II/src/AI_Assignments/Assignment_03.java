package AI_Assignments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair{
    int dist;
    int vertex;

    public Pair(int dist, int vertex) {
        this.dist = dist;
        this.vertex = vertex;
    }
}

public class Assignment_03 {
    public static void main(String[] args) {

//        TODO Selection Sort
        int[] arr = {5, 2, 1, 11, 19, 13};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

//        TODO Prims Algorithm
//        int[][] adMat = takeInput();
//        primsAlgo(adMat);

//        TODO Dijkstras Algorithm
        //From a source node, find shortest distance to all the other nodes
//        dijkstrasAlgorithm(adMat);




    }

    private static void dijkstrasAlgorithm(int[][] adMat) {
        int n = adMat.length;
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = Integer.MAX_VALUE;

        //this min heap will give us the vertex with minimum distance in O(logn)
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        minHeap.add(new Pair(0, 0));

        while (!minHeap.isEmpty()){
            Pair top = minHeap.poll(); //the vertex with the minimum distance
            int dist = top.dist, currVertex = top.vertex;

            for (int i = 0; i < n; i++) {
                if (adMat[currVertex][i] != 0) {// means there is a edge between them
                    if (distance[i] > (adMat[currVertex][i] + dist)) {
                        distance[i] = adMat[currVertex][i] + dist;

                        //add to min heap
                        minHeap.add(new Pair(distance[i], i));
                    }
                }
            }

        }

        System.out.println(Arrays.toString(distance));
    }

    private static void primsAlgo(int[][] adMat) {
        int n = adMat.length;
        //visited Array
        boolean[] visited = new boolean[n];

        //parent array
        int[] parent = new int[n];

        //weight array
        int[] weight = new int[n];
        for (int i = 1; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        int i = 0;
        while (i < n){
            int curr = findVertexWithMinimumWeight(weight, visited);
            visited[curr] = true;

            for (int j = 0; j < n; j++) {
                if (adMat[curr][j] != 0 && !visited[j]){
                    if (weight[j] > adMat[curr][j]){
                        weight[j] = adMat[curr][j];
                        parent[j] = curr;
                    }
                }

            }

            i++;
        }

        printMST(parent, weight);
    }

    private static void printMST(int[] parent, int[] weight) {
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " " + i + ", " + weight[i]);
    }

    private static int findVertexWithMinimumWeight(int[] weight, boolean[] visited) {
        int minIndex = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < weight.length; i++) {
            if (weight[i] < min && !visited[i])
                minIndex = i;
        }
        return minIndex;
    }

    private static int[][] takeInput() {
        Scanner sc = new Scanner(System.in);
        // Taking Input:
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        // creating an adjacency Matrix for storing graph
        int[][] adMat = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            adMat[v1][v2] = weight;
            adMat[v2][v1] = weight;
        }
        return adMat;
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= (n-2); i++) {
            //find minimum in the remaining array
            int minIndex = findMinIndex(arr, i, n);
            swap(arr, i, minIndex);
        }

    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private static int findMinIndex(int[] arr, int s, int n) {
        int minIndex = s;
        for (int i = s; i < n; i++) {
            if (arr[i] < arr[minIndex])
                minIndex = i;
        }
        return minIndex;
    }
}
