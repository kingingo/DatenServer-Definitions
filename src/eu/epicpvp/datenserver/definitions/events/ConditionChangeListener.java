package eu.epicpvp.datenserver.definitions.events;

public interface ConditionChangeListener<T> {
	public void onValueAdd(EventCondition con,T obj);
	public void onValueRemove(EventCondition con,T obj);
}
