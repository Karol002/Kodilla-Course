package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DisplayName("TDD: Forum Statistics Test Suite \uD83D\uDE31")
@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private static int commentsQuantity = 0;
    private static int postsQuantity = 0;
    private static List<String> userQuantity = new ArrayList<>();

    private void statisticsGenerator(int comments, int posts, int users) {
        commentsQuantity = comments;
        postsQuantity = posts;
        for (int i = 0; i < users; i++) {
                userQuantity.add("User" + i);
        }
   }

    private void statisticsCleaner() {
        commentsQuantity = 0;
        postsQuantity = 0;
        userQuantity.clear();

    }

    @AfterEach
    public void afterEveryTest() {
        statisticsCleaner();
    }

    @Nested
    @DisplayName("Tests for posts quantity")
    class PostsQuantity {

        @Test
        void testForZeroPosts() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(1,1,1);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.getAverageCommentsPerUser();

            //Then
            assertEquals(1,resultUsers);
            assertEquals(1,resultPosts);
            assertEquals(1,resultComments);
        }

        @Test
        void testForThousandPosts() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(500,1000,1);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.getAverageCommentsPerUser();

            //Then
            assertEquals(500,resultUsers);
            assertEquals(1000,resultPosts);
            assertEquals(0.5,resultComments);
        }
    }

    @Nested
    @DisplayName("Tests for comments quantity")
    class CommentsQuantity {

        @Test
        void testForZeroComments() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(0,1,1);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double result = statisticsData.getAverageCommentsPerUser();

            //Then
            assertEquals(0,result);
        }

        @Test
        void testForLessCommentsThanPosts() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(1,2,2);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.getAverageCommentsPerUser();

            //Then
            assertTrue(resultPosts > resultComments);
            assertTrue(resultPosts > resultUsers);
            assertTrue(resultUsers == resultComments);
        }

        @Test
        void testForMoreCommentsThanPosts() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(2,1,1);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.getAverageCommentsPerUser();

            //Then
            assertTrue(resultPosts < resultComments);
            assertTrue(resultPosts < resultUsers);
            assertTrue(resultUsers == resultComments);
        }
    }

    @Nested
    @DisplayName("Tests for users quantity")
    class UsersQuantity {

        @Test
        void testForZeroUsers() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(100,100,0);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.usersNames().size();

            //Then
            assertEquals(0,resultUsers);
            assertEquals(0,resultPosts);
            assertEquals(0,resultComments);
        }

        @Test
        void testForHundredUsers() {

            //Given
            StatisticsData statisticsData = new StatisticsData(statisticsMock);
            statisticsGenerator(100,100,100);

            when(statisticsMock.postsCount()).thenReturn(postsQuantity);
            when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);
            when(statisticsMock.usersNames()).thenReturn(userQuantity);

            //When
            statisticsData.calculateAdvStatistics(statisticsMock);
            double resultComments = statisticsData.getAverageCommentsPerPosts();
            double resultPosts = statisticsData.getAveragePostsPerUser();
            double resultUsers = statisticsData.usersNames().size();

            //Then
            assertEquals(1,resultComments);
            assertEquals(1,resultPosts);
            assertEquals(100,resultUsers);
        }
    }
}
