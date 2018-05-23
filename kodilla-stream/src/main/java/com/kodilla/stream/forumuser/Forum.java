package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1,"JanKowalski",'M',LocalDate.of(1980,5,5), 250));
        theUserList.add(new ForumUser(1,"PiotrNowak",'M',LocalDate.of(1985,3,2), 0));
        theUserList.add(new ForumUser(1,"JoannaMlak",'K',LocalDate.of(1990,11,3), 30));
        theUserList.add(new ForumUser(1,"RafalWojcik",'M',LocalDate.of(1999,5,23), 55));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
