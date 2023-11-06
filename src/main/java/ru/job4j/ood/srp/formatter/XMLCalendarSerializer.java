package ru.job4j.ood.srp.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XMLCalendarSerializer extends XmlAdapter<String, Calendar> {


    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public String marshal(Calendar v) {
        return dateFormat.format(v.getTime());
    }

    @Override
    public Calendar unmarshal(String v) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(v));
        return cal;
    }
}
