package daviplata.nacional.iOS.pageObjects;

public class GenerarExtractosPageObjects {

	public static final String BTN_HEADER = "//XCUIElementTypeOther[@label = 'Menú DaviPlata botón'] | //XCUIElementTypeOther[@name='btn-left-0']";
	public static final String BTN_SOLICITUDES = "//XCUIElementTypeOther[@name='Seccion Solicitudes Desplegar opciones boton']";
	public static final String BTN_EXTRACTOS = "(//XCUIElementTypeOther[contains(@label, 'Extractos')])[last()] | //XCUIElementTypeOther[@name='btn-1']";
	public static final String TXT_NO_CUENTA_EXTRACTOS_DISPONIBLES = "//XCUIElementTypeStaticText[contains(@name, 'Usted no cuenta con extractos disponibles para su consulta')]";
	public static final String BTN_DESPLEGABLE_PERIODO = "//XCUIElementTypeImage[@name='btn_lista_detalle_abierto_open']";
	public static final String BTN_DESCARGAR = "//XCUIElementTypeStaticText[@name='Descargar']";
    public static final String TXT_EXTRACTO = "//XCUIElementTypeButton[contains(@name, 'Extracto')]";
    public static final String BTN_COMPARTIR = "//XCUIElementTypeButton[contains(@label, 'Share')]";
    public static final String BTN_SAVE_TO_FILES = "//XCUIElementTypeCell[@name='Save to Files']/XCUIElementTypeOther[2]";
    public static final String BTN_GUARDAR = "//XCUIElementTypeButton[@name='Guardar']";
	
    public static final String BOTON_DISCO_PERIODO = "(//XCUIElementTypeOther)[9]";
    public static final String POPUP_NANOCREDITO = "//XCUIElementTypeStaticText[contains(@value, 'Conozca el Nanocrédito')] | //XCUIElementTypeStaticText[contains(@name, 'Conozca el Nanocrédito')]";
    public static final String BOTON_NO_ME_INTERESA = "";
    public static final String TEXTO_CUANTO_DEBO = "";
    public static final String OPCION_CERTIFICACIONES_NANOCREDITO = "";
    
    
    
	public static final String BOTON_ACEPTAR_OTP_SACAR_PLATA = "//XCUIElementTypeButton[@name='Aceptar boton']";
	public static final String SALDOS_HOME_NEGOCIO = "//XCUIElementTypeStaticText[contains(@value, '$')]";
	public static final String ADMINISTRAR_NEGOCIO = "//XCUIElementTypeStaticText[contains(@value, 'Administrar mi negocio')]";
	public static final String ADMIN_NEGOCIO_MODULE = "//XCUIElementTypeStaticText[contains(@name,'crear sus puntos de venta, registrar sus vendedores')]";
	public static final String ABRIR_PUNTO_VENTA_BTN = "//XCUIElementTypeOther[@name='Abrir punto de venta']";
	public static final String ABRIR_PUNTO_VENTA_MODULO = "//XCUIElementTypeStaticText[contains(@name, 'Ingrese los siguientes datos')]";
	public static final String NOMBRE_PUNTO_VENTA_CAMPO = "//XCUIElementTypeTextField[contains(@value, 'Ingrese el nombre')]";
	public static final String CIUDAD_MUNICIPIO_PUNTO_VENTA_CAMPO = "//XCUIElementTypeTextField[contains(@value, 'Ingrese ciudad o municipio')]";
	public static final String DIRECCIÓN_PUNTO_VENTA_CAMPO = "//XCUIElementTypeStaticText[@name='Seleccione']";
	public static final String LETRA_PUNTO_VENTA_CAMPO = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeTextField[1]";
	public static final String NUMERO1_PUNTO_VENTA_CAMPO = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeTextField[2]";
	public static final String NUMERO2_PUNTO_VENTA_CAMPO = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeTextField[3]";
	public static final String OPCION_AVENIDA = "//XCUIElementTypeStaticText[@name='Avenida']";
	public static final String CREAR_PUNTO_VENTA_BTN = "//XCUIElementTypeButton[@name='Crear']";
	public static final String TXT_CAMBIO_EXITOSO_FOTO = "//XCUIElementTypeStaticText[@name='Imagen cargada exitosamente']";
	public static final String BTN_NEGOCIO = "//XCUIElementTypeOther[@name='btn-mi-negocio']";
	public static final String BOTON_VER_MOVIMIENTOS = "//XCUIElementTypeStaticText[contains(@label, 'Último movimiento')]";
	public static final String BTN_REGRESAR_MI_NEGOCIO = "//XCUIElementTypeButton[contains(@name, 'Atras Boton')] | //XCUIElementTypeButton[contains(@label, 'Atras Boton')]";
	public static final String BOTON_TOPES = "//XCUIElementTypeStaticText[@name='Topes']";
	public static final String BTN_USAR_DAVIPLATA = "//XCUIElementTypeStaticText[@name='Usar Mi DaviPlata']";
	public static final String BTN_MI_DAVIPLATA = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2] | //XCUIElementTypeStaticText[@name='Mi DaviPlata'] | //XCUIElementTypeStaticText[@label='Mi DaviPlata']";
	public static final String BTN_MENU_DAVIPLATA = "(//XCUIElementTypeOther[contains(@label, 'Menú DaviPlata botón')])[8]";
	public static final String CAMPO_CORREO = "//XCUIElementTypeTextField[@name='Correo electrónico']";
	public static final String CAMPO_CONFIRM_CORREO = "//XCUIElementTypeTextField[@name='Confirme Correo electrónico']";
	public static final String BTN_DONE_TECLADO = "//XCUIElementTypeButton[@name='Done']";
	public static final String BTN_CREAR_PRIMER_PRODUCTO = "//XCUIElementTypeStaticText[@name='Crear producto']";
	public static final String REFERENCIAS = "//XCUIElementTypeStaticText[@name='Referencias']";
	public static final String ACEPTAR = "//XCUIElementTypeButton[@name='Aceptar Botón'] | //XCUIElementTypeButton[contains(@name, 'Aceptar')] | //XCUIElementTypeButton[contains(@label, 'Aceptar')]";
	public static final String INPUT_UNIDADES = "//XCUIElementTypeOther[@name='Valor']/preceding-sibling::XCUIElementTypeOther[1] | //XCUIElementTypeOther[@name='Unidades disponibles'] | //XCUIElementTypeOther[@name='Su negocio DaviPlata']/XCUIElementTypeOther[13] | //XCUIElementTypeOther[@name='Su negocio DaviPlata']/XCUIElementTypeOther[13]/XCUIElementTypeTextField";
	public static final String DESLIZABLE_BANCOS = "//XCUIElementTypeApplication[@name='DaviPlata']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[14]/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String TP_CUENTA_AHORRO = "//XCUIElementTypeButton[@name='Cuenta de Ahorros']";
	public static final String TP_CUENTA_CORRIENTE = "//XCUIElementTypeButton[@name='Cuenta Corriente']";
	public static final String TP_MONEDERO = "//XCUIElementTypeButton[@name='Monedero']";
	public static final String POPUP_PASAR_PLATA = "//XCUIElementTypeStaticText[contains(@name, 'Si pasa plata antes de las 3:00 P.M')]";
	public static final String DIRIGIENDO_PERFIL_PERSONA_TXT = "//XCUIElementTypeStaticText[@name='Lo estamos dirigiendo a su perfil persona']";
	
}