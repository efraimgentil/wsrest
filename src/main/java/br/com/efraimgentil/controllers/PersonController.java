package br.com.efraimgentil.controllers;

import br.com.efraimgentil.models.Pessoa;
import br.com.efraimgentil.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

  @Secured("ROLE_LOL")
  @RequestMapping(value = { "/" } , method = RequestMethod.GET )
  public List<Pessoa> persons(){
    return personRepository.findAll();
  }

}
