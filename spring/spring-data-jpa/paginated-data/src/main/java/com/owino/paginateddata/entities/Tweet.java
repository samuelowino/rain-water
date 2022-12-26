package com.owino.paginateddata.entities;


import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Tweet {
    private long id;
    private String contents;
    private String dateString;
    private String timeString;
}
