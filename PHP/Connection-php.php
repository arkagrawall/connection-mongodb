<?php

// MongoDB connection settings
$mongoClient = new MongoDB\Client("mongodb://localhost:27017");
$databaseName = "mydatabase";
$collectionName = "mycollection";

// Connect to MongoDB
try {
    $database = $mongoClient->$databaseName;
    $collection = $database->$collectionName;
    echo "Connected to MongoDB\n";

    // Example: Inserting a document
    $document = array("name" => "Ark", "age" => 18);
    $insertResult = $collection->insertOne($document);
    echo "Document inserted with ID: " . $insertResult->getInsertedId() . "\n";

    // Example: Querying documents
    $query = array("name" => "Ark");
    $result = $collection->findOne($query);
    echo "Found document: " . json_encode($result) . "\n";
} catch (Exception $e) {
    echo "Error: " . $e->getMessage() . "\n";
}
?>
