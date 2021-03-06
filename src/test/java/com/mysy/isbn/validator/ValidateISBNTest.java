package com.mysy.isbn.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

    @Test
    void checkAValid10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn("0321125215");
        assertThat(result).isTrue();
        //8389779013
        result = validator.checkIsbn("8389779013");
        assertThat(result).isTrue();
    }

    @Test
    void checkAValid13DigitISBN() {
        //9788327159168
        ValidateISBN validator = new ValidateISBN();
        boolean result =  validator.checkIsbn("9788327159168");
        assertThat(result).isTrue();
        //9788365973849
        result =  validator.checkIsbn("9788365973849");
        assertThat(result).isTrue();

    }

    @Test
    void checkAnInvalid13DigitISBN() {

        //9788327159168
        //9*1 + 7*3 + 8*1 + 8*3 + 3*1 + 2*3 + 7*1 + 1*3 + 5*1 + 9*3 + 1*1 + 6*3 + 8*1 = 140%10 = 0 - is valid
        ValidateISBN validator = new ValidateISBN();
        boolean result =  validator.checkIsbn("9788327159169");
        assertThat(result).isFalse();
        //9788365973849
//        result =  validator.checkIsbn("9788365973840");
//        assertThat(result).isTrue();

    }


    @Test
    void TenDigitISBNumbersEndingXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkIsbn("012000030X");
        assertThat(result).isTrue();
    }

    @Test
    void checkAnInvalid10DigitISBN() {
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
