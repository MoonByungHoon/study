package main;

import java.util.Scanner;

import connector.DBConnector;
import connector.MySqlConnector;
import viewer.UserViewer;

public class Main {

	public static void main(String[] args) {
		DBConnector conn = new MySqlConnector();
		Scanner sc = new Scanner(System.in);

		UserViewer uv = new UserViewer(sc, conn);

		uv.showMenu();
	}

}
