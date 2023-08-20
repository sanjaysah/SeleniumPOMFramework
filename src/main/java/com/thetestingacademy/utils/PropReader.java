package com.thetestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class PropReader {

    PropReader(){}

    static FileInputStream fis = null;
    static Properties prop = null;
    static HashMap<String, String> PROP_KEYS = new HashMap<>();

    static{
        try{
            String filepath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
            prop = new Properties();
            fis = new FileInputStream(new File(filepath));
            prop.load(fis);

            for(Object key : prop.keySet()){
                PROP_KEYS.put(String.valueOf(key),prop.getProperty(String.valueOf(key)));//key, value converted to String
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(Objects.nonNull(fis)){
                    fis.close();
                }
                }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String readKey(String key) throws Exception {
        if(key == null && prop.get("key")==null){
            throw new Exception("Property not found!!");
        }
        else{
            return PROP_KEYS.get(key);
        }
    }
}
