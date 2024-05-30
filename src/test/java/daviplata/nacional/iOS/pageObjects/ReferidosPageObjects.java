package daviplata.nacional.iOS.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public class ReferidosPageObjects extends PageObject {
	
		public static final String LOGO_DAVIPLATA_HEADER = "//XCUIElementTypeOther[@label= 'Menú DaviPlata botón'] | //XCUIElementTypeOther[@name='btn-left-0']";
		public static final String BOTON_SALIR = "//XCUIElementTypeOther[@name='btn-rigth-0']";
		public static final String BOTON_CERRAR_APP = "//XCUIElementTypeOther[@name='btn-sign-out'] | //XCUIElementTypeOther[@label= 'Salir de DaviPlata botón']";
		public static final String BOTON_ACEPTAR_CERRAR_APP = "//XCUIElementTypeStaticText[@name='Aceptar']";
		public static final String CHECK_TYC = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[5]/XCUIElementTypeOther";
		public static final String TEXTOS_REFERIDOS = "//XCUIElementTypeStaticText[contains(@name, 'Gane invitando a sus amigos a registrarse y usar DaviPlata')] | //XCUIElementTypeStaticText[contains(@name, 'Si sus amigos también invitan ¡seguirá ganando')]";
		public static final String BOTON_INVITAR = "//XCUIElementTypeButton[@name='Invitar']";
		public static final String GANE_PLATA_INVITANDO = "//XCUIElementTypeStaticText[contains(@name, 'Gane plata invitando a sus amigos')]";
		public static final String BTN_DONE = "//XCUIElementTypeButton[@name='Done']";
		public static final String BTN_DONE_TECLADO = "(//XCUIElementTypeButton[@name='Done'])[2]";
		public static final String BARRA_AVANCE = "(//XCUIElementTypeOther)[113]";
		public static final String DAVIPLATA_HEADER_REFERIDOS = "//XCUIElementTypeStaticText[contains(@name,'Términos y condiciones')]";
		public static final String MENU_HAMBURGUESA_REFERIDOS = "//XCUIElementTypeButton[@name='Toggle navigation']";
		public static final String OPCION_PARA_INVITAR	= "//XCUIElementTypeButton[@name='Opciones para invitar']";
		public static final String OPCION_MIS_GANANCIAS	= "//XCUIElementTypeButton[@name='Mis ganancias']";
		public static final String BOTON_CONTINUAR = "//XCUIElementTypeButton[contains(@name, 'Continuar')]";
		public static final String CONTENIDO_OPCIONES_PARA_INVITAR = "//XCUIElementTypeStaticText[contains(@name, 'Comparta este enlace para invitar')]";
		public static final String CONTENIDO_OPCION_MIS_GANANCIAS = "//XCUIElementTypeStaticText[@name='Mis ganancias']";
		public static final String BOTON_REGISTRARSE_EN_DAVIPLATA = "//XCUIElementTypeStaticText[@name='Registrarse en DaviPlata']";
		public static final String CUADRO_TEXTO_LINK = "//XCUIElementTypeOther[@name='Opciones para invitar, tab panel']/XCUIElementTypeTextField";
		public static final String ICONOS_CANALES_COMPARTIR = "//XCUIElementTypeOther[@name='Opciones para invitar, tab panel']/XCUIElementTypeOther[8]";
		public static final String OPCION_DESCARGAR_APP = "//XCUIElementTypeStaticText[@name='Descargar o abrir DaviPlata']";
		public static final String OPCION_COMPLETAR_REGISTRO_APP = "//XCUIElementTypeStaticText[@name='registro']";
		public static final String OPCION_REALIZAR_COMPRA_APP = "//XCUIElementTypeStaticText[contains(@name, 'Realizar una compra por el QR')]";
		public static final String OPCION_CORREO = "//XCUIElementTypeStaticText[@name='Correo']";
		public static final String PANTALLA_OPCION_CORREO = "//XCUIElementTypeStaticText[@name='Correo electrónico de tus amigos']";
		public static final String OPCION_INSTAGRAM = "//XCUIElementTypeStaticText[@name='Instagram']";
		public static final String PANTALLA_OPCION_INSTAGRAM = "//XCUIElementTypeStaticText[@name='Instrucciones para compartir en Instagram']";
		public static final String OPCION_FACEBOOK = "//XCUIElementTypeStaticText[@name='Facebook']";
		public static final String PANTALLA_OPCION_FACEBOOK = "//XCUIElementTypeStaticText[@name='únicamente desde el enlace de invitación']";
		public static final String LABEL_SALDO = "//XCUIElementTypeStaticText[contains(@name, '$')]";
		public static final String CONTADOR_ENLACES_VECES_COMPARTIDO = "//XCUIElementTypeOther[@name='Mis ganancias, tab panel']/XCUIElementTypeOther[4]/preceding-sibling::XCUIElementTypeStaticText[1]";
		public static final String CONTADOR_ENLACES_COMPARTIDOS_EXITOSOS = "//XCUIElementTypeOther[@name='Mis ganancias, tab panel']/XCUIElementTypeOther[5]/preceding-sibling::XCUIElementTypeStaticText[1]";
		public static final String CAMPO_BUSQUEDA_POR_NOMBRE = "//XCUIElementTypeOther[@name='Mis ganancias, tab panel']/XCUIElementTypeSearchField";
		public static final String CAMPO_BUSQUEDA_POR_FECHA = "//XCUIElementTypeOther[@name='Mis ganancias, tab panel']/XCUIElementTypeTextField";
		public static final String BTN_BUSCAR = "//XCUIElementTypeButton[@name='Buscar']";
		
		
		public static final String MENU_TRES_PUNTOS = "//XCUIElementTypeButton[contains(@label, 'Menu boton')] | //XCUIElementTypeButton[contains(@value, 'Menu de conocimiento')]";
		public static final String LABEL_INGRESO_DAVIPLATA = "//XCUIElementTypeStaticText[@name='Ingrese a su Daviplata']";
		public static final String LABEL_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name, 'Daviplata') or contains(@name, 'DaviPlata')]";
		public static final String BTN_CONTINUAR_REGISTRARME = "//XCUIElementTypeButton[@name='Continuar boton']";
		public static final String BTN_INGRESAR = "(//XCUIElementTypeButton[@name='Ingresar'])[2]";
		public static final String TEXTO_BIENVENIDA = "//*[contains(@name,'bienvenida')]";
		public static final String BOTON_YA_TENGO_DAVIPLATA = "//XCUIElementTypeButton[contains(@name,'Ya tengo DaviPlata botón')]";
		public static final String LISTA_DESPLEGABLE_TIPO_DOCUMENTO = "//XCUIElementTypeButton[@name='Lista Desplegable']";
		public static final String POP_UP_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeTextView[contains(@name, 'Verifique que el número del documento')]";
		public static final String BOTON_CANCELAR_POP_UP_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeButton[@name='Cancelar']";
		public static final String BOTON_REGISTRARME_POP_UP_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeButton[@name='Registrarme']";
		public static final String BOTON_INGRESAR_POP_UP_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeButton[@name='Ingresar']";
		public static final String BOTON_DECLARO_PERMISOS_REGISTRO_USUARIO_NUEVO = "//XCUIElementTypeButton[@name='checkbox empty'] | //XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
		public static final String TEXTO_INGRESE_SUS_DATOS = "//XCUIElementTypeStaticText[@name='Ingrese sus datos']";
		public static final String BOTON_NECESITO_AYUDA = "//XCUIElementTypeOther[contains(@name,'Ir a asesor virtual boton')]";
		public static final String OPCION_CEDULA = "//XCUIElementTypeOther[contains(@name,'Cédula')]";
		public static final String BOTON_REGRESAR = "//XCUIElementTypeButton[contains(@name, 'icon arrow left') or contains(@name, 'Regresar')] | //XCUIElementTypeButton[@name='Botón atrás']";
		public static final String BTN_REGRESO_ARROW_LEFT = "//XCUIElementTypeButton[@name='icon arrow left']";
		public static final String POP_UP_USER_REGISTRADO = "//XCUIElementTypeTextView[contains(@value, 'Para ingresar')]";
		public static final String TEXTO_POP_UP_USUARIO_CON_CUENTA = "//XCUIElementTypeTextView[contains(@name,'ya cuenta con un DaviPlata')]";
		public static final String TXT_AUTORIZACIONES_REGISTRO = "//XCUIElementTypeStaticText[@name='Autorizaciones'] | //XCUIElementTypeStaticText[contains(@name, 'Autorizaciones')]";
		public static final String CHECKBOX_AUTORIZACIONES = "//XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
		public static final String TXT_VALIDACION_IDENTIDAD = "//XCUIElementTypeStaticText[@name='Validación de identidad'] | //XCUIElementTypeStaticText[contains(@name, 'documento prefiere registrarse')]";
		public static final String BX_CEDULA_TRADICIONAL = "//XCUIElementTypeOther[@name='Cédula tradicional']";
		public static final String TXT_VALIDACION_IDENTIDAD_BIO = "//XCUIElementTypeStaticText[contains(@name, 'Ingrese sus datos')] | //XCUIElementTypeStaticText[contains(@value, 'Ingrese sus datos')] | (//XCUIElementTypeOther)[9]/preceding-sibling::XCUIElementTypeStaticText";
		public static final String BTN_REGRESAR_DESDE_VI_BIO = "//XCUIElementTypeButton[contains(@name, 'Botón atrás')] | //XCUIElementTypeButton[contains(@label, 'Botón atrás')] | //XCUIElementTypeNavigationBar[@name=\"DaviPlata.EnterYourDataView\"]/XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton";
		public static final String BTN_REGRESAR_DESDE_VI = "//XCUIElementTypeButton[@name='Botón atrás'] | //XCUIElementTypeButton[@label='Botón atrás'] | //XCUIElementTypeButton[contains(@name, 'Botón atrás')]";
		public static final String BTN_REGRESAR_DESDE_AUTORIZACIONES = "//XCUIElementTypeButton[@name='back'] | //XCUIElementTypeButton[contains(@label, 'back')]";
		public static final String BTN_REGISTRARME_HOME_BIENV = "//XCUIElementTypeButton[@name='Registrarme botón']";
		public static final String BTN_TRES_PUNTOS = "//XCUIElementTypeButton[@name='Menu boton']";
		public static final String OPCION_1_BTN_3_PUNTOS = "//XCUIElementTypeStaticText[contains(@name, 'Dónde usar su DaviPlata')]";
		public static final String OPCION_2_BTN_3_PUNTOS = "//XCUIElementTypeStaticText[contains(@name, 'Acerca de DaviPlata')]";
		public static final String BOTON_TOMAR_FOTO_CEDULA = "//XCUIElementTypeButton[@name='Tomar foto de mi cédula'] | //XCUIElementTypeStaticText[contains(@name, 'Tomar foto de mi cédula')] | //XCUIElementTypeStaticText[contains(@label, 'Tomar foto de mi cédula')]";
		public static final String TEXTO_FORMULARIO_MIS_DATOS = "//XCUIElementTypeStaticText[@name='Mis datos'] | //XCUIElementTypeStaticText[contains(@value, 'Mis datos')] | //XCUIElementTypeStaticText[contains(@name, 'Mis datos')] ";
		public static final String CAMPO_NOMBRE_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Escribir el nombre')] | //XCUIElementTypeTextField[contains(@label, 'Escribir el nombre')] | //XCUIElementTypeTextField[contains(@value, 'Igual como está en su documento')]";
		public static final String CAMPO_DOCUMENTO_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Escribir el número del documento')] | //XCUIElementTypeTextField[contains(@label, 'Escribir el número del documento')]";
		public static final String DESPLEGABLE_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE = "(//XCUIElementTypeButton[contains(@name, 'DD/MM/AAAA')])[1] | (//XCUIElementTypeButton[@name='DD/MM/AAAA'])[1] | //XCUIElementTypeStaticText[@name='Fecha de nacimiento']/following-sibling::XCUIElementTypeButton";
		public static final String OPCION_ANIO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE = "(//XCUIElementTypePickerWheel)[last()]";
		public static final String BOTON_HECHO_FECHA_NACIMIENTO_USUARIO_REGISTRO_CE = "//XCUIElementTypeButton[contains(@name, 'Done')] | //XCUIElementTypeButton[contains(@label, 'Done')]";
		public static final String DESPLEGABLE_FECHA_EXPEDICION_USUARIO_REGISTRO_CE = "(//XCUIElementTypeButton[@name='DD/MM/AAAA'])[2] | //XCUIElementTypeStaticText[@name='Fecha de expedición del documento']/following-sibling::XCUIElementTypeButton";
		public static final String CAMPO_CIUDAD_EXPEDICION_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Seleccionar el lugar de expedición')] | //XCUIElementTypeTextField[contains(@value, 'Ciudad de expedición del documento')] | //XCUIElementTypeStaticText[@name='Lugar de expedicíon del documento']/following-sibling::XCUIElementTypeTextField";
		public static final String CAMPO_NUMERO_CELULAR_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Escribir el número de celular')] |  //XCUIElementTypeTextField[contains(@label, 'Escribir el número de celular')] | //XCUIElementTypeStaticText[@name= 'Número de celular']/following-sibling::XCUIElementTypeTextField";
		public static final String CAMPO_CONFIRMAR_NUMERO_CELULAR_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Confirmar el número de celular')] | //XCUIElementTypeTextField[contains(@label, 'Confirmar el número de celular')] | //XCUIElementTypeStaticText[@name='Confirmar número de celular']/following-sibling::XCUIElementTypeTextField";
		public static final String CAMPO_CORREO_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@label, 'Escribir el correo electrónico')] | //XCUIElementTypeTextField[contains(@name, 'Escribir el correo electrónico')] | //XCUIElementTypeStaticText[@name='Correo eléctronico']/following-sibling::XCUIElementTypeTextField";
		public static final String CAMPO_CONFIRMAR_CORREO_USUARIO_REGISTRO_CE = "//XCUIElementTypeTextField[contains(@name, 'Confirmar el correo electrónico')] | //XCUIElementTypeTextField[contains(@label, 'Confirmar el correo electrónico')] | //XCUIElementTypeStaticText[@name='Confirmar correo electrónico']/following-sibling::XCUIElementTypeTextField";
		public static final String BOTON_CONTINUAR_POPUP_CAMBIO_DISPOSITIVO = "(//XCUIElementTypeButton[@name='Continuar'])[1] | //XCUIElementTypeStaticText[contains(@name, 'Continuar')] | //XCUIElementTypeStaticText[contains(@value, 'Continuar')]";
		public static final String POPUP_REGLAMENTO_CAMBIO_DISPOSITIVO = "//XCUIElementTypeStaticText[contains(@name, 'Le hemos enviado un código de 6 dígitos')]";
		public static final String INPUT_OTP_REGISTRO = "//XCUIElementTypeSecureTextField[contains(@name, 'Ingresar del codigo de 6 digitos')] | //XCUIElementTypeSecureTextField[contains(@value, 'Código de 6 dígitos')]";
		public static final String POPUP_REGLAMENTO_CAMBIO_DISPOSITIVO2 = "//XCUIElementTypeStaticText[contains(@name, 'DaviPlata le informa que el Valor Total Unificado')]";
		public static final String BOTON_TERMINO = "//XCUIElementTypeButton[@name='Aceptar reglamento DaviPlata']";
		public static final String BOTON_REGLAS = "//XCUIElementTypeButton[@name='Autorizar usar mis datos']";
		public static final String BOTON_AUTO = "//XCUIElementTypeButton[@name='Autorizar compartir mis datos']";
		public static final String CAMPO_CLAVE_REGISTRO = "//XCUIElementTypeSecureTextField[@name='Editar casilla clave DaviPlata']";
		public static final String CAMPO_CONFIRMACION_CLAVE_REGISTRO = "//XCUIElementTypeSecureTextField[@name='Editar casilla confirmar clave DaviPlata']";
		public static final String BOTON_CONTINUAR_CREACION_CLAVE = "//XCUIElementTypeStaticText[@name='Crear Daviplata']";
		public static final String ACEPTAR_BTN = "//XCUIElementTypeButton[@name='Continuar']";
		public static final String TEXTO_VIDEO_INFORMATIVO = "//XCUIElementTypeStaticText[contains(@name, 'Conozca todo lo que puede hacer con DaviPlata')]";
		public static final String TEXTO_ACTUALIZAMOS_CONDICIONES = "//XCUIElementTypeStaticText[@name='Actualizamos las condiciones de uso de sus datos']";
		public static final String CHECK_BOX_ACTUALIZACION_1 = "(//XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x'])[1]";
		public static final String CHECK_BOX_ACTUALIZACION_2 = "//XCUIElementTypeButton[@name='ic ui checkbox empty 2@2x']";
		public static final String ACEPTAR_ACTUALZIACION_CONDICIONES = "//XCUIElementTypeStaticText[@name='Aceptar']";
		public static final String TEXTO_CUANTO_TENGO_DETALLE_SALDO = "//XCUIElementTypeStaticText[contains(@value, 'Cuánto tengo')] | //XCUIElementTypeStaticText[contains(@label, 'Cuánto tengo')]";	
		public static final String CAMPO_NOMBRES_COMPLETOS = "//XCUIElementTypeTextField[contains(@name, 'Escribir el nombre')] | //XCUIElementTypeTextField[contains(@label, 'Escribir el nombre')] | //XCUIElementTypeTextField[contains(@value, 'Igual como está en su documento')]";
		public static final String DESPLEGABLE_FECHA_DIA = "(//XCUIElementTypeStaticText[contains(@value,'Día')])[1]";
		public static final String DESPLEGABLE_FECHA_DIA_VALUE = "//XCUIElementTypeStaticText[contains(@name,'31')]";
		public static final String DESPLEGABLE_FECHA_MES = "(//XCUIElementTypeStaticText[contains(@value,'Mes')])[1]";
		public static final String DESPLEGABLE_FECHA_MES_VALUE = "//XCUIElementTypeStaticText[contains(@name, 'Dic')]";
		public static final String DESPLEGABLE_FECHA_ANIO = "(//XCUIElementTypeStaticText[contains(@value,'Año')])[1]";
		public static final String DESPLEGABLE_FECHA_ANIO_VALUE = "//XCUIElementTypeStaticText[contains(@name,'1920')]";
		public static final String DESPLEGABLE_DIA_FECHA_EXPEDICION = "(//XCUIElementTypeStaticText[@name='Día'])[2]";
		public static final String DESPLEGABLE_MES_FECHA_EXPEDICION = "(//XCUIElementTypeStaticText[@name='Mes'])[2]";
		public static final String DESPLEGABLE_ANIO_FECHA_EXPEDICION = "(//XCUIElementTypeStaticText[@name='Año'])[2]";
		public static final String BTN_CONTINUAR_TECLADO = "(//XCUIElementTypeButton[@name='Continuar'])[2]";
		public static final String CAMPO_LUGAR_EXPEDICION = "//XCUIElementTypeTextField[contains(@name, 'Seleccionar el lugar de expedición')] | //XCUIElementTypeTextField[contains(@value, 'Ciudad de expedición del documento')] | //XCUIElementTypeStaticText[@name='Lugar de expedicíon del documento']/following-sibling::XCUIElementTypeTextField | //XCUIElementTypeStaticText[contains(@name,'Ciudad de expedición del documento')]";
		public static final String CAMPO_NUMERO_CELULAR = "//XCUIElementTypeTextField[contains(@name, 'Escribir el número de celular')] |  //XCUIElementTypeTextField[contains(@label, 'Escribir el número de celular')] | //XCUIElementTypeStaticText[@name= 'Número de celular']/following-sibling::XCUIElementTypeTextField | //XCUIElementTypeStaticText[contains(@name,'Número de celular')]";
		public static final String VALOR_CAMPO_NUMERO_CEL = "(//XCUIElementTypeOther)[22]/XCUIElementTypeTextField";
		public static final String CAMPO_CORREO = "//XCUIElementTypeTextField[contains(@label, 'Escribir el correo electrónico')] | //XCUIElementTypeTextField[contains(@name, 'Escribir el correo electrónico')] | //XCUIElementTypeStaticText[@name='Correo eléctronico']/following-sibling::XCUIElementTypeTextField | //XCUIElementTypeStaticText[@name='Correo electrónico']";
		public static final String VALOR_CAMPO_CORREO = "(//XCUIElementTypeOther)[23]/XCUIElementTypeTextField";
		public static final String CAMPO_CONFIRMACION_CORREO = "//XCUIElementTypeTextField[contains(@name, 'Confirmar el correo electrónico')] | //XCUIElementTypeTextField[contains(@label, 'Confirmar el correo electrónico')] | //XCUIElementTypeStaticText[@name='Confirmar correo electrónico']/following-sibling::XCUIElementTypeTextField | //XCUIElementTypeStaticText[@name='Confirme su correo electrónico']";
		public static final String VALOR_CAMPO_CONFIRMACION_CORREO = "(//XCUIElementTypeOther)[24]/XCUIElementTypeTextField";
		public static final String BOTON_CEDULA_VALIDACION = "//XCUIElementTypeOther[contains(@name, 'Cédula tradicional')]";
		public static final String TEXTO_FECHA_EXPEDICION = "//XCUIElementTypeStaticText[contains(@name, 'Fecha de expedición del documento')]";
		public static final String DISPLAY = "//XCUIElementTypeOther[@name='Vertical scroll bar, 7 pages'] | //XCUIElementTypeOther[@name='Vertical scroll bar, 3 pages'] | //XCUIElementTypeOther[@name='Vertical scroll bar, 18 pages'] | //XCUIElementTypeOther[@name='Vertical scroll bar, 21 pages']";
		public static final String INPUT_DAY = "(//XCUIElementTypeScrollView)[2]//XCUIElementTypeOther[30]";
		public static final String NOMBRES_APELLIDOS_FIELD = "//XCUIElementTypeStaticText[contains(@name, 'Nombres y apellidos')] | //XCUIElementTypeStaticText[contains(@label, 'Nombres y apellidos')]";
		public static final String POP_UP_FECHA_EXPEDICION = "//XCUIElementTypeStaticText[contains(@name, 'FECHA DE EXPEDICIÓN')]";
		public static final String BOTON_ACEPTAR = "//XCUIElementTypeStaticText[contains(@name, 'Aceptar')]";
		public static final String SELECCION_LUGAR_EXPEDICION = "//XCUIElementTypeCell//XCUIElementTypeStaticText";
		public static final String MENSAJE_CORREO_ERRONEO = "//XCUIElementTypeStaticText[contains(@value, 'El correo no coincide con el ingresado arriba')] | //XCUIElementTypeStaticText[contains(@name, 'El correo no coincide con el ingresado arriba')] | //XCUIElementTypeStaticText[@name='El correo no coincide con el ingresado arriba']";
		public static final String TEXTO_CODIGO_VERIFICACION = "//XCUIElementTypeStaticText[contains(@value, 'Código de verificación')] | //XCUIElementTypeStaticText[contains(@name, 'Código de verificación')]";
		public static final String TEXTO_CREACION = "//XCUIElementTypeStaticText[contains(@name, 'Felicitaciones')] | //XCUIElementTypeStaticText[contains(@name, 'Su DaviPlata ha sido creado')]";
		public static final String USAR_MI_DAVIPLATA = "//XCUIElementTypeStaticText[contains(@name, 'Usar Mi DaviPlata')] | //XCUIElementTypeButton[@name='Usar Mi DaviPlata']";
		public static final String BOTON_LAPIZ = "//XCUIElementTypeImage[@name='icon_pencil']";
		public static final String LO_SENTIMOS_FUNCIONALIDAD_NEGOCIO = "//XCUIElementTypeTextView[contains(@value, 'esta funcionalidad estará disponible cuando cambie su documento de identidad')] | //XCUIElementTypeButton[@name='Aceptar']/preceding-sibling::XCUIElementTypeOther";
		public static final String ACEPTAR_POP_UP_LO_SENTIMOS_FUNC_BTN = "//XCUIElementTypeButton[@name='Aceptar'] | //XCUIElementTypeButton[contains(@name, 'Aceptar')] | //XCUIElementTypeButton[contains(@label, 'Aceptar')]";
}
