package Printers;

public class Printer {
    int numberOfPrinterOptions; //this parameter will allow us to verify the options that the printer has to print
    String name;
    String fileToPrint;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileToPrint() {
        return fileToPrint;
    }

    public void setFileToPrint(String fileToPrint) {
        this.fileToPrint = fileToPrint;
    }

    public int getNumberOfPrinterOptions() {
        return numberOfPrinterOptions;
    }

    public void setNumberOfPrinterOptions(int numberOfPrinterOptions) {
        this.numberOfPrinterOptions = numberOfPrinterOptions;
    }
}
