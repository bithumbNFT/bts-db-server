package com.bts.db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeleteDto {
    private String from;
    private String id;
}
