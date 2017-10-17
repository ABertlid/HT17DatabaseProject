package com.anneli.repository.model;

import java.util.List;

public interface GeneralRepository<T> {

	T get(int primaryKey, String uString);

	List<T> getAll();

	void add(String uString);

	void delete(int uInt);

	List<T> searchSerie(String uString);
	
	List<T> searchSerieByCategory(String userInput);
	
	void closeFactory();
}
