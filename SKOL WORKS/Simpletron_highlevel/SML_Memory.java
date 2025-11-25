public class SML_Memory {
    private String[] mem;
    private int size = 100;

    public SML_Memory(int size) {
        this.size = size;
        mem = new String[size];
    }

    public void additem(int address, String data) {
        int num = Integer.parseInt(data);
        this.mem[address] = String.format("%04d", num);
    }

    public String getitem(int address) {
        return this.mem[address];
    }

    public int getNextAvailableAddress() {
        for (int i = 0; i < size; i++) {
            if (this.mem[i] == null)
                return i;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public String[] memDumpArray() {
        return mem;
    }

    public void dump() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.print("    ");
        for (int col = 0; col < 10; col++) {
            System.out.printf("  %-8d", col);
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            if (i % 10 == 0) {
                if (i != 0) System.out.println();
                System.out.printf("%02d  ", i);
            }
            System.out.printf("%-10s", mem[i] != null ? "+" + mem[i] : "+0000");
        }
        System.out.println();
    }
}
