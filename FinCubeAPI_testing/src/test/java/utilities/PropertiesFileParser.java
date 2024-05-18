package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertiesFileParser {

    private static final ReentrantLock lock = new ReentrantLock();
    // Оба метода используют блокировку ReentrantLock (lock)
    // для обеспечения потокобезопасности при доступе к файлу. Блокировка гарантирует, что только один поток может выполнять
    // чтение или запись файла в определенный момент времени, предотвращая тем самым возможные конфликты при доступе к общему ресурсу.

    public static String getProperty(String fileName, String key) {
        lock.lock();
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
            Properties properties = new Properties();

            if (Files.notExists(Paths.get(filePath))) {
                System.out.println("Файл не существует: " + filePath);
                return null;
            }

            // Загружаем существующие свойства из файла
            try (FileInputStream fis = new FileInputStream(filePath)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            // Получаем значение по ключу
            return properties.getProperty(key);
        } finally {
            lock.unlock();
        }

    }

    public static void setProperty(String fileName, String key, String value) {
        lock.lock();
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
            Properties properties = new Properties();

            if (Files.notExists(Paths.get(filePath))) {
                System.out.println("Файл не существует: " + filePath);
                return;
            }

            // Загружаем существующие свойства из файла
            try (FileInputStream fis = new FileInputStream(filePath)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Устанавливаем новое значение для ключа
            properties.setProperty(key, value);

            // Сохраняем свойства обратно в файл
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                properties.store(fos, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }


    }







/*    public static ResourceBundle getProperty(String resource) {
        readWriteLock.readLock().lock();
        try {
            ResourceBundle routes = ResourceBundle.getBundle(resource);
            return routes;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void setProperty(String fileName, String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

            Properties properties = new Properties();

            if (Files.notExists(Paths.get(filePath))) {
                System.out.println("Файл не существует: " + filePath);
                return;
            }

            // Загружаем существующие свойства из файла
            try (FileInputStream fis = new FileInputStream(filePath)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Устанавливаем новое значение для ключа
            properties.setProperty(key, value);

            // Сохраняем свойства обратно в файл
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                properties.store(fos, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }*/

}
