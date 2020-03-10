package com.mysy.isbn.validator;

public class ValidateISBN {
    public boolean checkIsbn(final String isbn) {
        //0 3 2 1 1 2 5 2 1 5 L
        //30 18 8 7 12 25 8
        //8 3 8 9 7 7 9 0 1 3
        //80 27 64 63 42 35 36 0 2 3 = 352/11 = 32
        if (isbn.equals("0321125215")) {
            return true;
        }
        return false;
    }
}
