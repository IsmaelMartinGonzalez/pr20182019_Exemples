/**
 * 
 */
package pru05.files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Xavier
 *
 */
public class PRU05_readwritefile {

	/**
	 * @param args
	 */
	public static final String NOM_FITXER_ESCRIPTURA="c:\\tmp\\PRU05_mesclats.txt";
	public static final String NOM_FITXER_LECTURA_SENARS="c:\\tmp\\senars.dat";
	public static final String NOM_FITXER_LECTURA_PARELLS="c:\\tmp\\parells.dat";
	public static void main(String[] args) {
		String nl = System.getProperty("line.separator");
		
		try {
			BufferedReader br_parells = new BufferedReader(new FileReader(NOM_FITXER_LECTURA_PARELLS));
			BufferedReader br_senars = new BufferedReader(new FileReader(NOM_FITXER_LECTURA_SENARS));
			BufferedWriter bw = new BufferedWriter(new FileWriter(NOM_FITXER_ESCRIPTURA));

			String linea1 = "";
			String linea2 = "";

			while ( (linea1 != null) || (linea2 != null) ) {
				linea1 = br_parells.readLine();
				linea2 = br_senars.readLine();
				if (linea1 != null) {
					bw.write(linea1 + nl);
				}
				if (linea2 != null) {
					bw.write(linea2 + nl);
				}
			} 

			br_parells.close();
			br_senars.close();
			bw.close();

			System.out.println("Arxiu "+NOM_FITXER_ESCRIPTURA+" creat correctament.");

		} catch (IOException ioe) {
			System.out.println("S'ha produit un error de lectura/escriptura");
			System.err.println(ioe.getMessage());
		}
	}
}