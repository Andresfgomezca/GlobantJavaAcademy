package Observer.AcceleratorExample;

public class Main{
    public static void main(String[] args)    {
        /*
        tenemos objeto A=aceleraador
        cuando se acelera (metodo) el objeto motor se mueve
        el acelerador manda un evento al motor para moverse

        motor observa acelerador
        sujeto es acelerador



         */

        Motor v8 = new Motor();
        Accelerator x = new Accelerator();

        x.enlazarObservador(v8);
    }
}
