package conexiones;

import java.sql.*;

public class Mysql {

	public Connection conex_mysql;
	public Statement estSQL;
	public ResultSet consulta;
	public String consultaString = "";
	
	public Mysql(){
		
		try{

			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conex_mysql = DriverManager.getConnection("jdbc:odbc:MLM", "root", "mlmexico55");
		    	estSQL = conex_mysql.createStatement();*/

			Class.forName("com.mysql.jdbc.Driver").newInstance();
				conex_mysql = DriverManager.getConnection("jdbc:mysql://10.16.0.8/mlm", "root", "mlmexico55");
				estSQL = conex_mysql.createStatement();


				//conex2 = DriverManager.getConnection("jdbc:odbc:MLM2", "root", "root");
		    	//estSQL2 = conex2.createStatement();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet conexionSimple(String query){

		try{
			    //System.out.println("query: "+query);
		    	estSQL = conex_mysql.createStatement();

			    consulta = estSQL.executeQuery(query);

		}catch(Exception e) {
			e.printStackTrace();
		}

			return consulta;

	}

	public String consultaSimple(String query){

		try{
			    //System.out.println("query: "+query);
		    	estSQL = conex_mysql.createStatement();

			    consulta = estSQL.executeQuery(query);
			    consulta.next();
				consultaString = consulta.getString(1);

		}catch(Exception e) {
			e.printStackTrace();
		}

			return consultaString;

	}


	public void insertarSimple(String consulta){

		try{
			    //estSQL = conex_mysql.createStatement();
			    int a = estSQL.executeUpdate(consulta);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void cerrar(){

			try{

				if(estSQL!=null)
					estSQL.close();

				if(conex_mysql!=null)
					conex_mysql.close();
                                
			}catch(Exception e) {

					e.printStackTrace();

			}

	}
	
}
