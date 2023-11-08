package org.matheuscordeiro.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.matheuscordeiro.entity.Company;
import org.matheuscordeiro.service.CompanyService;

@Path("/company")
public class CompanyController {
    @Inject
    CompanyService companyService;

    @POST
    public Response save(Company company) {
        final var savedCompany = companyService.save(company);
        if (savedCompany.isPresent()) {
            return Response.ok(savedCompany.get()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    public Response findAllCompanies() {
        final var companies = companyService.getCompanies();
        if (companies.isPresent()) {
            return Response.ok(companies).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
