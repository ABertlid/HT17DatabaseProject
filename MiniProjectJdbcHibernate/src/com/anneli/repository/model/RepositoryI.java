package com.anneli.repository.model;

import java.util.List;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Serie;

/**
 * Interface with CRUD methods
 * 
 * @author Anneli
 *
 */
public interface RepositoryI extends AutoCloseable {
	/**
	 * Updates a row in Serie table
	 * 
	 * @param primaryKey
	 *            points to the specific key/row
	 * @param uString
	 *            retrieves an updated string from user
	 * @return the updated object of Serie class
	 */
	Serie updateSerie(int primaryKey, String uString);

	/**
	 * Reads all data i Serie table
	 * 
	 * @return a linked list with all the data
	 */
	List<Serie> getAllInDatabase();

	/**
	 * Reads the title column
	 * 
	 * @return a linked list with all the titles
	 */
	List<Serie> readAllSeries();

	/**
	 * Creates a new row in Serie table
	 * 
	 * @param uString
	 *            retrieves a string with data from user
	 */
	void addSerie(String uString);

	/**
	 * Deletes a row in the Serie table
	 * 
	 * @param uInt
	 *            points to the specific key/row user wants to delete
	 */
	void deleteSerie(int uInt);

	/**
	 * Search for data in Serie table
	 * 
	 * @param uString
	 *            retrieves one or more letters
	 * @return a linked list with all the titles according to the search
	 */
	List<Serie> searchSerie(String uString);

	/**
	 * Search for data in Category table
	 * 
	 * @param userInput
	 *            retrieves the name of a specific category
	 * @return a linked list with titles according to category
	 */
	List<Category> searchSerieByCategory(String userInput);

}
