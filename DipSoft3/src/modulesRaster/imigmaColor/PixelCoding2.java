package modulesRaster.imigmaColor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PixelCoding2 {


	private List<String> temp = new ArrayList<String>();
	AsciiGenerator ascii = new AsciiGenerator("C:\\Users\\Piotr\\PrivateWorkspace\\DipSoft3\\src\\modulesRaster\\imigmaColor\\ascii95.tsv");
	String rotorInput = "C:\\Users\\Piotr\\PrivateWorkspace\\DipSoft3\\src\\modulesRaster\\imigmaColor\\rotors.tsv";
	String outputText = "0";

	/**
	 * This class creates coded text based on given string.
	 *
	 * @param inputText
	 *            String (text) to code
	 * @param secretCode
	 *            String (text) secret code to code and decode given text. Has to
	 *            have 4 characters.
	 */

	public PixelCoding2(String input, int pixelNumber, String secretCode) {
		
		// temporary array that splits text into chars

		// for each symbol it does the given function

			

			// only possible to code writable ASCII symbols

				// the function mixes given character 3 times on dynamic rotor, once on a mirror
				// rotor and 3 times on reversed dynamic rotor

				
				Rotor rotor1 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(0))), 1,
						pixelNumber);
				String tempCharacter = rotor1.getCodeNormalRotor(input);
				
				Rotor rotor2 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(1))), 2,
						pixelNumber);
				String tempCharacter2 = rotor2.getCodeNormalRotor(tempCharacter);

				Rotor rotor3 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(2))), 3,
						pixelNumber);
				String tempCharacter3 = rotor3.getCodeNormalRotor(tempCharacter2);

				
				Rotor rotor4 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(3))), 4,
						pixelNumber);
				String tempCharacter4 = rotor4.getCodeNormalRotor(tempCharacter3);

				Rotor rotor5 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(2))), 3,
						pixelNumber);
				String tempCharacter5 = rotor5.getCodeReverseRotor(tempCharacter4);
						

				Rotor rotor6 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(1))), 2,
						pixelNumber);
				String tempCharacter6 = rotor6.getCodeReverseRotor(tempCharacter5);

				Rotor rotor7 = new Rotor(rotorInput, ascii.getAsciiCode(Character.toString(secretCode.charAt(0))), 1,
						pixelNumber);
				String tempCharacter7 = rotor7.getCodeReverseRotor(tempCharacter6);

				outputText = tempCharacter7;

			}

		
	

	public String getOutputText() {
		return outputText;
	}

}
