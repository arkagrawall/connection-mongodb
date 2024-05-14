package main

import (
	"context"
	"fmt"
	"log"

	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

func main() {
	// MongoDB connection settings
	clientOptions := options.Client().ApplyURI("mongodb://localhost:27017")
	client, err := mongo.Connect(context.Background(), clientOptions)
	if err != nil {
		log.Fatal(err)
	}
	defer client.Disconnect(context.Background())
	fmt.Println("Connected to MongoDB")

	// Accessing a database
	database := client.Database("mydatabase")
	collection := database.Collection("mycollection")

	// Example: Inserting a document
	document := bson.D{{"name", "Ark"}, {"age", 17}}
	insertResult, err := collection.InsertOne(context.Background(), document)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Document inserted with ID:", insertResult.InsertedID)

	// Example: Querying documents
	filter := bson.D{{"name", "Ark"}}
	var result bson.M
	err = collection.FindOne(context.Background(), filter).Decode(&result)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Found document:", result)
}
