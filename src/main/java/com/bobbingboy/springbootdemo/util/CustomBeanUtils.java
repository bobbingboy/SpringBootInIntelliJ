package com.bobbingboy.springbootdemo.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class CustomBeanUtils {
    //獲取所有屬性值為空的屬性名之陣列的方法
    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

        List<String> nullPropertyNames = new ArrayList<>();

        for(PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if(beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
}
