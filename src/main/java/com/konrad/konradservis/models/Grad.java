package com.konrad.konradservis.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Grad extends Root {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5007119140453307497L;

	private String name;

	@Column(name = "NAZIV")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Grad [name=" + name + "]";
	}
}
