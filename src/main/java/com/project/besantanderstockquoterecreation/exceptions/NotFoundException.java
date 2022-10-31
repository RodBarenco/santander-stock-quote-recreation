package com.project.besantanderstockquoterecreation.exceptions;

import com.project.besantanderstockquoterecreation.util.MessageUtils;

public class NotFoundException extends  RuntimeException {

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
