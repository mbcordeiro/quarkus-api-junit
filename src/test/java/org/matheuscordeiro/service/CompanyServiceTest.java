package org.matheuscordeiro.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.matheuscordeiro.entity.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@QuarkusTest
class CompanyServiceTest {
    @Inject
    CompanyService service;
    private Company company;

    @BeforeEach
    public void setupTests() {
        company = new Company();
        company.setName("Test Company");
        company.setAddress("Street ABC");
        company.setPhone("222333444");
        company.setRegistry("111222333");
    }

    @Test
    @TestTransaction
    void shouldGetCompanies() {
        service.save(company);
        final var companies = List.of(company);
        Assertions.assertEquals(Optional.of(companies), service.getCompanies());
    }

    @Test
    @TestTransaction
    void shouldSaveCompany() {
        Assertions.assertEquals(Optional.of(company), service.save(company));
    }

    @Test
    @TestTransaction
    void shouldErrorSaveCompany() {
        Assertions.assertEquals(Optional.empty(), service.save(null));
    }
}
