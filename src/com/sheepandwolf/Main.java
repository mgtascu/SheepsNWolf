package com.sheepandwolf;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        MapInit mapInit = new MapInit();
        //mapInit.readFile();
        mapInit.initEmptyBoard();
        mapInit.spawnWolf(2,4);
        //mapInit.spawnWolf(2,6);
        mapInit.spawnSheep(1,1);
        mapInit.spawnSheep(2,2);
        mapInit.spawnSheep(3,3);
        mapInit.spawnSheep(4,4);
        //mapInit.spawnSheep(2,4);
    }
}
