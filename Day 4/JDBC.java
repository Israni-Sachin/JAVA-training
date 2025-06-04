import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class JDBC {
    public static void main(String[] args) {
        // MongoDB Compass usually connects to localhost on port 27017
        String uri = "mongodb://localhost:27017";

        // Create a MongoDB client
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Connect to a database (will be created if it doesn't exist)
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("users");

            System.out.println("All Users:");
            FindIterable<Document> users = collection.find();

            for (Document user : users) {
                System.out.println(user.toJson());
            }
            System.out.println("Connected to MongoDB successfully!");
            System.out.println("Database name: " + database.getName());
        } catch (Exception e) {
            System.err.println("Failed to connect to MongoDB: " + e.getMessage());
        }
    }
}
