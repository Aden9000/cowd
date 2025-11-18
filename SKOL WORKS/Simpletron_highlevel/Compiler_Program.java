import java.io.*;
import java.util.*;

public class Compiler_Program {
    private SML_Memory memory;
    private Simpletron_Processor cpu;
    private Map<String, Integer> labels = new HashMap<>();
    private Map<String, Integer> variables = new HashMap<>();
    private List<String> instructions = new ArrayList<>();

    public Compiler_Program(SML_Memory memory, Simpletron_Processor cpu) {
        this.memory = memory;
        this.cpu = cpu;
    }

    public void compile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int address = 0;

        // --- First Pass: store labels and variables ---
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty())
                continue;

            if (line.endsWith(":")) {
                // Label definition (do NOT increment address here)
                String label = line.substring(0, line.length() - 1);
                labels.put(label, address);
                continue;
            }

            if (!isInstruction(line)) {
                // Variable declaration (assign a fixed memory slot)
                if (!variables.containsKey(line)) {
                    variables.put(line, variables.size()); // start vars at 0
                }
            } else {
                // Actual instruction line
                instructions.add(line);
                address++;
            }
        }
        br.close();

        // --- Initialize variables in memory with +0000 ---
        for (Map.Entry<String, Integer> var : variables.entrySet()) {
            int addr = var.getValue();
            memory.additem(addr, "0"); // default 0
        }

        // --- Second Pass: translate instructions ---
        address = 0;
        for (String instr : instructions) {
            String[] parts = instr.split("\\s+");
            String op = parts[0].toLowerCase();
            String operand = (parts.length > 1) ? parts[1] : "";

            int code = 0;
            int addr = getAddress(operand);

            switch (op) {
                case "read":
                    code = 10_00 + addr;
                    break;
                case "write":
                    code = 11_00 + addr;
                    break;
                case "loadm":
                    code = 20_00 + addr;
                    break;
                case "store":
                    code = 21_00 + addr;
                    break;
                case "loadi":
                    code = 22_00 + addr;
                    break;
                case "addm":
                    code = 30_00 + addr;
                    break;
                case "subm":
                    code = 31_00 + addr;
                    break;
                case "divm":
                    code = 32_00 + addr;
                    break;
                case "modm":
                    code = 33_00 + addr;
                    break;
                case "mulm":
                    code = 34_00 + addr;
                    break;
                case "addi":
                    code = 35_00 + addr;
                    break;
                case "subi":
                    code = 36_00 + addr;
                    break;
                case "divi":
                    code = 37_00 + addr;
                    break;
                case "modi":
                    code = 38_00 + addr;
                    break;
                case "muli":
                    code = 39_00 + addr;
                    break;
                case "jmp":
                    code = 40_00 + addr;
                    break;
                case "jn":
                    code = 41_00 + addr;
                    break;
                case "jz":
                    code = 42_00 + addr;
                    break;
                case "halt":
                    code = 43_00;
                    break;
                default:
                    System.out.println("Unknown instruction: " + op);
                    break;
            }

            memory.additem(address, String.valueOf(code));
            address++;
        }
    }

    private boolean isInstruction(String line) {
        return line.matches(
                "(?i)^(read|write|loadm|store|loadi|addm|subm|divm|modm|mulm|addi|subi|divi|modi|muli|jmp|jn|jz|halt).*");
    }

    private int getAddress(String operand) {
        if (operand.isEmpty())
            return 0;
        if (variables.containsKey(operand))
            return variables.get(operand);
        if (labels.containsKey(operand))
            return labels.get(operand);
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void printCodeListing(String[] memory) {
        System.out.println();
        System.out.println("Code Address\tOpcode");
        System.out.println("------------\t-------");

        for (int i = 0; i < memory.length; i++) {
            if (memory[i] != null && !memory[i].equals("+0000")) {
                System.out.printf("%02d\t\t%s%n", i, memory[i]);
            }
        }
        System.out.println();
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        try {
            SML_Memory memory = new SML_Memory(100);
            Simpletron_Processor cpu = new Simpletron_Processor(memory);
            Compiler_Program compiler = new Compiler_Program(memory, cpu);
            compiler.compile("test.sml");

            System.out.println("\n-----Memory Before Execution:");
            printCodeListing(memory.memDumpArray());
            memory.dump();
            System.out.println("\n");

            System.out.println("-----Execution:");
            cpu.run();

            System.out.println("\n-----Memory After Execution:");
            printCodeListing(memory.memDumpArray());
            System.out.println("\nMemory Dump:");
            memory.dump();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
