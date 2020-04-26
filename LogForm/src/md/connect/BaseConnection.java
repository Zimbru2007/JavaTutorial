package md.connect;

import java.sql.*;

public class BaseConnection {

	public static final int SQL_OP = 0;
	public static final int DROP_OP = 1;
	public static final int UPD_OP = 2;
	public static final int CREATE_OP = 3;
	public static final int INSERT_OP = 4;
	
	public static final int CONNECTION_OK = 0;
	public static final int UNKN_DB = 1;
	public static final int UNREACH_DB = 4;
	public static final int UNKN_ERROR = 3;
	public static final int WRONG_CREDENTIALS = 2;
	
	
	private static Connection con = null;
	private static Statement stmt = null;

	public static String constructStmt(int oper, String tabName, String[] tabFields, String[] tabOptions,
			String addWhere, String orderBy) {
		String sql = "";
		switch (oper) {
		case BaseConnection.SQL_OP:
			sql = "SELECT \n";

			for (int i = 0; i < tabFields.length; i++) {
				sql = sql + tabFields[i];
				if (i != tabFields.length - 1) {
					sql += ",";
				}
			}
			sql += "\nFROM\n";
			sql += tabName;
			if (addWhere != null && !"".equals(addWhere)) {
				sql += "\nWHERE\n" + addWhere;
			}

			if (orderBy != null && !"".equals(orderBy)) {
				sql += "\nORDER BY\n" + orderBy;
			}
			break;
		case BaseConnection.CREATE_OP:
			if (tabFields.length != tabOptions.length) {
				break;
			}

			sql = "CREATE TABLE " + tabName + "(";

			for (int i = 0; i < tabFields.length; i++) {
				sql = sql + tabFields[i] + " " + tabOptions[i];
				if (i != tabFields.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
			break;
		case BaseConnection.DROP_OP:
			break;
		case BaseConnection.INSERT_OP:
			if (tabFields.length != tabOptions.length) {
				break;
			}
			sql = "INSERT INTO " + tabName + "(";
			for (int i = 0; i < tabFields.length; i++) {
				sql = sql + tabFields[i];
				if (i != tabFields.length - 1) {
					sql += ",";
				}
			}
			sql += ")VALUES (";
			for (int i = 0; i < tabOptions.length; i++) {
				sql = sql + tabOptions[i];
				if (i != tabOptions.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
			break;
		case BaseConnection.UPD_OP:
		}
		return sql;
	}

	public static int connect(String constr, String user, String password) {
		int returncode = BaseConnection.CONNECTION_OK; // Successful connection
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			BaseConnection.con = DriverManager.getConnection(constr, user, password);
			BaseConnection.stmt = BaseConnection.con.createStatement();
		} catch (SQLSyntaxErrorException e) {
			returncode = BaseConnection.UNKN_DB; // Unknown database

		} catch (SQLException e) {
			if (e.getMessage().contains("Communications link failure")) {
				returncode =  BaseConnection.UNREACH_DB; // Unreachable database
			} else {
				returncode = BaseConnection.WRONG_CREDENTIALS; // Wrong User or password
			}
		} catch (Exception e) {
			// e.printStackTrace();
			returncode = BaseConnection.UNKN_ERROR; // Unknown error
		}

		return returncode;

	}

	public static boolean tableExist(String tabName) {
		boolean ret = false;

		DatabaseMetaData dbm;
		try {
			dbm = BaseConnection.con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, tabName, null);
			if (tables.next()) {
				ret = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// check if "employee" table is there

		return ret;
	}

	public static void insertSQL(String tabName, String[] tabFields, String[] tabValues) {
		String sql = constructStmt(BaseConnection.INSERT_OP,tabName,tabFields,tabValues,null,null); 
		if (sql == null || "".equals(sql) ) {
			System.out.println("number of Fields do not match number of Values");
			return;
		}
		try { 
			stmt.executeUpdate(sql);
			//System.out.println("Info was inserted...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createTable(String tabName, String[] tabFields, String[] tabFieldsTypes) {
		String sql = constructStmt(BaseConnection.CREATE_OP,tabName,tabFields,tabFieldsTypes,null,null); 
		//System.out.println(sql);
		if (sql == null || "".equals(sql) ) {
			System.out.println("number of Fields do not match number of Types");
			return;
		}
		 
		try {
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet runSql(String tabName, String[] tabFields, String addWhere, String orderBy) {
		String sql = constructStmt(BaseConnection.SQL_OP,tabName,tabFields,null,addWhere,orderBy); 
		//System.out.println(sql);
		ResultSet rs=null;
		try {
			  rs = BaseConnection.stmt.executeQuery(sql);
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return rs;
	}
	
	public static void printResult(ResultSet rs,String delimiter) {
		try {
			// get number of columns in resultset
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			// print result set 
			while (rs.next()) {
				String line="";
	           for(int i=1; i <= columnsNumber; i++ ) {
	        	   line =line + rs.getObject(i).toString()+delimiter;
	           }
	           System.out.println(line);
	        }
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
