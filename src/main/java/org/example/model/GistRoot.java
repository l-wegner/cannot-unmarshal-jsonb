package org.example.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS)
@Entity
public class GistRoot {
    @Id
    @AutoPopulated
    UUID id;
    @NotNull
    String location;

    @NotNull
    @Singular
    @TypeDef(type = DataType.JSON)
    List<GistListEntry> members;
}
