package com.example.reportsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/databases")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Map<String, Object>> getAllDatabases() {
        return jdbcTemplate.queryForList("SHOW DATABASES");
    }

    @GetMapping("/tables")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Map<String, Object>> getAllTables() {
        return jdbcTemplate.queryForList("SHOW TABLES");
    }

    @GetMapping("/status")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> getDatabaseStatus() {
        return jdbcTemplate.queryForMap("SHOW STATUS LIKE 'Uptime'");
    }
}