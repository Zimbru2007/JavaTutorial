package md.connect;

import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		int conresult = BaseConnection.connect("jdbc:mysql://localhost:3306/Javateam", "javateam", "haimoldova");
		// TODO Auto-generated method stub
		switch (conresult) {
		case BaseConnection.CONNECTION_OK:
			System.out.println("Connection was successful");
			break;
		case BaseConnection.UNKN_DB:
			System.out.println("Unknown database");
			break;
		case BaseConnection.WRONG_CREDENTIALS:
			System.out.println("Wrong User or password ");
			break;
		case BaseConnection.UNKN_ERROR:
			System.out.println("Unknown error");
			break;
		case BaseConnection.UNREACH_DB:
			System.out.println("Unreachable database");
			break;
		}
		String usersName="Users1";
		String[] usersFields={"ID","Full_Name","Password","Birth_day"};
		String[] usersFieldsTypes={"Integer","varchar(50)","varchar(30)","Date"};
		String[] usersValues={"2","'Filat Vlad'","'Plahathebest2'","'1971/12/31'"};
		if(!BaseConnection.tableExist(usersName))
		{
			BaseConnection.createTable(usersName,usersFields ,usersFieldsTypes );
		}
		
		for (int i=0;i<10;i++) {
			usersValues[0]=""+i;
			BaseConnection.insertSQL(usersName, usersFields, usersValues);
		}
		 ResultSet rs = BaseConnection.runSql(usersName, usersFields,null,null);
		 BaseConnection.printResult(rs,"|");
		//BaseConnection.printResult(BaseConnection.runSql(usersName, usersFields,null,null),"|"); 
		
	}

}
