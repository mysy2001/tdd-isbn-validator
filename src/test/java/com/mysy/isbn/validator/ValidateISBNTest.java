package com.mysy.isbn.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

    @Test
    void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn(321125215);
        assertThat(result).isTrue();
    }
}
