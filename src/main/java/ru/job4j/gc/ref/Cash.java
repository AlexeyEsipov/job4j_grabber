package ru.job4j.gc.ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Cash {
    private final Map<String, SoftReference<String>> map = new HashMap<>();

    public String getFile(String fileName) {
        String string;
        if (map.containsKey(fileName)) {
            System.out.println(" Файл раньше загружали, пробуем найти в кэше ");
            string = map.get(fileName).get();
            if (string == null) {
                System.out.println(" кэш пустой, загружаем файл  ");
                string = loadFile(fileName);
            } else {
                System.out.println(" найдено в кэше: ");
            }
        } else {
            System.out.println("Файл раньше не загружали, загрузим его и сохраним в кэше ");
            string = loadFile(fileName);
        }
        return string;
    }

    private String loadFile(String fileName) {
        String str = "";
        try (BufferedReader bufReader = Files.newBufferedReader(Paths.get(fileName),
                Charset.forName("cp1251"))) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = bufReader.read()) != -1) {
                text.append((char) read);
            }
            str = text.toString();
            SoftReference<String> softRefString = new SoftReference<>(str);
            map.put(fileName, softRefString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
