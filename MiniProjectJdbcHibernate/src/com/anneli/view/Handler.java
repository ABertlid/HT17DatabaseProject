package com.anneli.view;

import java.util.Scanner;

public class Handler implements InputHandler {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public String inputStringFromUser() {		
		String input = scan.nextLine();		
		
		return input;
	}

	@Override
	public int inputIntFromUser() {
		int input = scan.nextInt();
		
		return input;
	}

	@Override
	public void closeScanner() {
		scan.close();
		
	}

}
