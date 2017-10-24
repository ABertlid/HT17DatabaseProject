package com.anneli.entity.pojo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

/**
 * Entity bean class represents table Serie from database
 * 
 * @author Anneli
 *
 */
@Entity
@NamedStoredProcedureQuery(name = "all_series", procedureName = "all_series")
@Table(name = "series")
public class Serie implements Serializable {
	private static final long serialVersionUID = 2918636636420848857L;

	@Id
	@Column(name = "serie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serieId;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category myConnect;

	@ManyToOne
	@JoinColumn(name = "rating_id")
	private Rating myEvaluate;

	public Serie() {

	}

	public Serie(String title) {
		this.title = title;
	}

	/**
	 * Gets the primary key
	 * 
	 * @return the number of serieId
	 */
	public int getSerieId() {
		return serieId;
	}

	/**
	 * Gets the title of a Serie
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the primary key
	 * 
	 * @param serieId
	 *            as an int
	 */
	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}

	/**
	 * Sets the title of a Serie
	 * 
	 * @param title
	 *            as a String
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the primary key of a category
	 * 
	 * @return Category key object
	 */
	public Category getMyConnect() {
		return myConnect;
	}

	/**
	 * Sets a category type
	 * 
	 * @param myConnect
	 */
	public void setMyConnect(Category myConnect) {
		this.myConnect = myConnect;
	}

	/**
	 * Gets the primary key of rating
	 * 
	 * @return Rating key object
	 */
	public Rating getMyEvaluate() {
		return myEvaluate;
	}

	/**
	 * Sets a rating type
	 * 
	 * @param myEvaluate
	 */
	public void setMyEvaluate(Rating myEvaluate) {
		this.myEvaluate = myEvaluate;
	}

	@Override
	public String toString() {
		String result = String.format("%1$-5s %2$-30s %3$-20s %4$s", serieId, title, myConnect.getType(),
				myEvaluate.getRating());

		return result;
	}

}
