package com.askie01.springsecuritytutorial.mapper;

public interface ToDTOMapper <Source, DTO> {
    DTO mapToDTO(Source source);
}
