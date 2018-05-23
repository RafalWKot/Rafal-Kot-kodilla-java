package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForumUser = new Forum();
        Map<Integer, ForumUser> theResultUserList = theForumUser.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthOfDate().isBefore(LocalDate.of(1998,5,22)))
                .filter(user -> user.getPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getIdUser, user ->user));

        theResultUserList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
