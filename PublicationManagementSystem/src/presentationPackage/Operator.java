package presentationPackage;

import domainPackage.Document;

import java.sql.*;

public class Operator extends Person {
    public Connection jdbc_connection;
    public Statement statement;
    public String tableName = "document";
    
    String connectInfo = "jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false";
	String user = "root";
	String pword = "ShayanZack97";
    
    public Operator() {
    	try {
    		jdbc_connection = DriverManager.getConnection(connectInfo, user, pword);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void addDoc(Document doc){

        String sql = "INSERT INTO " + tableName 
        		+ " (title,onsale,price,publisher,type,genre,author)" +
                " VALUES ('" + doc.getTitle() + "', " +
                doc.isOnSale() + ", " +
                doc.getPrice() + ",'" +
                doc.getPublisher() + "','" +
                doc.getType() + "','" +
                doc.getGenre() + "','" +
                doc.getAuthor() + "');";
        try{
            statement = jdbc_connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public Document selectDoc(int docID){
            String sql = "SELECT * FROM " + tableName + " WHERE ID=" + docID;
            ResultSet doc;
            try {
                statement = jdbc_connection.createStatement();
                doc = statement.executeQuery(sql);
                if(doc.next())
                {
                    return new Document(doc.getString("TITLE"),
                    		doc.getBoolean("ONSALE"),
                    		doc.getDouble("PRICE"),
                            doc.getString("PUBLISHER"),
                            doc.getString("TYPE"),
                            doc.getString("GENRE"),
                            doc.getString("AUTHOR")
                            );
                }

            } catch (SQLException e) { e.printStackTrace(); }

            return null;
    }

    public void editDocPrice(int docID, double price, boolean onsale){
        String sql = "UPDATE "+tableName+" SET price=?, onsale=? WHERE id = "+docID;

        try{
            PreparedStatement preparedStmt = jdbc_connection.prepareStatement(sql);
            preparedStmt.setDouble   (1, price);
            preparedStmt.setBoolean(2, onsale);
            preparedStmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeDoc(int docID){

        String sql = "DELETE FROM "+tableName+" WHERE id = "+docID;
        try{
            statement = jdbc_connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
}
