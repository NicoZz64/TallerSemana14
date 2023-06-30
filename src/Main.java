import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Figura> listaFiguras = new ArrayList<>();

        int opc;
        do {
            System.out.println("Seleccione una figura geométrica:");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Pirámide");
            System.out.println("5. Cubo");
            System.out.println("6. Esfera");
            System.out.println("7. Listar Figuras");
            System.out.println("0. Salir");

            opc = scanner.nextInt();

            if (opc >= 1 && opc <= 7) {
                Figura figura;

                switch (opc) {
                    case 1:
                        figura = crearTriangulo(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 2:
                        figura = crearCuadrado(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 3:
                        figura = crearCirculo(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 4:
                        figura = crearPiramide(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 5:
                        figura = crearCubo(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 6:
                        figura = crearEsfera(scanner);
                        listaFiguras.add(figura);
                        break;
                    case 7:
                        System.out.println("==============================================================================================");
                        System.out.println("Usted ha ingresado las siguientes figuras: ");
                        for (int i = 0; i<listaFiguras.size(); i++){
                            System.out.print("\n" + (i+1) + ".- " + listaFiguras.get(i).getTipo() + " Perímetro: " + listaFiguras.get(i).calcularPerimetro() + " Área: " + listaFiguras.get(i).calcularArea());
                            if (listaFiguras.get(i).getTipo() == "Piramide" || listaFiguras.get(i).getTipo() == "Cubo" || listaFiguras.get(i).getTipo() == "Esfera"){
                                System.out.print(" Volúmen: " + listaFiguras.get(i).calcularVolumen() + "\n");
                            }
                        }
                        System.out.println("\nFin.");
                        System.out.println("==============================================================================================");
                        figura = null;
                        break;
                    default:
                        figura = null;
                        break;
                }
                if (figura != null) {
                    int opcionCalculo;
                    do {
                        System.out.println("Seleccione qué desea calcular:");
                        System.out.println("1. Perímetro");
                        System.out.println("2. Área");
                        if (figura instanceof Piramide || figura instanceof Cubo || figura instanceof Esfera) {
                            System.out.println("3. Volumen");
                        }
                        System.out.println("0. Volver al menú principal");

                        opcionCalculo = scanner.nextInt();

                        switch (opcionCalculo) {
                            case 1:
                                System.out.println("El perímetro es: " + figura.calcularPerimetro());
                                break;
                            case 2:
                                System.out.println("El área es: " + figura.calcularArea());
                                break;
                            case 3:
                                if (figura instanceof Piramide) {
                                    Piramide piramide = (Piramide) figura;
                                    System.out.println("El volumen de la pirámide es: " + piramide.calcularVolumen());
                                } else if (figura instanceof Cubo) {
                                    Cubo cubo = (Cubo) figura;
                                    System.out.println("El volumen del cubo es: " + cubo.calcularVolumen());
                                } else if (figura instanceof Esfera) {
                                    Esfera esfera = (Esfera) figura;
                                    System.out.println("El volumen de la esfera es: " + esfera.calcularVolumen());
                                }
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }

                    } while (opcionCalculo != 0);
                }
            } else if (opc != 0) {
                System.out.println("Opción inválida.");
            }

        } while (opc != 0);

        scanner.close();
    }
    private static Triangulo crearTriangulo(Scanner scanner) {
        System.out.println("Ingrese las coordenadas del punto 1 (x y):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Punto p1 = new Punto(x1, y1);

        System.out.println("Ingrese las coordenadas del punto 2 (x y):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Punto p2 = new Punto(x2, y2);

        System.out.println("Ingrese las coordenadas del punto 3 (x y):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        Punto p3 = new Punto(x3, y3);

        return new Triangulo(p1, p2, p3);
    }

    private static Cuadrado crearCuadrado(Scanner scanner) {
        System.out.println("Ingrese las coordenadas del punto 1 (x y):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Punto p1 = new Punto(x1, y1);

        System.out.println("Ingrese las coordenadas del punto 2 (x y):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Punto p2 = new Punto(x2, y2);

        return new Cuadrado(p1, p2);
    }

    private static Circulo crearCirculo(Scanner scanner) {
        System.out.println("Ingrese las coordenadas del centro del círculo (x y):");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        Punto centro = new Punto(x, y);

        System.out.println("Ingrese el radio del círculo:");
        double radio = scanner.nextDouble();

        return new Circulo(centro, radio);
    }

    private static Piramide crearPiramide(Scanner scanner) {
        Triangulo base = crearTriangulo(scanner);

        System.out.println("Ingrese la altura de la pirámide:");
        double altura = scanner.nextDouble();

        return new Piramide(base.getP1(), base.getP2(), base.getP3(), altura);
    }

    private static Cubo crearCubo(Scanner scanner) {
        System.out.println("Ingrese las coordenadas del punto 1 (x y):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        Punto p1 = new Punto(x1, y1);

        System.out.println("Ingrese las coordenadas del punto 2 (x y):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Punto p2 = new Punto(x2, y2);

        return new Cubo(p1, p2);
    }

    private static Esfera crearEsfera(Scanner scanner) {
        Circulo base = crearCirculo(scanner);
        return new Esfera(base.centro, base.radio);
    }
}