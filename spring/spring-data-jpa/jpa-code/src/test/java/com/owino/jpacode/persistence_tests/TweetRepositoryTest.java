package com.owino.jpacode.persistence_tests;

import com.owino.jpacode.entities.Tweet;
import com.owino.jpacode.repositories.TweetRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class TweetRepositoryTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(TweetRepositoryTest.class);
    @Autowired
    private TweetRepository repository;

    @Test
    public void shouldSaveTweetTest() {
        var tweet = new Tweet(1L, "#goodvibes #sweetypie", "2022-12-11", "11:00PM");
        var savedTweet = repository.save(tweet);
        Assertions.assertThat(savedTweet).isNotNull();
        Assertions.assertThat(savedTweet.getId()).isEqualTo(1L);
        Assertions.assertThat(savedTweet.getContents()).isEqualTo("#goodvibes #sweetypie");
        Assertions.assertThat(savedTweet.getDateString()).isEqualTo("2022-12-11");
        Assertions.assertThat(savedTweet.getTimeString()).isEqualTo("11:00PM");
    }

    @Test
    public void shouldFetchTweetPageTest() {
        var count = 1L;

        do {
            repository.save(new Tweet(count, "#goodvibes #sweetypie", String.valueOf(System.currentTimeMillis()), String.valueOf(new Date())));
            count++;
        } while (count <= 50);

        var page = repository.findAll(PageRequest.of(0, 25));

        Assertions.assertThat(page).isNotNull();
        Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(25);
        Assertions.assertThat(page.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(page.stream().toList().size()).isEqualTo(25);
        Assertions.assertThat(page.stream().toList().get(1).getContents()).isEqualTo("#goodvibes #sweetypie");

        page.stream().forEach(System.out::println);

        var secondPage = repository.findAll(PageRequest.of(1,25));

        Assertions.assertThat(secondPage).isNotNull();
        Assertions.assertThat(secondPage.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(secondPage.getNumberOfElements()).isEqualTo(25);
        Assertions.assertThat(secondPage.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(secondPage.stream().toList().size()).isEqualTo(25);
        Assertions.assertThat(secondPage.stream().toList().get(1).getContents()).isEqualTo("#goodvibes #sweetypie");

        secondPage.stream().forEach(System.out::println);
    }

    @Test
    public void shouldCountByTweetPostDateTest(){
        var count = 1L;
        var postDateToday = LocalDate.now();
        var postTime = LocalDateTime.now();
        var postDateTomorrow = LocalDate.now().plusDays(1);
        var dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        var timeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        do {
            if (count % 2 == 0) {
                repository.save(new Tweet(count, "#goodvibes #sweetypie", postDateToday.format(dateTimeFormatter), postTime.format(timeFormatter)));
            }else {
                repository.save(new Tweet(count, "#goodvibes #sweetypie", postDateTomorrow.format(dateTimeFormatter), postTime.format(timeFormatter)));
            }
            count++;
        } while (count <= 50);

        var tomorrowPostsCount = repository.countByDateString(postDateTomorrow.format(dateTimeFormatter));

        LOGGER.info("tomorrowPostsCount found " + tomorrowPostsCount);

        Assertions.assertThat(tomorrowPostsCount).isNotZero();
        Assertions.assertThat(tomorrowPostsCount).isEqualTo(25);
    }

    @Test
    public void shouldRemoveByTweetContentsTest(){
        var count = 1L;
        var dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        do {
            if (count % 2 == 0) {
                repository.save(new Tweet(count, "#goodvibes", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }else {
                repository.save(new Tweet(count, "#badvibe", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }
            count++;
        } while (count <= 50);

        var deletedTweets = repository.removeByContents("#badvibe");
        var newCount = repository.count();

        Assertions.assertThat(deletedTweets).isNotEmpty();
        Assertions.assertThat(deletedTweets.get(0).getContents()).isEqualTo("#badvibe");
        Assertions.assertThat(newCount).isEqualTo(25);

    }

    @Test
    public void shouldGetAllTweetContentsTest(){
        var count = 1L;
        var dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        do {
            if (count % 2 == 0) {
                repository.save(new Tweet(count, "#goodvibes", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }else {
                repository.save(new Tweet(count, "#badvibe", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }
            count++;
        } while (count <= 50);

        var contentEntries = repository.findAllTweetContents();

        Assertions.assertThat(contentEntries).isNotEmpty();
        Assertions.assertThat(contentEntries.get(0)).isNotNull();
        Assertions.assertThat(contentEntries.get(0) instanceof String).isTrue();
        Assertions.assertThat(contentEntries.get(0)).startsWith("#");
    }

    @Test
    public void shouldUpdateTweetContentsIfBeginsWithHashTagTest(){
        var count = 1L;
        var dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        do {
            if (count % 2 == 0) {
                repository.save(new Tweet(count, "#goodvibes", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }else {
                repository.save(new Tweet(count, "#badvibe", LocalDate.now().format(dateTimeFormatter), LocalDate.now().format(dateTimeFormatter)));
            }
            count++;
        } while (count <= 50);

        repository.updateContentsIfContainsHashTag("goodvibes !updated tweet");
        var updatedList = repository.findAll();

        Assertions.assertThat(updatedList.isEmpty()).isFalse();
        Assertions.assertThat(updatedList.get(0).getContents().contains("#")).isFalse();
    }

    @Test
    public void shouldFindAllCircleTweetsTests(){
        repository.save( new Tweet(1L,"This is a very secret message","2022-11-11","12:30PM", "Circle Type"));
        var circleTweets = repository.findAllCircleTweets("Circle Type");
        Assertions.assertThat(circleTweets).isNotEmpty();
        Assertions.assertThat(circleTweets.get(0)).isNotNull();
        Assertions.assertThat(circleTweets.get(0).getTweetType()).isEqualTo("Circle Type");
        Assertions.assertThat(circleTweets.get(0).getCreated()).isNotNull();
    }
}
