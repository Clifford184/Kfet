package application.controller;

import application.Model.Soldable.Categorie;
import application.Model.Soldable.OfferTemplate;
import application.Model.Soldable.Product;
import application.Model.Soldable.Type;

import java.util.ArrayList;

public class DynamicOfferController {

    OfferTemplate offerTemplate;
    int currentStep;

    ArrayList<Product> productChoosenList = new ArrayList<>();

    public DynamicOfferController(){

    }

    public void start(OfferTemplate pOfferTemplate){
        currentStep = -1;
        offerTemplate = pOfferTemplate;
        nextStep();
    }

    public void chooseCategorie(Categorie pCategorie){

    }

    public void chooseType(){

    }

    public void nextStep(){
        currentStep++;
        if(currentStep >= offerTemplate.getCategorieList().size()){
            end();
        }
        // TODO methode existe pas dans type ??
//        ArrayList<Type> nextChoice = Type.getTypeByCategorie(offerTemplate.getCategorieList().get(currentStep));
//        if(nextChoice.size()==0){
//            //ERREUR
//        }
//        if(nextChoice.size()==1){
//            //Aller directement sur l'ecran de choix du produit
//        }
        //Interface avec choix du type
        //Changement d'interface et en envoie une liste de données qui seront link au bouton
        //Les boutons appelerons makeChoice()
    }

    public void end(){

    }

}
