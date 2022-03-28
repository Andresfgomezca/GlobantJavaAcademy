package Printers;

public class EpsonEcoTankL3110 extends PrinterBuilder{
    public EpsonEcoTankL3110() {
        printer = new Printer();
        printer.setName("Epson EcoTank L3110");
        printer.setNumberOfPrinterOptions(1);//In this example this printer will only have the option to print B&W
    }

    @Override
    public void NewPrinter() {
        printer.setNumberOfPrinterOptions(1);
        printer.setName("Epson EcoTank L3110");
    }

    @Override
    public void printerSelected() {
        System.out.println(printer.getName());
    }



}
