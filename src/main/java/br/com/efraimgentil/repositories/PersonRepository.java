package br.com.efraimgentil.repositories;

import br.com.efraimgentil.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 12/03/16.
 */
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
}
