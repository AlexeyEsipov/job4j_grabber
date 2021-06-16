// Код закомментирован, так как класс GeneratorString не реализован по условию задачи
//2.5.0. TDD 3. Шаблонизатор. [#855 #57575]
//package ru.job4j.template;
//
//import org.junit.Test;
//
//
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//public class GeneratorStringTest {
//
//    @Test
//    public void produceIfAllOk() {
//        Generator generator = new GeneratorString();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> args = Map.of("name", "Petr", "subject", "you");
//        String expected = "I am a Petr, Who are you? ";
//        assertEquals(expected, generator.produce(template, args));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenNotEnoughKey() {
//        Generator generator = new GeneratorString();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> args = Map.of("name", "Petr");
//        generator.produce(template, args);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenManyKey() {
//        Generator generator = new GeneratorString();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> args = Map.of("name", "Petr", "state", "married",
//                                          "subject", "you");
//        generator.produce(template, args);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void whenExcessKey() {
//        Generator generator = new GeneratorString();
//        String template = "I am a ${name}, Who are ${subject}? ";
//        Map<String, String> args = Map.of("job", "teacher", "state", "married");
//        generator.produce(template, args);
//    }
//}