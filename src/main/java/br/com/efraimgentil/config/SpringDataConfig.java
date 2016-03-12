package br.com.efraimgentil.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 18/02/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = { "br.com.efraimgentil.repositories" })
public class SpringDataConfig {

  @Qualifier("database")
  @Autowired
  protected ResourceBundle resourceBundle;


}
