package main;

import java.util.Scanner;

import connector.DBConnector;
import connector.MySqlConnector;
import viewer.UserViewer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DBConnector conn = new MySqlConnector();
		UserViewer userV = new UserViewer(sc, conn);

		userV.showIndex();

		sc.close();
	}
}
