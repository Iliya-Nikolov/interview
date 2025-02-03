package com.example.interview.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContactDto {

    Long id;
    String name;
}
