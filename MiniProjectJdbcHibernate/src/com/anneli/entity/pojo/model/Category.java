package com.anneli.entity.pojo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.anneli.repository.model.EntityCRUD;

@Entity
@Table(name = "categories")
public class Category extends EntityCRUD<Category> implements Serializable {
	private static final long serialVersionUID = 7687175411398320073L;

	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;

	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "myConnect", fetch = FetchType.EAGER)
	private List<Serie> series;

	public Category() {

	}

	public Category(String type) {
		this.type = type;
	}

	public int getCatId() {
		return catId;
	}

	public String getType() {
		return type;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return series.toString();
					
	}

}
