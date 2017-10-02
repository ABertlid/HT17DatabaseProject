package com.anneli.repository;

import java.util.List;

import com.anneli.entity.Category;

public interface CategoryRepositoryI {

	Category get(int primaryKey);

	void getAll();

	List<Category> searchSerieByCategory(String uString);
}
