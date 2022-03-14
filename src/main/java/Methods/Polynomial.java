package Methods;

import java.util.List;
import java.util.ArrayList;

public class Polynomial {
    private List<Monomial> listOfMonomials = new ArrayList<Monomial>();

    public List<Monomial> getlistOfMonomials() {return listOfMonomials;}
    public void setlistOfMonomials(List<Monomial> listOfMonomials) {this.listOfMonomials = listOfMonomials;}

    public List<Monomial> createListPolynomial(String stringPolynomial){
        String substringPolynomial = "";
        int j = 0;
        for(int i = 0; i < stringPolynomial.length(); i++){
            if(stringPolynomial.charAt(i) == '+' || stringPolynomial.charAt(i) == '-') {
                substringPolynomial = stringPolynomial.substring(j,i);
                Monomial monomial = new Monomial(substringPolynomial);
                listOfMonomials.add(monomial);
                j = i;
            }
            else if(i == stringPolynomial.length()-1){
                substringPolynomial = stringPolynomial.substring(j,i+1);
                Monomial monomial = new Monomial(substringPolynomial);
                listOfMonomials.add(monomial);
                j = i;
            }
        }
        return listOfMonomials;
    }

    public void showListPolynomial(List<Monomial> listMonomial){
        for(Monomial monomial: listMonomial) {
            System.out.print(monomial.getSign());
            System.out.print(monomial.getCoefficient());
            System.out.print("*X^");
            System.out.print(monomial.getExponent());
        }
        System.out.println();
    }
}
