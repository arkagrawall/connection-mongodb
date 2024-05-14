require 'mongo'

# MongoDB connection settings
client = Mongo::Client.new('mongodb://localhost:27017/mydatabase')
collection = client[:mycollection]

# Example: Inserting a document
document = { name: 'Ark', age: 18 }
result = collection.insert_one(document)
puts "Document inserted with ID: #{result.inserted_id}"

# Example: Querying documents
query = { name: 'Ark' }
result = collection.find(query).first
puts "Found document: #{result}"
