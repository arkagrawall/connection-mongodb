import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // MongoDB connection settings
        String connectionString = "mongodb://localhost:27017";
        String databaseName = "mydatabase";

        // Connect to MongoDB
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            System.out.println("Connected to MongoDB");

            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection("mycollection");

            // Example: Inserting a document
            Document document = new Document("name", "John")
                .append("age", 30);
            collection.insertOne(document);
            System.out.println("Document inserted");

            // Example: Querying documents
            Document query = new Document("name", "John");
            Document result = collection.find(query).first();
            System.out.println("Found document: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
