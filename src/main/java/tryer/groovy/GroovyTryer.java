package tryer.groovy;

import groovy.util.GroovyScriptEngine;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
public class GroovyTryer {


    private static GroovyScriptEngine gse;


    public static void main(String[] args) throws Exception {

        gse = new GroovyScriptEngine("/home/dnikolaichenko/groovyscripts");

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Class scriptClass = gse.loadScriptByName("start.groovy");
                Object scriptInstance = scriptClass.newInstance();
                scriptClass.getDeclaredMethod("startPrinting").invoke(scriptInstance);
            } catch (Exception ex) {
                System.out.println("Exception while printing");
                ex.printStackTrace();
            }
        }

    }
}
