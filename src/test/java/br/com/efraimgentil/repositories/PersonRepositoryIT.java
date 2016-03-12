package br.com.efraimgentil.repositories;

import br.com.efraimgentil.config.DatabaseConfig;
import br.com.efraimgentil.config.SpringConfig;
import br.com.efraimgentil.config.SpringDataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
@ContextConfiguration(classes = { SpringConfig.class, DatabaseConfig.class , SpringDataConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRepositoryIT {

  @Autowired
  PersonRepository personRepository;

  @Test
  public void doesDoSomething(){
    System.out.println( personRepository.findAll() );
  }

}
