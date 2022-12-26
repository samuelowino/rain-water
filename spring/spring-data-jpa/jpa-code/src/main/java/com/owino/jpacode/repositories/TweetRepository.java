package com.owino.jpacode.repositories;

import com.owino.jpacode.entities.Tweet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    long countByDateString(String dateString);

    List<Tweet> removeByContents(String contents);

    @Query(value = "SELECT contents FROM tweet", nativeQuery = true)
    List<String> findAllTweetContents();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE tweet SET contents = ?1 WHERE contents LIKE '%#%'", nativeQuery = true)
    int updateContentsIfContainsHashTag(String updateBody);

    @Query(value = "SELECT * FROM tweet WHERE tweetType = ?1", nativeQuery = true)
    List<Tweet> findAllCircleTweets(String type);
}
