package org.example.backend_14_1.controller;

import org.example.backend_14_1.exception.FieldNotComplatedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(FieldNotComplatedException.class)
    public String handleException(FieldNotComplatedException exception, Model model) {
        model.addAttribute("error", exception.getMessage()); // ✅ to‘g‘ri nom
        return "addBook"; // ❌ redirect emas
    }

}
