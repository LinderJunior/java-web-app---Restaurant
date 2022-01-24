package DAO;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DataHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendario = Calendar.getInstance();
		java.sql.Date data = new java.sql.Date(calendario.getTime().getTime());
	
	
	System.out.println( "hora: " + data);

		

	}

}
