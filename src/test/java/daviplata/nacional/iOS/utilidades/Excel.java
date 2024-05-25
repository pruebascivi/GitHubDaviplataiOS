package daviplata.nacional.iOS.utilidades;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;


import org.apache.poi.ss.usermodel.Workbook;


import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.Scenario;
import daviplata.nacional.iOS.definitions.Hooks;


import org.apache.poi.ss.usermodel.Sheet;

public class Excel {
	
    
	static XSSFWorkbook workbookEvidencias = new XSSFWorkbook();
	static XSSFSheet Datos;
	static XSSFSheet hojaEvidencia;
	static XSSFRow filaEvidencia;
	static XSSFRow celdaColumnA;
	static String[] header;
	static String[] datos;
	static String[] scenario;
	
	static String rutaArchivoTempo = "";
	static File rutaArchivoEvidencia;
	static Cell c;
	static int contadorFila = 1;
	int contadorCelda = 1;

	

	// Anadir elementos
	static XSSFSheet hoja1 = null;
	static XSSFWorkbook wb = null;
	static BufferedImage in;
	

	
	// Metodo para crear o leer un archivo
	public static void crearLeerArchivo(String rutaEvidencia, String nombreArchivo) {
		rutaArchivoTempo = rutaEvidencia + "/" + nombreArchivo;
		rutaArchivoEvidencia = new File(rutaArchivoTempo);
		if (rutaArchivoEvidencia.exists()) {
			datos = datos();
			buscarFilas();
			ingresarDatos(contadorFila, hoja1);
			autoSize(hoja1, contadorFila);
			try {
				addImage();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				escribirExcel(rutaArchivoTempo, wb);
			} catch (IOException e) {
				System.out.println("No se cerro el archivo");
			}
		} else {

			System.out.println("Creo el archivo");
			workbookEvidencias = new XSSFWorkbook();
			Datos = workbookEvidencias.createSheet("Datos");
			hojaEvidencia = workbookEvidencias.createSheet("Evidencia");
			header = header();
			cabecera();
			autoSize(Datos, 2);
			datos = datos();
			

			try {
				cerrarExcel(rutaArchivoTempo, workbookEvidencias);// Creo un libro de excel en blanco
			} catch (Exception e) {
				System.out.println(e);
			}
			
			buscarFilas();
			ingresarDatos(contadorFila, hoja1);
			autoSize(hoja1, contadorFila);
			try {
				addImage();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				escribirExcel(rutaArchivoTempo, wb);
			} catch (IOException e) {
				System.out.println("No se cerro el archivo");
			}
		}
	}

	// Escribe el excel
	public static void escribirExcel(String ruta, XSSFWorkbook wb) throws IOException {
		FileOutputStream fileOut = null;
		fileOut = new FileOutputStream(ruta);
		wb.write(fileOut);
		fileOut.close();
	}

	// Cierra el excel
	public static void cerrarExcel(String ruta, XSSFWorkbook wb) throws IOException {
		FileOutputStream auxiliarEscritura = new FileOutputStream(ruta);
		wb.write(auxiliarEscritura);
		auxiliarEscritura.flush();
		auxiliarEscritura.close();
		workbookEvidencias.close();
	}

	// Datos de encabezados
	public static String[] header() {
		String[] header = new String[] { "", "ID Caso", "ID Usuario", "Contraseña","Cuenta destino", "Disponible inicial", "Disponible final",
				"valor transación", "ID de transaccion" };
		return header;
	}

	// Datos de prueba
	public static String[] datos() {
		scenario = Hooks.getScenario().getName().split("_");
		String[] datos = new String[] {"", scenario[0], System.getProperty("idUsuario"), System.getProperty("numContraseña"), 
				System.getProperty("cuentaDestino"), System.getProperty("saldoInicialHomeUsuario"), System.getProperty("saldoFinalHomeUsuario"), 
				System.getProperty("valorTransferencia"), System.getProperty("codigoTransación"), };
		return datos;
	}

	// Metodo para insertar la cabecera en el excel
	public static void cabecera() {
		for (int i = 1; i < header.length; i++) {
			XSSFRow row = Datos.createRow(i);
			for (int j = 1; j < header.length; j++) {
				if (i == 1) {
					XSSFCell cell = row.createCell(j);
					cell.setCellStyle(styleCabecera(workbookEvidencias));
					cell.setCellValue(header[j]);
				}
			}
		}
	}

	// Estilo de la cabecera
	public static CellStyle styleCabecera(XSSFWorkbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBold(true);
		style.setFont(font);
		return style;

	}

	// Ajustar las celdas
	public static void autoSize(XSSFSheet sh, int fila) {
		for (int i = 0; i <= sh.getRow(fila).getPhysicalNumberOfCells(); i++) {
			sh.autoSizeColumn(i);
		}
	}

	// Escribir en el excel
	public static void ingresarDatos(int fila, XSSFSheet sf) {
		XSSFRow row = sf.createRow(fila);
		for (int j = 1; j < datos.length; j++) {
			XSSFCell cell = row.createCell(j);
			cell.setCellValue(datos[j]);

		}
	}

	// Busco la fila disponible para escribir la data
	public static void buscarFilas() {
		try (FileInputStream file = new FileInputStream(rutaArchivoEvidencia)) {
			wb = new XSSFWorkbook(file);
			hoja1 = wb.getSheetAt(0);
			for (Sheet sheet : wb) {
				for (Row row : sheet) {
					isRowEmpty(row);
				}

			}

		} catch (Exception e) {

		}

	}

	// Metodo para determinar que celdas estan vacias
	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < 100; c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != CellType.BLANK) {
				String value = cell.getStringCellValue();
				System.out.println(value);
				contadorFila++;
				return false;
			}

		}
		return true;

	}
	public static void addImage() throws IOException {
		int t=5;
		String [] vector = Evidencias.getImagen();
		int col = 4;
		int row = 2;
		int i = 0;
		double f = 2;
		int espacio =25;
		int casoFila= 1;
		double scaleX =0.0;
		double scaleY=0.0;
		System.setProperty("nombreScenario", String.valueOf(scenario));
		

		hojaEvidencia = wb.getSheetAt(1);
		//Agregar el caso al excel
//		XSSFRow Row1 = hojaEvidencia.createRow(2);
//		XSSFRow Row2 = hojaEvidencia.createRow(espacio-1);
//		XSSFRow Row3 = hojaEvidencia.createRow((espacio*2)-1);
//		XSSFRow Row4 = hojaEvidencia.createRow((espacio*3)-1);
//		XSSFRow Row5 = hojaEvidencia.createRow((espacio*4)-1);
		//Agregar mas imagenes
		
		System.out.println("el contador es"+contadorFila);
		if(contadorFila==2) {
			System.out.println("Ejecuto 1 ves");
			XSSFRow Row1 = hojaEvidencia.createRow(3);
			Cell cell = Row1.createCell(4);
			cell.setCellValue(System.getProperty("idScenario"));
			row = 4;
		}
		else if(contadorFila==3){
			System.out.println("Ejecuto 2 ves");
			XSSFRow Row = hojaEvidencia.createRow(espacio-1);
			Cell cell = Row.createCell(4);
			cell.setCellValue(System.getProperty("idScenario"));
			row =espacio;
		}
		else {
			System.out.println("Ejecuto 3 ves");
			contadorFila = contadorFila-2;
			row = (espacio * contadorFila)-3;
			System.out.println("El contador esta en : "+contadorFila);
			XSSFRow Row = hojaEvidencia.createRow(row-1);
			Cell cell = Row.createCell(4);
			cell.setCellValue(System.getProperty("idScenario"));
		}
		do {
			InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"//Evidencias//"
		+scenario[0]+"//"+vector[i]+".PNG");	
		//	System.out.println("Nombre imagen "+ base.NombreImage[i]);
			byte [] bytes = IOUtils.toByteArray(inputStream);
			int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			inputStream.close();
			CreationHelper helper = wb.getCreationHelper();
			Drawing<?> drawing = hojaEvidencia.createDrawingPatriarch();
			ClientAnchor anchor = helper.createClientAnchor();
			anchor.setCol1(col);
			anchor.setRow1(row);
			Picture pict = drawing.createPicture(anchor, pictureIdx);
			scaleX = t * 1.0 * 0.5908494;
			scaleY = t * 1.8 * 1.9677996;
			if(vector[i].contains("web")) {
				pict.resize(10,15);
			    col = col +11;
		    }else{
			pict.resize(scaleX, scaleY);
			col = col + 3;  	
			    }
			i++;
		}while(vector[i]!= null);
		contadorFila=1;
	}
}
