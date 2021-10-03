package com.bts.db.domain;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class NFTDto {
    private String id;
    private String name;
    private String description;
    private String image;
    private Long owner;
    private String date;
    private String imagepath;
}
