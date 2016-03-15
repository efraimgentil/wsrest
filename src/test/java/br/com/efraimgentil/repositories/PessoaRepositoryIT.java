package br.com.efraimgentil.repositories;

import br.com.efraimgentil.config.DatabaseConfig;
import br.com.efraimgentil.config.SpringConfig;
import br.com.efraimgentil.config.SpringDataConfig;
import br.com.efraimgentil.models.Pessoa;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 14/03/16.
 */
@ContextConfiguration(classes = { SpringConfig.class, DatabaseConfig.class , SpringDataConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PessoaRepositoryIT {

  @PersistenceContext
  EntityManager entityManager;

  @Test
  public void l(){
    Pessoa p = new Pessoa();
    p.setName("Efraim Gentil");
    entityManager.persist( p );


    //entityManager.
  }


}
