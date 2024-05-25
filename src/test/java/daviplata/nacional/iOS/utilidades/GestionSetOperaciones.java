package daviplata.nacional.iOS.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class GestionSetOperaciones {
	XSSFWorkbook workbookTemporal = new XSSFWorkbook();
	XSSFWorkbook workbookEvidencias = new XSSFWorkbook();
	XSSFSheet hojaTemporal;
	XSSFRow filaTemporal;
	XSSFSheet hojaEvidencia;
	XSSFRow filaEvidencia;
	XSSFRow celdaColumnA;

	String rutaTemporal = Credenciales.parametrosGenerales().getProperty("setoperaciones.temporal");
	String rutaEvidencia = Credenciales.parametrosGenerales().getProperty("setoperaciones.evidencia");

	File rutaArchivoTemporal = new File(rutaTemporal);
	File rutaArchivoEvidencia = new File(rutaEvidencia);

	int index = 0;
	int filaScreenShot = 0;
	ArrayList<String> dataTemp = new ArrayList<String>();

	public void crearArchivos() throws FileNotFoundException, IOException {
		if (!rutaArchivoTemporal.exists()) {
			workbookTemporal = new XSSFWorkbook(); // Creo un libro de excel en blanco
			hojaTemporal = workbookTemporal.createSheet("Evidencia"); // Creo una hoja dentro de ese excel
		} else {
			workbookTemporal = new XSSFWorkbook(new FileInputStream(rutaArchivoTemporal));
		}
		if (!rutaArchivoEvidencia.exists()) {
			workbookEvidencias = new XSSFWorkbook();
			hojaEvidencia = workbookEvidencias.createSheet("Evidencia General");
		} else {
			workbookEvidencias = new XSSFWorkbook(new FileInputStream(rutaArchivoEvidencia));
		}
	}

	public void insertarEvidencia(String path) throws IOException {
		File carpeta = new File(path);
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File f, String name) {
				return name.endsWith("png");
			}
		};
		File[] archivos = carpeta.listFiles(filter);
		if (archivos == null || archivos.length == 0) {
			System.out.println("No hay elementos dentro de la carpeta actual");
			return;
		} else {
			Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
			int numeroHojasLibro = workbookEvidencias.getNumberOfSheets();
			for (int i = 0; i < numeroHojasLibro; i++) {
				if (i == 0 || i == numeroHojasLibro - 1) {
					hojaEvidencia = workbookEvidencias.getSheetAt(i);
					filaEvidencia = hojaEvidencia.createRow(hojaEvidencia.getLastRowNum() + 2);
					int filaScreenShot = filaEvidencia.getRowNum();// - (index / 2);
					for (int j = 0; j < archivos.length; j++) {
						File archivo = archivos[j];
						String nameFile = archivo.getName();
						InputStream inputStream = new FileInputStream(path + "\\" + nameFile);
						byte[] bytes = IOUtils.toByteArray(inputStream);
						int pictureIdx = workbookEvidencias.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
						inputStream.close();
						int scaleX = 4;
						int scaleY = 20;
						CreationHelper helper = workbookEvidencias.getCreationHelper();
						Drawing<?> drawing = hojaEvidencia.createDrawingPatriarch();
						ClientAnchor anchor = helper.createClientAnchor();
						anchor.setCol1((3 + (j * 5)));
						anchor.setRow1(filaScreenShot);
						Picture pict = drawing.createPicture(anchor, pictureIdx);
						pict.resize(scaleX, scaleY);
					}
				}
			}
			auxiliarEscritura(rutaEvidencia, workbookEvidencias);
			escribirExcel(rutaEvidencia, workbookEvidencias);
		}
	}

	public void guardarDataTemporal(String titulo, String valor) throws IOException {
		crearArchivos();
		hojaTemporal = workbookTemporal.getSheetAt(0);
		filaTemporal = hojaTemporal.createRow(hojaTemporal.getLastRowNum() + 1);
		XSSFCell titulos = filaTemporal.createCell(0);
		XSSFCell valores = filaTemporal.createCell(1);
		titulos.setCellValue(titulo);
		valores.setCellValue(valor);
		auxiliarEscritura(rutaEvidencia, workbookEvidencias);
		escribirExcel(rutaTemporal, workbookTemporal);
	}

	public void agregarDataTemporalArrayList() {
		Iterator<Row> rowIterator = hojaTemporal.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				dataTemp.add(index, cell.getStringCellValue());
				index++;
			}
		}
	}

	public void copiarDataTemporalAEvidencia() throws IOException {
		agregarDataTemporalArrayList();
		hojaEvidencia = workbookEvidencias.getSheetAt(0);
		filaEvidencia = hojaEvidencia.createRow(hojaEvidencia.getLastRowNum() + 1);
		int UltimaFilaOcupada = filaEvidencia.getRowNum();
		if (UltimaFilaOcupada == 0) {
			filaEvidencia = hojaEvidencia.createRow(hojaEvidencia.getLastRowNum() + 1);
		} else if (UltimaFilaOcupada > 0) {
			filaEvidencia = hojaEvidencia.createRow(hojaEvidencia.getLastRowNum() + 22);
		}
		CellStyle cellStyle = workbookEvidencias.createCellStyle();
		Font cellFont = workbookEvidencias.createFont();
		cellFont.setBold(true);
		cellStyle.setFont(cellFont);
		for (int i = 0; i < dataTemp.size(); i = i + 1) {
			XSSFCell celdaColumn = filaEvidencia.createCell(i);
			celdaColumn.setCellValue(dataTemp.get(i));
			if (i % 2 == 0)
				celdaColumn.setCellStyle(cellStyle);
		}
		copiarDataTemporalNuevaHoja();
	}

	public void copiarDataTemporalNuevaHoja() throws IOException {
		int numeroHojasLibro = workbookEvidencias.getNumberOfSheets();
		XSSFSheet nuevaHoja = workbookEvidencias.createSheet("Test Execution " + numeroHojasLibro);
		nuevaHoja = workbookEvidencias.getSheetAt(numeroHojasLibro);
		XSSFRow filaNuevaHoja = nuevaHoja.createRow(nuevaHoja.getLastRowNum() + 1);
		CellStyle cellStyle = workbookEvidencias.createCellStyle();
		Font cellFont = workbookEvidencias.createFont();
		cellFont.setBold(true);
		cellStyle.setFont(cellFont);
		for (int i = 0; i < dataTemp.size(); i = i + 1) {
			XSSFCell columnNew = filaNuevaHoja.createCell(i);
			columnNew.setCellValue(dataTemp.get(i));
			if (i % 2 == 0)
				columnNew.setCellStyle(cellStyle);
		}
	}

	public void escribirExcel(String ruta, XSSFWorkbook wb) throws IOException {
		FileOutputStream fileOut = null;
		fileOut = new FileOutputStream(ruta);
		wb.write(fileOut);
		fileOut.close();
	}

	public void auxiliarEscritura(String ruta, XSSFWorkbook wb) throws IOException {
		FileOutputStream auxiliarEscritura = new FileOutputStream(ruta);
		wb.write(auxiliarEscritura);
		auxiliarEscritura.flush();
		auxiliarEscritura.close();
	}

	public void eliminarArchivoTemporal() throws IOException {
		workbookTemporal.close();
		File myObj = new File(rutaTemporal);
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
	}
}
