package eu.epicpvp.datenserver.definitions.events;

import java.util.ArrayList;

import eu.epicpvp.datenserver.definitions.dataserver.protocoll.DataBuffer;

public abstract class ArrayEventCondition<T> extends SerelizeableEventCondition<T>{
	private ArrayList<T> elements = new ArrayList<>();
	private Class<T> elementType;
	public ArrayEventCondition(Class<T> elementType) {
		this.elementType = elementType;
	}

	@Override
	public void read(DataBuffer buffer) {
		int length = buffer.readInt();
		for(int i = 0;i<length;i++)
			elements.add(readElement(buffer));
	}

	@Override
	public void write(DataBuffer buffer) {
		buffer.writeInt(elements.size());
		for(T e : elements)
			writeElement(e, buffer);
	}

	public abstract T readElement(DataBuffer buffer);
	public abstract void writeElement(T obj,DataBuffer buffer);

	@Override
	public void addValue(T value) {
		if(!elementType.isAssignableFrom(value.getClass()))
			throw new RuntimeException("Condition parameters are "+elementType.getName());
		elements.add(value);
	}

	@Override
	public void removeValue(T value) {
		elements.remove(value);
	}

	@Override
	public boolean hasValue(T value) {
		return elements.contains(value);
	}

	@Override
	public ArrayList<T> getValues() {
		return elements;
	}
}
