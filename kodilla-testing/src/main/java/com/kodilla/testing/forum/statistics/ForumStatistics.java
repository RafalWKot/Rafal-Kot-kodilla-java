package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int numberUsers;
    int numberPosts;
    int numberComments;
    double averagePostsPerUser;
    double averageCommentsPerUser;
    double averageCommentsPerPost;

    void calculateAdvStatistics(Statistics statistics) {
        numberUsers = statistics.usersNames().size();
        numberPosts = statistics.postsCount();
        numberComments = statistics.commentsCount();

        averagePostsPerUser = numberPosts / numberUsers;
        averageCommentsPerUser = numberComments / numberUsers;
        averageCommentsPerPost = numberComments / numberPosts;
    }
    void showStatistics() {}


}
