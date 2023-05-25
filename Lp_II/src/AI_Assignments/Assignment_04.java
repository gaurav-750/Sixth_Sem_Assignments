package AI_Assignments;

import java.util.Scanner;

public class Assignment_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];
        nQueens(board, 0, 0, n);

    }

    private static void nQueens(char[][] board, int row, int col, int n) {
//        base case
        if (col >= n)
            return;
        if (row == n){
            printChessBoard(board);
            return;
        }

        if (canQueenBePlacedHere(board, row, col)){
            board[row][col] = 'Q';
            nQueens(board, row+1, 0, n);
        }

        board[row][col] = '.';
        nQueens(board, row, col+1, n);
    }

    private static void printChessBoard(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean canQueenBePlacedHere(char[][] chessBoard, int row, int col) {
//        check if there's any attack to the Queen if placed at chessBoard[row][col]
//        from up
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q')
                return false;
        }

//        from left diagonal
        int i = row-1, j = col-1;
        while (i >= 0 && j >= 0){
            if (chessBoard[i][j] == 'Q')
                return false;
            i--; j--;
        }

//        from right diagonal
        i = row-1; j = col+1; int n = chessBoard.length-1;
        while (i >= 0 && j <= n){
            if (chessBoard[i][j] == 'Q')
                return false;
            i--; j++;
        }
        return true;
    }
}
