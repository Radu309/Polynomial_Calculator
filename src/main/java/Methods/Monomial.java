package Methods;

public class Monomial {
    private String stringPolynomial;
    private int exponent = 0;
    private float coefficient = 0.0F;
    private char sign = '+';

    public Monomial(String stringPolynomial) {
        this.stringPolynomial = stringPolynomial;
    }

    public int getExponent() {return exponent;}
    public void setExponent(int exponent) {this.exponent = exponent;}

    public float getCoefficient() {return coefficient;}
    public void setCoefficient(float coefficient) {this.coefficient = coefficient;}

    public char getSign() {return sign;}
    public void setSign(char sign) {this.sign = sign;}

    public String getstringPolynomial() {return stringPolynomial;}
    public void setstringPolynomial(String stringPolynomial) {this.stringPolynomial = stringPolynomial;}

    public int monomialExponent(){
        int exponentX = 0;
        for (int i = 0; i < stringPolynomial.length(); i++) {
            if(i < stringPolynomial.length() - 1) {
                if (stringPolynomial.charAt(i) == 'X' && stringPolynomial.charAt(i + 1) == '^') {
                    for (int j = i + 2; j < stringPolynomial.length(); j++) {
                        if (stringPolynomial.charAt(j) >= '0' && stringPolynomial.charAt(j) <= '9')
                            exponentX = exponentX * 10 + Character.getNumericValue(stringPolynomial.charAt(j));
                    }
                    setExponent(exponentX);
                    return exponentX;
                }
                else if (stringPolynomial.charAt(i) == 'X') {
                    setExponent(1);
                    return 1;
                }
            }
            else if (stringPolynomial.charAt(i) == 'X') {
                setExponent(1);
                return 1;
            }
        }
        setExponent(0);
        return 0;
    }

    public float monomialCoefficient(){
        float coefficientX = 0.0F;
        float fractionalPartX = 0.0F;
        int P = 10;
        for (int i = 0; i < stringPolynomial.length(); i++) {
            if (stringPolynomial.charAt(1) == 'X')
                return 1;
            if(stringPolynomial.charAt(i) == '-' || stringPolynomial.charAt(i) == '+')
                i++;
            if (stringPolynomial.charAt(i) >= '0' && stringPolynomial.charAt(i) <= '9')
                coefficientX = coefficientX * 10 + Character.getNumericValue(stringPolynomial.charAt(i));
            else {
                if (stringPolynomial.charAt(i) == '.')
                    for (int j = i + 1; j < stringPolynomial.length(); j++)
                        if (stringPolynomial.charAt(j) >= '0' && stringPolynomial.charAt(j) <= '9') {
                            fractionalPartX = fractionalPartX + (float) Character.getNumericValue(stringPolynomial.charAt(j)) / P;
                            P *= 10;
                        } else {
                            setCoefficient(coefficientX + fractionalPartX);
                            return (coefficientX + fractionalPartX);
                        }
                setCoefficient(coefficientX);
                return coefficientX;
            }
        }
        setCoefficient(coefficientX);
        return coefficientX;
    }

    public char monomialSign(){
        for(int i = 0; i < stringPolynomial.length(); i++){
            if(stringPolynomial.charAt(i) == '+') {
                setSign('+');
                return '+';
            }
            if(stringPolynomial.charAt(i) == '-') {
                setSign('-');
                return '-';
            }
        }
        setSign('+');
        return '+';
    }
}
