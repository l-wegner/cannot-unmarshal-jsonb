package org.example.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.example.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class GistRepositoryTest {
    @Inject
    GistRepository repo;
    @Inject
    ObjectMapper om;


    @Test
    void testSerializationWithMicronaut() {
        GistRoot.GistRootBuilder entityBuilder = GistRoot.builder()
                .location("interwebs")
                .member(GistListEntry.builder()
                        .name("Alice")
                        .age(42)
                        .build())
                .member(GistListEntry.builder()
                        .name("Bob")
                        .age(23)
                        .build());
        GistRoot entityToSave = entityBuilder
                .build();

        UUID newEntityId = repo.save(entityToSave).getId();
        GistRoot expectedEntity = entityBuilder
                .id(newEntityId)
                .build();

        Optional<GistRoot> savedProofTemplate = repo.findById(newEntityId);
        assertTrue(savedProofTemplate.isPresent());
        assertEquals(expectedEntity, savedProofTemplate.get());
    }

    @Test
    void testThatSerializationWorksBothWays() throws JsonProcessingException {
        GistRoot expectedEntity = GistRoot.builder()
                .location("interwebs")
                .member(GistListEntry.builder()
                        .name("Alice")
                        .age(42)
                        .build())
                .member(GistListEntry.builder()
                        .name("Bob")
                        .age(23)
                        .build()).build();
        String string = om.writeValueAsString(expectedEntity);
        GistRoot actualEntity = om.readValue(string, GistRoot.class);
        Assertions.assertEquals(expectedEntity, actualEntity);
    }
}
