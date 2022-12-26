package com.owino.jpacode.entities;

import com.owino.jpacode.entities.base.TweetMetadata;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class Tweet extends TweetMetadata {
    @Id
    private long id;
    private String contents;
    private String dateString;
    private String timeString;

    public Tweet(long id, String contents, String dateString, String timeString, String tweetType) {
        this.id = id;
        this.contents = contents;
        this.dateString = dateString;
        this.timeString = timeString;
        super.setTweetType(tweetType);
    }
}
