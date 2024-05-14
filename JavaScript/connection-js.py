const { MongoClient } = require('mongodb');

// MongoDB connection settings
const MONGODB_URL = 'mongodb://localhost:27017';
const DB_NAME = 'mydatabase';

async function main() {
  // Connect to MongoDB
  const client = new MongoClient(MONGODB_URL, { useNewUrlParser: true, useUnifiedTopology: true });
  try {
    await client.connect();
    console.log('Connected to MongoDB');

    const db = client.db(DB_NAME);
    const collection = db.collection('mycollection');

    // Example: Inserting a document
    const document = { name: 'Ark', age: 18 };
    const insertResult = await collection.insertOne(document);
    console.log('Document inserted with ID:', insertResult.insertedId);

    // Example: Querying documents
    const query = { name: 'Ark' };
    const result = await collection.findOne(query);
    console.log('Found document:', result);
  } catch (error) {
    console.error('Error:', error);
  } finally {
    // Close the connection
    await client.close();
    console.log('Disconnected from MongoDB');
  }
}

main().catch(console.error);
