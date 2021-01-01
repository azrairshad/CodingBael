package org.baeldung.web.main.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Configuration
public class DBConfig {

    private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"org.baeldung.web.main.entity"};

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hinbernate_dilect;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl_auto;

    @Value("${spring.jpa.show-sql}")
    private String show_sql;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    private Logger logger = LoggerFactory.getLogger(DBConfig.class);

    @Bean
    public DataSource sqlDataSource() {
        logger.info("DataSource is initializing ... "+url +" , " + driver);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.type(org.sqlite.SQLiteDataSource.class);
        return dataSourceBuilder.build();
    }
}
