package daviplata.nacional.iOS.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public class MovimientoFuncionalPageObjects extends PageObject {
	
	public static final String EQUIS_HEADER = "//XCUIElementTypeImage[contains(@name,'Salir movimientos boton')]";
    public static final String VER_MAS_SALDO_HEADER = "//XCUIElementTypeStaticText[contains(@value, 'Ver más')]";
    public static final String TEXTO_CUANTO_TENGO_DETALLE_SALDO = "//XCUIElementTypeStaticText[contains(@name, 'Últimos movimientos')]";
    public static final String ULTIMO_MOVIMIENTO_BTN = "//XCUIElementTypeStaticText[contains(@value, 'Último movimiento')]";
    public static final String MODULO_MOVIMIENTOS_TXT = "//XCUIElementTypeStaticText[@name='Todos los movimientos']";
    public static final String VER_TODOS_MOV_BTN = "//XCUIElementTypeStaticText[contains(@label, 'Ver todos')]";
    public static final String BOTON_VER_MOVIMIENTOS = "//android.view.ViewGroup[@content-desc='ver todos mis movimientos botón']";
    public static final String BOTON_ATRAS_MOVIMIENTOS = "//XCUIElementTypeButton[@name='Atrás Botón'] | //XCUIElementTypeButton[contains(@name, 'Regresar')] | //XCUIElementTypeOther[contains(@name, 'left')]"; 
    public static final String BOTON_VER_MAS_MOVIMIENTOS = "//XCUIElementTypeButton[@name='Ver más']"; 
    public static final String TEXTO_MODULO_MOVIMIENTOS = "//XCUIElementTypeStaticText[@name='Movimientos']"; 
    public static final String BOTON_EQUIS_MOVIMIENTOS = "//XCUIElementTypeButton[@name='Salir Botón']"; 
    public static final String TEXTO_MOVIMIENTO_DEL_DIA_HOY = "//XCUIElementTypeStaticText[@name='Hoy']";
    public static final String TEXTO_FECHA_MOVIMIENTO = "//*[contains(@text, 'Enero') or contains(@text, 'Febrero') or contains(@text, 'Marzo') or contains(@text, 'Abril') or contains(@text, 'Mayo') or contains(@text, 'Junio') or contains(@text, 'Julio') or contains(@text, 'Agosto') or contains(@text, 'Septiembre') or contains(@text, 'Octubre') or contains(@text, 'Noviembre') or contains(@text, 'Diciembre')]";
    public static final String TEXTO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA = "(//XCUIElementTypeStaticText[@name='Pasó plata a otro DaviPlata'])[1] | (//XCUIElementTypeStaticText[@name='Recibió plata de otro DaviPlata'])[1]";
    public static final String TEXTO_NUMERO_MOVIMIENTO_PASAR_PLATA_DAVIPLATA = "//XCUIElementTypeOther[@name='Pasó plata a otro DaviPlata']/following-sibling::XCUIElementTypeOther[1] | //XCUIElementTypeOther[@name='Recibió plata de otro DaviPlata']/following-sibling::XCUIElementTypeOther[1]";
    public static final String POPUP_LO_SENTIMOS_DEFECTO = "//XCUIElementTypeStaticText[contains(@name, '¡Lo sentimos! En este momento no podemos cargar su información.')]";
}
