package modulesRaster.imigmaColorSimple;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Rotor {

	private BiMap<String, String> rotor1 = HashBiMap.create();

	private String csvFile;
	private String line = "";
	private String cvsSplitBy = "\t";
	private Queue<String> rotor1QueKeys = new LinkedList<String>();
	private Queue<String> rotor1QueValues = new LinkedList<String>();
	private List<String> temp = new ArrayList<String>();
	private String initialCode;
	private int rotorNumber = 0;

	/**
	 * Setting up the character mixing device. This class requires Google Guava
	 * BiMap and HashBiMap.
	 *
	 * @param csvFile
	 *            A text file containing 8 columns representing 4 rotors of Enigma
	 *            machine. 3 of those rotors are dynamic, while the last one is
	 *            static and mirrored Usually in first, third, fifth, seventh column
	 *            there are continous numbers ascenting from smallest to biggest. In
	 *            second, fourth, sixth column, there are random mixed number that
	 *            mix the given character. The eight column is mirrored, therefore
	 *            if A in column seven equals to B in column eighth, B in column
	 *            seven also equals to A in column eight.
	 * 
	 * @param initialCode
	 *            A string of 4 characters. They are the initial rotors 1-4 position
	 * @param rotorNumber
	 *            A number of rotor that is being used in given time
	 * @param characterNumber
	 *            A number of character in given text
	 */

	public Rotor(String csvFile, String initialCode) {

		this.csvFile = csvFile;
		this.initialCode = initialCode;

		// changing rotor number to correct collumn in csvFile

		// reading csvFile and putting values into temporary queues
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)))) {

			while ((line = br.readLine()) != null) {
				// use comma as separator or tab if differnt file used

				String[] rotor = line.split(cvsSplitBy);

				// putting keys of given rotor into queue 1
				rotor1QueKeys.add(rotor[rotorNumber]);
				// putting values of given rotor into queue 2
				rotor1QueValues.add(rotor[rotorNumber + 1]);
				// temporary list to know how much to rotate
				temp.add(rotor[rotorNumber + 1]);

			}

			// rotating the rotor 1

			if (rotorNumber == 0) {
			
				for (int x = 0; x < temp.indexOf(Character.toString((initialCode.charAt(0)))); x++) { // rotating

					rotor1QueValues.add(rotor1QueValues.poll());

				}
				
				for (int x = 0; x < temp.indexOf(Character.toString((initialCode.charAt(1)))); x++) { // rotating

					rotor1QueValues.add(rotor1QueValues.poll());

				}
				for (int x = 0; x < temp.indexOf(Character.toString((initialCode.charAt(2)))); x++) { // rotating

					rotor1QueValues.add(rotor1QueValues.poll());

				}
				for (int x = 0; x < temp.indexOf(Character.toString((initialCode.charAt(3)))); x++) { // rotating

					rotor1QueValues.add(rotor1QueValues.poll());

				}
				// rotating the rotor 2
			} 

			

			temp.clear(); // deleting temporary list

			for (int x = 0; x < 256; x++) { // creating proper, rotated rotor as a BiMap

				rotor1.put(rotor1QueKeys.poll(), rotor1QueValues.poll());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns a value for a given key after proper rotor is constructed
	 * 
	 * @param x
	 *            key
	 * @return value for a given key, after proper rotor is constructed
	 */
	public int getCodeNormalRotor(int x) {
		return Integer.parseInt(rotor1.get(Integer.toString(x)));
	}

	/**
	 * Returns a key for a given value after proper rotor is constructed
	 * 
	 * @param x
	 *            value
	 * @return key for a given value, after proper rotor is constructed
	 */
	public int getCodeReverseRotor(int x) {
		return Integer.parseInt(rotor1.inverse().get(Integer.toString(x)));
		
	}

}
