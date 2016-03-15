package br.com.efraimgentil.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
@Entity
@Table(name="pessoa" )
@Inheritance(strategy =  InheritanceType.JOINED)
public class Pessoa {

  @Id
  private Integer id;

  private String name;

  @ManyToOne( cascade =  CascadeType.REFRESH )
  @JoinColumn(name="vinculo_id" )
  private Vinculo vinculoAtual;

  @OneToMany(mappedBy = "pessoa")
  private List<Vinculo> vinculos;

  public Pessoa() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Vinculo getVinculoAtual() {
    return vinculoAtual;
  }

  public void setVinculoAtual(Vinculo vinculoAtual) {
    this.vinculoAtual = vinculoAtual;
  }

  public List<Vinculo> getVinculos() {
    return vinculos;
  }

  public void setVinculos(List<Vinculo> vinculos) {
    this.vinculos = vinculos;
  }
}
