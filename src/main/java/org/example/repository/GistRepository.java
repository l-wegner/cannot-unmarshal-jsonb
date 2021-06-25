package org.example.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import org.example.model.GistRoot;

import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GistRepository extends CrudRepository<GistRoot, UUID> {
}