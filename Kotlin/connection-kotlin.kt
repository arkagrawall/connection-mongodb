import org.bson.Document
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI

fun main() {
    // MongoDB connection settings
    val uri = MongoClientURI("mongodb://localhost:27017")
    val client = MongoClient(uri)
    val database = client.getDatabase("mydatabase")
    val collection = database.getCollection("mycollection")

    // Example: Inserting a document
    val document = Document("name", "Ark")
        .append("age", 17)
    collection.insertOne(document)
    println("Document inserted")

    // Example: Querying documents
    val query = Document("name", "Ark")
    val result = collection.find(query).first()
    println("Found document: $result")
}
