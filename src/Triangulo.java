public class Triangulo extends Figura{
    private Punto p1, p2, p3;
    String tipo;
    public Triangulo(Punto p1, Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        tipo = "Triángulo";
    }

    @Override
    public double calcularArea() {
        // Cálculo del área del triángulo
        return 0.5 * Math.abs((p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY()) + p3.getX() * (p1.getY() - p2.getY())));
    }

    @Override
    public double calcularPerimetro() {
        // Cálculo del perímetro del triángulo
        double lado1 = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        double lado3 = Math.sqrt(Math.pow(p3.getX() - p1.getX(), 2) + Math.pow(p3.getY() - p1.getY(), 2));
        double lado2 = Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));

        return lado1 + lado2 + lado3;
    }

    @Override
    double calcularVolumen() {
        return 0;
    }

    @Override
    public String getTipo(){
        return tipo;
    }

    //Getters y Setters

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public Punto getP3() {
        return p3;
    }

    public void setP3(Punto p3) {
        this.p3 = p3;
    }
}
