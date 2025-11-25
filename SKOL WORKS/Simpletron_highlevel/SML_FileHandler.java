import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SML_FileHandler {

    public List<String> readFile(String path) throws IOException {
        Path p = Paths.get(path);
        if (!Files.exists(p)) throw new FileNotFoundException("File not found: " + path);

        List<String> raw = Files.readAllLines(p);
        List<String> cleaned = new ArrayList<>();

        for (String line : raw) {
            if (line == null) continue;
            String trimmed = line.trim();
            if (trimmed.isEmpty()) continue;

            int commentIndex = trimmed.indexOf("//");
            if (commentIndex != -1) {
                trimmed = trimmed.substring(0, commentIndex).trim();
                if (trimmed.isEmpty()) continue;
            }
            cleaned.add(trimmed);
        }
        return cleaned;
    }
}
