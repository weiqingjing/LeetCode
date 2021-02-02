package com.qing.leet.code.leet.solution.recursion;

public class EightQueens {

    public static int QueenNum = 4;

    static int[] result = new int[QueenNum];

    public static void cal8Queens(int row) {
        if (row == QueenNum) {
            printQueens(result);
        }

        for (int column = 0; column < QueenNum; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < QueenNum) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < QueenNum; ++row) {
            for (int column = 0; column < QueenNum; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        cal8Queens(0);
    }

}
