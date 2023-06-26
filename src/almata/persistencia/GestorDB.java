package almata.persistencia;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDB {
	private static Connection connexioActual=null;
	
	static {
		try {
			Class.forName(Configuracio.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	private static Connection getConnexio() {
		if(connexioActual==null) {
			try {
					connexioActual = DriverManager.getConnection(getCadenaConnexio(), Configuracio.USUARI,
						Configuracio.PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connexioActual;
	}
	
	private static String getCadenaConnexio() {
		return Configuracio.PROTOCOL + Configuracio.IP_SERVIDOR + ":" + Configuracio.PORT_BBDD + "/"
				+ Configuracio.BBDD + Configuracio.NO_USE_SSL;
	}
	
	private static void closeConnexio() {
		try {
			connexioActual.close();
			connexioActual=null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void modificaDB(String sql) {
		try (Statement sentencia = getConnexio().createStatement();
		) {
			sentencia.executeUpdate(sql);
		} catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnexio();
		}
	}
 
	public static <T> List<T> consultaDB(String sql, Class<T> classe) {
		List<T> llistaObjectes = null;
		try (  	Statement sentencia = getConnexio().createStatement();
				ResultSet files = sentencia.executeQuery(sql)) {
			llistaObjectes = resultSetToCollection(files, classe);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}  finally {
			closeConnexio();
		}
		return llistaObjectes;
	}
	

	@SuppressWarnings("unchecked")
	private static <T> List<T> resultSetToCollection(ResultSet files, Class<T> classe)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, InvocationTargetException {
		Method[] metodes = null;
		Parameter[] p = null;
		T objecte = null;
		List<T> llistaObjectes = new ArrayList<T>();
		while (files.next()) {
			try {
				objecte = (T) Class.forName(classe.getName()).getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			metodes = objecte.getClass().getDeclaredMethods();
			for (int i = 0; i < metodes.length; i++) {
				if (metodes[i].getName().startsWith("set")) {
					p = metodes[i].getParameters();
					switch (p[0].getType().getName()) {
					case "int":
						metodes[i].invoke(objecte, files.getInt(metodes[i].getName().substring(3)));
						break;
					case "boolean":
						metodes[i].invoke(objecte, files.getBoolean(metodes[i].getName().substring(3)));
						break;
					case "double":
						metodes[i].invoke(objecte, files.getDouble(metodes[i].getName().substring(3)));
						break;
					case "java.lang.String":
						metodes[i].invoke(objecte, files.getString(metodes[i].getName().substring(3).trim()));
						break;
					case "java.time.LocalDate":
						Date d = files.getDate(metodes[i].getName().substring(3));
						LocalDate ld = d.toLocalDate();
						metodes[i].invoke(objecte, ld);
						break;
					}
				}
			}
			llistaObjectes.add(objecte);
		}
		return llistaObjectes;
	}

	

}
