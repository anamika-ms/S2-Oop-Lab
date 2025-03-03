import java.util.Scanner;
import Graphics.*;

public class TestShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for Rectangle
        System.out.print("Enter length of Rectangle: ");
        double rectLength = scanner.nextDouble();
        System.out.print("Enter width of Rectangle: ");
        double rectWidth = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectLength, rectWidth);

	System.out.println("\nArea of Rectangle: " + rectangle.area());

        // Get input for Triangle
        System.out.print("\nEnter base of Triangle: ");
        double triBase = scanner.nextDouble();
        System.out.print("Enter height of Triangle: ");
        double triHeight = scanner.nextDouble();
        Triangle triangle = new Triangle(triBase, triHeight);

	System.out.println("\nArea of Triangle: " + triangle.area());

        // Get input for Square
        System.out.print("\nEnter side of Square: ");
        double squareSide = scanner.nextDouble();
        Square square = new Square(squareSide);

	System.out.println("\nArea of Square: " + square.area());

        // Get input for Circle
        System.out.print("\nEnter radius of Circle: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleRadius);

	System.out.println("\nArea of Circle: " + circle.area());


        scanner.close();
	}
}
