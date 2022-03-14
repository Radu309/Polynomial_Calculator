package Methods;

import java.util.*;

import static java.lang.Integer.max;

public class Operations {
    Polynomial polynomial1 = new Polynomial();
    Polynomial polynomial2 = new Polynomial();

    List<Monomial> listMonomial1 = new ArrayList<Monomial>();
    List<Monomial> listMonomial2 = new ArrayList<Monomial>();

    // adunare/scadere
    public String addSubTwoPolynomial(String firstPolynomial, String secondPolynomial, char operation) {
        String resultString = "";
        listMonomial1 = polynomial1.createListPolynomial(firstPolynomial);
        listMonomial2 = polynomial2.createListPolynomial(secondPolynomial);
        listMonomial1 = sortPolynomial(listMonomial1);
        listMonomial2 = sortPolynomial(listMonomial2);
        int maxExponent = max(maxExponent(listMonomial1), maxExponent(listMonomial2));
        float[] array1 = arrayCoefficient(listMonomial1,maxExponent);
        float[] array2 = arrayCoefficient(listMonomial2,maxExponent);
        float[] arrayResulString = new float[maxExponent+1];

        if(operation == '+')
            for(int i = 0; i <= maxExponent; i++)
                arrayResulString[i] = array1[i] + array2[i];
        if(operation == '-')
            for(int i = 0; i <= maxExponent; i++)
                arrayResulString[i] = array1[i] - array2[i];

        resultString = createResultAddSub(arrayResulString,maxExponent);
        if(resultString.length() != 0) {
            if (resultString.charAt(0) == '+')
                resultString = resultString.substring(1, resultString.length());
        }
        else
            return "0";
        return resultString;
    }
    public float[] arrayCoefficient(List<Monomial> listMonomial, int maxim){
        float[] array = new float[maxim+1];
        int index = 0;
        for(int i = 0; i <= maxim; i++){
            if(index < listMonomial.size()) {
                Monomial monomial = listMonomial.get(index);
                if (maxim - i > monomial.monomialExponent()) {
                    array[i] = 0.0F;
                }
                if (maxim - i == monomial.monomialExponent()) {
                    if (monomial.monomialSign() == '+')
                        array[i] = monomial.monomialCoefficient();
                    else
                        array[i] = -monomial.monomialCoefficient();
                    index++;
                }
                if (maxim - i < monomial.monomialExponent()) {
                    index++;
                    i--;
                }
            }
        }
        return array;
    }
    public String createResultAddSub(float[] arrayCoefString, int maxExponent){
        String resultString = "";
        for(int i = 0; i < maxExponent-1; i++) {
            if (arrayCoefString[i] != 0) {
                if(arrayCoefString[i] > 0)
                    resultString = resultString + "+";
                if (checkInteger(arrayCoefString[i]) == 1)
                    resultString = resultString + ((int)arrayCoefString[i]) + "*X^" + (maxExponent-i);
                else
                    resultString = resultString + arrayCoefString[i] + "*X^" + (maxExponent-i);
            }
        }
        if(arrayCoefString[maxExponent-1] > 0)
            resultString = resultString + "+";
        if (arrayCoefString[maxExponent-1] != 0) {
            if (checkInteger(arrayCoefString[maxExponent]) == 1)
                resultString = resultString + ((int) arrayCoefString[maxExponent-1]) + "*X";
            else
                resultString = resultString + (arrayCoefString[maxExponent-1]) + "*X";
        }
        if(arrayCoefString[maxExponent] > 0)
            resultString = resultString + "+";
        if (arrayCoefString[maxExponent] != 0) {
            if (checkInteger(arrayCoefString[maxExponent]) == 1)
                resultString = resultString + ((int) arrayCoefString[maxExponent]);
            else
                resultString = resultString +  arrayCoefString[maxExponent];
        }
        return resultString;
    }
    // inmultire
    public String multiplicationTwoPolynomial(String firstPolynomial, String secondPolynomial){
        String resultString = "";
        List<Monomial> tempListMonomial = new ArrayList<Monomial>();
        listMonomial1 = polynomial1.createListPolynomial(firstPolynomial);
        listMonomial2 = polynomial2.createListPolynomial(secondPolynomial);
        listMonomial1 = sortPolynomial(listMonomial1);
        listMonomial2 = sortPolynomial(listMonomial2);

        resultString = createMultiplicationOfTwoStrings(tempListMonomial,listMonomial1,listMonomial2);
        if(resultString.length() != 0) {
            if (resultString.charAt(0) == '+')
                resultString = resultString.substring(1, resultString.length());
        }
        else
            return "0";
        return resultString;
    }
    public String createMultiplicationOfTwoStrings(List<Monomial> tempListMonomial,List<Monomial> listMonomial1, List<Monomial> listMonomial2){
        String resultString = "";
        for(Monomial monomial1: listMonomial1){
            for(Monomial monomial2: listMonomial2){
                Monomial tempMonomial = new Monomial("");
                tempMonomial.setExponent(monomial1.monomialExponent() + monomial2.monomialExponent());
                tempMonomial.setCoefficient(monomial1.monomialCoefficient() * monomial2.monomialCoefficient());
                if(monomial1.monomialSign() != monomial2.monomialSign())
                    tempMonomial.setSign('-');
                else
                    tempMonomial.setSign('+');
                tempListMonomial.add(tempMonomial);
            }
        }
        tempListMonomial = getSortPolynomial(tempListMonomial);
        for(int i = 0; i < tempListMonomial.size()-1; i++){
            float suma = 0.0F;
            if(tempListMonomial.get(i).getSign() == '+')
                suma = tempListMonomial.get(i).getCoefficient();
            else
                suma = tempListMonomial.get(i).getCoefficient() * (-1);
            if(tempListMonomial.get(i).getExponent() == tempListMonomial.get(i+1).getExponent()) {
                for (int j = i; j < tempListMonomial.size() - 1; j++) {
                    if (tempListMonomial.get(j).getExponent() == tempListMonomial.get(j + 1).getExponent())
                        if(tempListMonomial.get(j+1).getSign() == '+')
                            suma = suma + tempListMonomial.get(j+1).getCoefficient();
                        else
                            suma = suma + tempListMonomial.get(j+1).getCoefficient() * (-1);
                    else
                        break;
                    i++;
                }
            }
            if(checkInteger(suma) == 1) {
                if (suma > 0)
                    resultString = resultString + "+" + ((int)suma) + "*X^" + tempListMonomial.get(i).getExponent();
                else if( suma < 0)
                    resultString = resultString + "" + ((int)suma) + "*X^" + tempListMonomial.get(i).getExponent();
            }
            else
                if(suma > 0)
                    resultString = resultString + "+" + suma + "*X^" + tempListMonomial.get(i).getExponent();
                else if( suma < 0)
                    resultString = resultString + "" + suma + "*X^" + tempListMonomial.get(i).getExponent();
        }
        if(tempListMonomial.get(tempListMonomial.size()-1).getExponent() != tempListMonomial.get(tempListMonomial.size()-2).getExponent() && tempListMonomial.get(tempListMonomial.size()-1).getCoefficient() > 0)
            resultString = resultString  + "+" + (int)tempListMonomial.get(tempListMonomial.size()-1).getCoefficient() + "*X^" + tempListMonomial.get(tempListMonomial.size()-1).getExponent();
        else
            resultString = resultString  + "" + (int)tempListMonomial.get(tempListMonomial.size()-1).getCoefficient() + "*X^" + tempListMonomial.get(tempListMonomial.size()-1).getExponent();
        return resultString;
    }
    // derivare
    public String derivateTwoPolynomial(String firstPolynomial){
        String resultString = "";
        List<Monomial> tempListMonomial = new ArrayList<Monomial>();
        listMonomial1 = polynomial1.createListPolynomial(firstPolynomial);
        listMonomial1 = sortPolynomial(listMonomial1);
        for(Monomial monomial:listMonomial1){
            monomial.setCoefficient(monomial.monomialCoefficient() * monomial.monomialExponent());
            monomial.setExponent(monomial.monomialExponent()-1);
            monomial.setSign(monomial.monomialSign());
            tempListMonomial.add(monomial);
        }
        resultString = createResultStringFromList(tempListMonomial);
        return resultString;
    }
    // integrare
    public String integrationTwoPolynomials(String firstPolynomial){
        String resultString = "";
        List<Monomial> tempListMonomial = new ArrayList<Monomial>();
        listMonomial1 = polynomial1.createListPolynomial(firstPolynomial);
        listMonomial1 = sortPolynomial(listMonomial1);
        for(Monomial monomial:listMonomial1){
            monomial.setCoefficient(monomial.monomialCoefficient() * ( (float)1/(monomial.monomialExponent()+1) ));
            monomial.setExponent(monomial.monomialExponent()+1);
            monomial.setSign(monomial.monomialSign());
            tempListMonomial.add(monomial);
        }
        resultString = createResultStringFromList(tempListMonomial);
        return resultString;
    }
    // creare resultat string in functie de conditii
    public String createResultStringFromList(List<Monomial> tempListMonomial){
        String resultString = "";
        for(Monomial monomial: tempListMonomial){
            if(monomial.getExponent() >= 0) {
                if (checkInteger(monomial.getCoefficient()) == 1)
                    resultString = resultString + monomial.getSign() + (int) monomial.getCoefficient() + "*X^" + monomial.getExponent();
                else
                    resultString = resultString + monomial.getSign() + monomial.getCoefficient() + "*X^" + monomial.getExponent();
            }
        }
        if(resultString.length() != 0) {
            if (resultString.charAt(0) == '+')
                resultString = resultString.substring(1, resultString.length());
        }
        else
            return "0";
        return resultString;
    }
    // metod3 ajutatoare
    public List<Monomial> sortPolynomial(List<Monomial> listMonomial){
        for(int i = 0; i < listMonomial.size(); i++){
            for(int j = i + 1; j < listMonomial.size(); j++){
                Monomial monomial1 = listMonomial.get(i);
                Monomial monomial2 = listMonomial.get(j);
                if(monomial1.monomialExponent() < monomial2.monomialExponent()){
                    Collections.swap(listMonomial,i,j);
                }
            }
        }
        return listMonomial;
    }
    public List<Monomial> getSortPolynomial(List<Monomial> listMonomial){
        for(int i = 0; i < listMonomial.size(); i++){
            for(int j = i + 1; j < listMonomial.size(); j++){
                Monomial monomial1 = listMonomial.get(i);
                Monomial monomial2 = listMonomial.get(j);
                if(monomial1.getExponent() < monomial2.getExponent()){
                    Collections.swap(listMonomial,i,j);
                }
            }
        }
        return listMonomial;
    }
    public int checkInteger(float checkNumber){
        int integerNumber = (int) checkNumber;
        if(checkNumber == integerNumber)
            return 1;
        else
            return -1;
    }
    public int maxExponent(List<Monomial> listMonomial){
        int max = 0;
        for (Monomial monomial: listMonomial){
            if(max < monomial.monomialExponent())
                max = monomial.monomialExponent();
        }
        return max;
    }

}