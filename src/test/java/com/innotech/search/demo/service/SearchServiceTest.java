package com.innotech.search.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchServiceTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void testBuildQuery() throws Exception {
        // Prepare the input
        Map<String, String> input = new HashMap<>();
        input.put("attr1.prop1", "40");
        input.put("attr1.prop2", "65");
        input.put("options.type1", "1");
        input.put("options.type2.type", "2");
        input.put("options.type2.type.attr2.propx", "5");
        input.put("options.type2.type.attr2.propy", "15");
        input.put("options.type2.type.attr2.prop1", "20");

        // Expected Output
        Map<String, Object> expected = new HashMap<>();
        Map<String, Object> attr1 = new HashMap<>();
        Map<String, Object> options = new HashMap<>();
        Map<String, Object> type2 = new HashMap<>();
        Map<String, Object> type = new HashMap<>();
        Map<String, Object> attr2 = new HashMap<>();

        attr1.put("prop1", "40");
        attr1.put("prop2", "65");
        options.put("type1", "1");
        attr2.put("propx", "5");
        attr2.put("propy", "15");
        attr2.put("prop1", "20");
        type.put("attr2", attr2);
        type2.put("type", type);
        options.put("type2", type2);

        expected.put("attr1", attr1);
        expected.put("options", options);

        // Call the method
        Map<String, Object> actual = searchService.buildQuery(input);

        // Assert the result
        assertEquals(expected, actual, "The actual map does not match the expected map");
    }
}
