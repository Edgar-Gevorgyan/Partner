package com.gevorgyan.partner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
class Partner {

    @Id @GeneratedValue
    private Long id;

    private String companyName;
    private String ref;
    private Locale locale;
    private ZonedDateTime expires;

    public Partner(String companyName, String ref, Locale locale, ZonedDateTime expires) {
        this.companyName = companyName;
        this.ref = ref;
        this.locale = locale;
        this.expires = expires;
    }
}