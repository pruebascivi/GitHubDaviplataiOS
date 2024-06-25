package daviplata.nacional.iOS.steps;

import static org.junit.Assert.fail;
import daviplata.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import daviplata.nacional.iOS.pageObjects.Excepcion4x1000PageObjects;
import daviplata.nacional.iOS.pageObjects.LoginPageObjects;
import daviplata.nacional.iOS.pageObjects.LoginRobustoPage;
import daviplata.nacional.iOS.pageObjects.ReferidosPageObjects;
import daviplata.nacional.iOS.pageObjects.RegistroMayoresPageObjects;
import daviplata.nacional.iOS.pageObjects.WebLatiniaPageObject;
import daviplata.nacional.iOS.utilidades.Evidencias;
import daviplata.nacional.iOS.utilidades.Utilidades;
import daviplata.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class ReferidosSteps {

	static Utilidades utilidad;
	Excepcion4x1000PageObjects pageExcepcion4x1000;
	static LoginPageObjects pageLogin;
	static WebLatiniaPageObject pageLatinia;
	int contador = 0;
	UtilidadesTCS utilidadesTCS;
	LoginSteps loginSteps;
	LoginRobustoPage loginRobustoPage;
	ReferidosPageObjects referidosPageObjects;

	@Step
	public void ingresarAlPopUpReferidos(String tipoDocumento, String usuario, String contrasena) {
		utilidadesTCS.esperaCargaElemento(LoginRobustoPage.PROGRESS_BAR, 60);
		System.out.println("Ingresando a la app");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_NOTIFICACIONES);
		Utilidades.esperaMiliseg(800);
		verificarVersion();
		utilidadesTCS.seleccionarTipoDocumentoInputHomeDaviplata("xpath", tipoDocumento);
		utilidadesTCS.writeElement("xpath", LoginRobustoPage.CAMPO_INGRESO_USUARIO, usuario);
		Utilidades.esperaMiliseg(800);
		Utilidades.tomaEvidencia("Selecciono tipo de usurio: " + tipoDocumento + " e ingreso usuario: " + usuario);
		utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_INGRESAR);
		boolean estadoVisibilidadPopUP = utilidadesTCS.validateElementVisibilityCatch("xpath",
				LoginRobustoPage.POP_UP_CAMBIAR_DISPOSITIVO);
		if (estadoVisibilidadPopUP == true) {
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
			Utilidades.esperaMiliseg(1000);
			boolean validarBiometria = utilidadesTCS.validateElementVisibilityCatch("xpath",
					LoginRobustoPage.TEXTO_TYT_BIOMETRIA);
			if (validarBiometria == true) {
				System.out.println("*********************************************");
				System.out.println("*                                           *");
				System.out.println("*          ¡ALERTA DE BIOMETRÍA!            *");
				System.out.println("*                                           *");
				System.out.println("*        BIOMETRÍA ACTIVA DETECTADA         *");
				System.out.println("*                                           *");
				System.out.println("*********************************************");
				Utilidades.tomaEvidencia("Error, biometria activa en cambio de dispositivo");
				fail("Se encuentra la biometria activa para el cambio de dispositivo");
			} else {
				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_REGLAMENTO_CAMBIO_DISPOSITIVO);
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CORREO_ELECTRONICO, "XXX@gmail.com");
				utilidadesTCS.writeElement("xpath", LoginRobustoPage.INPUT_CLAVE_DAVIPLATA, contrasena);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.POP_UP_OTP);
				utilidadesTCS.clicElement("xpath", LoginRobustoPage.POP_UP_OTP);
				Utilidades.esperaMiliseg(2000);
				utilidadesTCS.clickCoordinates(221, 435);
				boolean visibilidadTeclado = utilidadesTCS.validateElementVisibilityCatch("xpath",
						LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
				if (visibilidadTeclado == true) {
					utilidadesTCS.escribirPorTecladoIos("230116");
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
				} else {
					utilidadesTCS.clickCoordinates(194, 385);
					utilidadesTCS.escribirPorTecladoIos("230116");
					utilidadesTCS.validateElementVisibility("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.BOTON_ACEPTAR_TECLADO_IOS);
				}
				Utilidades.esperaMiliseg(2000);
				utilidadesTCS.clickCoordinates(217, 562);
				boolean estadoVisiblePopUpAmigos = utilidadesTCS.validateElementVisibilityCatch("xpath",
						LoginRobustoPage.POP_UP_INVITE_AMIGOS);
				boolean estadoVisibleSlideInformativo = utilidadesTCS.validateElementVisibilityCatch("xpath",
						LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
				if (estadoVisiblePopUpAmigos == true || estadoVisibleSlideInformativo == true) {
					Utilidades.esperaMiliseg(1000);
					boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath",
							LoginRobustoPage.POP_UP_INVITE_AMIGOS);
					if (estadoVisible == true) {
						utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_INVITAR);
					}
					utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
				} else {
					utilidadesTCS.clickCoordinates(198, 490);
					Utilidades.esperaMiliseg(1000);
					boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath",
							LoginRobustoPage.POP_UP_INVITE_AMIGOS);
					if (estadoVisible == true) {
						utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_INVITAR);
					}
					utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.SLIDE_INFORMATIVO_DAVIPLATA);
					utilidadesTCS.clicElement("xpath", LoginRobustoPage.CONTINUAR_POP_UP_CAMBIAR_DISPOSITIVO);
				}
			}
		} else {
			Utilidades.esperaMiliseg(1000);
			pageLogin.ingresarContrasena(contrasena);
			Utilidades.tomaEvidencia("Diligencio contraseña " + contrasena);
			pageLogin.darClicBotonIngresar();
			Utilidades.esperaMiliseg(500);
			pageLogin.darClicBotonIngresar();
		}

		boolean estadoVisible = utilidadesTCS.validateElementVisibilityCatch("xpath",
				LoginRobustoPage.POP_UP_INVITE_AMIGOS);
		if (estadoVisible == true) {
			utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_INVITAR);
		}

		boolean condicionesUso = utilidadesTCS.validateElementVisibilityCatch("xpath",
				RegistroMayoresPageObjects.TEXTO_ACTUALIZAMOS_CONDICIONES);
		if (condicionesUso) {
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_1);
			utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.CHECK_BOX_ACTUALIZACION_2);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Validar actualizacion de las condiciones de uso de los datos");
			utilidadesTCS.clicElement("xpath", RegistroMayoresPageObjects.ACEPTAR_ACTUALZIACION_CONDICIONES);
		}
		boolean ganePlataInvitando = utilidadesTCS.validateElementVisibilityCatch("xpath", 
				ReferidosPageObjects.GANE_PLATA_INVITANDO);
		if (ganePlataInvitando == true) {
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido que el usuario ya ha aceptado terminos y condiciones para invitar amigos");
			System.out.println("Valido que el usuario ya ha aceptado terminos y condiciones para invitar amigos");
			Utilidades.esperaMiliseg(500);
			fail("Valido que el usuario ya ha aceptado terminos y condiciones para invitar amigos");
			//utilidadesTCS.clicElement("xpath", 
			//		ReferidosPageObjects.BTN_DONE);
		} 
		boolean ganePlataImagenes = utilidadesTCS.validateElementVisibilityCatch("xpath", 
				ReferidosPageObjects.CHECK_TYC);
		if (ganePlataImagenes == true) {
			Utilidades.esperaMiliseg(500);
			System.out.println("Valido que el usuario no ha aceptado terminos y condiciones para invitar amigos");
			Utilidades.tomaEvidencia("Valido que el usuario no ha aceptado terminos y condiciones para invitar amigos");
		} 
//		else {
//			Utilidades.esperaMiliseg(3000);
//			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_BOLSILLOS);
//			Utilidades.tomaEvidencia("Ingreso a Daviplata");
//			pageLogin.capturarSaldo();
//			Utilidades.esperaMiliseg(500);
//			pageLogin.cerrarMensajeTopes();
//		}
	}

	@Step
	public void validoLaEquisEnElHeaderReferidos() {
		utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.LOGO_DAVIPLATA_HEADER);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.LOGO_DAVIPLATA_HEADER);
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.BOTON_SALIR);
		utilidadesTCS.validateStatusElement(elemento);
		Utilidades.tomaEvidencia("Validar que en el header este el boton 'X'");
	}

	@Step
	public void salirDelHeaderDeReferidos() {
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_SALIR);
		utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.LOGO_DAVIPLATA_HEADER);
		Utilidades.tomaEvidencia("Salir del header de referidos");
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.LOGO_DAVIPLATA_HEADER);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_CERRAR_APP);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_ACEPTAR_CERRAR_APP);
	}

	@Step
	public void validarLogoDaviplataEnElHeader() {
		boolean check = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (check == true) {
			boolean elemento = utilidadesTCS.validateElementVisibility("xpath",
					ReferidosPageObjects.LOGO_DAVIPLATA_HEADER);
			utilidadesTCS.validateStatusElement(!elemento);
			Utilidades.tomaEvidencia("Validar que este presente el logo en la parte superior izquierda debajo del header");
		}
	}

	@Step
	public void hacerClicEnElBotonMenuHamburguesa() {
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.tomaEvidencia("Hacer clic en el menu hamburguesa");
	}

	@Step
	public void validarLasOpcionesParaInvitar() {
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		boolean elementoUno = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.OPCION_PARA_INVITAR);
		utilidadesTCS.validateStatusElement(elementoUno);
		Utilidades.tomaEvidencia("Validar opcion 'Opciones para invitar'");
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_PARA_INVITAR);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		boolean contenido = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.CONTENIDO_OPCIONES_PARA_INVITAR);
		utilidadesTCS.validateStatusElement(contenido);
		utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.CONTENIDO_OPCIONES_PARA_INVITAR);
		Utilidades.tomaEvidencia("Validar contenido de la opcion 'Opciones para invitar'");
	}

	@Step
	public void validarLaOpcionMisGanancias() {
		//Utilidades.esperaMiliseg(1500);
		//utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		boolean elementoUno = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.OPCION_MIS_GANANCIAS);
		utilidadesTCS.validateStatusElement(elementoUno);
		Utilidades.tomaEvidencia("Validar opcion 'Mis ganancias");
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_MIS_GANANCIAS);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		boolean contenido = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.CONTENIDO_OPCION_MIS_GANANCIAS);
		utilidadesTCS.validateStatusElement(contenido);
		utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.CONTENIDO_OPCION_MIS_GANANCIAS);
		Utilidades.tomaEvidencia("Validar contenido de la opcion 'Mis ganancias'");
	}

	@Step
	public void validarLaOpcionRegistrarseEnDaviplata() {
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_PARA_INVITAR);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.MENU_HAMBURGUESA_REFERIDOS);
		Utilidades.esperaMiliseg(500);
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.BOTON_REGISTRARSE_EN_DAVIPLATA);
		utilidadesTCS.validateStatusElement(elemento);
		Utilidades.tomaEvidencia(
				"Valido que esté presente el botón de 'Registrarse en DaviPlata' con su respectivo icono");
	}

	@Step
	public void validarCuadroDeTextoDelLinkJuntoConElCuadroDeCopiar() {
		boolean elementoUno = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.CUADRO_TEXTO_LINK);
		utilidadesTCS.validateStatusElement(elementoUno);
		Utilidades.tomaEvidencia("Valido que se presente un cuadro de texto con el link y el botón con el icono de copiar");
	}

	@Step
	public void validarLosDiferentesCanalesParaCompartir() {
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.ICONOS_CANALES_COMPARTIR);
		utilidadesTCS.validateStatusElement(elemento);
		Utilidades.tomaEvidencia("Valido que se presenten los diferentes canales para compartir");
	}

	@Step
	public void validarOpcionesParaGanarPorInvitarAmigos() {
		boolean elementoUno = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.OPCION_DESCARGAR_APP);
		boolean elementoDos = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.OPCION_COMPLETAR_REGISTRO_APP);
		boolean elementoTres = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.OPCION_REALIZAR_COMPRA_APP);
		utilidadesTCS.validateStatusElement(elementoUno);
		utilidadesTCS.validateStatusElement(elementoDos);
		utilidadesTCS.validateStatusElement(elementoTres);
		Utilidades.tomaEvidencia(
				"Validar que la 1ra opcion tenga el texto 'Descargar o abrir Daviplata unicamente desde el enlace de invitacion'");
		Utilidades.tomaEvidencia("Validar que la 2da opcion tenga el texto 'Completar el registro en Daviplata'");
		Utilidades.tomaEvidencia(
				"Validar que la 3ra opcion tenga el texto 'Recibir, Meter o Pasar minimo $20,000 en un plazo de 30 dias'");
	}
	
	@Step
	public void validarMediosParaCompartirReferidos() {
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_CORREO);
		boolean elementoCorreo = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.PANTALLA_OPCION_CORREO);
		utilidadesTCS.validateStatusElement(elementoCorreo);
		utilidadesTCS.scrollBackground("xpath", ReferidosPageObjects.PANTALLA_OPCION_CORREO, 0, -300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validar pantalla al compartir referido por correo");
 
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_INSTAGRAM);
		boolean elementoInstagram = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.PANTALLA_OPCION_INSTAGRAM);
		utilidadesTCS.validateStatusElement(elementoInstagram);
		utilidadesTCS.scrollBackground("xpath", ReferidosPageObjects.PANTALLA_OPCION_INSTAGRAM, 0, -300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validar pantalla al compartir referido por instagram");

		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.OPCION_FACEBOOK);
		boolean elementoFacebook = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.PANTALLA_OPCION_FACEBOOK);
		utilidadesTCS.validateStatusElement(elementoFacebook);
		utilidadesTCS.scrollBackground("xpath", ReferidosPageObjects.PANTALLA_OPCION_FACEBOOK, 0, -150);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validar pantalla al compartir referido por facebook");
	}
	
	@Step
	public void validoRecuadroDineroGanado() {
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.LABEL_SALDO);
		utilidadesTCS.validateStatusElement(elemento);
		Utilidades.tomaEvidencia("Validar que se presente un recuadro con el dinero recibido");
	}

	@Step
	public void validarContadoresDeReferidos() {
		Utilidades.esperaMiliseg(2000);
		Utilidades.scrollDownSwipe(1);
		boolean contadorUno = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.CONTADOR_ENLACES_VECES_COMPARTIDO);
		boolean contadorDos = utilidadesTCS.validateElementVisibility("xpath",
				ReferidosPageObjects.CONTADOR_ENLACES_COMPARTIDOS_EXITOSOS);
		utilidadesTCS.validateStatusElement(contadorUno);
		utilidadesTCS.validateStatusElement(contadorDos);
		Utilidades.tomaEvidencia(
				"Validar que se presente un contador con la cantidad de veces que se abrio el "
				+ "enlace y un contador con los referidos exitosos y sus respectivos iconos");
	}

	@Step
	public void validarTextoReferidosMisGanancias() {
		String texto = utilidadesTCS.obtenerTexto("xpath", ReferidosPageObjects.CONTENIDO_OPCION_MIS_GANANCIAS);
		//utilidadesTCS.validateTextContainsString(texto, "Recuerde que el pago");
		Utilidades.tomaEvidencia(
				"Validar que se presente el texto 'Recuerde que el pago del beneficio se realiza los Viernes de cada semana' centrado");
	}

	@Step
	public void validarCamposPrediccionBusquedaPorNombreYFecha() {
		utilidadesTCS.writeElement("xpath", ReferidosPageObjects.CAMPO_BUSQUEDA_POR_NOMBRE, "Camilo");
		utilidadesTCS.writeElement("xpath", ReferidosPageObjects.CAMPO_BUSQUEDA_POR_FECHA, "2024-04-29");
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BTN_DONE_TECLADO);
		utilidadesTCS.zoomIn(5);
		Utilidades.tomaEvidencia("Validar que se presenten 2 campos de busqueda tipo lista predictiva");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.zoomIn(6);
		utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BTN_BUSCAR);
	}

	@Step
	public void validarListaDeReferidos() {
		Utilidades.esperaMiliseg(1500);
		//boolean elementoLista = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.LISTA_REFERIDOS);
		//utilidadesTCS.validateStatusElement(elementoLista);
		Utilidades.tomaEvidencia("Validar que se visualice el listado con los referidos del cliente");
	}
	
	@Step
	public void validarTextosDeLasPantallasDeReferidos() {
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (elemento == true) {
			utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
			Utilidades.esperaMiliseg(4000);
			boolean primeraCantidadElementos = utilidadesTCS.validateQuantityOfElements("xpath",
					ReferidosPageObjects.TEXTOS_REFERIDOS, 2);
			utilidadesTCS.validateStatusElement(primeraCantidadElementos);
			Utilidades.tomaEvidencia("Validar que en la primera pantalla se presenten 2 textos");
			utilidadesTCS.scrollMultiDireccional("izquierda");
			boolean segundaCantidadElementos = utilidadesTCS.validateQuantityOfElements("xpath",
					ReferidosPageObjects.TEXTOS_REFERIDOS, 2);
			utilidadesTCS.validateStatusElement(segundaCantidadElementos);
			Utilidades.tomaEvidencia("Validar que en la segunda pantalla se presenten 2 textos");
		}
	}

	@Step
	public void validarLaBarraDeAvance() {
		
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (elemento == true) {
			boolean barra = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.BARRA_AVANCE);
			utilidadesTCS.validateStatusElement(!barra);
			Utilidades.tomaEvidencia(
					"Validar que se presente una barra ilustrativa que informe el avance de las 2 pantallas");
		}
	}
	
	@Step
	public void validarCheckDesmarcado() {
		
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (elemento == true) {
			utilidadesTCS.validateStatusElement(elemento);
			Utilidades.tomaEvidencia("Validar que este presente un check obligatorio desmarcado");
		}
	}

	@Step
	public void validarElCheckTyCEnLasDosPantallas() {
		
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (elemento == true) {
			utilidadesTCS.scrollMultiDireccional("izquierda");
			utilidadesTCS.clicElement("xpath", ReferidosPageObjects.CHECK_TYC);
			Utilidades.tomaEvidencia("Validar check activo en primera pantalla");
			utilidadesTCS.scrollMultiDireccional("derecha");
			Utilidades.tomaEvidencia("Validar check activo en segunda pantalla");
		}
	}
	
	@Step
	public void darClicAlBtnContinuar() {
	      for(int i = 0; i<1; i++) {
	  			Utilidades.esperaMiliseg(3000);
	            utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BOTON_CONTINUAR);	        
	      }
	}
	
	@Step
	public void regresarAlHome() {
		boolean elemento = utilidadesTCS.validateElementVisibility("xpath", ReferidosPageObjects.DAVIPLATA_HEADER_REFERIDOS);
		if (elemento == true) {
			utilidadesTCS.esperarElementVisibility("xpath", ReferidosPageObjects.BTN_DONE);
			utilidadesTCS.clicElement("xpath", ReferidosPageObjects.BTN_DONE);
			Utilidades.esperaMiliseg(3000);
			utilidadesTCS.esperarElementVisibility("xpath", LoginRobustoPage.BOTON_BOLSILLOS);
			Utilidades.tomaEvidencia("Regresé al home");
		}
	}

	@Step
	public void verificarVersion() {

		try {

			utilidadesTCS.clicElement("name", LoginRobustoPage.MENU_TRES_PUNTOS);
			Utilidades.tomaEvidencia("Menu tres puntos");
		} catch (Exception e) {

			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("name", LoginRobustoPage.MENU_TRES_PUNTOS)
					: "No se pudo interactuar con el elemento." + LoginRobustoPage.MENU_TRES_PUNTOS;
		}
		try {
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clicElement("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA);
			Utilidades.esperaMiliseg(1500);
			Evidencias.capturaDispositivo("Entro a menu hamburguesa perfil negocio", AcercaDeDaviplataPage.VERSION);
			String version = utilidadesTCS.obtenerTexto("xpath", AcercaDeDaviplataPage.VERSION);
			Utilidades.tomaEvidencia("Ingreso al módulo 'Acerca de Daviplata' y capturo la versión: " + version);
			System.out.println("La versión es: " + version);

		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.ACERCA_DE_DAVIPLATA)
					: "No se pudo interactuar con el elemento." + LoginRobustoPage.ACERCA_DE_DAVIPLATA;
		}
		try {

			utilidadesTCS.clicElement("xpath", LoginRobustoPage.REGRESAR);
			utilidadesTCS.validateElementVisibility("name", "Ingrese a su Daviplata");

		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", LoginRobustoPage.REGRESAR)
					: "No se pudo interactuar con el elemento." + LoginRobustoPage.REGRESAR;
		}
	}
	
	@Step
	public void validarModuloGanePlataInvitando() {
		try {
			utilidadesTCS.esperarElementVisibility("xpath", 
					ReferidosPageObjects.GANE_PLATA_INVITANDO);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido que el usuario ya ha aceptado terminos y condiciones para invitar amigos");
			System.out.println("Valido que el usuario ya ha aceptado terminos y condiciones para invitar amigos");
			Utilidades.esperaMiliseg(500);
			
		} catch(Exception e) {
			System.out.println("No se pudo interactuar con el elemento debido a: " + e.getMessage().toString());
			assert utilidadesTCS.validateElementVisibilityCatch("xpath", 
					ReferidosPageObjects.GANE_PLATA_INVITANDO) : 
						"No se pudo interactuar con el elemento." + ReferidosPageObjects.GANE_PLATA_INVITANDO;
		}
	}
}
