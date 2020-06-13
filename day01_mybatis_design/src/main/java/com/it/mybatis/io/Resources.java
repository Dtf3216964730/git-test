package com.it.mybatis.io;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String filepath){
        return Resources.class.getClassLoader().getResourceAsStream("filename");
    }
}
