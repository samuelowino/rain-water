package com.owino.jpacode.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class TweetMetadata {
    @Column(name = "TWEETTYPE")
    private String tweetType;
    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;
}
