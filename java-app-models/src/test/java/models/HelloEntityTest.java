package com.njax.destructocats.java.app.models;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class HelloEntityTest {

	@Test
    public void itCanSetAndGetATitleString(){
        HelloEntity helloEntity = new HelloEntity();
        helloEntity.setTitle("I'm a title");
        Assert.assertEquals("I'm a title", helloEntity.getTitle());
    }

}
