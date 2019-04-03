package com.example.demo.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Name XmlBuilder
 * @Description
 * @Author wen
 * @Date 2019-03-28
 */
public class XmlBuilder {
    
    /**
    * @Name xmlStrToObj
    * @Description
    * @Author wen
    * @Date 2019/3/28
    * @param clazz
    * @param xmlStr
    * @return java.lang.Object
    */
    public static Object xmlStrToObj(Class<?> clazz, String xmlStr) throws Exception{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(xmlStr);
        Object xmlObj = unmarshaller.unmarshal(reader);
        if(reader != null){
            reader.close();
        }
        return xmlObj;
    }
    
}
