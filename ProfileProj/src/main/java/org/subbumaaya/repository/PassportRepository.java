package org.subbumaaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.subbumaaya.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
