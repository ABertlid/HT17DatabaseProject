package com.anneli.view;

public interface Reader extends AutoCloseable {

	String stringInputFromUser();

	int intInputFromUser();

}
