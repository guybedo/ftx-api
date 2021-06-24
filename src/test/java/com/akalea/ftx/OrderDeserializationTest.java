package com.akalea.ftx;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.springframework.core.io.ClassPathResource;

import com.akalea.ftx.domain.FtxOrder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

public class OrderDeserializationTest extends TestCase {

    public void test()
        throws JsonParseException,
        JsonMappingException,
        IOException,
        ParseException {
        String date = "2019-03-05T09:56:55.728933+00:00";
        Assert.assertNotNull(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(date));
        Assert.assertNotNull(
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX").parse(date));
        FtxOrder order =
            new ObjectMapper().readValue(
                new ClassPathResource("order.json").getInputStream(),
                FtxOrder.class);
        Assert.assertNotNull(order);
    }
}
