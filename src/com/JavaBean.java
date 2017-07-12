package com;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class JavaBean {
	private String name;//字段
    
    public String getName() {
    	System.out.println("getName---->");
    	return name;
    }
    public void setName(String name) {
    	System.out.println("setName---->");
    	this.name = name;
    }
	public static void main(String[] args) throws Exception{
		JavaBean student = new JavaBean();
        //1.通过Introspector来获取bean对象的beaninfo
        BeanInfo bif = Introspector.getBeanInfo(JavaBean.class);
        //2.通过beaninfo来获得属性描述器(propertyDescriptor)
        PropertyDescriptor pds[] = bif.getPropertyDescriptors();
        //3.通过属性描述器来获得对应的get/set方法
        for(PropertyDescriptor pd:pds){
               //4.获得并输出字段的名字
               System.out.println(pd.getName());
               //5.获得并输出字段的类型
               System.out.println(pd.getPropertyType());
               if(pd.getName().equals("name")){
                      //6.获得PropertyDescriptor对象的写方法-->setName
                      Method md = pd.getWriteMethod();
                      //7.执行写方法
                      md.invoke(student, "Lou_Wazor");
               }
        }
        //8.输出所赋值字段的值
        System.out.println(student.getName());
	}
	
}
