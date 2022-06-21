package main;

import java.util.Scanner;

import viewer.UserViewer;

public class MovieMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserViewer uv = new UserViewer(sc);

		uv.showMain();
	}

}
