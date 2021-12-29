package week01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Your task is to write a program that creates or splits Camel Case variable, method, and class names.
// Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
//
// The operation will either be S (split) or C (combine)
//
// M indicates method, C indicates class, and V indicates variable
//
// In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
//
// In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String.
// Methods should end with an empty set of parentheses to differentiate them from variable names.
public class CamelCase4Test {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void case01() {
        convertToCamelCase("S;M;plasticCup()");
        Assertions.assertEquals("plastic cup", output.toString());
    }

    @Test
    public void case02() {
        convertToCamelCase("C;V;mobile phone");
        Assertions.assertEquals("mobilePhone", output.toString());
    }

    @Test
    public void case03() {
        convertToCamelCase("C;C;coffee machine");
        Assertions.assertEquals("CoffeeMachine", output.toString());
    }

    @Test
    public void case04() {
        convertToCamelCase("S;C;LargeSoftwareBook");
        Assertions.assertEquals("large software book", output.toString());
    }

    @Test
    public void case05() {
        convertToCamelCase("C;M;white sheet of paper");
        Assertions.assertEquals("whiteSheetOfPaper()", output.toString());
    }

    @Test
    public void case06() {
        convertToCamelCase("S;V;pictureFrame");
        Assertions.assertEquals("picture frame", output.toString());
    }

    public void convertToCamelCase(String input) {
        Converter converter = new Converter();
        String output = converter.convert(input);
        System.out.print(output);
    }
}

class Converter {

    private Operator operator;

    String convert (String input) {
        String[] inputs = input.split("\\;+");
        if (inputs[0].equals("S")) {
            operator = new Split();
        } else {
            operator = new Combine();
        }

        return operator.transform(input);
    }
}

interface Operator {
    String transform(String input);
}
class Split implements Operator {

    @Override
    public String transform(String input) {
        String[] inputs = input.split("\\;+");
        if (inputs[1].equals("M")) {
            inputs[2] = inputs[2].substring(0, inputs[2].length()-2);
        }

        String[] outputs = inputs[2].split("(?=\\p{Upper})");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < outputs.length; i++) {
            output.append(outputs[i].toLowerCase()).append(" ");
        }

        return output.toString().substring(0, output.length()-1);
    }
}
class Combine implements Operator {

    @Override
    public String transform(String input) {
        String[] inputs = input.split("\\;+");
        String[] splited = inputs[2].split("\\s+");

        StringBuilder output = new StringBuilder();
        if (inputs[1].equals("C")) {
            output.append(splited[0].substring(0, 1).toUpperCase() + splited[0].substring(1));
        } else {
            output.append(splited[0]);
        }
        for (int i = 1; i < splited.length; i++) {
            output.append(splited[i].substring(0, 1).toUpperCase() + splited[i].substring(1));
        }

        if (inputs[1].equals("M")) {
            output.append("()");
        }

        return output.toString();
    }
}
