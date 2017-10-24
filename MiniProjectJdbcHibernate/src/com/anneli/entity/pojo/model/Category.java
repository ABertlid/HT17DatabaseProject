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

/**
 * Entity bean class represents table Category from database
 * 
 * @author Anneli
 *
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {
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

	/**
	 * Gets the primary key
	 * 
	 * @return the number of catId
	 */
	public int getCatId() {
		return catId;
	}

	/**
	 * Gets the type of a Category
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the primary key
	 * 
	 * @param catId
	 *            as an int
	 */
	public void setCatId(int catId) {
		this.catId = catId;
	}

	/**
	 * Sets the type of a Category
	 * 
	 * @param type
	 *            as a String
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets a list of type Serie
	 * 
	 * @return a list of series
	 */
	public List<Serie> getSeries() {
		return series;
	}

	/**
	 * Sets a serie type
	 * 
	 * @param series
	 */
	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		String result = String.format("%1$-5s", series);

		return result;

	}

}
