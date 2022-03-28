import Printers.EpsonEcoTankL3110;
import Printers.HpLaserJetProP1102;
import Printers.Printer;
import Printers.PrinterBuilder;

import java.util.ArrayList;

public class PrinterDirector {
    protected PrinterBuilder printerBuilder;
    public ArrayList<PrinterBuilder> printers=new ArrayList<>();//Array list to record the available printers
    public void setPrinterBuilder(PrinterBuilder printerBuilder) {
        this.printerBuilder = printerBuilder;
    }

    public void PrintersCreation() {
        //creation of the printer 1
        PrinterBuilder printer1 = new EpsonEcoTankL3110(); //initialization of the product
        setPrinterBuilder(printer1);
        printer1.NewPrinter();
        printers.add(printer1);
        //creation of the printer 2
        PrinterBuilder printer2 = new HpLaserJetProP1102(); //initialization of the product
        setPrinterBuilder(printer2);
        printer2.NewPrinter();
        printers.add(printer2);
    }

    public void PrintPrintersInformation(){
        System.out.println("Printers Available");
        for(int i=0;i<printers.size();i++){ //limited due the number of printers for this exercise
            System.out.println("------------------------------------------------");
            System.out.println("Printer #"+(i+1));
            System.out.println("Name: "+(printers.get(i)).getPrinter().getName());
            System.out.println("Options to print: "+(printers.get(i)).getPrinter().getNumberOfPrinterOptions());
        }
    }
}
