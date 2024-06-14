package com.innotech.search.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SearchService {

    public Map<String, Object> buildQuery(Map<String, String> params) throws JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<>();
        params.forEach((key, value) -> {
            String[] parts = key.split("\\.");
            Map<String, Object> currentMap = jsonMap;

            for (int i = 0; i < parts.length; i++) {
                String part = parts[i];

                // If it's the last part, put the value
                if (i == parts.length - 1) {
                    currentMap.put(part, value);
                } else {
                    // If the key doesn't exist, or is not a map, create a new map
                    if (!currentMap.containsKey(part) || !(currentMap.get(part) instanceof Map)) {
                        currentMap.put(part, new HashMap<>());
                    }
                    // Move to the nested map
                    currentMap = (Map<String, Object>) currentMap.get(part);
                }
            }
        });

        // Serialize map to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
        System.out.println(json);

        return jsonMap;
    }

}
