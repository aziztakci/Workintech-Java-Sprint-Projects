package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    public static void validateCard(Card card) {
        if (card == null) {
            throw new CardException("Card nesnesi null olamaz!", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() != null && card.getValue() != null) {
            throw new CardException("Bir kartın aynı anda hem TYPE hem de VALUE değeri olamaz!", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() == null && card.getValue() == null) {
            throw new CardException("Bir kartın ya TYPE ya da VALUE değeri olmak zorundadır!", HttpStatus.BAD_REQUEST);
        }
    }
    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new CardException("Geçersiz Card ID: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}