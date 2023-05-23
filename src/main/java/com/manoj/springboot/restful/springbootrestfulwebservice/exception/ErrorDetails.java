package com.manoj.springboot.restful.springbootrestfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    LocalDateTime localDateTime;
    private String message;
    private String path;
    private String errorCode;
}
