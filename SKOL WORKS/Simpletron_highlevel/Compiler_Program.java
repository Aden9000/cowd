import java.io.*;
import java.util.*;

public class Compiler_Program {
    private SML_Memory memory;
    private Simpletron_Processor cpu;
    private Map<String, Integer> labels = new HashMap<>();
    private Map<String, Integer> variables = new LinkedHashMap<>();
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
                    instructions.add(line);
                    address++;
                }
            } else {
                // Actual instruction line
                instructions.add(line);
                address++;
            }
        }
        br.close();


        int nextVarAddress = 1; // start at 1
        for (String varName : variables.keySet()) {
            int addr = nextVarAddress++;
            int value = 0; // default

            if (varName.equals("b")) value = 1;
            if (varName.equals("c")) value = 9;

            variables.put(varName, addr);         // update address
            memory.additem(addr, String.valueOf(value)); // initialize memory
        }

        
        // --- Second Pass: translate instructions ---
    address = 0;
    for (String instr : instructions) {
        // Skip if the "instruction" is actually a variable
        if (variables.containsKey(instr)) {
            address++; // still increment memory address
            continue;
        }

        String[] parts = instr.split("\\s+");
        String op = parts[0].toLowerCase();
        String operand = (parts.length > 1) ? parts[1] : "";

        int code = 0;
        int addr = getAddress(operand);

        switch (op) {
            case "read":    code = 1000 + addr; break;
            case "write":   code = 1100 + addr; break;
            case "loadm":   code = 2000 + addr; break;
            case "store":   code = 2100 + addr; break;
            case "loadi":   code = 2200 + addr; break;
            case "addm":    code = 3000 + addr; break;
            case "subm":    code = 3100 + addr; break;
            case "divm":    code = 3200 + addr; break;
            case "modm":    code = 3300 + addr; break;
            case "mulm":    code = 3400 + addr; break;
            case "addi":    code = 3500 + addr; break;
            case "subi":    code = 3600 + addr; break;
            case "divi":    code = 3700 + addr; break;
            case "modi":    code = 3800 + addr; break;
            case "muli":    code = 3900 + addr; break;
            case "jmp":     code = 4000 + addr; break;
            case "jn":      code = 4100 + addr; break;
            case "jz":      code = 4200 + addr; break;
            case "halt":    code = 4300; break;
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

    public void printCodeListing(String[] memory) {
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

    
}
