package com.mysy.isbn.validator;

public class ValidateISBN {

    private static final int LONG_ISBN_LENGTH = 13;

    private static final int SHORT_ISBN_LENGTH = 10;

    private static final int LONG_ISBN_MULTIPLIER = 10;

    private static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkIsbn(final String isbn) {

        if ( isbn.length() == 13 ) {
            return isThisAValidLongIsbn(isbn);
        } else if (isbn.length() == 10) {
            return isThisAValidShortIsbn(isbn);
        }

        throw new NumberFormatException("Isbn number must be 10 or 13 digits long");
    }

    private boolean isThisAValidShortIsbn(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if ( !Character.isDigit(isbn.charAt(i)) ) {
                if ( i == 9 && isbn.charAt(i) == 'X' ) {
                    //ok
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN number can only contain numeric digits");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }

        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private boolean isThisAValidLongIsbn(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {

            if ( i % 2 == 0 ) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return (total % LONG_ISBN_MULTIPLIER == 0);
    }
}
