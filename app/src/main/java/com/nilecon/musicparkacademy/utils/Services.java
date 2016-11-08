package com.nilecon.musicparkacademy.utils;

/**
 * Created by tum on 11-Feb-15.
 */
public class Services {
    public static final String HOME = "http://www.jwctv.com/mainstore/api/rest/products?page=%s";
    public static final String CATAGORIES = "http://www.jwctv.com/mainstore/api/rest/products/category/";
    public static final String TEST = "http://www.musicpark.esy.es/servicetest.php";

    //public static final String LOGIN = "http://161.246.58.188:8888/Service1.svc/login?username=1&password=1";
    public static  final String LOGIN(String username,String password){
        return "http://161.246.58.188:8888/Service1.svc/login?username="+username+"&password="+password;
    }
}
