package application.model;

import application.model.client.Client;
import application.model.client.Groupe;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.TemplateOffre;
import application.model.vendable.Type;

import java.io.*;
import java.util.ArrayList;

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

        String path = "Categorie&Type&Produit.txt";   //Categorie stocke Type qui stocke Produit
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Categorie.categorieListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "TemplateOffre.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(TemplateOffre.templateOffreListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "Stock.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Stock.getInstance());
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "Groupe&Client.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Groupe.groupeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "Panier.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Groupe.groupeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = "Commande.txt";
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(Groupe.groupeListe);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadAll(){
        String path = "Categorie&Type&Produit.txt";   //Categorie stocke Type qui stocke Produit
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Categorie> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "TemplateOffre.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Type> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "Stock.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Produit> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "Groupe&Client.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            Stock s = (Stock)ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "Panier.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Panier> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        path = "Commande.txt";
        try (FileInputStream fis = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList<Commande> l = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

}

