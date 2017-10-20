package com.anneli.repository.model;

import java.util.List;

import com.anneli.entity.pojo.model.Serie;

public interface SerieRepositoryI {
	//TODO
	// extends AutoCloseable

	Serie get(int primaryKey, String uString); //update

	List<Serie> getAll(); //read

	void add(String uString); //create

	void delete(int uInt); //delete

	List<Serie> searchSerie(String uString);

	void closeFactory();
}
