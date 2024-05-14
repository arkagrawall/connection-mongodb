import Foundation
import MongoSwift

let uri = "mongodb://localhost:27017"
let client = try MongoClient(uri)
let database = client.db("mydatabase")
let collection = database.collection("mycollection")

// Example: Inserting a document
let document: Document = ["name": "Ark", "age": 18]
let result = try collection.insertOne(document)
print("Document inserted with ID: \(result.insertedId)")

// Example: Querying documents
let query: Document = ["name": "Ark"]
if let result = try collection.findOne(query) {
    print("Found document: \(result)")
}
