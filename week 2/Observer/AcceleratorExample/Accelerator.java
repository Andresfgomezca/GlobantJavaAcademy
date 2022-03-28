package Observer.AcceleratorExample;

import java.util.ArrayList;

public class Accelerator implements Subject{
    //esto es el minimo requerido
    private ArrayList<Observer> observers;
    //constructor del objecto para no tener error


    public Accelerator() {
        observers = new ArrayList<>();
    }
    public void pisarAcelerador(){
        //se pisa el acelerador y notifica
        notificar();
    }

    public void enlazarObservador(Observer o){
    observers.add(o);
    }

    @Override
    public void notificar() {
        for(Observer o: observers)
        {
            o.update(); // de esta manera los observadores que se registren ejecutaran su metodo update
        }
    }
}
