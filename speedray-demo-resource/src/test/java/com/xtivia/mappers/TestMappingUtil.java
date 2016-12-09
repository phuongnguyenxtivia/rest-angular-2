package com.xtivia.mappers;

import static org.fest.assertions.Assertions.*;
import org.testng.annotations.Test;


/**
 * Created by ddavis on 12/6/16.
 */
public class TestMappingUtil {

    @Test
    public void happyPath() {
        TestMappingInterface testMappingInterface = MappingUtil.getMapper(TestMappingInterface.class);
        assertThat(testMappingInterface).isNotNull();
        assertThat(testMappingInterface).isInstanceOf(TestMappingInterfaceImpl.class);
    }

    @Test
    public void handlesNullCorrectly() {
        Class<?> nullInterface = MappingUtil.getMapper(null);
        assertThat(nullInterface).isNull();
    }
}
