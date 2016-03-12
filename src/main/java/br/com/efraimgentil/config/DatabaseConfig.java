package br.com.efraimgentil.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 08/03/16.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  @Bean
  @Qualifier(value = "database")
  public ResourceBundle dataBaseProperties(){
    return ResourceBundle.getBundle("database");
  }

  @Qualifier(value = "postgres")
  @Bean
  public DataSource postgres(){
    ResourceBundle databaseBundle = dataBaseProperties();
    HikariConfig dataSourceConfig = new HikariConfig();
    dataSourceConfig.setDriverClassName(databaseBundle.getString("pg.driver"));
    dataSourceConfig.setJdbcUrl(databaseBundle.getString("pg.url"));
    dataSourceConfig.setUsername(databaseBundle.getString("pg.username"));
    dataSourceConfig.setPassword( databaseBundle.getString("pg.password")  );
    dataSourceConfig.setMaximumPoolSize( 10 );
    dataSourceConfig.setConnectionTestQuery( databaseBundle.getString("pg.testQuery") );
    dataSourceConfig.setIdleTimeout( 1000000 );
    return new HikariDataSource(dataSourceConfig);
  }

  @Bean
  @DependsOn(value = "postgres")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("postgres") DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan("br.com.efraimgentil.models");
    Properties jpaProperties = new Properties();
    //Configures the used database dialect. This allows Hibernate to create SQL
    //that is optimized for the used database.
    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    //If the value of this property is true, Hibernate writes all SQL
    //statements to the console.
    jpaProperties.put("hibernate.show_sql", "true");
    //If the value of this property is true, Hibernate will format the SQL
    //that is written to the console.
    jpaProperties.put("hibernate.format_sql", "true" );
    jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop" );
    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    return entityManagerFactoryBean;
  }

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

}
