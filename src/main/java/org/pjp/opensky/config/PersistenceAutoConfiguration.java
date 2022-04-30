package org.pjp.opensky.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author frialey63
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "org.pjp.opensky.repository",
    entityManagerFactoryRef = "aircraftEntityManager", transactionManagerRef = "aircraftTransactionManager")
public class PersistenceAutoConfiguration {

    /**
     * @return The DataSource
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @return The LocalContainerEntityManagerFactoryBean
     */
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean aircraftEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"org.pjp.opensky.model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.show-sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
        em.setJpaPropertyMap(properties);

        return em;
    }

    /**
     * @return The PlatformTransactionManager
     */
    @Primary
    @Bean
    public PlatformTransactionManager aircraftTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(aircraftEntityManager().getObject());
        return transactionManager;
    }
}