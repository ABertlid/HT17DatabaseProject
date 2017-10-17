package com.anneli.repository.model;

import java.util.List;

import com.anneli.entity.model.Serie;

public interface SerieRepositoryI {

	Serie get(int primaryKey, String uString);

	List<Serie> getAll();

	void add(String uString);

	void delete(int uInt);

	List<Serie> searchSerie(String uString);

	void closeFactory();
}
