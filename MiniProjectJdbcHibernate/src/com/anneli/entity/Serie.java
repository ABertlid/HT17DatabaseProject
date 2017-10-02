package com.anneli.entity;

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


	public int getSerieId() {
		return serieId;
	}

	public String getTitle() {
		return title;
	}

	public void setSerieId(int serieId) {
		this.serieId = serieId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Category getMyConnect() {
		return myConnect;
	}

	public void setMyConnect(Category myConnect) {
		this.myConnect = myConnect;
	}

	@Override
	public String toString() {
		String result = String.format("%1$-5s %2$-30s %3$-20s %4$s", serieId, title, myConnect.getType(), myEvaluate.getRating());
		return result;
	}

	
}
