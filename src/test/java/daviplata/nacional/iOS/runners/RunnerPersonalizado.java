/**
 * @since 27/11/2017
 */
package daviplata.nacional.iOS.runners;

import daviplata.nacional.iOS.utilidades.BeforeSuite;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import cucumber.api.junit.Cucumber;


/**
 * Personalización del Runner con el cual se puede determinar que busque y modifique los .feature antes de ser ejecutados
 * @since 27/11/2017
 * @author bgaona
 *
 */
public class RunnerPersonalizado extends Runner {
	 
	 private Class<Cucumber> classValue;
	 private Cucumber cucumber;
	 
	 
	 public RunnerPersonalizado(Class<Cucumber> classValue) throws Exception {
	        this.classValue = classValue;
	        cucumber = new Cucumber(classValue);
	    }
	 
	  @Override
	    public Description getDescription() {
	        return cucumber.getDescription();
	    }
	  
	  private void runAnnotatedMethods(Class<?> annotation) throws Exception {
	        if (!annotation.isAnnotation()) {
	            return;
	        }
	        Method[] methods = this.classValue.getMethods();
	        for (Method method : methods) {
	            Annotation[] annotations = method.getAnnotations();
	            for (Annotation item : annotations) {
	                if (item.annotationType().equals(annotation)) {
	                    method.invoke(null);
	                    break;
	                }
	            }
	        }
	  }
	  
	  @Override
	    public void run(RunNotifier notifier) {
	        try {
	            runAnnotatedMethods(BeforeSuite.class);
	            cucumber = new Cucumber(classValue);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        cucumber.run(notifier);
	    }
}

