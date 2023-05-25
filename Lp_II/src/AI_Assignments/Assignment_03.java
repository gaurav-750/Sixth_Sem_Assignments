package AI_Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment_03 {
    public static void main(String[] args) {

//        TODO Selection Sort
//        int[] arr = {5, 2, 1, 11, 19, 13};
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));

//        TODO Prims Algorithm
        int[][] adMat = takeInput();
//        primsAlgo(adMat);

        




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
