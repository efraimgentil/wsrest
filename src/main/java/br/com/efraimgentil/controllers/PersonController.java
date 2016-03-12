package br.com.efraimgentil.controllers;

import br.com.efraimgentil.models.Person;
import br.com.efraimgentil.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

  @Autowired
  protected PersonRepository personRepository;

  @Sec
  @RequestMapping(value = { "/" } , method = RequestMethod.GET )
  public List<Person> persons(){
    return personRepository.findAll();
  }

}
