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

        if (numberUsers != 0) {
            averagePostsPerUser = (double) numberPosts / numberUsers;
            averageCommentsPerUser = (double)numberComments / numberUsers;
        }
        else {
            averagePostsPerUser = 0;
            averageCommentsPerUser = 0;
        }
        if (numberPosts != 0) {
            averageCommentsPerPost = (double)numberComments / numberPosts;
        }
        else {
            averageCommentsPerPost = 0;
        }
    }


    void showStatistics() {
        System.out.println("averagePostsPerUser=" + averagePostsPerUser);
        System.out.println("averageCommentsPerUser=" + averageCommentsPerUser);
        System.out.println("averageCommentsPerPost=" + averageCommentsPerPost);
    }


}
