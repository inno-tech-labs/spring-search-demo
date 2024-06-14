package com.innotech.search.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.innotech.search.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping
    public Map createQuery(@RequestBody Map<String, String> criteria) throws JsonProcessingException {
        return searchService.buildQuery(criteria);
    }
}
