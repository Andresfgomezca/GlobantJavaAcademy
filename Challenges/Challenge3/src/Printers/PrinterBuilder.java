package Printers;

public abstract class PrinterBuilder {
    //This interface will allow us the creation of the printers that the office will have in the future and the current
    //printers using the builder design pattern
    protected Printer printer;
    protected String name;
    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public abstract void NewPrinter();

    public abstract void printerSelected();
    public void printOption(int optionSelectedByUser){
        String printOption="";
        if(optionSelectedByUser>printer.getNumberOfPrinterOptions()){
            printOption="The printer can not print with this option";
        }
        if (optionSelectedByUser<= printer.getNumberOfPrinterOptions())
        {
            if (optionSelectedByUser==1){
                printOption="Printing in B&W the file "+printer.getFileToPrint();
            }
            else{
                printOption="Printing in Color the file "+ printer.getFileToPrint();
            }
        }
        System.out.println(printOption);
    }
}
