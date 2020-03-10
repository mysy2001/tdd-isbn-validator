package com.mysy.isbn.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

    @Test
    void checkAValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn("0321125215");
        assertThat(result).isTrue();
        //8389779013
        result = validator.checkIsbn("8389779013");
        assertThat(result).isTrue();
    }

    @Test
    void ISBNumbersEndingXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn("012000030X");
        assertThat(result).isTrue();
    }

    @Test
    void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn("0321125216");
        assertThat(result).isFalse();
    }

    @Test
    void nineDigitIsbnIsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();

        assertThatThrownBy(() -> {
            validator.checkIsbn("321125216");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void nonNumberIsbnIsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();

        assertThatThrownBy(() -> {
            validator.checkIsbn("HelloWorld");
        }).isInstanceOf(NumberFormatException.class);
    }
}
