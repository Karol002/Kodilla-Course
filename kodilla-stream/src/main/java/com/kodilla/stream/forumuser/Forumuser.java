package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class Forumuser {
    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBrith;
    private final int postQuantity;

    public Forumuser(final int userID, final String userName, final char sex,
                     final LocalDate dateOfBrith, final int postQuantity) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBrith = dateOfBrith;
        this.postQuantity = postQuantity;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBrith() {
        return dateOfBrith;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "Forumuser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBrith=" + dateOfBrith +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
