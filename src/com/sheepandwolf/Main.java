package com.sheepandwolf;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MapInit mapInit = new MapInit();
        mapInit.readFile();
        //mapInit.createMatrix();
        mapInit.setWolfPos(2,4);
    }
}
