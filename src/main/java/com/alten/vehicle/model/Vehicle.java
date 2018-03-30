package com.alten.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VEHICLE")
public class Vehicle {
	@Id
	private String id;

	@Column(name = "registration_no")
	private String registrationNo;

	public Vehicle() {

	}

	public Vehicle(String id, String registrationNo) {
		this.id = id;
		this.registrationNo = registrationNo;
	}

	public String getId() {
		return id;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registrationNo=" + registrationNo + "]";
	}

}
