package com.example.interview.api;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.util.Set;

@Value
@Builder
@Jacksonized
public class CustomerDto {

    Long id;

    String name;

    @Builder.Default
    Set<ContactDto> contacts = Set.of();
}
