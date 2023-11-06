package ru.job4j.ood.srp.formatter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JSONCalendarSerializer implements JsonSerializer<Calendar> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(DATE_FORMAT.format(calendar.getTime()));
    }
}
