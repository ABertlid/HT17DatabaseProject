package com.anneli.view;

/**
 * Interface that handle input from user and will automatically close the
 * scanner
 * 
 * @author Anneli
 *
 */
public interface Reader extends AutoCloseable {
	/**
	 * Saves the text from userinput
	 * 
	 * @return the text (String) from user
	 */
	String stringInputFromUser();

	/**
	 * Saves the number from userinput
	 * 
	 * @return the number (int) from user
	 */
	int intInputFromUser();

}
