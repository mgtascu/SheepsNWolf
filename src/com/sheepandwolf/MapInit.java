package com.sheepandwolf;

import java.io.*;
import java.util.Scanner;

public class MapInit {

    String filePath = "src/board_init.txt";
    String line;
    char board[][] = new char[100][100];

    public void readFile() {

        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(fileInputStream);
            int currentLine = 0;
            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    board[currentLine][j] = line.charAt(j);
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
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}