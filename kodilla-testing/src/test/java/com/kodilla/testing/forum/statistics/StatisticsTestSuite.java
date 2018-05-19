package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private static int testCounter = 0;

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

        forumStatistics.calculateAdvStatistics(statistics);

        //when
        double averagePostsPerUser = forumStatistics.averagePostsPerUser;
        double averageCommentsPerUser = forumStatistics.averageCommentsPerUser;
        double averageCommentsPerPost = forumStatistics.averageCommentsPerPost;

        //then
        Assert.assertEquals(4.0, averagePostsPerUser,0);
        Assert.assertEquals(50.0,averageCommentsPerUser,0);
        Assert.assertEquals(12.5,averageCommentsPerPost,0);
    }
}
