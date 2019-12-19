import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class MariaDBTest {

	private static final String DBDRIVER ="org.mariadb.jdbc.Driver";
	private static final String DBURL ="jdbc:mariadb://localhost:3306/test";
	private static final String USER ="root";
	private static final String PASSWORD ="gy@19780117";

	private static Connection m_objConn = null;
	private static Statement m_objStmt = null;
	
	private static ResultSet m_objRes = null;
	
	public static void ExitDB() {
		
		if((m_objStmt == null ) || (m_objConn == null))
			return ;
		
		try {
			m_objConn.close();
			m_objConn = null;
			
			m_objStmt.close();
			m_objStmt = null;
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void InitEnv() {
		try {
			Class.forName(DBDRIVER);
			
			Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
			
			m_objConn = conn;
			System.out.println(conn);
			
			Statement stmt = conn.createStatement();
			
			m_objStmt = stmt;
			
		
		
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void mariaDBTest() {
		
		try {
			Class.forName(DBDRIVER);
			
			Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
			
			System.out.println(conn);
			
			Statement stmt = conn.createStatement();
			
			
			String strSQL = "Create table hz(id integer,name varchar(8),remark text,constraint pk_name primary key(id))";
			
			int len = stmt.executeUpdate(strSQL);
			
			System.out.println("rows : "+  len + " " );
			
			stmt.close();
			
			conn.close();
		
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	// Create table hz(id integer,name varchar(8),remark text,constraint pk_name primary key(id))
	// insert into hz(name,remark)values('name','value');
	public static void execSQL(String sql) {
		
		if((m_objStmt == null ) || (m_objConn == null))
			return ;
		
		try {
		
			int len = m_objStmt.executeUpdate(sql);
			
			System.out.println("rows : "+  len + " " );
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
public static void execBatchSQL() {
		
		if((m_objStmt == null ) || (m_objConn == null))
			return ;
		
		
		try {
			
			m_objStmt.addBatch("insert into hz(id,name,remark)values(20,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(21,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(22,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(23,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(24,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(25,'name','value');");
		
			int len[] = m_objStmt.executeBatch();
			
			System.out.println("rows : "+  Arrays.toString(len) );
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
	

	public static void transactionTest() {
	
		if((m_objStmt == null ) || (m_objConn == null))
			return ;
		
		
		try {

			m_objConn.setAutoCommit(false);
			
			m_objStmt.addBatch("insert into hz(id,name,remark)values(20,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(21,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(22,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(23,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(24,'name','value');");
			m_objStmt.addBatch("insert into hz(id,name,remark)values(25,'name','value');");
		
			int len[] = m_objStmt.executeBatch();
			
			System.out.println("rows : "+  Arrays.toString(len) );
	
			m_objConn.commit();
			
		}catch(Exception exp) {
			exp.printStackTrace();
			try {
				m_objConn.rollback();
			}catch(Exception exp1) {
				exp1.printStackTrace();
			}
		}
		
	}

	public static void querySQL(String sql) {
		if((m_objStmt == null ) || (m_objConn == null))
			return ;
		
		try {
			
			m_objRes  = m_objStmt.executeQuery(sql);
			
			while(m_objRes.next()) {
				int id = m_objRes.getInt("id");
				String name = m_objRes.getString("name");
				String value = m_objRes.getString("remark");
				
				System.out.println(id  + " " + name + " " + value );
			}
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	// select id,name,remark fro hz where id > ?;
	public static void prepareStatementSQL(String sql,int idval) {
		if((m_objConn == null))
			return ;
		
		try {
			
		 	PreparedStatement pstmt = m_objConn.prepareStatement(sql);
			
		 	pstmt.setInt(1, idval);
			
			m_objRes  = pstmt.executeQuery();
			
			while(m_objRes.next()) {
				int id = m_objRes.getInt("id");
				String name = m_objRes.getString("name");
				String value = m_objRes.getString("remark");
				
				System.out.println(id  + " " + name + " " + value );
			}
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	
	
}
