package com.proyecto.proyecto_market.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    // Definir el DataSource que se usará para la conexión a la base de datos
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Cambia esto si usas otro DBMS
        dataSource.setUrl("jdbc:postgresql://localhost:5432/MeowMarket"); // URL de tu base de datos
        dataSource.setUsername("postgres"); // Usuario de la base de datos
        dataSource.setPassword("root"); // Contraseña de la base de datos
        return dataSource;
    }

    // Crear el JdbcTemplate que se inyectará en los repositorios
    @Bean
    public static JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource); // Inyecta el DataSource configurado
    }
}