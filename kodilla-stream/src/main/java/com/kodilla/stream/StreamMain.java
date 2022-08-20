package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.Forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args){
        Forum forum = new Forum();

        Map<Integer, Forumuser> theResulMapOfUsers = forum.getList().stream()
                .filter(user -> user.getPostQuantity() > 0)
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getDateOfBrith().getYear() < 2002)
                .collect(Collectors.toMap(Forumuser::getUserID, user -> user));

        System.out.println("Elements: " + theResulMapOfUsers.size());
        theResulMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
