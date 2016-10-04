package dev.wolveringer.events;

public interface ConditionChangeListener<T> {
	public void onValueAdd(EventCondition con,T obj);
	public void onValueRemove(EventCondition con,T obj);
}
