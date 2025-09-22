// Aldrin Meller T. Basalo
// ProgLan

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpletronFileReader {
    public static void main(String[] args) {

        String[] memory = new String[100];

        for (int i = 0; i < 100; i++) {
            memory[i] = "+0000";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("test.sml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                String[] parts = line.split("\\s+"); 

                if (parts.length >= 2) {
                    int address = Integer.parseInt(parts[0]);
                    String value = parts[1];

                    if (!value.startsWith("+") && !value.startsWith("-")) 
                        value = "+" + value;
                   
                    if (address >= 0 && address < 100) 
                        memory[address] = value;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("MEMORY:");
        
        for (int i = 0; i < 10; i++) {
            System.out.print("\t\t" + i);
        }
        System.out.println();

        for (int row = 0; row < 10; row++) {
            System.out.printf("%02d\t", row * 10);
            
            for (int col = 0; col < 10; col++) {
                int index = row * 10 + col;
                System.out.print(memory[index] + "\t");
            }
            System.out.println();
        }
    }
}
