package br.com.efraimgentil.models;

import javax.persistence.*;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
@Entity
@Table(name="person" )
@Inheritance(strategy =  InheritanceType.JOINED)
public class Person {

  @Id
  private Integer id;

  private String name;


}
