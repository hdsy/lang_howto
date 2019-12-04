/*
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;
//*/
import java.util.function.*;

public class FRTest{
    public static void main(final String args[]) {
        final Function<String, Boolean> fun = "abcd"::startsWith;

        System.out.println(fun.apply("cd"));
        System.out.println(fun.apply("ab"));

        final Consumer<String> cons = System.out::print;
        cons.accept("Hello aa");

        final Supplier<String> sup = "gauss"::toUpperCase;
        System.out.println(sup.get());

        final Predicate<String> pre = "gauss"::equalsIgnoreCase;
        System.out.println(pre.test("GAUSS"));
        System.out.println(pre.test("GAUsS1234"));

    }
}