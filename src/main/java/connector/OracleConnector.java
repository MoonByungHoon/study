package connector;

import java.sql.Connection;

public class OracleConnector implements DBConnector {
	@Override
	public Connection makeConnection() {
		System.out.println("오라클 DB연결 시도!!");
		System.out.println("코드 대충 실행!");
		System.out.println("오라클 DB 연결 성공!");

		return null;
	}

}
