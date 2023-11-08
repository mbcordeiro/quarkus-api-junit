package org.matheuscordeiro.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.matheuscordeiro.entity.Company;
import org.matheuscordeiro.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyService {
    @Inject
    CompanyRepository companyRepository;

    public Optional<Company> save(Company company) {
        try {
            companyRepository.persist(company);
            final var listSize = companyRepository.listAll().size();
            final var savedCompany = companyRepository.listAll().get(listSize - 1);
            return Optional.of(savedCompany);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<List<Company>> getCompanies() {
        return Optional.of(companyRepository.findAll().list());
    }
}
