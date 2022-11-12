package application.controller;

import application.model.vendable.Categorie;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Produit;

import java.util.ArrayList;

public class DynamicOfferController {

    TemplateOffre templateOffre;
    int currentStep;

    ArrayList<Produit> produitChoosenList = new ArrayList<>();

    public DynamicOfferController(){

    }

    public void start(TemplateOffre pTemplateOffre){
        currentStep = -1;
        templateOffre = pTemplateOffre;
        nextStep();
    }

    public void chooseCategorie(Categorie pCategorie){

    }

    public void chooseType(){

    }

    public void nextStep(){
        currentStep++;
        if(currentStep >= templateOffre.getCategorieListe().size()){
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
