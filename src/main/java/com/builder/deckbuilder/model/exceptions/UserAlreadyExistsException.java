package com.builder.deckbuilder.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User Already Exists.")
public class UserAlreadyExistsException {
}
