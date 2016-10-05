package eu.epicpvp.datenserver.definitions.events;

import java.util.ArrayList;

public abstract class ChangeableEventCondition<T> extends ArrayEventCondition<T> {
	private ArrayList<ConditionChangeListener<T>> listener = new ArrayList<>();
	
	public ChangeableEventCondition(Class<T> elementType) {
		super(elementType);
	}
	
	@Override
	public void addValue(T value) {
		super.addValue(value);
		for(ConditionChangeListener<T> l : new ArrayList<>(listener))
			l.onValueAdd(this, value);
	}
	@Override
	public void removeValue(T value) {
		super.removeValue(value);
		for(ConditionChangeListener<T> l : new ArrayList<>(listener))
			l.onValueRemove(this, value);
	}
	
	public void addListener(ConditionChangeListener<T> listener){
		this.listener.add(listener);
	}
	public void removeListener(ConditionChangeListener<T> listener){
		this.listener.remove(listener);
	}
}
