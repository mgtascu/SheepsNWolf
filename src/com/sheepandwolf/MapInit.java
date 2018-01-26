package com.sheepandwolf;

import java.io.*;
import java.util.Scanner;

public class MapInit {

    private String initFilePath = "src/board_init.txt";
    private String playFilePath = "src/board_play.txt";
    private String line;
    private char board[][] = new char[100][100];

    public void readFile(String readFile) {

        try {

            FileInputStream fileInputStream = new FileInputStream(readFile);
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

    public void printFile(String printFile) throws IOException {

        try {

            FileWriter fileWriter = new FileWriter(printFile);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    fileWriter.write(board[i][j]);
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
            //System.out.println("Successfully written");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void showMap() {

        System.out.println("\n###################\n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initEmptyBoard() throws IOException {

        readFile(initFilePath);
        showMap();
        printFile(playFilePath);
    }


    public void spawnWolf(int x, int y) throws IOException {

        readFile(playFilePath);
        boolean check = true;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (board[i][j] == 'W') {
                    check = false;
                }
            }
        }
        if (check) {
            board[x][y] = 'W';
            printFile(playFilePath);
            showMap();
        } else {
            System.out.println("Wolf already spawned");
        }
    }

    public void spawnSheep(int x, int y) throws IOException {
        //board[x][y] = 'S';

        readFile(playFilePath);

        int sheepCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (board[i][j] == 'S') {
                    sheepCount++;
                }
            }
        }
        if (sheepCount < 4 && board[x][y] != 'S' && board[x][y] != 'W') {
            board[x][y] = 'S';
            printFile(playFilePath);
            showMap();
        } else if (board[x][y] == 'S' || board[x][y] == 'W') {
            System.out.println("Spot is already used");
        } else {
            System.out.println("You have spawned the maximum number of sheep");
        }

    }
}