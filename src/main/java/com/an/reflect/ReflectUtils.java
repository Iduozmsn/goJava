package com.an.reflect;
import java.lang.reflect.Constructor;


public class ReflectUtils {
    /**
     * find constructor you want in constructors returned by clazz.getConstructors() in java.lang.Class<T>
     * @param constructors constructors returned by clazz.getConstructors()
     * @param parameterTypes Class<?>[] represents parameterType,mind parameter order;if no parameter,you can just use: null
     * @return constructor<?> object you want
     * @throws Exception
     */
    public static Constructor<?> getConstructorWant(Constructor<?>[] constructors, Class<?>[] parameterTypes) {
        int parameterCount = 0;
        if (parameterTypes != null) {
            parameterCount = parameterTypes.length;
        }
        for (Constructor<?> constructor : constructors) {
            boolean found = true; // have found constructor you want
            if (constructor.getParameterCount() != parameterCount){
                continue;
            }
            Class<?>[] parameterTypes1 = constructor.getParameterTypes();
            for (int i = 0; i < parameterCount; i++) {
                if(parameterTypes[i] != parameterTypes1[i]){
                    found = false;
                    break;
                }
            }
            if(found){
                return constructor;
            }
        }
        return null;
    }
}
