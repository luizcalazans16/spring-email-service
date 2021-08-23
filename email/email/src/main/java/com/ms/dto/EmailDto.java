package com.ms.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.ms.enums.StatusEmailEnum;
import lombok.Builder;
import lombok.Data;

import javax.servlet.annotation.WebInitParam;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@JsonDeserialize(builder = EmailDto.EmailDtoBuilder.class)
public class EmailDto {

    @NotBlank
    private String ownerRef;

    @Email
    @NotBlank
    private String emailFrom;

    @Email
    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    private LocalDateTime sendDateEmail;

    private StatusEmailEnum statusEmail;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class EmailDtoBuilder{

    }
}
