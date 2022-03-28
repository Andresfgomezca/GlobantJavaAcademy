import Printers.PrinterBuilder;

public class OfficeUser {
    //This user will be the person that uses the printer
    private PrinterBuilder printerUsed;
    private String userName;
    private int OptionForPrinter;//this parameter will be the option selected by the user and implemented in the printer
    private String file=null;//this will be the file that the user wants to print
    public void setPrinter(PrinterBuilder printer) { //injection using setter method
        this.printerUsed = printer;
    }

    public OfficeUser(String userName) {
        this.userName = userName;
    }

    public void service(){
        printerUsed.NewPrinter();
        printerUsed.getPrinter().setFileToPrint(file);
        printerUsed.printerSelected();
        printerUsed.printOption(OptionForPrinter);
    }

    public void setOptionForPrinter(int optionForPrinter) {
        OptionForPrinter = optionForPrinter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
