package com.mysy.isbn.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

    @Test
    void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn(321125215L);
        assertThat(result).isTrue();
        //8389779013
        result = validator.checkIsbn(8389779013L);
        assertThat(result).isTrue();
    }

    @Test
    void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn(321125216);
        assertThat(result).isFalse();
    }
}
