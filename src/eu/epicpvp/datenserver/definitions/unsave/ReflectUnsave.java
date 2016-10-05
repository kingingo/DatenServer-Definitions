package eu.epicpvp.datenserver.definitions.unsave;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class ReflectUnsave {
	private static Unsafe unsaveInstance = null;
	public static Unsafe getUnsafe() {
		if(unsaveInstance != null)
			return unsaveInstance;
        Field singleoneInstanceField;
		try {
			singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
			singleoneInstanceField.setAccessible(true);
	        return unsaveInstance = (Unsafe) singleoneInstanceField.get(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
    }
}
