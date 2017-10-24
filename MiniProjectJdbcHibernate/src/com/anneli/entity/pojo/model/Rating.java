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
 * Entity bean class represents table Rating from database
 * 
 * @author Anneli
 *
 */
@Entity
@Table(name = "ratings")
public class Rating implements Serializable {
	private static final long serialVersionUID = -2652523004112845176L;

	@Id
	@Column(name = "rat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratId;

	@Column(name = "rating")
	private double rating;

	@OneToMany(mappedBy = "myEvaluate", fetch = FetchType.EAGER)
	private List<Serie> series;

	public Rating() {

	}

	public Rating(double rating) {
		this.rating = rating;
	}

	/**
	 * Gets the primary key
	 * 
	 * @return the number of ratId
	 */
	public int getRatId() {
		return ratId;
	}

	/**
	 * Gets the rate
	 * 
	 * @return rating double
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the primary key
	 * 
	 * @param ratId
	 *            as an int
	 */
	public void setRatId(int ratId) {
		this.ratId = ratId;
	}

	/**
	 * Sets the rate
	 * 
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
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
		return "Rating [ratId=" + ratId + ", rating=" + rating + ", series=" + series + "]";
	}

}
