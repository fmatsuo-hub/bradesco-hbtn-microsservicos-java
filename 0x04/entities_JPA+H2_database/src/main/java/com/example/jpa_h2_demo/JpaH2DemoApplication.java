package com.example.jpa_h2_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class JpaH2DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaH2DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner exportTables(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection();
                 Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='PUBLIC'")) {

                try (FileWriter fw = new FileWriter("tabelas.txt")) {
                    while (rs.next()) {
                        fw.write(rs.getString(1) + System.lineSeparator());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
