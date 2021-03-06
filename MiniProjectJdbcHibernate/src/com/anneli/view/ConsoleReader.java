package com.anneli.view;

import java.util.Scanner;

/**
 * Class that handle the inputs from user with a scanner object
 * 
 * @author Anneli
 *
 */
public class ConsoleReader implements Reader {

	private Scanner scan = new Scanner(System.in);

	@Override
	public String stringInputFromUser() {
		String input = scan.nextLine();

		return input;
	}

	@Override
	public int intInputFromUser() {
		int input = scan.nextInt();

		return input;
	}

	@Override
	public void close() throws Exception {

	}

}
