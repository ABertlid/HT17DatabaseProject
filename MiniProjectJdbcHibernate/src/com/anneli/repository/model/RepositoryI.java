package com.anneli.repository.model;

import java.util.List;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Rating;
import com.anneli.entity.pojo.model.Serie;

public interface RepositoryI extends AutoCloseable {

	Serie updateSerie(int primaryKey, String uString);

	Category updateCategory(int primaryKey, String uString);

	Rating updateRating(int primaryKey, double uDouble);

	List<Serie> getAllInDatabase();

	List<Category> getAllCategories();

	void addSerie(String uString);

	void addCategory(String uString);

	void addRating(double uDouble);

	void deleteSerie(int uInt);

	void deleteCategory(int uInt);

	List<Serie> searchSerie(String uString);

	List<Category> searchCategory(String uString);

	List<Category> searchSerieByCategory(String userInput);

}
