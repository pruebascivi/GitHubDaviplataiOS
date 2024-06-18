package daviplata.nacional.iOS.pageObjects;


public class LauraChatPageObjects {
	
	public static final String BOTON_NECESITO_AYUDA_HOME = "//XCUIElementTypeOther[@name='btn-rigth-1'] | //XCUIElementTypeOther[@label= 'Ayuda']";
    public static final String TEXTO_BIENVENIDA_CHAT = "//XCUIElementTypeStaticText[contains(@name, 'Bienvenido al chat de servicio en DaviPlata')]";
    public static final String BOTON_EQUIS = "//XCUIElementTypeImage[@name='Cerrar']";
    public static final String BOTON_MINIMIZAR = "//XCUIElementTypeImage[@name='Minimizar'] | //XCUIElementTypeImage[@name='Restaurar'] | (//XCUIElementTypeImage)[3]";
    public static final String BOTON_EMPECEMOS = "//XCUIElementTypeButton[@name='Empecemos']";
    public static final String TEXTO_AL_CANAL_CHAT = "//XCUIElementTypeStaticText[contains(@name, 'Bienvenido a nuestro canal de Chat DaviPlata')]";
    public static final String TXT_INGRESE_SUS_DATOS = "//XCUIElementTypeStaticText[@name='Ingrese sus datos']";
    public static final String BOTON_PERMITIR_SOLO_USO_CON_APP = ""; //No aparece PopUp
}
