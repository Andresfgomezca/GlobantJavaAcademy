package Observer.AcceleratorExample;

public class Motor implements Observer{
    @Override
    public void update() {
        System.out.println("subir potencia, velocidad, revoluciones etc");
        //accion a realizar despues de ser notificado de un cambio
    }

    public Motor() {
    }
}
