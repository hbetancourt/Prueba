package conexiones;

import java.sql.*;

public class Teradata {

	Connection conex;
	Statement estSQL;
	Statement estSQL_global;
	double totalFacturado;
	String resultado;
	ResultSet RsResultado;
	
	public Teradata(){

		try{

			Class.forName("com.teradata.jdbc.TeraDriver");
			Connection conex = DriverManager.getConnection(
	  		"jdbc:teradata://172.16.28.11/","appmlm","MeXico#55");

				estSQL_global = conex.createStatement();

			}catch(Exception e) {

				System.out.println(e.getMessage());

			}

	}
	
	public String consultaSimple(String consulta){

		try{

			ResultSet rs = estSQL_global.executeQuery(consulta);
			rs.next();
			resultado = rs.getString(1);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			return resultado;
	}

	public ResultSet conexionSimple(String consulta){

		try{

			RsResultado = estSQL_global.executeQuery(consulta);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			return RsResultado;
	}

	public void insertarSimple(String consulta){

		try{
			    //estSQL = conex_mysql.createStatement();
			    int a = estSQL_global.executeUpdate(consulta);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
        
	public void cerrar(){

			try{

				if(estSQL_global!=null)
					estSQL_global.close();

				if(conex!=null)
					conex.close();
                                
			}catch(Exception e) {

					System.out.println(e.getMessage());

			}

	}
	
}
