### GCD

Greatest Common Divisor (GCD) or Highest Common Factor (HCF) of two positive integers is the largest positive integer that divides both numbers without remainder. It is useful for reducing fractions to be in its lowest terms.

GCD == FPB

#### Euclidean Algorithm

This algorithm finds GCD by performing repeated division starting from the two numbers we want to find the GCD of until we get a remainder of 0.

Euclid's method depends on two important theorems:  
1. If we subtract the smaller number from the larger number, the GCD doesn't change. Therefore, if we keep on subtracting the number we finally end up with their GCD.  
2. When the smaller number exactly divides the larger number, the smaller number is the GCD of the two given numbers.

For example, GCD of 40 and 64.  
- 64 / 40 = 1 with a remainder of 24.  
- 40 / 24 = 1 with a remainder of 16.  
- 24 / 16 = 1 with a remainder of 8.  
- 16 / 8 = 2 with a remainder of 0.
The gcd is the last value we use as a divisor, 8.

### References:

[Greatest Common Divisor and Least Common Multiple](https://www.idomaths.com/hcflcm.php)  
[Finding Greatest Common Divisor in Java](https://www.baeldung.com/java-greatest-common-divisor)