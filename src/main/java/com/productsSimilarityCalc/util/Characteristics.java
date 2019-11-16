package com.productsSimilarityCalc.util;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Class that has a array of all possible charactericts
 * Singleton pattern applied
 * It is not necessary to create a instance of this class, just retrieve the array of all possible charactericts
 *
 */
public class Characteristics {
	
	private Characteristics() {
		
	}

	public static String[] getCharacteristics() {		
		return new String[]{"neutro","veludo","couro","basics","festa",
						    "workwear","inverno","boho","estampas","balada",
						    "colorido","casual","liso","moderno","passeio",
						    "metal","viagem","delicado","descolado","elastano"};
	}

}
