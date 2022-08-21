package by.tms.json.jsonrunner;


import by.tms.json.entities.*;
import by.tms.json.entities.characteristicsofcomputer.Size;
import by.tms.json.entities.characteristicsofcomputer.Type;
import by.tms.json.entities.inheritorsofcomponents.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class JsonRunner {

    public static void main(String[] args) {
        Type type = new Type(true, 2300, true);
        Size size = new Size(363, 22.9, 2200);
        Ram ram = new Ram(23, "Оперативная память", "Иран", 23456, true, 234);
        Monitor monitor = new Monitor(1, "Монитор", "Минск", 345, true, 14);
        Keyboard keyboard = new Keyboard(2, "Клавиатура", "Минск", 356, true, "Синий");
        HDD hdd = new HDD(2, "Жесткий диск", "Иран", 8457, true, 3500);
        Motherboard motherboard = new Motherboard(4, "Материнская плата", "Латвия", 765, true, "AM4");
        Battery battery = new Battery(6, "Аккумулятор", "Азия", 543, true, 6.5);
        CPU cpu = new CPU(7, "Процессор", "Гродно", 3215, true, "i5");
        Touchpad touchpad = new Touchpad(7, "Тачпад", "Минск", 213, false, 2);
        Computer computer = new Computer(Arrays.asList(ram, monitor, keyboard, hdd, motherboard, battery, cpu, touchpad), type, size);

        ObjectMapper objectMapper = new ObjectMapper();
        File file = Path.of("resources", "lesson-json", "zoo.json").toFile();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, computer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Computer computerFromJson = objectMapper.readValue(file, Computer.class);
            System.out.println(computerFromJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
