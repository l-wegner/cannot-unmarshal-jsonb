package org.example.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS)
public class GistListEntry {

    @NotEmpty
    private String name;
    @NotEmpty
    private Integer age;
}
