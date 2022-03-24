package sn.dioufy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sn.dioufy.entities.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
