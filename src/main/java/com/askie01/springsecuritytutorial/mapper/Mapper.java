package com.askie01.springsecuritytutorial.mapper;

public interface Mapper <Source, Target> {
    void map(Source source, Target target);
}
