package daviplata.nacional.iOS.pageObjects;


public class LauraVozPageObjects {
	
	public static final String POP_UP_DOS_ENLACES = "//XCUIElementTypeOther[@name='PRUEBA DOS ENLACES'] | //XCUIElementTypeStaticText[@name='PRUEBA DOS ENLACES' and @value='PRUEBA DOS ENLACES']";
	public static final String BOTON_CERRAR_PRUEBAS_DOS_ENLACES = "//XCUIElementTypeImage[@name='close'] | //XCUIElementTypeImage[contains(@name, 'close')] | //XCUIElementTypeImage[contains(@label, 'close')] | //XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeOther[3]/XCUIElementTypeImage";
	public static final String PANTALLA_CHAT_NECESITO_AYUDA = "//XCUIElementTypeStaticText[@name='Bienvenido a nuestro canal de servicio'] | //XCUIElementTypeTextField[@value='Escriba aquí su consulta']";
	public static final String PANTALLA_DE_BIENVENIDA_LAURA_VOZ = "//XCUIElementTypeStaticText[contains(@name, 'Bienvenido al chat de servicio')]";
	public static final String ICONO_CERRAR_PANTALLA_LAURA_VOZ = "//XCUIElementTypeImage[@name='Cerrar']";
	public static final String BOTON_EMPECEMOS = "//XCUIElementTypeButton[@name='Empecemos']";
	public static final String TEXTO_CHAT_LAURA = "//XCUIElementTypeStaticText[contains(@name, 'Soy Laura y estaré encargada de atender su consulta')]";
	public static final String HORA_CHAT_LAURA = "//XCUIElementTypeStaticText[contains(@name, 'PM')] | //XCUIElementTypeStaticText[contains(@name, 'AM')] | //XCUIElementTypeStaticText[contains(@name, '-')]";
	public static final String ICONO_MINIMIZAR_PANTALLA_LAURA_VOZ = "//XCUIElementTypeImage[@name='Minimizar'] | //XCUIElementTypeImage[@name='Restaurar'] | (//XCUIElementTypeImage)[3]";
	public static final String TITULO_NECESITA_AYUDA = "//XCUIElementTypeStaticText[contains(@name, 'Necesita Ayuda')]";
	public static final String TEXTO_TODAS_SUS_CONSULTAS_PANTALLA_BIENVENIDA = "//XCUIElementTypeStaticText[contains(@name, 'Aquí podrá realizar todas sus consultas')]";
    public static final String TEXTO_BIENVENIDA_LAURA_VOZ = "//XCUIElementTypeStaticText[@name='Renovamos nuestro servicio']";
    public static final String BOTON_REPRODUCIR = "//XCUIElementTypeOther[@name='FAQ Daviplata']/XCUIElementTypeOther[7]/XCUIElementTypeImage[5]";
    public static final String TEXTO_HOLA = "";
    public static final String TEXTO_SOY_LAURA = "";
    public static final String TEXTO_CONSULTE_FACILMENTE = "";
    public static final String TEXTO_REVISAR_VOLUMEN = "";
    public static final String BOTON_OMITIR = "";

}
