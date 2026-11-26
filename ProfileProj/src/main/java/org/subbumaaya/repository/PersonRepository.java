package org.subbumaaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subbumaaya.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
