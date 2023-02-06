package com.example.vehicle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vId;
	private String vName;
	private long vPrice;
	private int vModel;
	private String vColor;
	
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public long getvPrice() {
		return vPrice;
	}
	public void setvPrice(long vPrice) {
		this.vPrice = vPrice;
	}
	public int getvModel() {
		return vModel;
	}
	public void setvModel(int vModel) {
		this.vModel = vModel;
	}
	public String getvColor() {
		return vColor;
	}
	public void setvColor(String vColor) {
		this.vColor = vColor;
	}
	@Override
	public String toString() {
		return "Vehicle [vId=" + vId + ", vName=" + vName + ", vPrice=" + vPrice + ", vModel=" + vModel + ", vColor="
				+ vColor + "]";
	}
	
}
