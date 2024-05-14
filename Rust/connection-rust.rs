use mongodb::{Client, bson};

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    // MongoDB connection settings
    let client = Client::with_uri_str("mongodb://localhost:27017").await?;
    println!("Connected to MongoDB");

    let database = client.database("mydatabase");
    let collection = database.collection("mycollection");

    // Example: Inserting a document
    let document = bson::doc! { "name": "Ark", "age": 18 };
    collection.insert_one(document, None).await?;
    println!("Document inserted");

    // Example: Querying documents
    let query = bson::doc! { "name": "Ark" };
    if let Some(result) = collection.find_one(query, None).await? {
        println!("Found document: {:?}", result);
    }

    Ok(())
}
