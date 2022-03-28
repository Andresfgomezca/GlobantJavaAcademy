package Printers;

public class HpLaserJetProP1102 extends PrinterBuilder{
    public HpLaserJetProP1102() {
        printer = new Printer();
        printer.setName("Hp LaserJet Pro P1102");
        printer.setNumberOfPrinterOptions(2);//In this example this printer will have 2 options to print B&W and Color
    }

    @Override
    public void NewPrinter() {
        printer.setName("Hp LaserJet Pro P1102");
        printer.setNumberOfPrinterOptions(2);
    }

    @Override
    public void printerSelected() {
        System.out.println(printer.getName());
    }
}
