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
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_IR_NEGOCIO);
		Utilidades.esperaMiliseg(10000);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.esperaMiliseg(10000);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a perfil negocio");
		Utilidades.tomaEvidencia("Perfil Mi Negocio");
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.TXT_ERROR_SISTEMA);
		if(estadoVisiblePopUpAmigos == true) {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
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
	
	@Step
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
	
	@Step
	public void validoBotonIrPerfilUsuario() {
		negocioPO.validarBotónIrAPerfilPersona();
		Utilidades.tomaEvidencia("Validar boton ir a perfil persona");
		negocioPO.btnIrAPerfilPersona();
		Utilidades.esperaMiliseg(10000);
	}
	
	@Step
	public void ingresarOpcionPasarPlataPerfilNegocio() {
//		utilidad.tomaEvidencia("Clic en opcion usar plata");
//		negocioPO.clicOpcionUsarPlata();
		Utilidades.tomaEvidencia("Clic en opcion pasar plata");
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_PASAR_PLATA_MH);
		negocioPO.clicOpcionPasarPlataPerfilNegocio();
	}

	@Step
	public void ingresarOpcionPasarPlataPerfilNegocioMH() {
		Utilidades.tomaEvidencia("Clic en opcion pasar plata desde menu hamburguesa perfil negocio");
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_PASAR_PLATA_MH);
	}
	
	@Step
	public void ingresarOpcionSacarPlataPerfilNegocio() {
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Menú hamburguesa");
		negocioPO.clicOpcionUsarPlata();
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
	
	@Step
	public void ingresarOpcionAOtroDaviplataPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Clic en opcion a otro daviplata");
		negocioPO.clicBtnAOtroDaviplataPerfilNegocio();
		negocioPO.clicBtnAceptarPerfilNegocio();
	}
	
	@Step
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
	
	@Step
	public void flujoSacarPlataPerfilNegocio() {
		negocioPO.escogerMontoPerfilNegocioSacarPlata();
		Utilidades.tomaEvidencia("Seleccionar monto");
		negocioPO.clicBtnAceptarPerfilNegocio();
		Utilidades.tomaEvidencia("Confirmación de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		Utilidades.esperaMiliseg(4000);
		Utilidades.tomaEvidencia("Confirmación de codigo de retiro");
		Utilidades.esperaMiliseg(5000);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.TXT_MEMORICE);
		if(estadoVisible == true) {
			utilidadesTCS.clicElementAction("xpath", negocioPageObjects.ACEPTAR);
		} else {
			utilidadesTCS.clickCoordinates(194, 518);
		}
		System.out.println("Se completo el proceso de 'Sacar Plata'");
		Utilidades.esperaMiliseg(15000);
		utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_MI_DAVIPLATA);
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
		boolean estadoVisibleFinalizar = utilidadesTCS.validateElementVisibilityCatch("xpath", MenuHamburguesaPageObjects.BOTON_FINALIZAR_MOVIMIENTOS);
		if(estadoVisibleFinalizar == true) {
			utilidadesTCS.clicElement("xpath", MenuHamburguesaPageObjects.BOTON_FINALIZAR_MOVIMIENTOS);
		}
	}
	
	@Step
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
	
	@Step
	public void verMovimientosPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a movimientos de ventas en el perfil negocio desde 'Más Servicios'");
		Utilidades.esperaMiliseg(1000);
		negocioPO.clicBtnMovimientosPerfilNegocio();
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Validación movimientos de ventas en el perfil negocio");
	}
	
	@Step
	public void validarMovimientosPerfilNegocio() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Validación movimientos de ventas en el perfil negocio");
	}
	
	@Step
	public void actualizacionDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.validarActualizarDatosPerfilNegocio();
		negocioPO.clicActualizarDatosPerfilNegocio();
		Utilidades.esperaMiliseg(10000);
		Utilidades.tomaEvidencia("Validación actualizacion de datos en el perfil negocio");
	}
	
	@Step
	public void actualizarDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		Utilidades.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.clicActualizarDatosPerfilNegocio();
		Utilidades.esperaMiliseg(15000);
	}
	
	@Step
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
	
	@Step
	public void actualizarNombrePerfilNegocio(String nombreNegocioNuevo) {
		negocioPO.ingresarNombrePerfilNegocio(nombreNegocioNuevo);
		Utilidades.tomaEvidencia("Ingresar nombre nuevo en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	public void actualizarDireccionPerfilNegocio(String tipoVia, String numeroUno, String numeroDos, String numeroTres) {
		System.out.println("Entré a actualizar dirección");
//		negocioPO.clicInputDireccionPerfilNegocio();
//		negocioPO.clicTipoViaDireccionPerfilNegocio();
//		negocioPO.clicTipoViaDiscosDireccionPerfilNegocio(tipoVia);
//		negocioPO.inputNumeroUnoDireccionPerfilNegocio(numeroUno);
//		negocioPO.inputNumeroDosDireccionPerfilNegocio(numeroDos);
//		negocioPO.inputNumeroTresDireccionPerfilNegocio(numeroTres);		
//		Utilidades.tomaEvidencia("Ingresar dirección nueva en el perfil negocio");
//		negocioPO.clicGuardarCambiosPerfilNegocio();
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
		//Utilidades.scrollDownSwipe(1);
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
		negocioPO.clicCrearProductoCatalogoPerfilNegocio();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
		Utilidades.esperaMiliseg(5000);
		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.POPUP_CATALOGO_CREADO_EXITOSAMENTE);
		if(estadoVisible == true) {
			Utilidades.tomaEvidencia("Valido mensaje de creación de catálogo");
			utilidadesTCS.clicElement("xpath", negocioPageObjects.POPUP_CATALOGO_CREADO_EXITOSAMENTE);
		} else {
			Utilidades.tomaEvidencia("Valido mensaje de creación de catálogo errónea");
			fail("Valido mensaje de creación de catálogo errónea");
		}
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 120);
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
		Utilidades.scrollDownSwipe(1);
		//negocioPO.scrollCatalogo();
		negocioPO.validarCatalogoPerfilNegocio();
		Utilidades.tomaEvidencia("Validación de catálogo existente");
	}
	
	public void ingresarACatalogo() {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		Utilidades.scrollDownSwipe(1);
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
        validarInicioSesionANegocio();
    }
	
	public void validarInicioSesionANegocio() {
        boolean lblIngresaPresente = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BTN_MENU_DAVIPLATA);
        if (lblIngresaPresente == true) {
            System.out.println("Estoy en perfil persona mi DaviPlata");
            utilidadesTCS.clicElement("xpath", LoginPageObjects.HOME_PERFIL_NEGOCIO);
        } else {
            System.out.println("Estoy en perfil Negocio");
        }
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
        	utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_ENLACE_DE_PAGO);
        	Utilidades.esperaMiliseg(800);
//        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_TOPES);
//        	Utilidades.esperaMiliseg(1500);
//        	Utilidades.tomaEvidencia("Valido topes desde perfil negocio");
//        	Utilidades.esperaMiliseg(800);
//          utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_REGRESAR_MI_NEGOCIO);
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
	
	@Step
	public void ingresarALaOpcionMasServicios() {
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_MAS_SERVICIOS);
        Utilidades.tomaEvidencia("Ingreso a la opcion de Más Servicios");
        negocioPO.clicBtnMasServicios();
    }
    
	@Step
    public void ingresoEnAdministrarMiNegocio() {
    	Utilidades.tomaEvidencia("Hacer clic en el botón administrar mi negocio");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ADMINISTRAR_MI_NEGOCIO);
        Utilidades.esperaMiliseg(4000);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_ADMINISTRAR_MI_NEGOCIO);
        Utilidades.esperaMiliseg(2000);
//        utilidadesTCS.scrollBackground("xpath", negocioPageObjects.TEXTO_ADMINISTRAR_NEGOCIO, 0, -310);
    }
    
    @Step
    public void crearFlujoDePuntoVenta(String nombrePuntoVenta, String ciudad, String primerNumeroDireccion, String segundoNumeroDireccion, String tercerNumeroDireccion) {
        String nombresCiudadesPuntosVentas = ciudad;
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.BOTON_ABRIR_PUNTO_VENTA);
        Utilidades.tomaEvidencia("Dar clic en el boton 'Abrir punto de venta'");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ABRIR_PUNTO_VENTA);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TEXTO_FORMULARIO_CREAR_PUNTO_VENTA);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA, nombrePuntoVenta);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_CIUDAD_PUNTO_VENTA, ciudad);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", "//XCUIElementTypeStaticText[contains(@value, '"+ nombresCiudadesPuntosVentas +"')]");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.LISTA_DESPLEGABLE_NOMBRE_CALLE);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_NOMBRE_AVENIDA);
        Utilidades.esperaMiliseg(500);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_PRIMER_NUMERO_DIRECCION, primerNumeroDireccion);
        Utilidades.esperaMiliseg(500);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_SEGUNDO_NUMERO_DIRECCION, segundoNumeroDireccion);
        Utilidades.esperaMiliseg(500);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_TERCER_NUMERO_DIRECCION, tercerNumeroDireccion);
        Utilidades.tomaEvidencia("Llenar formulario de creacion punto de venta");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CREAR);
    }
    
    @Step
    public void validarCreacionPuntoVenta() {
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.POP_FALLA_CREACION_PUNTO_VENTA);
        if(estado) {
        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ACEPTAR_POP_FALLA_CREACION_PUNTO_VENTA);
            Utilidades.esperaMiliseg(2000);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CREAR);
    		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        }
//      utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.POP_CREACION_PUNTO_EXITOSO);
//      String texto = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.POP_CREACION_PUNTO_EXITOSO);
//      utilidadesTCS.validateTextContainsString(texto, "Ya creó el punto");
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Validar que permita crear punto de venta");
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
    }
    
    @Step
    public void crearVendedor(String tipoDocumento, String nombreVendedor, String numeroDocumento, String numeroDeCelular) {
        try {
//        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CREAR_VENDEDOR);
            /** Acciones por coordenadas ya que no se pueden mapear elementos **/
            utilidadesTCS.clickCoordinates(268, 544);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_CREAR_VENDEDOR) : "No se pudo interactuar con el elemento." + negocioPageObjects.BOTON_CREAR_VENDEDOR;
        }
        try {
        	utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.INPUT_NOMBRE_VENDEDOR);
        	utilidadesTCS.writeElement("xpath", negocioPageObjects.INPUT_NOMBRE_VENDEDOR, nombreVendedor);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.INPUT_NOMBRE_VENDEDOR) : "No se pudo interactuar con el elemento." + negocioPageObjects.INPUT_NOMBRE_VENDEDOR;
        }
        try {
        	utilidadesTCS.clicElement("xpath", negocioPageObjects.LISTA_DESPLEGABLE_TIPO_DOCUMENTO);
            Utilidades.esperaMiliseg(2000);
            utilidadesTCS.seleccionarTipoDocumentoNegocio("xpath",tipoDocumento);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.LISTA_DESPLEGABLE_TIPO_DOCUMENTO) : "No se pudo interactuar con el elemento." + negocioPageObjects.LISTA_DESPLEGABLE_TIPO_DOCUMENTO;
        }
        try {
        	utilidadesTCS.writeElement("xpath", negocioPageObjects.INPUT_NUMERO_DOCUMENTO, numeroDocumento);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        	Utilidades.esperaMiliseg(3000);
            utilidadesTCS.clicElementAction("xpath", negocioPageObjects.INPUT_NUMERO_CELULAR);
            utilidadesTCS.writeElement("xpath", negocioPageObjects.INPUT_NUMERO_CELULAR, numeroDeCelular);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.INPUT_NUMERO_DOCUMENTO) : "No se pudo interactuar con el elemento." + negocioPageObjects.INPUT_NUMERO_DOCUMENTO;
        }
        try {
        	Utilidades.esperaMiliseg(1500);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        	Utilidades.esperaMiliseg(1500);
        	utilidadesTCS.clicElementAction("xpath", negocioPageObjects.CHECK_TYC);
            Utilidades.tomaEvidencia("Finalice el formulario del vendedor");
            System.out.println("Finalizo el formulario");
            Utilidades.esperaMiliseg(2000);
        } catch (Exception e) {
                System.out.println("Se presento un error debido a: "+ e.getMessage() );
                assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.CHECK_TYC) : "No se pudo interactuar con el elemento." + negocioPageObjects.CHECK_TYC;
        }
        try {
        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CREAR);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_CREAR) : "No se pudo interactuar con el elemento." + negocioPageObjects.BOTON_CREAR;
        }
        try {
//        	utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.POP_UP_EXITOSO);
//          String popUpExitoso = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.POP_UP_EXITOSO);
//          utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(popUpExitoso, "se creó exitosamente");
            Utilidades.tomaEvidencia("Valido la creación del vendedor");
        }  catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.POP_UP_EXITOSO) : "No se pudo interactuar con el elemento." + negocioPageObjects.POP_UP_EXITOSO;
        }
        try {
//        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CONTINUAR);
            /** Acciones por coordenadas ya que no se pueden mapear elementos **/
            utilidadesTCS.clickCoordinates(220, 550);
            utilidadesTCS.clickCoordinates(215, 530);
            utilidadesTCS.clickCoordinates(190, 439);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_CONTINUAR) : "No se pudo interactuar con el elemento." + OlvidoClavePageObjects.BOTON_CONTINUAR;
        }
    }
    
    @Step
    public void validarQuePermitaActualizarDatosVendedorYVenta(String nombrePuntoVentaDos, String numeroDeCelularDos) {
        try {
            Utilidades.tomaEvidencia("Módulo administrar mi negocio");
            utilidadesTCS.clicElement("xpath", negocioPageObjects.PUNTO_VENTA);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.PUNTO_VENTA) : "No se pudo interactuar con el elemento." + negocioPageObjects.PUNTO_VENTA;
        }
        try {
        	Utilidades.esperaMiliseg(2000);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA);
            utilidadesTCS.cleanInputElement("xpath", negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.EDITAR_OPCION_UNO) : "No se pudo interactuar con el elemento." + negocioPageObjects.EDITAR_OPCION_UNO;
        }
        try {
        	utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA, nombrePuntoVentaDos);
        	Utilidades.esperaMiliseg(2000);
        	utilidadesTCS.clicElement("xpath", negocioPageObjects.LISTA_DESPLEGABLE_NOMBRE_CALLE);
            Utilidades.esperaMiliseg(1000);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_NOMBRE_AVENIDA);
            Utilidades.esperaMiliseg(500);
            String primerNumeroDireccion = "10";
            utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_PRIMER_NUMERO_DIRECCION, primerNumeroDireccion);
            Utilidades.esperaMiliseg(500);
            String segundoNumeroDireccion = "11";
            utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_SEGUNDO_NUMERO_DIRECCION, segundoNumeroDireccion);
            Utilidades.esperaMiliseg(500);
            String tercerNumeroDireccion = "12";
            utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_TERCER_NUMERO_DIRECCION, tercerNumeroDireccion);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA) : "No se pudo interactuar con el elemento." + negocioPageObjects.CAMPO_NOMBRE_PUNTO_VENTA;
        }
        try {
        	Utilidades.tomaEvidencia("Actualizo el nombre del punto de venta");
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ACTUALIZAR);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_ACTUALIZAR) : "No se pudo interactuar con el elemento." + negocioPageObjects.BOTON_ACTUALIZAR;
        }
        try {
//          String popUpExitoso = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.TEXTO_EXITOSO);
//          utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(popUpExitoso, "se actualizaron exitosamente");
            Utilidades.tomaEvidencia("Valido actualización de datos");
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.TEXTO_EXITOSO) : "No se pudo interactuar con el elemento." + negocioPageObjects.TEXTO_EXITOSO;
        }
        try {
//        	utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CONTINUAR);
            /** Acciones por coordenadas ya que no se pueden mapear elementos **/
            utilidadesTCS.clickCoordinates(220, 550);
            utilidadesTCS.clickCoordinates(215, 530);
        	Utilidades.esperaMiliseg(2000);
        } catch (Exception e) {
            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_CONTINUAR) : "No se pudo interactuar con el elemento." + OlvidoClavePageObjects.BOTON_CONTINUAR;
        }
        
        /** Acciones por coordenadas ya que no se pueden mapear elementos **/
        
//        try {
//        	Utilidades.tomaEvidencia("Módulo administrar mi negocio");
//            utilidadesTCS.clicElement("xpath", negocioPageObjects.DATOS_VENDEDOR);
//        } catch (Exception e) {
//            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.DATOS_VENDEDOR) : "No se pudo interactuar con el elemento." + negocioPageObjects.DATOS_VENDEDOR;
//        }
//        try {
//        	Utilidades.esperaMiliseg(2000);
//        	utilidadesTCS.clicElement("xpath", negocioPageObjects.INPUT_NUMERO_CEL);
//        	utilidadesTCS.cleanInputElement("xpath", negocioPageObjects.INPUT_NUMERO_CEL);
//        	utilidadesTCS.writeElement("xpath", negocioPageObjects.INPUT_NUMERO_CEL, numeroDeCelularDos);
//        } catch (Exception e) {
//            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.INPUT_NUMERO_CEL) : "No se pudo interactuar con el elemento." + negocioPageObjects.INPUT_NUMERO_CEL;
//        }
//        try {
//        	Utilidades.tomaEvidencia("Actualizo el nombre del punto de venta");
//            utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ACTUALIZAR);
//        } catch (Exception e) {
//            System.out.println("Se presento un error debido a: "+ e.getMessage() );
//            assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_ACTUALIZAR) : "No se pudo interactuar con el elemento." + negocioPageObjects.BOTON_ACTUALIZAR;
//        }
//        Utilidades.tomaEvidencia("Valido actualización de datos");
//        utilidadesTCS.clickCoordinates(220, 550);
//        utilidadesTCS.clickCoordinates(215, 530);
    }
    
    @Step
    public void validarQuePermitaEliminarVendedorYVenta() {
    	
    	Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Módulo administrar mi negocio");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.PUNTO_VENTA);
        
        boolean estado = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.TXT_ELIMINAR_PUNTO_VENTA);
        if(estado) {
        	try {
            	Utilidades.esperaMiliseg(2000);
            	Utilidades.tomaEvidencia("Datos del punto de venta a eliminar");
                utilidadesTCS.clicElement("xpath", negocioPageObjects.ELIMINAR_PUNTO_VENTA);

            } catch (Exception e) {
                System.out.println("Se presento un error debido a: "+ e.getMessage() );
                assert utilidadesTCS.validateElementVisibilityCatch("name", negocioPageObjects.ELIMINAR_PUNTO_VENTA) : "No se pudo interactuar con el elemento." + negocioPageObjects.ELIMINAR_PUNTO_VENTA;
            }
            try {
            	Utilidades.tomaEvidencia("Pop Up de información del punto de venta y vendedor a eliminar");
            	Utilidades.esperaMiliseg(800);
//                utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ACEPTAR_POP_UP_SALIR_DAVIPLATA);
                /** Acciones por coordenadas ya que no se pueden mapear elementos **/
            	utilidadesTCS.clickCoordinates(220, 560);
            	Utilidades.esperaMiliseg(2000);

            } catch (Exception e) {
                System.out.println("Se presento un error debido a: "+ e.getMessage() );
//                assert utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.BOTON_ACEPTAR_POP_UP_SALIR_DAVIPLATA) : "No se pudo interactuar con el elemento." + LoginPageObject.BOTON_ACEPTAR_POP_UP_SALIR_DAVIPLATA;
            }
        }
    }
    
    @Step
    public void seleccionoElBotonEnlaceDePagoOpcionDos() {
        Utilidades.esperaMiliseg(10000);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(1500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(5000);
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.TXT_ERROR_SISTEMA);
		if(estadoVisiblePopUpAmigos == true) {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TEXTO_CUANTO_TENGO);
        Utilidades.esperaMiliseg(1500);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.ELEMENTOS_PAGO_VENTA);
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido el botón enlace de pago");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_ENLACE_DE_PAGO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TEXTO_OPCIONES_ENLACE);
        Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido el módulo Enlaces de pago");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_ENLACE_PAGO_PSE);
    }
    
    @Step
    public void RealizoLaCreacionDeLaVenta () {
    	Utilidades.esperaMiliseg(500);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_VALOR_FIJO);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElementAction("xpath", negocioPageObjects.DESPEGABLE_PRODUCTO_VENTA);
        /** Acciones por coordenadas ya que no se pueden mapear elementos **/
    	utilidadesTCS.clickCoordinates(360, 380);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.DESPEGABLE_CATALOGO);
        Utilidades.esperaMiliseg(800);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.NOMBRE_CATALOGO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(2500);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.DESPEGABLE_CATEGORIA);
        Utilidades.esperaMiliseg(800);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.NOMBRE_CATEGORIA);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(2500);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.DESPEGABLE_PRODUCTO);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.NOMBRE_PRODUCTO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Diligencio formulario del producto de venta");
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_CONTINUAR_PRODUCTO_VENTA);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.DESPEGABLE_REFERENCIA);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.NOMBRE_REFERENCIA_VENTA);
        Utilidades.esperaMiliseg(2000);
        Utilidades.tomaEvidencia("Finalizo el registro de mis productos");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CONTINUAR_PRODUCTO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TEXTO_GENERACION_ENLACE);
        String textoExitoso = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.TEXTO_GENERACION_ENLACE);
        utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(textoExitoso, "Generación exitosa");
        Utilidades.tomaEvidencia("Generación exitosa de enlace");
        utilidadesTCS.scrollBackground("xpath", negocioPageObjects.DESPEGABLE_PRODUCTO_VENTA, 0, -150); 
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_FINALIZAR);
    }
    
    @Step
    public void seleccionoMasIngresosParaSuNegocioHome () {
    	utilidadesTCS.scrollBackground("xpath", negocioPageObjects.TEXTO_CUANTO_TENGO, 0, -350);
    	Utilidades.esperaMiliseg(5000);
        Utilidades.tomaEvidencia("Selecciono Más ingresos");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_MAS_INGRESOS_HOME);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Módulo Más ingresos para su negocio");
        
        boolean visibilidadTYC = utilidadesTCS.validateElementVisibilityCatch("xpath", negocioPageObjects.TERMINOS_CONDICIONES_AUMENTE_INGRESOS);
        if(visibilidadTYC) {
        	Utilidades.esperaMiliseg(1500);
            utilidadesTCS.clicElement("xpath", negocioPageObjects.TERMINOS_CONDICIONES_AUMENTE_INGRESOS);
            Utilidades.tomaEvidencia("Acepto términos y condiciones de 'Aumente sus ingresos'");
            utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_CONTRATAR);
        }
    }
    
    @Step
    public void ingresarATiendaVirtualDesdeMasIngresos() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.scrollBackground("xpath", MarketPlacePageObjects.BTN_CAJA, -250, 0);
		Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_TIENDA_VIRTUAL);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Ingreso a tienda virtual desde la opción 'Aumente sus ingresos'");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.PRODUCTO_TIENDA_VIRTUAL);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TXT_PRODUCTOS_TIENDA_VIRTUAL); 
    	Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido opciones de compra");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.SPOTIFY_BONO);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TXT_CARACTERISTICAS_BONO); 
    	Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido las caracteristicas del bono");
    	utilidadesTCS.scrollBackground("xpath", negocioPageObjects.TXT_CARACTERISTICAS_BONO, 0, -150);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_CONTINUAR);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TXT_DETALLE_COMPRA); 
    	Utilidades.esperaMiliseg(500);
        Utilidades.tomaEvidencia("Valido los detalles de compra");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_COMPRAR);
    	Utilidades.esperaMiliseg(5000);
        Utilidades.tomaEvidencia("Acepto mensaje de compra de productos");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_FINALIZAR);
    	Utilidades.esperaMiliseg(1500);
        Utilidades.tomaEvidencia("Valido resultado de la compra");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_FINALIZAR);
    }
    
    @Step
    public void regresarXVeces() { 
    	Utilidades.esperaMiliseg(1500);
		Utilidades.reutilizableRegresoHome(1);
		
    }
    
    @Step
    public void regresarDesdeMovimientosOpcionIngresos() { 
    	Utilidades.esperaMiliseg(1500);
		Utilidades.reutilizableRegresoHome(2);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.TXT_ERROR_SISTEMA);
		if(estadoVisiblePopUpAmigos == true) {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
		}	
    }
    
    @Step
    public void ingresarAMovimientosDesdeMasIngresos() { 
    	Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.TEXTO_MOVIMIENTOS);  
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.tomaEvidencia("Ingresé a movimientos desde la opción más ingresos");
    }
    
	
	@Step
	public void backToHome() {
		boolean condition = utilidadesTCS.validateElementVisibilityCatch("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		do {
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		    utilidadesTCS.esperarElementVisibility("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
		    utilidadesTCS.clicElementAction("xpath", PasarPlataPageObjects.BOTON_ATRAS_BOLSILLOS);
			utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
			boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.POP_UP_INVITE_AMIGOS);
			if(estadoVisible == true) {
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_CLOSE);
			}
		} while (condition == true);
	}
    
    @Step
    public void descargarExtractosDesdeMovimientos() {
    	Utilidades.esperaMiliseg(500);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TXT_SELECCIONAR_MES_MOVIMIENTOS); 
    	Utilidades.esperaMiliseg(500);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DESCARGAR);  
    }
    
    @Step
    public void SeleccionoLaCreacionDelEnlaceDePagoOtros (String descripcion, String valor) {
        seleccionoElBotonEnlaceDePagoOpcionDos();
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        Utilidades.esperaMiliseg(1500);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.OPCION_VALOR_FIJO);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_OTROS);
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.CAMPO_DESCRIPCION);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_DESCRIPCION, descripcion);
        Utilidades.esperaMiliseg(2000);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.CAMPO_VALOR);
        utilidadesTCS.writeElement("xpath", negocioPageObjects.CAMPO_VALOR, valor);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BTN_DONE);
        Utilidades.esperaMiliseg(500);
        Utilidades.tomaEvidencia("Formulario de enlace de pago Otros");
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_CONTINUAR_PRODUCTO);
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
        utilidadesTCS.esperarElementVisibility("xpath", negocioPageObjects.TEXTO_GENERACION_ENLACE);
        String textoExitoso = utilidadesTCS.obtenerTexto("xpath", negocioPageObjects.TEXTO_GENERACION_ENLACE);
        utilidadesTCS.validateTextContainsStringIgnoreUppercaseLowercase(textoExitoso, "Generación exitosa");
        Utilidades.tomaEvidencia("Generación exitosa de enlace");
        Utilidades.esperaMiliseg(500);
        utilidadesTCS.clicElement("xpath", negocioPageObjects.BOTON_FINALIZAR);
    }
}
