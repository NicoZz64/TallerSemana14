public class Cubo extends Cuadrado {
    double altura;
    public Cubo(Punto p1, Punto p2) {
        super(p1, p2);
        this.altura = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        this.tipo = "Cubo";
    }
    @Override
    public double calcularVolumen() {
        // Cálculo del volumen del cubo (en realidad es un paralelepípedo si los puntos no forman un ángulo recto)
        return super.calcularArea() * altura;
    }
    @Override
    public String getTipo(){
        return tipo;
    }
}