package com.test.cc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest
{
    public static void main(String[] args)
    {
        String [] names ={"tom","tim","allen","alice"};
        Class<?> clazz = Test_0831.class;
        try
        {
            Method method = clazz.getMethod("sayHi", String.class,String.class);
            for(String name:names)
                method.invoke(clazz.newInstance(),name,name);
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        }
    }
}
class Test_0831
{
	public Test_0831() {
		System.out.println("constructor");
	}
    public void sayHi(String name,String add)
    {
        System.out.println("Hi "+name+"_"+add);
    }
}