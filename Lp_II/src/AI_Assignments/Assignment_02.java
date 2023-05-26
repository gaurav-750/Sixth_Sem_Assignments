package AI_Assignments;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment_02 {
    private static int g = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int[] start = new int[9], goal = {1, 2, 3, 4, 5, 6, 7, 8, -1};
            System.out.println("Enter the start state:");
            for (int i = 0; i < 9; i++) {
                start[i] = sc.nextInt();
            }

            print8Puzzle(start);
            solve8Puzzle(start, goal);
        }catch (InputMismatchException e){
            System.out.println("Please enter numbers only!");
        }

    }

    private static void solve8Puzzle(int[] start, int[] goal) {
        g++;

        moveTile(start, goal);
        print8Puzzle(start);

        int f = heuristic(start, goal);
        if (f == g){
            System.out.println("Solved in " + g + " number of trials!");
            return;
        }

        solve8Puzzle(start, goal);
    }

    private static void moveTile(int[] start, int[] goal) {
        //find the empty tile position
        int emptyTileIndex = 0;
        for (int i = 0; i < 9; i++) {
            if (start[i] == -1) {
                emptyTileIndex = i;
                break;
            }
        }
        System.out.println("emptyTileIndex = " + emptyTileIndex);


        //Make 4 Arrays:
        int[] temp1 = Arrays.copyOf(start, 9);
        int[] temp2 = Arrays.copyOf(start, 9);
        int[] temp3 = Arrays.copyOf(start, 9);
        int[] temp4 = Arrays.copyOf(start, 9);
        int f1 = Integer.MAX_VALUE,
            f2 = Integer.MAX_VALUE,
            f3 = Integer.MAX_VALUE,
            f4 = Integer.MAX_VALUE;

        int row = emptyTileIndex / 3,
            col = emptyTileIndex % 3;

        if (col >= 1) {
            moveLeft(temp1, emptyTileIndex);
            f1 = heuristic(temp1, goal);
        }

        if (col+1 < 3){
            moveRight(temp2, emptyTileIndex);
            f2 = heuristic(temp2, goal);
        }

        if (row+1 < 3){
            moveDown(temp3, emptyTileIndex);
            f3 = heuristic(temp3, goal);
        }

        if (row >= 1){
            moveUp(temp4, emptyTileIndex);
            f4 = heuristic(temp4, goal);
        }

        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
        System.out.println(Arrays.toString(temp3));
        System.out.println(Arrays.toString(temp4));

        System.out.println(f1 + ", " + f2 + ", " + f3 + ", " + f4);

        //find the least heuristic state and make the move
        if (f1 <= f2 && f1 <= f3 && f1 <= f4)
            moveLeft(start, emptyTileIndex);
        else if (f2 <= f1 && f2 <= f3 && f2 <= f4)
            moveRight(start, emptyTileIndex);
        else if (f3 <= f1 && f3 <= f2 && f3 <= f4)
            moveDown(start, emptyTileIndex);
        else
            moveUp(start, emptyTileIndex);

    }

    private static int heuristic(int[] temp, int[] goal) {
        System.out.println(Arrays.toString(temp));
        int h = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (temp[i] == goal[j] && temp[i] != -1)
                    h += Math.abs((j-i) / 3) + Math.abs((j-i) % 3);
            }
        }

        System.out.println("h: " + h + ", g: " + g);
        return h + g;
    }

    private static void moveUp(int[] arr, int ind) {
        swap(arr, ind-3, ind);
    }

    private static void moveDown(int[] arr, int ind) {
        swap(arr, ind, ind+3);
    }

    private static void moveRight(int[] arr, int ind) {
        swap(arr, ind, ind+1);
    }

    private static void moveLeft(int[] arr, int ind) {
        swap(arr, ind-1, ind);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void print8Puzzle(int[] start) {
        for (int i = 0; i < start.length; i++) {
            if (i % 3 == 0)
                System.out.println();
            if (start[i] == -1)
                System.out.print("_" + " ");
            else
                System.out.print(start[i] + " ");
        }
        System.out.println();
    }
}
