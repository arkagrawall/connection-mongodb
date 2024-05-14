import { MongoClient } from 'mongodb';

// MongoDB connection settings
const uri = 'mongodb://localhost:27017';
const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

async function main() {
    try {
        await client.connect();
        console.log('Connected to MongoDB');

        const database = client.db('mydatabase');
        const collection = database.collection('mycollection');

        // Example: Inserting a document
        const document = { name: 'John', age: 30 };
        const insertResult = await collection.insertOne(document);
        console.log('Document inserted with ID:', insertResult.insertedId);

        // Example: Querying documents
        const query = { name: 'John' };
        const result = await collection.findOne(query);
        console.log('Found document:', result);
    } catch (error) {
        console.error('Error:', error);
    } finally {
        await client.close();
        console.log('Disconnected from MongoDB');
    }
}

main().catch(console.error);
