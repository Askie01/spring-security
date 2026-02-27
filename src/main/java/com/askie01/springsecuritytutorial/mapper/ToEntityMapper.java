package com.askie01.springsecuritytutorial.mapper;

public interface ToEntityMapper <Source, Entity> {
    Entity mapToEntity(Source source);
}
