package Methods;

// verificam daca stringul inserat este polinom sau nu.
public class CheckPolynomial {

    public String checkMessage(String firstPolynomial, String secondPolynomial){
        String errorMessage = "";
        if(checkString(firstPolynomial, secondPolynomial) == 1)
            errorMessage = "Correct!";

        else if(checkString(firstPolynomial, secondPolynomial) == -1)
            errorMessage = "You must insert the polynomial equation";

        else if(checkString(firstPolynomial, secondPolynomial) == -2)
            errorMessage = "First and second polynomial equation are wrong";

        else if(checkString(firstPolynomial, secondPolynomial) == -3)
            errorMessage = "First polynomial equation is wrong";

        else if(checkString(firstPolynomial, secondPolynomial) == -4)
            errorMessage = "Second polynomial equation is wrong";
        return errorMessage;
    }

    public int checkString(String firstPolynomial, String secondPolynomial){
        if(firstPolynomial.length() == 0 || secondPolynomial.length() == 0)
            return-1;
        if(rulesPolynomial(firstPolynomial) != 1 && rulesPolynomial(secondPolynomial) != 1)
            return-2;
        else if(rulesPolynomial(firstPolynomial) != 1)
            return-3;
        else if(rulesPolynomial(secondPolynomial) != 1)
            return-4;
        return 1;
    }

    public int rulesPolynomial (String stringPolynomial){
        for(int i = 0; i < stringPolynomial.length(); i++){
            if(stringPolynomial.charAt(i) >= '0' && stringPolynomial.charAt(i) <='9')
                for (int j = i + 1; j < stringPolynomial.length(); j++) {
                    if (stringPolynomial.charAt(j) >= '9' || stringPolynomial.charAt(j) <= '0') {
                        if (stringPolynomial.charAt(j) != '+' && stringPolynomial.charAt(j) != '-' && stringPolynomial.charAt(j) != '*' && stringPolynomial.charAt(j) != '/' && stringPolynomial.charAt(j) != '.')
                            return -1;
                        else {
                            i = j - 1;
                            break;
                        }
                    }
                }
            if(stringPolynomial.length() > i+1) {
                if (stringPolynomial.charAt(i) == '^' && (stringPolynomial.charAt(i + 1) <= '0' && stringPolynomial.charAt(i + 1) >= '9'))
                    return -1;
                if (stringPolynomial.charAt(i) == '^' && stringPolynomial.charAt(i - 1) != 'X')
                    return -1;
                if (stringPolynomial.charAt(i) == '*' && stringPolynomial.charAt(i + 1) != 'X')
                    return -1;
            }
            else
            if((stringPolynomial.charAt(i) < '0' || stringPolynomial.charAt(i) > '9') && stringPolynomial.charAt(i) != 'X')
                return -1;
            if(stringPolynomial.charAt(i) == ' ')
                return -1;
        }
        return 1;
    }
}
