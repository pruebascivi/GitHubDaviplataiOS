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
    public static final String DESPLEGABLE_FILTROS_MOVIMIENTOS = "//XCUIElementTypeImage[@name='Icono fecha'] | (//XCUIElementTypeOther[@name='main'])[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther";
    public static final String LISTA_MOVIMIENTOS = "//XCUIElementTypeOther[contains(@name, 'Enero') or contains(@name, 'Febrero') or contains(@name, 'Marzo') or contains(@name, 'Abril') or contains(@name, 'Mayo') or contains(@name, 'Junio') or contains(@name, 'Julio') or contains(@name, 'Agosto') or contains(@name, 'Septiembre') or contains(@name, 'Octubre') or contains(@name, 'Noviembre') or contains(@name, 'Diciembre')]/following-sibling::XCUIElementTypeOther[not(position() = last())]/XCUIElementTypeStaticText[not(contains(@value, '0')) and not(contains(@value, '1')) and not(contains(@value, '2')) and not(contains(@value, '3')) and not(contains(@value, '4')) and not(contains(@value, '5')) and not(contains(@value, '6')) and not(contains(@value, '7')) and not(contains(@value, '8')) and not(contains(@value, '9')) and not(contains(@value, '$'))]";
    public static final String OPCION_FILTRO_PLATA_QUE_HA_RECIBIDO = "//XCUIElementTypeStaticText[@name='Plata que ha recibido']";
    public static final String OPCION_FILTRO_PLATA_QUE_HA_GASTADO = "//XCUIElementTypeStaticText[@name='Plata que ha gastado']";
    public static final String OPCION_FILTRO_SERVICIOS_QUE_HA_PAGADO = "//XCUIElementTypeStaticText[@name='Servicios que ha pagado']";
    public static final String OPCION_FILTRO_TODOS_LOS_MOVIMIENTOS = "//XCUIElementTypeStaticText[@name='Todos los movimientos']";
    public static final String DESLIZABLE = "(//XCUIElementTypeOther[@name='main'])[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeOther";
    public static final String BOTON_BUSCAR_MOVIMIENTOS = "//XCUIElementTypeButton[@name='Buscar']";
    public static final String CAMPO_BUSQUEDA_POR_NOMBRE_EN_CANGURO = "//XCUIElementTypeOther[@name='Por nombre, celular o cuenta'] | //XCUIElementTypeStaticText[@name='Por nombre, celular o cuenta']";
    public static final String BTN_DONE = "//XCUIElementTypeButton[@name='Done']";
    public static final String BOTON_BUSCAR = "(//XCUIElementTypeButton[@name='Buscar'])[2]";
    public static final String POPUP_NO_SE_ENCONTRARON_MOV = "//XCUIElementTypeStaticText[contains(@name, 'No se encontraron movimientos')]";
    public static final String BTN_ACEPTAR = "//XCUIElementTypeButton[@name='Aceptar'] | //XCUIElementTypeButton[@label='Aceptar']";
    public static final String TXT_MOV_ENCONTRADOS = "//XCUIElementTypeStaticText[@name='Movimientos encontrados']";
    public static final String BTN_CERRAR_BUSQUEDAD_MOV = "//XCUIElementTypeImage[@name='Salir boton']";
    public static final String TXT_BUSCAR_MOVIMIENTOS = "//XCUIElementTypeStaticText[@name='Buscar Movimientos']";

}
