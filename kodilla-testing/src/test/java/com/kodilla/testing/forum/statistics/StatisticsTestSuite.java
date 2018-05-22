package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private static int testCounter = 0;

    private List<String> generateListOfUsers(int numberUsers) {
        List<String> resultList = new ArrayList<>();
        for(int n = 1; n <= numberUsers; n++){
            String theName = "User " + n;
            resultList.add(theName);
        }
        return resultList;
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testCalculatedAdvStatistics() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        userNamesMock.add("Peter");
        userNamesMock.add("Mark");
        userNamesMock.add("Justice");
        userNamesMock.add("Nicolas");
        int  postsCountMock = 16;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(4.0, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(12.5,averageCommentsPerPost,0);
    }

    @Test
    public void testCalculatedAdvStatisticsOPosts() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        userNamesMock.add("Peter");
        userNamesMock.add("Mark");
        userNamesMock.add("Justice");
        userNamesMock.add("Nicolas");
        int  postsCountMock = 0;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(0.0, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(0.0,averageCommentsPerPost,0);
    }

    @Test
    public void testCalculatedAdvStatistics1000Posts() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        userNamesMock.add("Peter");
        userNamesMock.add("Mark");
        userNamesMock.add("Justice");
        userNamesMock.add("Nicolas");
        int  postsCountMock = 1000;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(250.0, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(0.2,averageCommentsPerPost,0);
    }

    @Test
    public void testCalculatedAdvStatisticsMorePostsThenComments() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        userNamesMock.add("Peter");
        userNamesMock.add("Mark");
        userNamesMock.add("Justice");
        userNamesMock.add("Nicolas");
        int  postsCountMock = 250;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(62.5, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(0.8,averageCommentsPerPost,0);
    }

    @Test
    public void testCalculatedAdvStatisticsLessPostsThenComments() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        userNamesMock.add("Peter");
        userNamesMock.add("Mark");
        userNamesMock.add("Justice");
        userNamesMock.add("Nicolas");
        int  postsCountMock = 160;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(40.0, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(1.25,averageCommentsPerPost,0);
    }
    @Test
    public void testCalculatedAdvStatisticsOUsers() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = new ArrayList<>();
        int  postsCountMock = 160;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(0.0, averagePostsPerUser,0);
        Assert.assertEquals(0.0,averageCommentsPerUser,0);
        Assert.assertEquals(1.25,averageCommentsPerPost,0);
    }

    @Test
    public void testCalculatedAdvStatistics100Users() {
        ForumStatistics forumStatistics = new ForumStatistics();
        Statistics statistics = mock(Statistics.class);
        List<String> userNamesMock = generateListOfUsers(100);
        int  postsCountMock = 160;
        int commentCountMock = 200;

        when(statistics.usersNames()).thenReturn(userNamesMock);
        when(statistics.commentsCount()).thenReturn(commentCountMock);
        when(statistics.postsCount()).thenReturn(postsCountMock);

        //when
        forumStatistics.calculateAdvStatistics(statistics);
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(1.6, averagePostsPerUser,0);
        Assert.assertEquals(2.0,averageCommentsPerUser,0);
        Assert.assertEquals(1.25,averageCommentsPerPost,0);
    }
}
