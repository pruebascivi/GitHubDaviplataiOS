package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.openqa.selenium.By;

import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.MarketPlacePageObjects;
import daviplata.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import daviplata.nacional.iOS.pageObjects.PasarPlataPageObjects;
import daviplata.nacional.iOS.pageObjects.negocioPageObjects;
import daviplata.nacional.iOS.utilidades.BaseUtil;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class negocioSteps {

	 negocioPageObjects negocioPO = new negocioPageObjects();
	 LoginPageObjects pageLogin;
	 MarketPlacePageObjects marketObj;
	 Utilidades utilidad;
	 BaseUtil base;
	 MenuHamburguesaPageObjects menuHamburPO;
	 PasarPlataPageObjects pagePasarPlata;
	 UtilidadesTCS utilidadesTCS;
	
	@Step
	public void IrANegocio() {
//		pageLogin.validarInicioSesion();
		Utilidades.esperaMiliseg(10000);
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a perfil negocio");
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Perfil Mi Negocio");
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
	}
	
	@Step
	public void verificarSaldoInicialNegocio() {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		String saldoInicialNegocio = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.SALDOS_HOME_NEGOCIO);
		Utilidades.esperaMiliseg(1000);
		System.out.println("Saldo capturado home negocio: " + saldoInicialNegocio);
		String subSaldo = saldoInicialNegocio.replaceAll("[^0-9]", "");
		BigDecimal saldoInicial = new BigDecimal(subSaldo); 
		BaseUtil.saldoInicial = saldoInicial;
		//int longitud = subSaldo.length();
		//int numero = longitud - 2;
		//subSaldo = subSaldo.substring(0, numero); 
		BigDecimal numSaldo = new BigDecimal(subSaldo);
		Serenity.setSessionVariable("saldoInicial").to(numSaldo);
		Utilidades.tomaEvidencia("Saldo Inicial " + BaseUtil.saldoInicial);
		pagePasarPlata.validarIgualdadSaldosIniciales();
	}
	
	@Step
	public void IrAPersona() {
		pageLogin.validarInicioSesionPersona();
	}
	
	@Step
	public void validarBtnIrASuNegocio() {
		negocioPO.validarBotonIrASuNegocio();
		Utilidades.tomaEvidencia("Validar visibilidad botón cambio de perfil desde perfil persona");
//		negocioPO.IraNegocio();
		
	}
	
	@Step
	public void flujoCambiarFoto() {
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic imagen perfil persona");
		negocioPO.clicImagenPerfil();
		Utilidades.tomaEvidencia("Clic cambiar foto perfil persona");
		negocioPO.clicCambiarImagenPerfilPersona();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic tomar foto perfil persona");
		negocioPO.clicTomarFotoPerfilPersona();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Guardar foto perfil persona");
		negocioPO.guardarFotoPerfilPersona();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic botón aceptar guardar foto perfil persona");
		negocioPO.clicBtnAceptarGuardarFotoPerfilPersona();
		
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisiblePopUpAmigos == true) {
			
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
	}
	
	@Step
	public void irAMenuHamburguesaPerfilNegocio() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.SALDOS_HOME_NEGOCIO);
		Utilidades.esperaMiliseg(1500);
		negocioPO.clicMenuHamburguesaPerfilNegocio();
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Entro a menu hamburguesa perfil negocio");
	}
	
	@Step
	public void flujoCambiarFotoPerfilNegocio() {
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Clic imagen perfil negocio");
		negocioPO.clicImagenPerfilNegocio();
		Utilidades.tomaEvidencia("Clic cambiar foto perfil negocio");
		negocioPO.clicCambiarImagenPerfilNegocio();
		Utilidades.tomaEvidencia("Clic tomar foto perfil persona");
		Utilidades.esperaMiliseg(4000);
		negocioPO.clicTomarFotoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Guardar foto perfil negocio");
		negocioPO.guardarFotoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Clic botón aceptar guardar foto perfil persona");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		
	}
	
	@Step
	public void validarCambioFoto() {
		//negocioPO.validarCambioFotoPerfilPersona();
		Utilidades.esperaMiliseg(500);
		//utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TXT_CAMBIO_EXITOSO_FOTO);
		Utilidades.tomaEvidencia("Valido mensaje cambio exitoso de foto de perfil persona");
	}
	
	@Step
	public void validarCambioFotoPerfilNegocio() {
		Utilidades.tomaEvidencia("Validacion de cambio en foto perfil negocio");
		negocioPO.validarCambioFotoPerfilNegocio();
	}
	
	@Step
	public void validarCampanaPerfilNegocio() {
		Utilidades.esperaMiliseg(25000);
		Utilidades.tomaEvidencia("Validar Campana de notificaciones");
		negocioPO.validacionCampanaPerfilNegocio();
	}
	
	@Step
	public void validarBotonCerrarPerfilNegocio() {
		Utilidades.esperaMiliseg(25000);
		Utilidades.tomaEvidencia("Validar botón cerrar");
		negocioPO.validacionBotonCerrarPerfilNegocio();
	}
	
	@Step
	public void validarMenuHamburguesaPerfilNegocio() {
		negocioPO.validacionMenuHamburguesaPerfilNegocio();
		Utilidades.tomaEvidencia("Validar menu hamburguesa");
	}
	
	@Step
	public void validarBtnMenuHamburguesaPerfilNegocio() {
		Utilidades.esperaMiliseg(25000);
		Utilidades.tomaEvidencia("Validar boton menu hamburguesa");
		negocioPO.validarBotonMenuHamburguesaPerfilNegocio();
	}
	
	public void validarBtnMenuHamburguesaPerfilNegocioUsarPlata() {
		System.out.println("esperando que cargue el negocio");
		Utilidades.esperaMiliseg(25000);
		System.out.println("se termino la espera");
		Utilidades.tomaEvidencia("Validar boton menu hamburguesa");
		negocioPO.validarBotonMenuHamburguesaPerfilNegocio();
		negocioPO.clicMenuHamburguesaPerfilNegocio();
		Utilidades.tomaEvidencia("Clic boton Usar Plata");
		negocioPO.clicOpcionUsarPlata();
		negocioPO.validarOpcionPasarPlataPerfilNegocio();
		negocioPO.validarOpcionSacarPlataPerfilNegocio();
		Utilidades.tomaEvidencia("Validar Opcion 'Pasar Plata' y 'Sacar Plata' de la opcion 'Usar Plata'");
	}
	
	
	@Step
	public void nombrePerfilNegocio() {
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Nombre del negocio");
		negocioPO.validarNombreNegocio();
	}
	
	@Step
	public void ValidarSaldoNegocio() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.SaldoNegocio();
		Utilidades.tomaEvidencia("Saldo negocio");
		negocioPO.validarSaldoNegocio();
	}
	
	@Step
	public void clickPasarPlataHome() {
		Utilidades.esperaMiliseg(25000);
		Utilidades.tomaEvidencia("Clic botón pasar plata");
		System.out.println("se acabo la espera para dar click pasar plata");
		negocioPO.clickPasarPlataHome();
	}
	
	@Step
	public void ValidarPasarPlataHome() {
		negocioPO.ValidarPasarPlataHome();
		Utilidades.tomaEvidencia("Valido Ingreso a pasarPlata");
	}
	
	@Step
	public void clickSacarPlataHome() {
		Utilidades.esperaMiliseg(25000);
		Utilidades.tomaEvidencia("Clic botón sacar plata");
		negocioPO.clickSacarPlataHome();
	}
	
	@Step
	public void ValidarSacarPlataHome() {
		negocioPO.ValidarSacarPlataHome();
		Utilidades.tomaEvidencia("Valido Ingreso a sacar plata");
	}
	
	@Step
	public void creacionNegocioZonaPublica(String contrasena, String nombre, String monto, String casa, String correo) {
		Utilidades.tomaEvidencia("Clic boton vender");
		negocioPO.clicBtnVender();
		marketObj.ingresarTerminosCondiciones();
		Utilidades.tomaEvidencia("Ingresar a terminos y condiciones");
		//smarketObj.hacerClicBtnAceptarTerminosCondiciones();
		Utilidades.esperaMiliseg(4000);
		utilidad.moverPantallaCorto();
		Utilidades.tomaEvidencia("Crear negocio");
		marketObj.hacerClicBtnCrearNegocio();
		Utilidades.tomaEvidencia("Ingresar Contraseña");
		pageLogin.ingresarContrasena(contrasena);
		pageLogin.darClicBotonIngresar();
		llenarFormularioCreacionNegocioZonaPublica(nombre,monto,casa,correo);
		marketObj.clicBtnCrearPerfilNegocio();
	}
	
	public void llenarFormularioCreacionNegocioZonaPublica(String nombre, String monto, String casa, String correo) {
		marketObj.esperarDesaparezcalogoCarga();
		utilidad.moverPantallaCorto();
		marketObj.ingresarNombrePerfilNegocio(nombre);
		//marketObj.clicBtnVenderPerfilNegocio();
		//marketObj.clicDiscoVenderPerfilNegocio();
		marketObj.ingresarMontoPerfilNegocio(monto);
		//marketObj.clicBtnCiudadPerfilNegocio();
		marketObj.elegirBtnCiudadPerfilNegocio();
		marketObj.clicTipoViaPerfilNegocio();
		marketObj.elegirTipoViaPerfilNegocio();
		marketObj.ingresarNumeroViaPerfilNegocio();
		marketObj.ingresarPrimerNumeroPlacaPerfilNegocio();
		marketObj.ingresarSegundoNumeroPlacaPerfilNegocio();
		marketObj.ingresarTipoViviendaPerfilNegocio(casa);
		marketObj.ingresarCorreoPerfilNegocio(correo);		
		Utilidades.tomaEvidencia("Completo el formulario requerido");
	}
	
	public void validoBotonIrPerfilUsuario() {
		negocioPO.validarBotónIrAPerfilPersona();
		Utilidades.tomaEvidencia("Validar boton ir a perfil persona");
		negocioPO.btnIrAPerfilPersona();
		Utilidades.esperaMiliseg(10000);
	}
	
	public void ingresarOpcionPasarPlataPerfilNegocio() {
//		utilidad.tomaEvidencia("Clic en opcion usar plata");
//		negocioPO.clicOpcionUsarPlata();
		Utilidades.tomaEvidencia("Clic en opcion pasar plata");
		negocioPO.clicOpcionPasarPlataPerfilNegocio();
	}
	
	public void ingresarOpcionSacarPlataPerfilNegocio() {
//		utilidad.tomaEvidencia("Menú hamburguesa");
//		negocioPO.clicOpcionUsarPlata();
		Utilidades.esperaMiliseg(5000);
		utilidadesTCS.clickCoordinates(87, 477);
		negocioPO.clicOpcionSacarPlataPerfilNegocio();
		Utilidades.tomaEvidencia("Clic en opcion sacar plata");
	}
	
	@Step
	public void ingresarOpcionSacarPlataHomePerfilNegocio() {
//		negocioPO.esperarCargaPerfilNegocio();
		Utilidades.tomaEvidencia("Clic en botón sacar plata");
		negocioPO.clicOpcionSacarPlataPerfilNegocio();
	}
	
	@Step
	public void ingresarOpcionPasarPlataHomePerfilNegocio() {
		negocioPO.esperarCargaPerfilNegocio();
		Utilidades.tomaEvidencia("Clic en botón Pasar plata");
		negocioPO.clicBotonPasarPlataHomePerfilNegocio();
		
	}
	
	public void ingresarOpcionAOtroDaviplataPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Clic en opcion a otro daviplata");
		negocioPO.clicBtnAOtroDaviplataPerfilNegocio();
		negocioPO.clicBtnAceptarPerfilNegocio();
				
	}
	
	public void flujoPasarPlataAOtroDaviplataPerfilNegocio(String numCelular) {
		Utilidades.tomaEvidencia("Ingresar numero cuenta: " + numCelular);
		negocioPO.ingresarNumeroCuentaPerfilNegocio(numCelular);
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.tomaEvidencia("Escoger monto a pasar");
		negocioPO.escogerMontoPerfilNegocio();
		negocioPO.clicBtnAceptarMonto();
		Utilidades.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();	
		
		
		
	}
	
	public void flujoSacarPlataPerfilNegocio() {
		negocioPO.escogerMontoPerfilNegocioSacarPlata();
		Utilidades.tomaEvidencia("Seleccionar monto");
		negocioPO.clicBtnAceptarPerfilNegocio();
		Utilidades.tomaEvidencia("Confirmación de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Confirmación de codigo de retiro");
		Utilidades.esperaMiliseg(4000);
		utilidadesTCS.clickCoordinates(214,563);
		System.out.println("Se completo el proceso de 'Sacar Plata'");
		
		Utilidades.esperaMiliseg(15000);
		utilidadesTCS.clickCoordinates(155,148);
		Utilidades.esperaMiliseg(2500);
		System.out.println("Se ingresa a Mi DaviPlata");
		Utilidades.tomaEvidencia("Se ingresa a Mi DaviPlata");
		pagePasarPlata.capturarSaldoFinal();
		Utilidades.tomaEvidencia("Saldo Final " + BaseUtil.saldoFinal);
		Utilidades.esperaMiliseg(2000);
		menuHamburPO.darClickVerMovimientos();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Ingreso a 'Ver Movimientos'");
		negocioPO.seleccionarMovimiento();
		Utilidades.tomaEvidencia("Numero de autorizacion del movimiento");
		Utilidades.esperaMiliseg(4000);
		negocioPO.txtAutorizadorSacarPlataPerfilNegocio();	
		utilidadesTCS.clicElement("xpath", MenuHamburguesaPageObjects.BOTON_FINALIZAR_MOVIMIENTOS);
		
	}
	
	public void validacionBtnMasServicios() {
		negocioPO.validarBtnMasServicios();
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Validación de botón 'Más Servicios'");
	}
	
	@Step
	public void verificarAbrirPuntoVenta() {
		try {
			utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.ADMINISTRAR_NEGOCIO);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.ADMINISTRAR_NEGOCIO);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.ADMIN_NEGOCIO_MODULE);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido el módulo 'Administrar mi negocio'");

		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.ADMINISTRAR_NEGOCIO) : "No se pudo interactuar con el elemento." + negocioPageObjects.ADMINISTRAR_NEGOCIO;
		}
	}
	
	@Step
	public void abrirPuntoDeVenta() {
		try {
			utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.ABRIR_PUNTO_VENTA_BTN);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.ABRIR_PUNTO_VENTA_BTN);
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.ABRIR_PUNTO_VENTA_MODULO);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido el módulo 'Administrar mi negocio - Abrir punto de venta.'");

		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.ABRIR_PUNTO_VENTA_BTN) : "No se pudo interactuar con el elemento." + negocioPageObjects.ABRIR_PUNTO_VENTA_BTN;
		}
	}
	
	@Step
	public void completarFormularioCrearPuntoDeVenta(String puntoVentaName, String ciudad, String tipoDireccion) {
		try {
			utilidadesTCS.clicElement("xpath", negocioPageObjects.NOMBRE_PUNTO_VENTA_CAMPO);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", negocioPageObjects.NOMBRE_PUNTO_VENTA_CAMPO, puntoVentaName);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.CIUDAD_MUNICIPIO_PUNTO_VENTA_CAMPO);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", negocioPageObjects.CIUDAD_MUNICIPIO_PUNTO_VENTA_CAMPO, ciudad);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_AVENIDA);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.DIRECCIÓN_PUNTO_VENTA_CAMPO);
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_AVENIDA);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", negocioPageObjects.LETRA_PUNTO_VENTA_CAMPO, "67");
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", negocioPageObjects.NUMERO1_PUNTO_VENTA_CAMPO, "51");
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", negocioPageObjects.NUMERO2_PUNTO_VENTA_CAMPO, "57");
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("Valido datos ingresados para crear punto de venta");
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", negocioPageObjects.CREAR_PUNTO_VENTA_BTN);
				
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.ABRIR_PUNTO_VENTA_BTN) : "No se pudo interactuar con el elemento." + negocioPageObjects.ABRIR_PUNTO_VENTA_BTN;
		}
	}
	
	public void verMovimientosPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a movimientos de ventas en el perfil negocio desde 'Más Servicios'");
		Utilidades.esperaMiliseg(1000);
		negocioPO.clicBtnMovimientosPerfilNegocio();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Validación movimientos de ventas en el perfil negocio");
	}
	
	public void validarMovimientosPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Validación movimientos de ventas en el perfil negocio");
	}
	
	public void actualizacionDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.validarActualizarDatosPerfilNegocio();
		negocioPO.clicActualizarDatosPerfilNegocio();
		Utilidades.esperaMiliseg(10000);
		Utilidades.tomaEvidencia("Validación actualizacion de datos en el perfil negocio");
	}
	
	public void actualizarDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.clicActualizarDatosPerfilNegocio();
		Utilidades.esperaMiliseg(15000);
	}
	
	public void actualizarCorreoPerfilNegocio(String correoNuevo) {
		//negocioPO.ingresarCorreoNuevoPerfilNegocio(correoNuevo);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.CAMPO_CORREO);
        utilidadesTCS.cleanInputElement("xpath", negocioPageObjects.CAMPO_CORREO);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_CORREO, correoNuevo);
		//negocioPO.ingresarConfirmacionCorreoNuevoPerfilNegocio(correoNuevo);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.CAMPO_CONFIRM_CORREO);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_CONFIRM_CORREO, correoNuevo);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE_TECLADO);
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidencia("Ingresé y confirmé el correo nuevo en el perfil negocio");
		Utilidades.esperaMiliseg(1500);
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	public void actualizarNombrePerfilNegocio(String nombreNegocioNuevo) {
		negocioPO.ingresarNombrePerfilNegocio(nombreNegocioNuevo);
		Utilidades.tomaEvidencia("Ingresar nombre nuevo en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	public void actualizarDireccionPerfilNegocio(String tipoVia, String numeroUno, String numeroDos, String numeroTres) {
		System.out.println("entre a actualizar direccion");
		negocioPO.clicInputDireccionPerfilNegocio();
		negocioPO.clicTipoViaDireccionPerfilNegocio();
		negocioPO.clicTipoViaDiscosDireccionPerfilNegocio(tipoVia);
		negocioPO.inputNumeroUnoDireccionPerfilNegocio(numeroUno);
		negocioPO.inputNumeroDosDireccionPerfilNegocio(numeroDos);
		negocioPO.inputNumeroTresDireccionPerfilNegocio(numeroTres);		
		Utilidades.tomaEvidencia("Ingresar dirección nueva en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	
	public void validarActualizacionDatosPerfilNegocio() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarMensajeActualizacionPerfilNegocio();
		Utilidades.tomaEvidencia("Validación modificación");
		
	}
	
	public void actualizarCiudadPerfilNegocio(String ciudadNueva) {
		Utilidades.esperaMiliseg(8000);
		negocioPO.actualizacionCiudadPerfilNegocio(ciudadNueva);
		negocioPO.escogerActualizacionCiudadPerfilNegocio();
		Utilidades.tomaEvidencia("Actualización ciudad perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
		
	}
	
	public void actualizarVentasPerfilNegocio(String ventaNueva) {
		Utilidades.esperaMiliseg(8000);
		negocioPO.actualizacionVentasPerfilNegocio(ventaNueva);
		negocioPO.escogerActualizacionVentasPerfilNegocio();
		Utilidades.tomaEvidencia("Actualización ventas perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
		
	}
	
	public void validarActualizacionDatosDireccionPerfilNegocio() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarMensajeActualizacionDireccionNegocioPerfilNegocio();
		Utilidades.tomaEvidencia("Validación modificación de dirección perfil negocio");
		
	}
	
	public void valdacionBotonVender() {
		negocioPO.validarBtnVender();
		Utilidades.tomaEvidencia("validar boton vender de zona publica");
		
	}
	
	public void validacionIngresoCreacionNegocio() {
		negocioPO.clicBtnVender();
		negocioPO.validarIngresoCreacionNegocioZonaPublica();
		Utilidades.tomaEvidencia("validar ingreso a creación negocio zona publica");
		
	}
	
	public void ingresarAOpcionCrearCatalogo() {
		Utilidades.esperaMiliseg(5000);
		utilidadesTCS.scrollBackground("xpath", negocioPageObjects.SALDOS_HOME_NEGOCIO, 0, -100);
		//Utilidades.scrollDownSwipe();
		Utilidades.tomaEvidencia("Ingresar a crear catalago");
		negocioPO.clicCrearCatalogoPerfilNegocio();
	}
	
	@Step
	public void creacionCatalogo(String nombreCatalogo, String nombreCategoria, String nombreProducto, String nombreContacto, String numeroContacto, String colorReferencias, String unidadesDisponibles, String valorProducto) {
		Utilidades.tomaEvidencia("Aceptar caracteristicas del negocio");
		//negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.clicBtnTomarFotoCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Tomar foto del producto catálogo");
		//negocioPO.clicTomarFotoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		utilidadesTCS.clickCoordinates(210, 410);
		Utilidades.tomaEvidencia("Guardar foto Catálogo");
		Utilidades.esperaMiliseg(1500);
		negocioPO.guardarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar Guardar foto Catálogo");
		Utilidades.esperaMiliseg(1500);
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		negocioPO.ingresarNombreCatalogoPerfilNegocio(nombreCatalogo);
		negocioPO.ingresarNombreCategoriaPerfilNegocio(nombreCategoria);
		Utilidades.tomaEvidencia("Llenar formulario de creacion catálogo");
		
	/** PASOS COMENTADOS POR FALLA EN AMBIENTE EN LA APP **/
		//negocioPO.clicCrearProductoCatalogoPerfilNegocio();
		//utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		//Utilidades.esperaMiliseg(1500);
		//Utilidades.tomaEvidencia("Valido mensaje de creación de catálogo");
		//utilidadesTCS.clickCoordinates(200, 500);
		//utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_CREAR_PRIMER_PRODUCTO);
		Utilidades.esperaMiliseg(2000);
		negocioPO.clicFotoProductoCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Tomar foto del producto catálogo");
		//negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Guardar foto");
		negocioPO.guardarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar Guardar foto");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		negocioPO.inputNombreProductoCatalogoPerfilNegocio(nombreProducto);
		negocioPO.inputNombreContactoCatalogoPerfilNegocio(nombreContacto);
		negocioPO.inputNumeroContactoCatalogoPerfilNegocio(numeroContacto);
		Utilidades.tomaEvidencia("Llenar formulario de producto");
		negocioPO.clicReferenciasCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Selecciono opción Referencia");
		utilidadesTCS.scrollBackground("xpath", negocioPageObjects.REFERENCIAS, 0, -200);
		Utilidades.esperaMiliseg(1000);
		negocioPO.inputColorReferenciasCatalogoPerfilNegocio(colorReferencias);
		negocioPO.inputUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
		negocioPO.inputValorProductoCatalogoPerfilNegocio(valorProducto);
		negocioPO.clicAgregarReferenciasPerfilNegocio();
		Utilidades.tomaEvidencia("Llenado del formulario completo");
		negocioPO.clicBtnCrearProductoCatalogoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Valido datos para creacion de producto");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.ACEPTAR);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.tomaEvidencia("Se acepta la creacion de producto");
	}
	
	public void creacionCatalogoSinReferencia(String nombreCatalogo, String nombreCategoria, String nombreProducto, String nombreContacto, String numeroContacto, String unidadesDisponibles, String valorProducto) {
		Utilidades.tomaEvidencia("Aceptar caracteristicas del negocio");
		//negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.clicBtnTomarFotoCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Tomar foto del producto catálogo");
		negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		//negocioPO.clicTomarFotoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		utilidadesTCS.clickCoordinates(210, 410);
		Utilidades.tomaEvidencia("Guardar foto Catálogo");
		Utilidades.esperaMiliseg(1500);
		negocioPO.guardarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar Guardar foto Catálogo");
		Utilidades.esperaMiliseg(1500);
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		negocioPO.ingresarNombreCatalogoPerfilNegocio(nombreCatalogo);
		negocioPO.ingresarNombreCategoriaPerfilNegocio(nombreCategoria);
		Utilidades.tomaEvidencia("Llenar formulario de creacion catálogo");
		
	/** PASOS COMENTADOS POR FALLA EN AMBIENTE EN LA APP **/
		//negocioPO.clicCrearProductoCatalogoPerfilNegocio();
		//utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		//Utilidades.esperaMiliseg(1500);
		//Utilidades.tomaEvidencia("Valido mensaje de creación de catálogo");
		//utilidadesTCS.clickCoordinates(200, 500);
		//utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_CREAR_PRIMER_PRODUCTO);
		Utilidades.esperaMiliseg(2000);
		negocioPO.clicFotoProductoCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Tomar foto del producto catálogo");
		//negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Guardar foto");
		negocioPO.guardarFotoPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar Guardar foto");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		negocioPO.inputNombreProductoCatalogoPerfilNegocio(nombreProducto);
		negocioPO.inputNombreContactoCatalogoPerfilNegocio(nombreContacto);
		negocioPO.inputNumeroContactoCatalogoPerfilNegocio(numeroContacto);

		negocioPO.clicSinReferenciasCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Seleccionar Opcion Sin Referencia");
		utilidadesTCS.scrollBackground("xpath", negocioPageObjects.REFERENCIAS, 0, -200);
		Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElementAction("xpath", negocioPageObjects.INPUT_UNIDADES);
		utilidadesTCS.escribirPorTecladoIos(unidadesDisponibles);
		//negocioPO.inputSinReferenciaUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
		negocioPO.inputValorProductoSinReferenciaCatalogoPerfilNegocio(valorProducto);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE_TECLADO);
		//negocioPO.clicCheckEnviosPerfilNegocio();
		Utilidades.tomaEvidencia("Llenado del formulario completo");		
		negocioPO.clicBtnCrearProductoCatalogoPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Valido datos para creacion de producto");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.ACEPTAR);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.tomaEvidencia("Se acepta la creacion de producto");
	}
	
	public void validarCreacionCatalogo() {		
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(5000);
		//negocioPO.validarCreacionCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Producto y catálogo creados");
	}
	
	public void validarCatalogo() {
		Utilidades.esperaMiliseg(35000);
		System.out.println("termine de esperar");
		for(int i = 0; i<3; i++) {
			Utilidades.scrollDownSwipe();	
		}
		//negocioPO.scrollCatalogo();
		negocioPO.validarCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Validación de catálogo existente");
	}
	
	public void ingresarACatalogo() {
		Utilidades.esperaMiliseg(35000);
		for(int i = 0; i<3; i++) {
			Utilidades.scrollDownSwipe();	
		}
		Utilidades.tomaEvidencia("Ingresar a catálogo existente");
		negocioPO.clicCatalogoPerfilNegocio();
	}
	
	public void validacionOpcionesCatalogo() {
		Utilidades.esperaMiliseg(17000);
		System.out.println("termine de esperar que cargue el catalogo");
		Utilidades.tomaEvidencia("Ingresar a opciones de catálogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();	
		Utilidades.esperaMiliseg(2000);
		negocioPO.validarOpcionCompartirCatalogoPerfilNegocio();
		negocioPO.validarOpcionEditarCatalogoPerfilNegocio();
		negocioPO.validarOpcionEliminarCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Validar opciones compartir, editar y eliminar del catálogo");
	}
	
	public void validacionOpcionEditarProductoCatalogo() {
		Utilidades.esperaMiliseg(12000);
		Utilidades.tomaEvidencia("Ingresar a opciones de producto");
		negocioPO.clicOpcionesProductoCatalogoPerfilNegocio();	
		Utilidades.tomaEvidencia("Ingresar a opción editar producto");
		negocioPO.validarOpcionEditarProductoPerfilNegocio();
		negocioPO.clicOpcionEditarPerfilNegocio();
		Utilidades.tomaEvidencia("Validar opción editar producto del catálogo");
	}
	
	public void validacionOpcionCompartir() {
		/*
		 * VALIDACION DE CATALOGO BTN COMPARTIR
		 * */
		Utilidades.esperaMiliseg(12000);
		System.out.println("validando catalogo");
		Utilidades.tomaEvidencia("Ingresar a opciones de catálogo");
		System.out.println("dando clic a btn catalogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Clic opción compartir catálogo");
		System.out.println("click opcion compartir");
		negocioPO.clicOpcionCompartirCatalogoPerfilNegocio();
		Utilidades.esperaMiliseg(2000);
		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Validar opción compartir por mensajes en Catálogo");
		Utilidades.esperaMiliseg(2000);
		negocioPO.clicFueraDelContenidoCompartirPerfilNegocio();
		
		/*
		 * VALIDACION DE CATEGORIA BTN COMPARTIR
		 * */
//		System.out.println("validando categoria");
//		utilidad.esperaMiliseg(2000);
//		utilidad.tomaEvidencia("Clic opciones categoria");
//		negocioPO.clicOpcionesCategoriaPerfilNegocio();
//		utilidad.tomaEvidencia("Clic opción compartir categoria");
//		negocioPO.clickBtnCompartirCategoria();
//		utilidad.esperaMiliseg(2000);
//		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
//		utilidad.tomaEvidencia("Validar opción compartir por mensajes en Categoria");
//		utilidad.esperaMiliseg(2000);
//		negocioPO.clicFueraDelContenidoCompartirPerfilNegocio();
//		
//		/*
//		 * VALIDACION DE PRODUCTO BTN COMPARTIR
//		 * */
//		System.out.println("validando producto");
//		utilidad.tomaEvidencia("Clic opciones producto");
//		negocioPO.clicOpcionesProductoCatalogoPerfilNegocio();
//		utilidad.tomaEvidencia("Clic opción compartir producto");
//		negocioPO.clickBtnCompartirProducto();
//		utilidad.esperaMiliseg(2000);
//		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
//		utilidad.tomaEvidencia("Validar opción compartir por mensajes en producto");		
	}
	
	public void validacionOpcionEliminarCatalogo() {
		Utilidades.esperaMiliseg(12000);
		Utilidades.tomaEvidencia("Ingresar a opciones de catálogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();
		negocioPO.validarOpcionEliminarCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Validar opción eliminar del catálogo");
		
	}
	
	public void ingresarACodigoQR() {
		negocioPO.esperarCargaPerfilNegocio();
		Utilidades.tomaEvidencia("Ingresar a opción QR");
		negocioPO.clicOpcionQR();
		
		
	}
	
	public void creacionQRSinValor() {
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Clic botón 'Generar QR' sin valor");
		negocioPO.clickBtnGenerarQr();
		
		
	}
	
	public void creacionQRConValor(String valor) {
		Utilidades.esperaMiliseg(8000);
		negocioPO.ingresarValorQR(valor);
		Utilidades.tomaEvidencia("Ingresar valor de QR");
		negocioPO.clickBtnGenerarQr();
	}
	
	public void creacionQRConValorMinimo(String valorMinimo) {
		Utilidades.esperaMiliseg(4000);
		System.out.println("ingresando a escribir valor minimo");
		negocioPO.ingresarValorQRMinimo(valorMinimo);
		Utilidades.tomaEvidencia("Ingresar valor minimo de QR");
		System.out.println("dando click a btn generar");
		negocioPO.clickBtnGenerarQr();		
	}
	
	public void creacionQRConValorMaximo(String valorMaximo) {
		Utilidades.esperaMiliseg(1500);
		negocioPO.clicBtnFinalizarQR();
		Utilidades.esperaMiliseg(15000);
		ingresarACodigoQR();
		Utilidades.esperaMiliseg(15000);
		negocioPO.ingresarValorQRMaximo(valorMaximo);
		Utilidades.tomaEvidencia("Ingresar valor maximo de QR");
		negocioPO.clickBtnGenerarQr();		
	}
	
	public void validarQRCreado() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		Utilidades.tomaEvidencia("validar QR generado sin valor");
		
		
	}
	
	public void validarQRCreadoValorAleatorio() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		Utilidades.tomaEvidencia("validar QR generado con valor aleatorio");
		
		
	}
	
	public void validarQRCreadoValorMinimo() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		Utilidades.tomaEvidencia("validar QR generado con valor minimo");
		
		
	}
	
	public void validarQRCreadoValorMaximo() {
		Utilidades.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		Utilidades.tomaEvidencia("validar QR generado con valor maximo");
		
		
	}
	
	public void validarDescargaQR() {
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Clic descargar QR");
		System.out.println("validando descarga");
		negocioPO.clicBtnDescargarQR();
		Utilidades.esperaMiliseg(15000);
		System.out.println("validando imagen descarga pdf");
		negocioPO.validarQRDescargado();
		Utilidades.tomaEvidencia("validar QR descargado sin valor");
		
		
	}
	
	public void validarDescargaQRConValor() {
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Clic descargar QR");
		negocioPO.clicBtnDescargarQR();
		Utilidades.esperaMiliseg(10000);
		negocioPO.validarQRDescargado();
		Utilidades.tomaEvidencia("validar QR descargado Con valor");
	}
	
	public void validarCompartirQR() {
		System.out.println("validando compartir");
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Clic compartir QR");
		System.out.println("dando click a btn compartir");
		negocioPO.clicBtnCompartirQR();
		System.out.println("validar elementos de compartir");
		negocioPO.validarElementosCompartirQR();
		Utilidades.tomaEvidencia("validar compartir QR sin valor");
	}
	
	public void validarCompartirQRConValor() {
		Utilidades.esperaMiliseg(10000);
		Utilidades.tomaEvidencia("Clic compartir QR");
		System.out.println("dando click a btn compartir");
		negocioPO.clicBtnCompartirQR();
		//negocioPO.darPermisosContactos();
		System.out.println("validar elementos de compartir");
		negocioPO.validarElementosCompartirQR();
		Utilidades.tomaEvidencia("validar compartir QR con valor");
		
		
	}
	
	public void irACuentaDeAhorros() {
		Utilidades.esperaMiliseg(5000);
		System.out.println("ingresando a donde quiero pasar plata");
		negocioPO.clicCuentaAhorros();
		System.out.println("dando click a btn aceptar");
		Utilidades.tomaEvidencia("Clic cuenta de ahorros");
		negocioPO.clicBtnAceptarPerfilNegocio();
		
		
		
	}
	
	public void flujoPasarPlataACuentaAhorrosPerfilNegocio(String numCuenta) {
		negocioPO.ingresarNumeroCuentaAhorrosPerfilNegocio(numCuenta);
		Utilidades.tomaEvidencia("Ingresar numero cuenta");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.escogerMontoPerfilNegocio();
		Utilidades.tomaEvidencia("Escoger monto a pasar");
		negocioPO.clicBtnAceptarPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();	
	}
	
	public void irACuentaCorriente() {
		negocioPO.clicCuentaCorriente();
		Utilidades.tomaEvidencia("Clic cuenta corriente");
		negocioPO.clicBtnAceptarPerfilNegocio();
	}
	
	public void flujoPasarPlataACuentaCorrientePerfilNegocio(String numCuenta) {
		negocioPO.ingresarNumeroCuentaCorrientePerfilNegocio(numCuenta);
		Utilidades.tomaEvidencia("Ingresar numero cuenta");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.escogerMontoPerfilNegocio();
		Utilidades.tomaEvidencia("Escoger monto a pasar");
		negocioPO.clicBtnAceptarPerfilNegocio();
		Utilidades.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.esperaMiliseg(8000);
		Utilidades.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();		
		
	}
	
	public void irAOtrosBancos() {
		negocioPO.clicAOtrosBancos();
		Utilidades.tomaEvidencia("Clic a otros bancos");
		negocioPO.clicBtnAceptarPerfilNegocio();		
	}
	
	public void irAOtrosBancosEnLinea() {
		negocioPO.clicAOtrosBancosEnLinea();
		Utilidades.tomaEvidencia("Clic a otro banco en linea");
		negocioPO.clicBtnAceptarPerfilNegocio();		
	}
	
	public void flujoPasarPlataAOtrosBancosPerfilNegocio(String numeroProducto, String numId, String montoAPasar, String motivoPasarPlata) {
		Utilidades.tomaEvidencia("Ingresar a cuentas no inscritas");
		negocioPO.clicOpcionCuentaNoInscrita();
		Utilidades.esperaMiliseg(4000);
		negocioPO.clicDesplegableBanco();
		String banco = "DAVIVIENDA";
		utilidadesTCS.scrollToElements("xpath", negocioPageObjects.DESLIZABLE_BANCOS, "//XCUIElementTypeButton[@name='"+ banco.trim() +"']", 20, 0, -200);
		Utilidades.esperaMiliseg(1000);
		negocioPO.clicTipoProducto();
		String tipoProducto = "Cuenta de Ahorros";
		utilidadesTCS.seleccionarTipoProducto("xpath", tipoProducto);
		Utilidades.esperaMiliseg(1000);
		negocioPO.ingresarNumeroProducto(numeroProducto);
		Utilidades.esperaMiliseg(1000);
		negocioPO.clicTipoIdentificacion();
		negocioPO.clicDiscosTipoIdentificacion();
		negocioPO.ingresarNumeroIdentificacion(numId);
		negocioPO.inputPlataAPasar(montoAPasar);
		negocioPO.inputDescripcionPasarPlata(motivoPasarPlata);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE_TECLADO);
		Utilidades.tomaEvidencia("Completo todo el formulario");
		negocioPO.clicBtnContinuar();
		Utilidades.esperaMiliseg(3000);
		
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BTN_DONE_TECLADO);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", negocioPageObjects.ACEPTAR);
		}
		Utilidades.tomaEvidencia("Valido información ingresada en el formulario");
		negocioPO.clicBtnContinuar();
		Utilidades.esperaMiliseg(5000);
		
		negocioPO.clicBtnAceptarCondiciones();
        negocioPO.clicBtnContinuarInformacion();
        negocioPO.validarTransaccionAOtrosBancosPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();        
	}
	
	public void flujoPasarPlataAOtroBancoEnLineaPerfilNegocio(String numCelular, String monto) {
		Utilidades.esperaMiliseg(40000);
		utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.DIRIGIENDO_PERFIL_PERSONA_TXT);
		Utilidades.tomaEvidencia("Esperando a ingresar a la opción pasar plata en linea");
        int contador = 0;
        while (contador < 5) {
            if (utilidadesTCS.validateElementInvisibility("xpath", negocioPageObjects.DIRIGIENDO_PERFIL_PERSONA_TXT)) {
                // El elemento ya no es visible, salir del bucle
                break;
            }
            System.out.println("Esperando a que termine de cargar el elemento para continuar...");
            Utilidades.esperaMiliseg(5000); // Espera 5 segundos
            contador++;
        }
        if (contador == 5) {
            fail("Tiempo de espera excedido. El elemento todavía es visible después de 25 segundos.");
        }
		pagePasarPlata.clicBtnPasarPlataLinea();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Ingresar a opción nueva solicitud");
		negocioPO.clicBtnNuevaSolicitud();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		Utilidades.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPasarPlataLinea();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPasarPlataLinea();
		Utilidades.esperaMiliseg(15000);
		negocioPO.validarTransaccionAOtrosBancosPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();
	}
	
	@Step
    public void validarCambioDePerfilANegocio() {
        negocioPO.validarInicioSesionANegocio();
    }
	
	@Step
	public void validarElPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Valido ingreso al perfil negocio");
        
        boolean visibility = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BTN_USAR_DAVIPLATA);
        if(visibility == true) {
        	Utilidades.esperaMiliseg(800);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_USAR_DAVIPLATA);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
        } else {
        	Utilidades.esperaMiliseg(1500);
        	utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_TOPES);
        	Utilidades.esperaMiliseg(800);
        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_TOPES);
        	Utilidades.esperaMiliseg(1500);
        	Utilidades.tomaEvidencia("Valido topes desde perfil negocio");
        	Utilidades.esperaMiliseg(800);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_REGRESAR_MI_NEGOCIO);
        }
    }
	
	@Step
	public void ingresarAPerfilPersona() {
        negocioPO.validarInicioSesionPersona();
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if(estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}
        //pageLogin.cerrarMensajeTopes();
    }
	
	@Step 
	public void validarElPerfilPersona() {
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_VER_MOVIMIENTOS);
        Utilidades.tomaEvidencia("Valido ingreso al perfil negocio");
    }
}