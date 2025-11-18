import java.util.Scanner;

public class Simpletron_Processor {
    private SML_Memory memory;
    private int accumulator = 0;
    private int pc = 0;
    private boolean running = true;
    private Scanner scanner = new Scanner(System.in);

    public Simpletron_Processor(SML_Memory memory) {
        this.memory = memory;
    }

    public void run() {
        running = true;
        while (running) {
            String instruction = memory.getitem(pc);
            if (instruction == null)
                instruction = "0000";

            String opcode = instruction.substring(0, 2);
            String operand = instruction.substring(2);
            decode(opcode, operand);
            pc++;
        }
        System.out.println("\nProgram halted.");
    }

    public void decode(String opcode, String operand) {
        int address = Integer.parseInt(operand);
        switch (opcode) {
            case "10": // READ
                System.out.print("Enter value: ");
                String input = scanner.nextLine();
                memory.additem(address, input);
                break;
            case "11": // WRITE
                System.out.println("Result: " + memory.getitem(address));
                break;
            case "20": // LOAD from memory
                accumulator = Integer.parseInt(memory.getitem(address));
                break;
            case "21": // STORE
                memory.additem(address, String.valueOf(accumulator));
                break;
            case "22": // LOAD immediate
                accumulator = address;
                break;
            case "30": // ADD from memory
                accumulator += Integer.parseInt(memory.getitem(address));
                break;
            case "31": // SUB from memory
                accumulator -= Integer.parseInt(memory.getitem(address));
                break;
            case "32": // DIV from memory
                int divisor = Integer.parseInt(memory.getitem(address));
                if (divisor == 0)
                    throw new ArithmeticException("Division by zero");
                accumulator /= divisor;
                break;
            case "33": // MOD from memory
                accumulator %= Integer.parseInt(memory.getitem(address));
                break;
            case "34": // MUL from memory
                accumulator *= Integer.parseInt(memory.getitem(address));
                break;
            case "35": // ADD immediate
                accumulator += address;
                break;
            case "36": // SUB immediate
                accumulator -= address;
                break;
            case "37": // DIV immediate
                if (address == 0)
                    throw new ArithmeticException("Division by zero");
                accumulator /= address;
                break;
            case "38": // MOD immediate
                accumulator %= address;
                break;
            case "39": // MUL immediate
                accumulator *= address;
                break;
            case "40": // JMP
                pc = address - 1;
                break;
            case "41": // JN
                if (accumulator < 0)
                    pc = address - 1;
                break;
            case "42": // JZ
                if (accumulator == 0)
                    pc = address - 1;
                break;
            case "43": // HALT
                running = false;
                break;
            default:
                System.out.println("Unknown operation: " + opcode);
                running = false;
                break;
        }
    }
}
