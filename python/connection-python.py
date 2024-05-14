from pymongo import MongoClient

# MongoDB connection settings
MONGODB_URL = "mongodb://localhost:27017/"
DB_NAME = "mydatabase"

# Connect to MongoDB
client = MongoClient(MONGODB_URL)
db = client[DB_NAME]

# Example: Inserting a document
collection = db["mycollection"]
data = {"name": "Ark", "age": 18}
insert_result = collection.insert_one(data)
print("Document inserted with ID:", insert_result.inserted_id)

# Example: Querying documents
query = {"name": "Ark"}
result = collection.find_one(query)
print("Found document:", result)
