package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsData {
    private Statistics statistics;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPosts;

    public StatisticsData(Statistics statistics) {
        this.statistics = statistics;
        calculateAdvStatistics(this.statistics);
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.usersNames().size() > 0) {
            averagePostsPerUser = (double) statistics.postsCount() / (double) statistics.usersNames().size();
            averageCommentsPerUser = (double) statistics.commentsCount() / (double) statistics.usersNames().size();

            if (statistics.commentsCount() > 0 && statistics.postsCount() > 0) {
                averageCommentsPerPosts = (double) statistics.commentsCount() / (double) statistics.postsCount();
            } else if (statistics.commentsCount() > 0) {
                averageCommentsPerPosts = statistics.commentsCount();
            } else {
                averageCommentsPerPosts = 0;
            }

        } else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
            averageCommentsPerPosts = 0;
        }
    }

    public void showStatistics() {
        System.out.println(averageCommentsPerPosts);
        System.out.println(averageCommentsPerUser);
        System.out.println(averagePostsPerUser);
    }


    public List<String> usersNames() {
        return statistics.usersNames();
    }
    int postsCount() {
        return statistics.postsCount();
    }
    int commentsCount() {
        return statistics.commentsCount();
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public void setAveragePostsPerUser(double averagePostsPerUser) {
        this.averagePostsPerUser = averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public void setAverageCommentsPerUser(double averageCommentsPerUser) {
        this.averageCommentsPerUser = averageCommentsPerUser;
    }

    public double getAverageCommentsPerPosts() {
        return averageCommentsPerPosts;
    }

    public void setAverageCommentsPerPosts(double averageCommentsPerPosts) {
        this.averageCommentsPerPosts = averageCommentsPerPosts;
    }
}
