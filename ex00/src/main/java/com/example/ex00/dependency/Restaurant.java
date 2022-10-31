package com.example.ex00.dependency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
@ToString
public class Restaurant {
    private final Chef chef;
}

