using MongoDB.Driver;
using System;

class Program
{
    static void Main(string[] args)
    {
        // MongoDB connection settings
        var connectionString = "mongodb://localhost:27017";
        var databaseName = "mydatabase";
        var collectionName = "mycollection";

        // Connect to MongoDB
        var client = new MongoClient(connectionString);
        var database = client.GetDatabase(databaseName);
        var collection = database.GetCollection<BsonDocument>(collectionName);
        Console.WriteLine("Connected to MongoDB");

        // Example: Inserting a document
        var document = new BsonDocument { { "name", "Ark" }, { "age", 18 } };
        collection.InsertOne(document);
        Console.WriteLine("Document inserted");

        // Example: Querying documents
        var filter = Builders<BsonDocument>.Filter.Eq("name", "Ark");
        var result = collection.Find(filter).FirstOrDefault();
        Console.WriteLine("Found document: " + result);
    }
}
