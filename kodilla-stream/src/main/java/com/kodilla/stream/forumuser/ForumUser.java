package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int idUser;
    private final String username;
    private final char sex;
    private final LocalDate birthOfDate;
    private int postsCount;

    public ForumUser(int idUser, String username, char sex, LocalDate birthOfDate, int postsCount) {
        this.idUser = idUser;
        this.username = username;
        this.sex = sex;
        this.birthOfDate = birthOfDate;
        this.postsCount = postsCount;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthOfDate=" + birthOfDate +
                ", postsCount=" + postsCount +
                '}';
    }
}
