package com.anneli.entity;

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

	public int getRatId() {
		return ratId;
	}

	public double getRating() {
		return rating;
	}

	public void setRatId(int ratId) {
		this.ratId = ratId;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "Rating [ratId=" + ratId + ", rating=" + rating + ", series=" + series + "]";
	}

}
