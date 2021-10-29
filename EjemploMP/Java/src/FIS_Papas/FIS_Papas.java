package FIS_Papas;

import java.util.ArrayList;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
//import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */

public class FIS_Papas {
        
        // Carga el archivo de lenguaje de control difuso 'FCL'
        String fileName = "src/FIS_Papas/FCL_Papas.fcl";
        FIS fis = FIS.load(fileName, true);
        
        public void ValidarRuta() {
        // En caso de error
	        if (fis == null) {
	            System.err.println("No se puede cargar el archivo: '" + fileName + "'");
	            return;
	        }
        }
        
        public void MostrarVariables(){
        	JFuzzyChart.get().chart(fis.getFunctionBlock("prop"));
        }
        
        public StringBuffer MostrarReglas(){
        	StringBuffer rules = new StringBuffer();
			
			// Muestra las reglas
	        for (Rule r : fis.getFunctionBlock("prop").getFuzzyRuleBlock("No1").getRules()) {
	            rules.append(r+"\n");
	        }
			
	        return rules;
        }
        
        public String fisStart(Double TEM, Double ALT, Double LUZ, Double AGUA, Double PH) {
        	
        	ValidarRuta();
        	// Establecer las entradas del sistema
            fis.setVariable("TEMPERATURA", TEM);
            fis.setVariable("ALTITUD", ALT);
            fis.setVariable("LUZ", LUZ);
            fis.setVariable("AGUA", AGUA);
            fis.setVariable("PH", PH);
            
            fis.evaluate();
	        
	        double CALIDAD_CULTIVO = fis.getVariable("CALIDAD_CULTIVO").getLatestDefuzzifiedValue();
	        double CONDICION_SUELO = fis.getVariable("CONDICION_SUELO").getLatestDefuzzifiedValue();
	        return "Para los valores de entrada\nla calidad del cultivo es: " + CALIDAD_CULTIVO + "\n" +
                    "la condicion del suelo sera: " + CONDICION_SUELO + "%\n";

        }
        
}
