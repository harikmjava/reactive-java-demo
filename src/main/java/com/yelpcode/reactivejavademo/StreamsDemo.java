package com.yelpcode.reactivejavademo;

import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {


        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        //Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(i -> i < 5)
                .forEach(i -> System.out.println(i));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        //Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(i -> i > 5)
                .limit(3).skip(1).forEach(i -> System.out.println(i));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer i = StreamSources.intNumbersStream().filter(e -> e > 5).findFirst().orElse(-1);
        System.out.println(i);

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().collect(Collectors.toList()).forEach(user -> System.out.println(user));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(id -> user.getId() == id)).forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        StreamSources.intNumbersStream().
                map(id -> StreamSources.userStream().
                        filter(user -> user.getId() == id)).
                flatMap(userStream -> userStream).
                forEach(user -> System.out.println(user.getFirstName()));

    }


}
