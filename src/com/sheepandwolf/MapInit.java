package com.sheepandwolf;

import java.io.*;
import java.util.Scanner;

public class MapInit {

    String filePath = "src/board_init.txt";

    char board[][] = new char[10][10];

    public void readFile() {

        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(fileInputStream);
            int currentLine = 0;
            while (scanner.hasNextLine()) {
                for (int j = 0; j < scanner.nextLine().length(); j++) {
                    board[currentLine][j] = scanner.nextLine().charAt(j+ currentLine*j);
                }
                currentLine++;
            }

            fileInputStream.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void createMatrix() {

        for (int row = 0; row < 10; row++)
            for (int col = 0; col < 10; col++) {
                System.out.println(board[row][col]);
        }

    }

    public void setWolfPos(int x, int y) {
        //board[x][y] = 'L';
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}