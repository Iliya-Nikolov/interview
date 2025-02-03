package com.example.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @NaturalId
    private String name;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "customer")
    @Builder.Default
    private Set<Contact> contacts = new HashSet<>();

}
