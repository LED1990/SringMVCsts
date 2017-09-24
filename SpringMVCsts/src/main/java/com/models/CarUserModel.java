package com.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarUserModel {
	private String name;
	private int id;
	private CarModel carModel;

	public CarUserModel() {
	}

	@Autowired
	public CarUserModel(String name, int id, CarModel carModel) {
		this.name = name;
		this.id = id;
		this.carModel = carModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarModel getCarModel() {
		return carModel;
	}

	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}

	public String rentedModel() {
		return carModel.getModel();
	}

	public String rentedMark() {
		return carModel.getMark();
	}
}
