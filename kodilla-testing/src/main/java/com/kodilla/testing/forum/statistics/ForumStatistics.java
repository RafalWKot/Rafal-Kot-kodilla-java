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

        averagePostsPerUser = (double)numberPosts / numberUsers;
        averageCommentsPerUser = (double)numberComments / numberUsers;
        averageCommentsPerPost = (double)numberComments / numberPosts;
    }


    void showStatistics() {
        System.out.println("averagePostsPerUser=" + averagePostsPerUser);
        System.out.println("averageCommentsPerUser=" + averageCommentsPerUser);
        System.out.println("averageCommentsPerPost=" + averageCommentsPerPost);
    }


}
