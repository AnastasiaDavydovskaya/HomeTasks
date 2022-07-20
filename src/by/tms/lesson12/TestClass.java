package by.tms.lesson12;

import by.tms.lesson12.util.FileUtils;

import java.nio.file.Paths;

public class TestClass {

    public static void main(String[] args) {
        FileUtils.writeCountOfLettersInFile(Paths.get("resources", "Alexander Pushkin.txt").toFile());
        FileUtils.createNewFileWithSortNumbers();
    }
}
