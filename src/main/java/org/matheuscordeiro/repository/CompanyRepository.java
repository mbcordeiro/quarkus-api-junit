package org.matheuscordeiro.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.matheuscordeiro.entity.Company;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
}
