package com.anneli.repository.model;

import java.util.List;

import com.anneli.entity.pojo.model.Category;

public interface CategoryRepositoryI {

	Category get(int primaryKey);

	List<Category> getAll();

	List<Category> searchSerieByCategory(String uString);
}
