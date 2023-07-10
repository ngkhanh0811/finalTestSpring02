package com.example.finaltestspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class PageDto {
    private Integer pageSize;
    private Integer pageNumber;
}
