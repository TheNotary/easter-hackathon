package com.njax.destructocats.java.app.models.version;

import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.boot.info.BuildProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class VersionTest {

    private Version version;

    // // This mock is autowired into our Version class via magic
    // @MockBean(name="buildProperties")
    // BuildProperties buildProperties;

    @Before
    public void setUp(){
        // given(this.buildProperties.getArtifact()).willReturn("java-app-models");
        // given(this.buildProperties.getGroup()).willReturn("com.njax.destructocats");
        // given(this.buildProperties.getVersion()).willReturn("1.1.1-SNAPSHOT");
        // version = new Version(buildProperties);
        version = new Version();
    }

	@Test
    public void itCanGetItsVersion(){
        String expectedVersion = "com.njax.destructocats:java-app-models:UNKNOWN";
        Assert.assertEquals(expectedVersion, version.info());
    }

}
