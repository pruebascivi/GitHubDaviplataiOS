package daviplata.nacional.iOS.utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credenciales extends Properties {
	
	private static final long serialVersionUID = 1L;
	
	public static Properties propertiesAlm() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/almcredentials.properties");
			
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}
	
	public static Properties propertiesWebs() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/credenciales_web.properties");
			
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}
	
	public static Properties parametrosGenerales() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/parametros.properties");
			
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}
	
	
	
	
	
	//*****************************************************************************
	

	public static Properties properties() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "\\almcredentials.properties");
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}
	public static Properties propertiesRegistro() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "\\credentialsRegistroLatinia.properties");
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}
	

	
	public static Properties propertiesStratus() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "\\stratuscredentials.properties");
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}

	
	

}
