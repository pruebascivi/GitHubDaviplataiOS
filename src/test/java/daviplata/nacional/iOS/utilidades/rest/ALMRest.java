package daviplata.nacional.iOS.utilidades.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.net.util.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

import daviplata.nacional.iOS.utilidades.Credenciales;
import daviplata.nacional.iOS.utilidades.Evidencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class ALMRest {

	static Logger logger = Logger.getLogger(ALMRest.class.getName());
	static String urlAutenticacion = Credenciales.propertiesAlm().getProperty("alm.url")
			+ "/authentication-point/authenticate";
	static String urlEstadoAuth = Credenciales.propertiesAlm().getProperty("alm.url") + "/rest/site-session";
	static String urlTest = Credenciales.propertiesAlm().getProperty("alm.url") + "/rest/domains/"
			+ Credenciales.propertiesAlm().getProperty("alm.domain") + "/projects/"
			+ Credenciales.propertiesAlm().getProperty("alm.project") + "/tests";
	static String urlTestInstaces = Credenciales.propertiesAlm().getProperty("alm.url") + "/rest/domains/"
			+ Credenciales.propertiesAlm().getProperty("alm.domain") + "/projects/"
			+ Credenciales.propertiesAlm().getProperty("alm.project") + "/test-instances";
	static String urlRuns = Credenciales.propertiesAlm().getProperty("alm.url") + "/rest/domains/"
			+ Credenciales.propertiesAlm().getProperty("alm.domain") + "/projects/"
			+ Credenciales.propertiesAlm().getProperty("alm.project") + "/runs";
	static String user = Credenciales.propertiesAlm().getProperty("alm.user");
	static String userPassword = Credenciales.propertiesAlm().getProperty("alm.user.password");
	static String setTest = Credenciales.propertiesAlm().getProperty("alm.testset.id");

	static String cookies = "";

	/**
	 * Query para buscar un TestInstances con IDSet y IDCase.
	 * 
	 * @param idSetTest
	 * @param idTest
	 * @return
	 */
	public static String queryTestInstance(String idSetTest, String idTest) {
		logger.info("Generando Query");
		return "?query={cycle-id[" + idSetTest + "];test-id[" + idTest + "]}";
	}

	/**
	 * Query para buscar información con el set-test
	 * 
	 * @param idSetTest
	 * @return
	 */
	public static String querySetTest(String idSetTest) {
		logger.info("Generando Query");
		return "?query={cycle-id[" + idSetTest + "]}";
	}

	public static String querySetTest(String idSetTest, String status) {
		logger.info("Generando Query");
		return "?query={cycle-id[" + idSetTest + "];status['" + status + "']}";
	}

	/**
	 * Texto en JSON para cambiar un estado.
	 * 
	 * @param status
	 * @return
	 */
	public static String strChangeStatusJSON(String status) {
		logger.info("Generando request JSON para cambio de estado");
		return "{\r\n" + "    \"Fields\": [\r\n" + "        {\r\n" + "            \"Name\": \"status\",\r\n"
				+ "            \"values\": [\r\n" + "                {\r\n" + "                    \"value\": \""
				+ status + "\"\r\n" + "                }\r\n" + "            ]\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"Name\": \"subtype-id\",\r\n" + "            \"values\": [\r\n"
				+ "                {\r\n" + "                    \"value\": \"hp.qc.test-instance.MANUAL\"\r\n"
				+ "                }\r\n" + "            ]\r\n" + "        }\r\n" + "    ]\r\n" + "}";
	}

	/**
	 * Texto en JSON para cambiar el estado y la fecha de ejecución.
	 * 
	 * @param status
	 * @param fecha
	 * @return
	 */
	public static String strChangeStatusJSON(String status, Date fecha) {
		logger.info("Generando request JSON para cambio de estado");
		String day = fecha.getYear() + "-" + fecha.getMonth() + "-" + fecha.getDay();
		String hours = fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
		return "{\r\n" + "    \"Fields\": [\r\n" + "        {\r\n" + "            \"Name\": \"status\",\r\n"
				+ "            \"values\": [\r\n" + "                {\r\n" + "                    \"value\": \""
				+ status + "\"\r\n" + "                }\r\n" + "            ]\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"Name\": \"subtype-id\",\r\n" + "            \"values\": [\r\n"
				+ "                {\r\n" + "                    \"value\": \"hp.qc.test-instance.MANUAL\"\r\n"
				+ "                }\r\n" + "            ]\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"Name\": \"exec-date\",\r\n" + "            \"values\": [\r\n" + "                {\r\n"
				+ "                    \"value\": \"" + day + "\"\r\n" + "                }\r\n" + "            ]\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"Name\": \"exec-time\",\r\n"
				+ "            \"values\": [\r\n" + "                {\r\n" + "                    \"value\": \""
				+ hours + "\"\r\n" + "                }\r\n" + "            ]\r\n" + "        }\r\n" + "    ]\r\n"
				+ "}";

	}

	/**
	 * Texto en JSON para cambiar el estado y la fecha de ejecución.
	 * 
	 * @param status
	 * @param day
	 * @param hours
	 * @return
	 */
	public static String strChangeStatusJSON(String status, String day, String hours) {
		logger.info("Generando request JSON para cambio de estado");
		return "{\r\n" + "    \"Fields\": [\r\n" + "        {\r\n" + "            \"Name\": \"status\",\r\n"
				+ "            \"values\": [\r\n" + "                {\r\n" + "                    \"value\": \""
				+ status + "\"\r\n" + "                }\r\n" + "            ]\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"Name\": \"subtype-id\",\r\n" + "            \"values\": [\r\n"
				+ "                {\r\n" + "                    \"value\": \"hp.qc.test-instance.MANUAL\"\r\n"
				+ "                }\r\n" + "            ]\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"Name\": \"exec-date\",\r\n" + "            \"values\": [\r\n" + "                {\r\n"
				+ "                    \"value\": \"" + day + "\"\r\n" + "                }\r\n" + "            ]\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"Name\": \"exec-time\",\r\n"
				+ "            \"values\": [\r\n" + "                {\r\n" + "                    \"value\": \""
				+ hours + "\"\r\n" + "                }\r\n" + "            ]\r\n" + "        }\r\n" + "    ]\r\n"
				+ "}";

	}

	/**
	 * XML para generar una ejecución en ALM.
	 * 
	 * @param entities
	 * @param testId
	 * @param status
	 * @return
	 * @throws IOException
	 */
	public static String strNewRun(Entities entities, String testId, String status) throws IOException {
		logger.info("Generando request XML para correr la ejecución");
		String name = searchParameterOneField(entities, "name");
		String testInstances = searchParameterOneField(entities, "test-instance");
		String testCyclId = searchParameterOneField(entities, "testcycl-id");
		return "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>\r\n" + "<Entity Type='run'>\r\n"
				+ "<Fields>\r\n" + "<Field Name='name'><Value>" + name + "</Value></Field>\r\n"
				+ "<Field Name='test-instance'><Value>" + testInstances + "</Value></Field>\r\n"
				+ "<Field Name='testcycl-id'><Value>" + testCyclId + "</Value></Field> \r\n"
				+ "<Field Name='cycle-id'><Value>" + setTest + "</Value></Field>\r\n" + "<Field Name='test-id'><Value>"
				+ testId + "</Value></Field>\r\n"
				+ "<Field Name='subtype-id'><Value>hp.qc.run.MANUAL</Value></Field>\r\n"
				+ "<Field Name='status'><Value>" + status + "</Value></Field>\r\n" + "<Field Name='owner'><Value>"
				+ user + "</Value></Field> \r\n" + "</Fields>\r\n" + "<RelatedEntities/>\r\n" + "</Entity>";
	}

	/**
	 * Pasa un string a fecha
	 * 
	 * @param fecha
	 * @return
	 */
	public Date stringToDate(String fecha) {
		Date date = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formato.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return date;
	}

	/**
	 * Realiza el inicio de sesión en ALM.
	 * 
	 * @param user
	 * @param password
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void signInALM(String user, String password) throws ClientProtocolException, IOException {
		logger.info("Generando inicio de sesión en ALM");
		String url = Credenciales.propertiesAlm().getProperty("alm.url") + "/api/authentication/sign-in";
		HttpGet request = new HttpGet(url);
		String auth = user + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode == HttpStatus.SC_OK) {
			logger.info("Status: " + statusCode + "-Sign-in OK");
		} else {
			logger.info("Status: " + statusCode + "-none");
		}
		// assertThat(statusCode, equals(HttpStatus.SC_OK));
	}

	/**
	 * Realiza el cierre de sesión para ALM.
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void signOutALM() throws ClientProtocolException, IOException {
		logger.info("Generando cierre de sesión en ALM");
		String url = Credenciales.propertiesAlm().getProperty("alm.url") + "/api/authentication/sign-out";
		HttpGet request = new HttpGet(url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			logger.info("Status: " + statusCode + "-Sign-out OK");
		} else {
			logger.info("Status: " + statusCode + "-none");
		}
	}

	/**
	 * Busca un parametro dentro de una entidad.
	 * 
	 * @param entidad
	 * @param paramBusqueda
	 * @return
	 * @throws IOException
	 */
	public static String searchParameter(Entities entidad, String paramBusqueda) throws IOException {
		logger.info("Buscando parametro: " + paramBusqueda);
		List<String> IDs = new ArrayList<String>();
		String resp = null;
		System.out.println(entidad);
		if (entidad.getTotalResults() != 0) {
			int c = 1;
			for (Fields fields : entidad.getEntities()) {
				for (Values values : fields.getFields()) {
					if (values.getName().equalsIgnoreCase(paramBusqueda)) {
						if (entidad.getTotalResults() == 1) {
							resp = values.getValues().get(0).getValue();
						} else {
							logger.info("Error: Hay más de un test con ese nombre.");
							logger.info("ID del caso " + c + ": " + values.getValues().get(0).getValue());
							c++;
							IDs.add(values.getValues().get(0).getValue());
						}
					}
				}
			}
			if (entidad.getTotalResults() > 1) {
				resp = nuevaBusquedaIDTest(IDs);
			}
			if (null == resp) {
				logger.info("ERROR: ¡¡¡Hay mas de un caso encontrado!!!");
				throw new IOException("ERROR: ¡¡¡Hay mas de un caso encontrado!!!");
			}

		} else {
			logger.info("Error: No se encuentra el caso solicitado.");
		}
		return resp;
	}

	public static String searchParameterOneField(Entities entidad, String paramBusqueda) throws IOException {
		logger.info("Buscando parametro: " + paramBusqueda);
		String resp = null;
		if (entidad.getTotalResults() != 0) {
			Fields fields = entidad.getEntities().get(0);
			for (Values values : fields.getFields()) {
				if (values.getName().equalsIgnoreCase(paramBusqueda)) {
					resp = values.getValues().get(0).getValue();
				}
			}
		} else {
			logger.info("Error: No se encuentra el caso solicitado.");
		}
		return resp;
	}

	/**
	 * Realiza una busqueda mas avanzada con los datos obtenidos.
	 * 
	 * @param IDs
	 * @return
	 * @throws IOException
	 */
	public static String nuevaBusquedaIDTest(List<String> IDs) throws IOException {
		logger.info("Corriendo busqueda avanzada...");
		String res = "";
		int conta = 0;
		for (String idTest : IDs) {
			URL url = new URL(urlTestInstaces + queryTestInstance(setTest, idTest)
					+ "&fields=id,status,attachment,test-id,cycle-id");
			logger.info("Url del test-instance: " + urlTestInstaces + queryTestInstance(setTest, idTest));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection = conn(connection, "GET", cookies);
			Entities consultaTestInstace = getEntity(connection);
			if (consultaTestInstace.getTotalResults() > 0) {
				for (Fields fields : consultaTestInstace.getEntities()) {
					String sup = searchParameter(fields, "test-id");
					for (Values values : fields.getFields()) {
						if (values.getName().equalsIgnoreCase("cycle-id")
								&& values.getValues().get(0).getValue().equalsIgnoreCase(setTest)) {
							res = sup;
							System.out.println("El ID encontrado es: " + res);
							conta++;
						}
					}
				}
			} else {
				// IDs.remove(idTest);
			}
		}
		if (conta == 1) {
			return res;
		}
		return null;
	}

	/**
	 * Busca un parametro dentro de un Fields
	 * 
	 * @param fields
	 * @param paramBusqueda
	 * @return
	 */
	public static String searchParameter(Fields fields, String paramBusqueda) {
		logger.info("Buscando parametro: " + paramBusqueda);
		String resp = null;
		for (Values values : fields.getFields()) {
			if (values.getName().equalsIgnoreCase(paramBusqueda)) {
				resp = values.getValues().get(0).getValue();
			}
		}
		return resp;
	}

	/**
	 * Obtiene una entidad de la consulta realizada, normalmente usado para Metodos
	 * tipo GET.
	 * 
	 * @param connection
	 * @return
	 * @throws IOException
	 */
	public static Entities getEntity(HttpURLConnection connection) throws IOException {
		logger.info("Leyendo información de respuesta");
		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String output = "";
		String salida = "";
		while ((output = br.readLine()) != null) {
			salida = output + salida;
		}
		Gson gson = new Gson();
		Entities entities = gson.fromJson(salida.toString(), Entities.class);
		return entities;
	}

	/**
	 * Obtiene una fields de la consulta realizada, normalmente usado para Metodos
	 * tipo GET.
	 * 
	 * @param connection
	 * @return
	 * @throws IOException
	 */
	public static Fields getFields(HttpURLConnection connection) throws IOException {
		logger.info("Leyendo información de respuesta");
		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String output = "";
		String salida = "";
		while ((output = br.readLine()) != null) {
			salida = output + salida;
		}
		System.out.println(salida);
		Gson gson = new Gson();
		Fields fields = gson.fromJson(salida.toString(), Fields.class);
		return fields;
	}

	/**
	 * Escribe un request para una actualización o creacion, y lee el response de
	 * esta.
	 * 
	 * @param connection
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Entities writeReadEntity(HttpURLConnection connection, String request) throws IOException {
		logger.info("Codificando información de envio");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(request);
		out.close();
		Entities entities = getEntity(connection);
		return entities;
	}

	/**
	 * Escribe un request para una actualización o creacion, y lee el response de
	 * esta.
	 * 
	 * @param connection
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Fields writeReadFields(HttpURLConnection connection, String request) throws IOException {
		logger.info("Codificando información de envio");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(request);
		out.close();
		Fields fields = getFields(connection);
		return fields;
	}

	/**
	 * Cambia el estado del caso y sube la evidencia de este.
	 * 
	 * @param nameCase
	 * @param statusFinal
	 * @param pathAttach
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void changeStatusCase(String nameCase, String statusFinal, String pathAttach)
			throws ClientProtocolException, IOException {
		boolean cambioDeJSONConFecha = false;
		nameCase = buscarComasCasos(nameCase);
		logger.info("Iniciando cambio de estado en ALM");
		statusFinal = Evidencias.homologarEstadoCaso(statusFinal);
		nameCase = nameCase.replace(" ", "+");
		nameCase = "?query={name['" + nameCase + "']}";
		URL url = new URL(urlAutenticacion);
		logger.info("Entrando : " + urlAutenticacion + " :Sign-in OK");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		logger.info("Conexión establecida.");
		connection = conn(connection, "GET", null);
		String cookieLWSSO = connection.getHeaderField(3);// obtiene el valor de la cookie Lwss
		logger.info("Obteniendo cookies...");
		url = new URL(urlEstadoAuth);
		connection = (HttpURLConnection) url.openConnection();
		connection = conn(connection, "POST", "{}", cookieLWSSO);
		String cookieAuth = connection.getHeaderField(5);// Obtiene el valor de la cookie de// Autenticacion.
		logger.info("Autenticando cookies...");
		url = new URL(urlTest + nameCase + "&fields=id,subtype-id");// "&fields=id"
		logger.info("Url del Caso: " + urlTest + nameCase);
		connection = (HttpURLConnection) url.openConnection();
		cookies = cookieAuth + cookieLWSSO;
		connection = conn(connection, "GET", cookies);
		logger.info("Realizando consulta de caso :" + nameCase);
		Entities consultaTest = getEntity(connection);
		String idTest = searchParameter(consultaTest, "id");
		logger.info("ID del Caso: " + idTest);
		String IdTestCambio = idTest;
		url = new URL(urlTestInstaces + queryTestInstance(setTest, idTest) + "&fields=id,status,attachment,test-id");
		logger.info("Url del test-instance: " + urlTestInstaces + queryTestInstance(setTest, idTest));
		connection = (HttpURLConnection) url.openConnection();
		connection = conn(connection, "GET", cookieAuth + cookieLWSSO);
		Entities consultaTestInstace = getEntity(connection);
		String statusTest = searchParameter(consultaTestInstace, "status");
		String fecha[] = null;
		if (statusFinal.equals(statusTest)) {
			logger.info("Generando Ejecución para estado: " + idTest);
			url = new URL(urlRuns + queryTestInstance(setTest, idTest));
			logger.info("Url del Runs: " + urlRuns + queryTestInstance(setTest, idTest));
			connection = (HttpURLConnection) url.openConnection();
			connection = conn(connection, "GET", cookieAuth + cookieLWSSO);
			Entities consultaTestRuns = getEntity(connection);
			String requestRunsXML = strNewRun(consultaTestRuns, idTest, statusFinal);
			url = new URL(urlRuns + queryTestInstance(setTest, idTest));
			logger.info("Url del Runs para Post: " + urlRuns + queryTestInstance(setTest, idTest));
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection = conn(connection, "POST", cookieAuth + cookieLWSSO, "application/xml", "application/json",
					true);
			logger.info("Enviando información a ALM...");
			Fields cambioEstadoRun = writeReadFields(connection, requestRunsXML);
			String ultimaModificacion = searchParameter(cambioEstadoRun, "last-modified");
			logger.info("Ultima fecha de ejecución" + ultimaModificacion);
			fecha = ultimaModificacion.split(" ");
			cambioDeJSONConFecha = true;

		}
		logger.info("Estado del test: " + statusTest);
		url = new URL(urlTestInstaces + queryTestInstance(setTest, IdTestCambio));
		connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection = conn(connection, "PUT", cookieAuth + cookieLWSSO, "application/json", "application/json",
				true);

		logger.info("Enviando información a ALM...");
		Entities cambioEstado;
		if (cambioDeJSONConFecha) {
			String cambio = strChangeStatusJSON(statusFinal, fecha[0], fecha[1]);
			cambioEstado = writeReadEntity(connection, cambio);
		} else {
			 cambioEstado = writeReadEntity(connection, strChangeStatusJSON(statusFinal));
		}
		logger.info("Guardando respuesta en clases.");
		idTest = searchParameter(cambioEstado, "id");
		try {
			logger.info("Subiendo evidencias de: " + pathAttach);
			AttachFile(connection, Integer.parseInt(idTest), cookieAuth + cookieLWSSO, pathAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.disconnect();
		logger.info("Sesión cerrada");
	}

	/**
	 * Generar la conexión con el API, pero por defecto Content-Type ->JSON y Accept
	 * ->JSON.
	 * 
	 * @param connection
	 * @param requestMethod
	 * @param cookie
	 * @return
	 * @throws ProtocolException
	 */
	public static HttpURLConnection conn(HttpURLConnection connection, String requestMethod, String cookie)
			throws ProtocolException {
		logger.info("Realizando conexión");
		connection.setRequestMethod(requestMethod);
		// connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
		connection.setRequestProperty(HttpHeaders.AUTHORIZATION, credencialesAuth());
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
		if (null != cookie) {
			connection.setRequestProperty("Cookie", cookie);
		}
		return connection;
	}

	public static HttpURLConnection conn(HttpURLConnection connection, String requestMethod, String json, String cookie)
			throws ProtocolException {
		logger.info("Realizando conexión");
		connection.setRequestMethod(requestMethod);
		// connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
		connection.setRequestProperty(HttpHeaders.AUTHORIZATION, credencialesAuth());
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
		connection.setDoOutput(true);
		if (null != cookie) {
			connection.setRequestProperty("Cookie", cookie);
		}
		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = json.getBytes("utf-8");
			os.write(input, 0, input.length);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}

	/**
	 * Generar la Conexión al API, pero necesita de un Content-Type y un Accept.
	 * 
	 * @param connection
	 * @param requestMethod
	 * @param cookie
	 * @param contentType
	 * @param accept
	 * @return
	 * @throws ProtocolException
	 */
	public static HttpURLConnection conn(HttpURLConnection connection, String requestMethod, String cookie,
			String contentType, String accept) throws ProtocolException {
		logger.info("Realizando conexion con los headers seleccionados");
		connection.setRequestMethod(requestMethod);
		// connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, contentType);
		connection.setRequestProperty(HttpHeaders.AUTHORIZATION, credencialesAuth());
		connection.setRequestProperty("Accept", accept);
		connection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
		if (null != cookie) {
			connection.setRequestProperty("Cookie", cookie);
		}
		return connection;
	}

	public static HttpURLConnection conn(HttpURLConnection connection, String requestMethod, String cookie,
			String contentType, String accept, boolean contentLength) throws ProtocolException {
		logger.info("Realizando conexion con los headers seleccionados");
		connection.setRequestMethod(requestMethod);
		if (contentLength) {
			connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, contentType);
		}
		connection.setRequestProperty(HttpHeaders.AUTHORIZATION, credencialesAuth());
		connection.setRequestProperty("Accept", accept);
		connection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
		if (null != cookie) {
			connection.setRequestProperty("Cookie", cookie);
		}
		return connection;
	}

	/**
	 * Generar la autenticación en bytes.
	 * 
	 * @return
	 */
	public static String credencialesAuth() {
		logger.info("Autenticando usuario de ALM");
		String auth = user + ":" + userPassword;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		return authHeader;
	}

	/**
	 * Genera los Byte del archivo de evidencia a subir.
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] prepararArchivo(File file) {
		logger.info("Preparando archivo seleccionado");
		FileInputStream fis = null;
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bArray;
	}

	/**
	 * Función que adjunta la evidencia dependiendo.
	 * 
	 * @param connection
	 * @param idCaso
	 * @param cookies
	 * @param pathFile
	 * @throws IOException
	 */
	public static void AttachFile(HttpURLConnection connection, int idCaso, String cookies, String pathFile)
			throws IOException {
		logger.info("Iniciando proceso para adjuntar archivo de evidecia");
		File file = new File(pathFile);
		logger.info("Autenticando cookies...");
		URL url = new URL(urlTestInstaces + "/" + idCaso + "/attachments");// "&fields=id"
		System.out.println("URL: " + url);
		logger.info("Url para adjuntar archivo: " + urlTestInstaces + "/" + idCaso + "/attachments");
		connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection = conn(connection, "POST", cookies, "application/octet-stream", "application/json",true);
		logger.info("Autenticando...");
		connection.setRequestProperty("slug", file.getName());
		System.out.println(file.getName());
		Fields fields = writeBytes(connection, file);
		logger.info("Subiendo archivo de evidencia");
		if (searchParameter(fields, "name").equals(file.getName())) {
			logger.info("Evidencia adjuntada.");
		} else {
			logger.info("Verificar evidencia del caso.");
		}

	}

	/**
	 * Realiza un request en byte, normalmente para uso del attachment.
	 * 
	 * @param connection
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Fields writeBytes(HttpURLConnection connection, File file) throws IOException {
		logger.info("Codificando información");
		OutputStream out = connection.getOutputStream();
		out.write(prepararArchivo(file));
		out.close();
		Fields fields = getFields(connection);
		return fields;
	}

	/**
	 * Genera un Informe en JSON de los casos para realizar metricas.
	 * 
	 * @throws IOException
	 */
	public static void generacionDataInforme() throws IOException {
		URL url = new URL(urlAutenticacion);
		logger.info("Entrando : " + urlAutenticacion + " :Sign-in OK");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		logger.info("Conexión establecida.");
		connection = conn(connection, "GET", null);
		String cookieLWSSO = connection.getHeaderField(3);// obtiene el valor de la cookie Lwss
		logger.info("Obteniendo cookies...");
		url = new URL(urlEstadoAuth);
		connection = (HttpURLConnection) url.openConnection();
		connection = conn(connection, "POST", "{}", cookieLWSSO);
		String cookieAuth = connection.getHeaderField(5);// Obtiene el valor de la cookie de// Autenticacion.
		logger.info("Autenticando cookies...");
		url = new URL(urlTestInstaces + querySetTest(setTest, "No+Run"));// "&fields=id" Casos no corridos
		logger.info("Url del Test: " + urlTestInstaces + querySetTest(setTest, "No+Run"));
		connection = (HttpURLConnection) url.openConnection();
		cookies = cookieAuth + cookieLWSSO;
		connection = conn(connection, "GET", cookies);
		Entities consultaTestSet = getEntity(connection);
		Long casosNoRun = consultaTestSet.getTotalResults();

		url = new URL(urlTestInstaces + querySetTest(setTest, "Passed"));// "&fields=id" Casos no corridos
		logger.info("Url del Test: " + urlTestInstaces + querySetTest(setTest, "Passed"));
		connection = (HttpURLConnection) url.openConnection();
		cookies = cookieAuth + cookieLWSSO;
		connection = conn(connection, "GET", cookies);
		consultaTestSet = getEntity(connection);
		Long casosPassed = consultaTestSet.getTotalResults();

		url = new URL(urlTestInstaces + querySetTest(setTest, "Failed"));// "&fields=id" Casos no corridos
		logger.info("Url del Test: " + urlTestInstaces + querySetTest(setTest, "Failed"));
		connection = (HttpURLConnection) url.openConnection();
		cookies = cookieAuth + cookieLWSSO;
		connection = conn(connection, "GET", cookies);
		consultaTestSet = getEntity(connection);
		Long casosFailed = consultaTestSet.getTotalResults();

		url = new URL(urlTestInstaces + querySetTest(setTest));// "&fields=id" Casos no corridos
		logger.info("Url del Test: " + urlTestInstaces + querySetTest(setTest));
		connection = (HttpURLConnection) url.openConnection();
		cookies = cookieAuth + cookieLWSSO;
		connection = conn(connection, "GET", cookies);
		consultaTestSet = getEntity(connection);
		Long casosTotal = consultaTestSet.getTotalResults();

		double porcentajePassed = casosPassed.doubleValue() / casosTotal.doubleValue();
		double porcentajeFailed = casosFailed.doubleValue() / casosTotal.doubleValue();
		double porcentajeNoRun = casosNoRun.doubleValue() / casosTotal.doubleValue();
		System.out.println(casosPassed + " : " + casosFailed + " : " + casosNoRun + " : " + casosTotal);
		System.out.println(porcentajePassed + " : " + porcentajeFailed + " : " + porcentajeNoRun);

		Metrica metricaCasos = new Metrica();
		Data failed = new Data();
		failed.setName("Failed");
		failed.setY(casosFailed);

		Data passed = new Data();
		passed.setName("Passed");
		passed.setY(casosPassed);

		Data noRun = new Data();
		noRun.setName("No Run");
		noRun.setY(casosNoRun);

		List<Data> data2 = new ArrayList<Data>();
		data2.add(noRun);
		data2.add(failed);
		data2.add(passed);

		metricaCasos.setName("Estados de Casos ALM");
		metricaCasos.setColorByPoint(true);
		metricaCasos.setData(data2);
		metricaCasos.setTotal(casosTotal);

		generarArchivoJson(metricaCasos, "ejemploBar2");

		Metrica metrica = new Metrica();
		Data dataFailed = new Data();
		dataFailed.setName("Failed");
		dataFailed.setY(porcentajeFailed);

		Data dataPassed = new Data();
		dataPassed.setName("Passed");
		dataPassed.setY(porcentajePassed);

		Data dataNoRun = new Data();
		dataNoRun.setName("No Run");
		dataNoRun.setY(porcentajeNoRun);

		List<Data> data = new ArrayList<Data>();
		data.add(dataNoRun);
		data.add(dataFailed);
		data.add(dataPassed);

		metrica.setName("Estados de Casos ALM en porcentaje");
		metrica.setColorByPoint(true);
		metrica.setData(data);

		generarArchivoJson(metrica, "ejemeploPie");

	}

	/**
	 * Convierte un Objecto en su respectivo Json y genera un archivo json con su
	 * nombre.
	 * 
	 * @param t
	 * @param nombreArchivo
	 */
	public static void generarArchivoJson(Object t, String nombreArchivo) {
		try {
			Gson gson = new Gson();

			String cadenaJson = gson.toJson(t);
			System.out.println("datosEmpresa Json: " + cadenaJson);
			FileWriter fileWriter = new FileWriter("C:\\xampp\\htdocs\\daviviendaSAF\\" + nombreArchivo + ".json");
			fileWriter.write(cadenaJson);
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Busca vocales para codificar correctamente.
	 * 
	 * @param input
	 * @return
	 */
	public static String buscarComasCasos(String input) {
		input = input.replace("á", "%C3%A1");
		input = input.replace("é", "%C3%A9");
		input = input.replace("í", "%C3%AD");
		input = input.replace("ó", "%C3%B3");
		input = input.replace("ú", "%C3%BA");
		input = input.replace("Á", "%C3%81");
		input = input.replace("É", "%C3%89");
		input = input.replace("Í", "%C3%8D");
		input = input.replace("Ó", "%C3%93");
		input = input.replace("Ú", "%C3%9A");
		input = input.replace("ñ", "%C3%B1");
		input = input.replace("Ñ", "%C3%91");

		return input;
	}

	public static void main(String args[]) throws ClientProtocolException, IOException, InterruptedException {
		// System.out.println(buscarComasCasos("óáéíúÁÍÉÓÚÑñ"));
//		AttachFile(67520);
//		pruebaStringToJSON();
//		signInALM("prnmarti", "Octubre2019");
//		consumirAPI();
//		consumirAPI();
//		changeStatusCase("CP0600M_SYS_Validar que no permita el cambio de correo cuando el correo actual no es valido",
//				"Failed",
//				"/Users/davivienda/eclipse-workspace/DaviplataNacional-iOS-POM-Fase2/Evidencias/CP0600M/Evidencias_CP0600M_FAILED_2020-11-06_12-29-19.docx");
//		System.out.println(changeStatusCase("CP0110M_SYS_Realizar aporte a fondo Dafuturo en transferencia", "No Run"));
//		signOutALM();
//		generacionDataInforme();
	}

}
