package com.weekendproject.connectivly;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mariadb://weekendlabs.xyz:3306/connectivly_new");
        dataSourceBuilder.username("regie");
        dataSourceBuilder.password("P@ssw0rd");
        return dataSourceBuilder.build();
    }
}
