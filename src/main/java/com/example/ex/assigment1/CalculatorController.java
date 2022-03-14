package com.example.ex.assigment1;

import Methods.CheckPolynomial;
import Methods.Operations;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class CalculatorController {
    @FXML
    TextField firstPolynomial;
    @FXML
    TextField secondPolynomial;
    @FXML
    private TextField resultPolynomial;
    @FXML
    private TextField stringPolynomial;
    @FXML
    protected Text messageWrited;
    @FXML
    private Button del;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button tree;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button slash;
    @FXML
    private Button ori;
    @FXML
    private Button putere;
    @FXML
    private Button punct;
    @FXML
    private Button x;

    ///////////////////////////     Text field cu MESAJ DE VALIDARE AL CELOR 2 POLINOAME INSERATE
    public int checkText(String string1, String string2){
        CheckPolynomial check = new CheckPolynomial();
        messageWrited.setText(check.checkMessage(firstPolynomial.getText(),secondPolynomial.getText()));
        if(Objects.equals(messageWrited.getText(), "Correct!"))
            return 1;
        else
            return -1;

    }
    /////////////////////////////////////////          BUTOANE CU OPERATII
    @FXML
    public void Add(){
        String string1 = firstPolynomial.getText();
        String string2 = secondPolynomial.getText();
        if(checkText(firstPolynomial.getText(),secondPolynomial.getText()) == 1) {
            Operations operations = new Operations();
            resultPolynomial.setText(operations.addSubTwoPolynomial(firstPolynomial.getText(), secondPolynomial.getText(), '+'));
        }
    }
    @FXML
    public void Sub(){
        String string1 = firstPolynomial.getText();
        String string2 = secondPolynomial.getText();
        if(checkText(firstPolynomial.getText(),secondPolynomial.getText()) == 1) {
            Operations operations = new Operations();
            resultPolynomial.setText(operations.addSubTwoPolynomial(firstPolynomial.getText(), secondPolynomial.getText(), '-'));
        }
    }
    @FXML
    public void Mul(){
        String string1 = firstPolynomial.getText();
        String string2 = secondPolynomial.getText();
        if(checkText(firstPolynomial.getText(),secondPolynomial.getText()) == 1) {
            Operations operations = new Operations();
            resultPolynomial.setText(operations.multiplicationTwoPolynomial(firstPolynomial.getText(),secondPolynomial.getText()));
        }
    }
    @FXML
    public void Derivate(){
        String string1 = firstPolynomial.getText();
        String string2 = secondPolynomial.getText();
        if(checkText(firstPolynomial.getText(),secondPolynomial.getText()) == 1) {
            Operations operations = new Operations();
            resultPolynomial.setText(operations.derivateTwoPolynomial(firstPolynomial.getText()));
        }
    }
    @FXML
    public void Integration(){
        String string1 = firstPolynomial.getText();
        String string2 = secondPolynomial.getText();
        if(checkText(firstPolynomial.getText(),secondPolynomial.getText()) == 1) {
            Operations operations = new Operations();
            resultPolynomial.setText(operations.integrationTwoPolynomials(firstPolynomial.getText()));
        }
    }
    //////////////////////////////////////////          BUTOANE SIMPLE
    @FXML
    public void onClickFirstField(){
        messageWrited.setText("Write the polynomial equation");
        stringPolynomial = firstPolynomial;
    }
    @FXML
    public void onClickSecondField(){
        messageWrited.setText("Write the polynomial equation");
        stringPolynomial = secondPolynomial;
    }
    @FXML
    public void onClickOne(){
        try {
            stringPolynomial.setText(stringPolynomial.getText() + "1");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickTwo(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "2");
    }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickTree(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "3");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickFour(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "4");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickFive(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "5");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickSix(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "6");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickSeven(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "7");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickEight(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "8");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickNine(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "9");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickZero(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "0");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickPlus(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "+");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickMinus(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "-");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickSlash(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "/");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickOri(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "*");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickPutere(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "^");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickPunct(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + ".");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickX(){
        try{
            stringPolynomial.setText(stringPolynomial.getText() + "X");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }
    }
    @FXML
    public void onClickDel() {
        try{
            if(stringPolynomial.getLength() >= 1)
            stringPolynomial.deleteText(stringPolynomial.getLength()-1,stringPolynomial.getLength());
            resultPolynomial.setText("");
        }
        catch (NullPointerException e){
            messageWrited.setText("Select the text field");
        }

    }
}
