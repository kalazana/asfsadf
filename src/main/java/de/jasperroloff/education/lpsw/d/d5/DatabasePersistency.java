package de.jasperroloff.education.lpsw.d.d5;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.IOException;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 *
 * This class implements persistency using MongoDB
 * @see Persistency
 *
 * For the MongoDB dependencies, Maven is used. See pom.xml
 *
 * WARNING: This class was not tested yet!
 */
public class DatabasePersistency implements Persistency {
    private MongoDatabase database;

    /**
     * constructor; used here for initiating a connection to the database server
     * @param dbName name of the database
     * @param host hostname of database server
     */
    public DatabasePersistency(String host, String dbName) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient(host, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        this.database = mongoClient.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);
    }

    /**
     * @see Persistency
     * @param zk a Zettelkasten instance
     * @param filename path to file where to save
     * @throws IOException e.g. file not found
     */
    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        // first, remove existing elements from database (this is a workaround to get it running fastly)
        // in a real world scenario we would have to check for each element if it already exists and if it has changed and update it instead of re-creating it
        // add each element to database
        for (Medium medium : zk) {
            this.database.getCollection("media", Medium.class).insertOne(medium);
        }
    }

    /**
     * @see Persistency
     * @param filename from which file to load
     * @return a Zettelkasten instance
     * @throws IOException e.g. file not found
     * @throws ClassNotFoundException in case of parsing error
     */
    @Override
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException {
        Zettelkasten zk = new Zettelkasten();
        // read elements from database and add them to new Zettelkasten object

        for (Medium medium : this.database.getCollection("media", Medium.class).find()) {
            try {
                zk.addMedium(medium);
            } catch (Medium.ValidationException e) {
                System.out.println("Loading from db failed for one Medium");
                e.printStackTrace();
            }
        }

        return zk;
    }
}
