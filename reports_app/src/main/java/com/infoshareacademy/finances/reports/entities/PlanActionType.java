package com.infoshareacademy.finances.reports.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;

public enum PlanActionType {
	BUY, SELL;

	@JsonCreator
	public static PlanActionType fromValue(String value){
		System.out.println("value = " + value);
		return PlanActionType.valueOf(value);
	}
}
