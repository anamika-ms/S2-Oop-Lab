import java.util.Scanner;

class Complex
{
    double real, imag;

    Complex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    Complex multiply(Complex c) {
        double realPart = (this.real * c.real) - (this.imag * c.imag);
        double imagPart = (this.real * c.imag) + (this.imag * c.real);
        return new Complex(realPart, imagPart);
    }

    public String toString() {
        return real + " + " + imag + "i";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter real and imaginary part of first complex number: ");
        Complex c1 = new Complex(sc.nextDouble(), sc.nextDouble());

        System.out.print("Enter real and imaginary part of second complex number: ");
        Complex c2 = new Complex(sc.nextDouble(), sc.nextDouble());

        Complex sum = c1.add(c2);
        Complex product = c1.multiply(c2);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);


    }
}
