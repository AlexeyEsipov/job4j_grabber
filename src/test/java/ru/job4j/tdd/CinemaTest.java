// Код закомментирован, так как классы не реализованы по условию задачи
//2.5.0. TDD 2. Что такое TDD? [#4918 #57577]
//
//package ru.job4j.tdd;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//import org.junit.Test;
//
//import java.util.*;
//
//public class CinemaTest {
//
//    @Test
//    public void buy() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        date.set(2021, Calendar.OCTOBER, 10, 23, 0);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        assertThat(ticket, is(new Ticket3D()));
//    }
//
//    @Test
//    public void find() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        assertThat(sessions, is(Collections.singletonList(new Session3D())));
//    }
//
//    @Test
//    public void add() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        assertThat(sessions, is(Collections.singletonList(new Session3D())));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void buyDuplicate() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        Calendar date = Calendar.getInstance();
//        date.set(2021, Calendar.OCTOBER, 10, 23, 0);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        Ticket ticketDuplicate = cinema.buy(account, 1, 1, date);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void buyIncorrectOldDate() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        Calendar date = Calendar.getInstance();
//        date.set(2010, Calendar.OCTOBER, 10, 23, 0);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void buyIncorrectRowSeat() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        Calendar date = Calendar.getInstance();
//        date.set(2020, Calendar.OCTOBER, 10, 23, 0);
//        Ticket ticket = cinema.buy(account, -1, 1, date);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void buyIncorrectColumnSeat() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        Calendar date = Calendar.getInstance();
//        date.set(2020, Calendar.OCTOBER, 10, 23, 0);
//        Ticket ticket = cinema.buy(account, 1, -1, date);
//    }
//}