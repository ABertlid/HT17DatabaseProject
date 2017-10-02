package com.anneli.repository;

import java.util.List;

import com.anneli.entity.Serie;

public interface SerieRepositoryI {
	
	Serie get(int primaryKey, String uString);
	List <Serie> getAll();
	void add(String uString);
	void delete(int uInt);
	List <Serie> searchSerie(String uString);	
}
