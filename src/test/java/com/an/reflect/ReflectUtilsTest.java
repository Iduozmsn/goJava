package com.an.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectUtilsTest {

    @Test
    public void testGetConstructorWant() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors = Person.class.getConstructors();
        // 想获得Person类的:public Person(String name, int age, int height)构造方法对应的constructor对象
        Constructor<?> constructor = ReflectUtils.getConstructorWant(constructors, new Class<?>[]{String.class, int.class, int.class});
        Object object = constructor.newInstance("an", 25, 169);
        Assert.assertEquals(object.getClass(), Person.class);

        // 想获得Person类的:public Person() 无参构造方法
        Constructor<?> constructor1 = ReflectUtils.getConstructorWant(constructors, null);
        Object object1 = constructor1.newInstance();
        Assert.assertEquals(object1.getClass(), Person.class);
    }
}
