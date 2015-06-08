package com.nbi.childportal.pojos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeDateAdapter extends XmlAdapter<String, Date>{

    @Override
    public String marshal(Date timestamp) throws Exception {
        return timestamp.toString();
    }

    @Override
    public Date unmarshal(String time) throws Exception {
    	
    	String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
        return format.parse(time);
        
    }

}