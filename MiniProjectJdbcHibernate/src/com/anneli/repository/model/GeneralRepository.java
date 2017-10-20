package com.anneli.repository.model;

import java.util.List;

public interface GeneralRepository<T> {

	T get(int primaryKey, String uString); //update

	List<T> getAll(); //read

	void add(String uString); //add

	void delete(int uInt); //delete

	List<T> searchSerie(String uString); //search
	
	List<T> searchSerieByCategory(String userInput);
	
	void closeFactory();
}
