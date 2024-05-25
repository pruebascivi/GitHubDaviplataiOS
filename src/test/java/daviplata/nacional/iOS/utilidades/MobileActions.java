package daviplata.nacional.iOS.utilidades;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileActions {
    private AppiumDriver driver;

    public MobileActions(AppiumDriver driver) {
        this.driver = driver;
    }

    // Método para realizar toques en la pantalla para mantener activo el dispositivo
    public void mantenerActivo(int segundos) {
        // Código para mantener activo el dispositivo mediante toques
        TouchAction touchAction = new TouchAction(driver);

        // Realizar un toque en la coordenada específica (startX, startY)
        int startX = 100; // Ejemplo: coordenada X
        int startY = 200; // Ejemplo: coordenada Y
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(startX, startY))).perform();
        
        // Imprimir mensaje en consola
        System.out.println("Moví dispositivo por inactividad");

        // Esperar los segundos especificados antes de realizar otro toque
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

