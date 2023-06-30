public class Cuadrado extends Figura {
    Punto p1, p2;
    String tipo;
    public Cuadrado(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        tipo = "Cuadrado";
    }

    @Override
    public double calcularArea() {
        // Cálculo del área del cuadrado (en realidad es un paralelogramo si los puntos no forman un ángulo recto)
        double lado1 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));

        return lado1 * lado1;
    }

    @Override
    public double calcularPerimetro() {
        // Cálculo del perímetro del cuadrado (en realidad es un paralelogramo si los puntos no forman un ángulo recto)
        double lado1 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));

        return 4 * lado1;
    }

    @Override
    double calcularVolumen() {
        return 0;
    }

    @Override
    public String getTipo(){
        return tipo;
    }
}
