package br.com.efraimgentil.repositories;

import br.com.efraimgentil.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
public interface PersonRepository extends JpaRepository<Pessoa, Integer>, JpaSpecificationExecutor<Pessoa> {
}
