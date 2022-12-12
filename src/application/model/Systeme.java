package application.model;

import application.model.client.*;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classe s'occupera d'enclencher la de/serialisation de tous
 * les objets. Etant donne que chaque classe a son propre fichier de sauvegarde,
 * il peut y avoir objets doublons si une meme objet est reference dans plusieurs autres.
 * C'est pourquoi chaque classe du modele possede une variable uuid et une liste statique:
 * lors de la deserialisation, on parcourera la liste statique et on regarde si l'uuid
 * existe deja. Cette verification est faite dans readResolve dans chaque classe.
 *
 */
public class Systeme {

    public static void saveAll(){

        //Si il y a une commande en cours non terminee, on doit vider le panier pour remplir le stock
        if(Panier.panierCourant.getTerminePanier()==false)
            Panier.panierCourant.viderPanier();

        String path = "data/Categorie&Type&Produit.txt";   //Categorie stocke Type qui stocke Produit
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Categorie.categorieListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "data/TemplateOffre.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(TemplateOffre.templateOffreListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "data/Stock.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Stock.getInstance().stock);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "data/Groupe&Client.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Groupe.groupeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "data/Panier.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Groupe.groupeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "data/Commande.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Commande.commandeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadAll(){
        String path = "data/Categorie&Type&Produit.txt";   //Categorie stocke Type qui stocke Produit
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Categorie> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "data/TemplateOffre.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Type> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "data/Stock.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            Stock.getInstance().stock = (HashMap<Produit, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "data/Groupe&Client.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Groupe> l = (ArrayList<Groupe>)ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "data/Panier.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Panier> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "data/Commande.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Commande> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}

