public class Main {
    public static void main(String[] args) {
        try {
            SML_Memory memory = new SML_Memory(100);
            Simpletron_Processor cpu = new Simpletron_Processor(memory);
            Compiler_Program compiler = new Compiler_Program(memory, cpu);

            compiler.compile("sample.sml");

            System.out.println("\n-----Memory Before Execution:-----");
            compiler.printCodeListing(memory.memDumpArray());
            System.out.println("\nMemory Dump Before Execution:");
            memory.dump();

            System.out.println("\n------------------Execution:--------------------");
            cpu.run();
            System.out.println("\n------------------------------------------------");

            System.out.println("\n-----Memory After Execution:-----");
            compiler.printCodeListing(memory.memDumpArray());
            System.out.println("\nMemory Dump After Execution:");
            memory.dump();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
