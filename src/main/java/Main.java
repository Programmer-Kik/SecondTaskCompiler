import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Automat> automats = new ArrayList<>();
        File root = new File("src/main/resources");

        List<File> jsons = Arrays.asList(root.listFiles());
        ObjectMapper mapper = new ObjectMapper();
        for (File json:jsons) {
            automats.add(mapper.readValue(json, Automat.class));
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String[] line = in.nextLine().split(" ");
        for (String word:line) {
            int priority = -1;
            String name = "";
            for (Automat automat:automats) {
                Pair<Boolean, Integer> pair = automat.max(word, 0);
                if (pair.getKey() && priority < automat.priority) {
                    priority = automat.priority;
                    name = automat.name;
                }
            }
            System.out.println("Это слово " + word + " является " + name);
        }
    }
}
