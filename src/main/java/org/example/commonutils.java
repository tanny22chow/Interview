package org.example;

import java.io.FileInputStream;
import java.util.Properties;

public class commonutils {
    public Properties configreader(String path){
        Properties p=new Properties();
        try{
            p.load(new FileInputStream(path));
        }catch (Exception e){}
        return p;
    }
}
