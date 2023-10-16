package br.com.souzayasmin.ToDoList.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class utils {
    //quando se tem o static nãoprecisa instanciar a classe


    //pega todas as que propriedades que não sçoa nulas
    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullProprtyNames(source));
    }
    
    //pega todas a propriedades nulas
    public static String[] getNullProprtyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source); //interface para acessar as prorpiedades do java

        PropertyDescriptor[] pds =  src.getPropertyDescriptors();

        //propriedade de valores null
        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd:pds){
           Object srcValue = src.getPropertyValue(pd.getName());
           if(srcValue == null){
              emptyNames.add(pd.getName());
           }
        }

        //array para armazenar todas a propriedade
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
