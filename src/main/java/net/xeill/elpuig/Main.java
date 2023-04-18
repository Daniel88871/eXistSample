package net.xeill.elpuig;

import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

public class Main {
    public static void main(String args[]) throws Exception {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver); //Cargar Driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        DatabaseManager.registerDatabase(database); //Registrar DB
        database.setProperty("create-database", "true");
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/apps/foaf", "dani", "1234");
        col.setProperty("pretty", "true");
        col.setProperty("encoding", "UTF-8");
//      XMLResource res = (XMLResource) col.getResource("prueba.xml");
        XMLResource res = (XMLResource) col.getResource("magarcia.rdf");
        if (res == null) {
            System.err.println("could not retrieve document " + args[0] + "!");
            return;
        }
        System.out.println((String) res.getContent()); //Recupero la inf.
    }
}
