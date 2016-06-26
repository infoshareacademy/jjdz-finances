package com.infoshareacademy.finances.reports.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;

public enum PlanActionType {
	BUY, SELL;
}
