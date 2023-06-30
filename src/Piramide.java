public class Piramide extends Triangulo {
    double altura;
    public Piramide(Punto p1, Punto p2, Punto p3, double altura) {
        super(p1, p2, p3);
        this.altura = altura;
        this.tipo = "Piramide";
    }
    @Override
    public double calcularVolumen() {
        // Cálculo del volumen de la pirámide
        System.out.println("El area de la base es: " + super.calcularArea());
        return (super.calcularArea() * altura) / 3;
    }
    @Override
    public String getTipo(){
        return tipo;
    }
}
