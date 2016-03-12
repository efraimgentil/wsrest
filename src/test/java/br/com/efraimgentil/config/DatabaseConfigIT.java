package br.com.efraimgentil.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 08/03/16.
 */
@ContextConfiguration(classes = { SpringConfig.class, DatabaseConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseConfigIT {

  @Autowired
  DataSource dataSource;

  @PersistenceContext
  EntityManager entityManager;


  @Test
  public void teste() throws SQLException {
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
    connection.close();
  }

  @Test
  public void helloEntityManager(){

    System.out.println( entityManager );
  }

}
