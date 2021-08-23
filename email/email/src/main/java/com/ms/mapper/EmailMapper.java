package com.ms.mapper;

import com.ms.dto.EmailDto;
import com.ms.model.Email;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

@UtilityClass
public class EmailMapper {

    public static Email map(EmailDto dto) {
        if (ObjectUtils.isEmpty(dto)) {
            return null;
        }

        var email = new Email();
        email.setOwnerRef(dto.getOwnerRef());
        email.setEmailFrom(dto.getEmailFrom());
        email.setEmailTo(dto.getEmailTo());
        email.setSubject(dto.getSubject());
        email.setText(dto.getText());

        return email;
    }

    public static EmailDto map(Email model) {
        if (ObjectUtils.isEmpty(model)) {
            return null;
        }

        return EmailDto.builder()
                .ownerRef(model.getOwnerRef())
                .emailFrom(model.getEmailFrom())
                .emailTo(model.getEmailTo())
                .subject(model.getSubject())
                .text(model.getText())
                .sendDateEmail(model.getSendDateEmail())
                .statusEmail(model.getStatusEmail())
                .build();
    }
}
