package AI_Assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Assignment_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

//        TODO DFS
//        int[][] adMat = takeAdjacencyMatrixInput(sc, n, e);
        // DFS Using Adjacency Matrix
//        dfs(adMat); // TC -> O(n^2)

        // DFS using Adjacency List
        ArrayList<ArrayList<Integer>> adList = takeAdjacencyListInput(sc, n, e);
//        dfs2(adList); // TC -> O(n + e)


//        TODO BFS
//        bfs(adList); //bfs using adjacency List






    }

    private static void bfs(ArrayList<ArrayList<Integer>> adList) {
        int n = adList.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                breadthFirstSearch(i, adList, visited);
        }

    }

    private static void breadthFirstSearch(int i, ArrayList<ArrayList<Integer>> adList, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int v: adList.get(curr)){
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

    }

    private static void dfs2(ArrayList<ArrayList<Integer>> adList) {

        boolean[] visited = new boolean[adList.size()];
        for (int i = 0; i < adList.size(); i++) {
            if (!visited[i])
                depthFirstTraversal2(adList, i, visited);
        }

    }

    private static void depthFirstTraversal2(ArrayList<ArrayList<Integer>> adList, int i, boolean[] visited) {

        System.out.print(i + " ");
        visited[i] = true;

//        ArrayList<Integer> list = adList.get(i);
//        System.out.println("list = " + list);
        for (int v: adList.get(i)){
            if (!visited[v])
                depthFirstTraversal2(adList, v, visited);
        }

    }

    private static void dfs(int[][] adMat) {

        //make a visited array
        boolean[] visited = new boolean[adMat.length];

        //we may have components in graph, so we must check for every vertex
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                depthFirstTraversal(adMat, i, visited);
        }

    }

    private static void depthFirstTraversal(int[][] adMat, int i, boolean[] visited) {

        System.out.print(i + " ");
        visited[i] = true; //make the current vertex as visited

        for (int j = 0; j < adMat.length; j++) {
            if (adMat[i][j] == 1 && !visited[j])
                depthFirstTraversal(adMat, j, visited);
        }

    }

    private static ArrayList<ArrayList<Integer>> takeAdjacencyListInput(Scanner sc, int n, int e) {
        ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        //initializing list of size n
        for (int i = 0; i < n; i++)
            adList.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adList.get(v1).add(v2);
            adList.get(v2).add(v1);
        }
        return adList;
    }

    private static int[][] takeAdjacencyMatrixInput(Scanner sc, int n, int e) {


        int[][] adMat = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adMat[v1][v2] = 1;
            adMat[v2][v1] = 1;
        }
        return adMat;
    }
}
