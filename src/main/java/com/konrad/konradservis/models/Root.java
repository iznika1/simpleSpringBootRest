package com.konrad.konradservis.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Root implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567551646437330081L;
	
	protected Integer id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
