package lambda;

public class LambdaFundamentals {

    public static void examples() {

        FuncInterface f = () -> System.out.println("This is how you use a lambda."); //target of a lambda expression
        // must be a functional interface
        // interface reference is used to call the method.
        f.simpleMethod();

        // adding using functional interface;
        Sum s = (a, b) -> (2*a + b); // implementation of the method
        //Sum s2 = (c,d) -> return c+d; //C.E. can't use return without curly braces
        //Sum s3 = (e,f) -> {e+f}; //C.E. return statement must be used within curly braces
        //Sum s4 = (g,h) -> {return g+h;} //C.E. lambda must end with semicolon
        //Sum s5 = (i,j) -> {return i+j};//C. E. every statement within lambda must end with a semicolon
        Sum s6 = (k,l) -> {return k+l;}; //this is correct implementation
        System.out.println(s.add(110, 140)); // will print 360, (2*110 + 140)
        System.out.println(s.add(120, 190)); // will print 430, (2*120 + 190)

    }

    public static void main(String[] args) {
        examples();
    }
}





