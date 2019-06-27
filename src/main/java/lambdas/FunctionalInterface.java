package lambdas;

public class FunctionalInterface {

    //A functional interface is an interface that specifies only one abstract method.
    //The signature of the abstract method of the functional interface describes the signature
    //of the lambda expression.
    // and the abstract method is called function descriptor.
    //a lambda expression can be assigned
    //to a variable or passed to a method expecting a functional interface as argument, provided
    //the lambda expression has the same signature as the abstract method of the
    //functional interface.

    //annotation @FunctionalInterface implies that the interface is intended a functional interface
    //i.e. it contains only a single abstract method (SAM)

}
