package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    final List<Forumuser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new Forumuser(001, "Kristine",'F',
                LocalDate.of(2002, 3, 4), 2));
        userList.add(new Forumuser(002, "Joana",'F',
                LocalDate.of(2004, 7, 15), 5));
        userList.add(new Forumuser(003, "Michel",'M',
                LocalDate.of(1998, 5, 13), 0));
        userList.add(new Forumuser(004, "Klaus",'M',
                LocalDate.of(1990, 1, 2), 7));
        userList.add(new Forumuser(005, "Darius",'M',
                LocalDate.of(2002, 3, 1), 10));
    }

    public List<Forumuser> getList() {
        return new ArrayList<>(userList);
    }
}
