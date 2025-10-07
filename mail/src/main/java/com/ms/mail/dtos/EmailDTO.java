package com.ms.mail.dtos;

public record EmailDTO(
        Long userId,
        String emailTo,
        String subject,
        String text
) {
}