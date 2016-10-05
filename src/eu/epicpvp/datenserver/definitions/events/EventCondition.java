package eu.epicpvp.datenserver.definitions.events;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public abstract class EventCondition<T> {
	public abstract EventConditions getCondition();
	public abstract void addValue(T value);
	public abstract void removeValue(T value);
	public abstract boolean hasValue(T value);
	public abstract ArrayList<T> getValues();
}
