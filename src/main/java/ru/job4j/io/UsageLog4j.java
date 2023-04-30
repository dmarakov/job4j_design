package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte a = 1;
        short b = 200;
        int c = 300;
        long d = 400L;
        double e = 500;
        float f = 600f;
        char g = 'a';
        boolean h = false;
        LOG.debug("a : {}, b : {}, c : {}, d : {}, e : {}, f : {}, g : {}, h : {}", a, b, c, d, e, f, g, h);
    }
}