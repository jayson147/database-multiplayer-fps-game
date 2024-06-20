import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


public class Database {
	private Connection connect()
	{
		Connection conn = null;
        //Scanner getDBNameObj = new Scanner(System.in);
        try {
        	System.out.println("Enter the name of the database");
        	//String DBName = getDBNameObj.nextLine();
            // db parameters
            String url = "jdbc:sqlite:/home/leezhexi/Desktop/SCC201_CW/TRY.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        } 
        return conn;
	}
	
	public void CreatePlayerTable() 
	 {
		Connection conn = null;
		
		 Scanner getDBNameObj = new Scanner(System.in);
	        try {
	        	System.out.println("CreateTable");
				conn = this.connect();

	       

	        	//System.out.println("Enter the name of the Table");

	        	//String TBName = getDBNameObj.nextLine();

	        	Statement UrazsOrder = conn.createStatement();

				String sql = "CREATE TABLE "+"Player"+ 
	        	"(Account_Number INTEGER,"+ 
				" Forename VARCHAR(20),"+ 
				" surname VARCHAR(20),"+ 
				" ExperiencePoints INTEGER," +
				" PRIMARY KEY(Account_Number));";

	        	int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }
 
	public void CreateCharacterTable() 
		{
			Connection conn = null;
			Scanner getDBNameObj = new Scanner(System.in);
			   try {
				   System.out.println("CreateTable");
				   conn = this.connect();

				   Statement UrazsOrder = conn.createStatement();
   
				   String sql="CREATE TABLE "+"Character"+ 
				   "(Character_Name VARCHAR(30),"+
				   " DefenceScore INTEGER,"+
				   " Max_Health INTEGER,"+
				   " Money_bank INTEGER,"+
				   " Health INTEGER,"+
				   " Character_Type VARCHAR(20) NOT NULL,"+
				   " Level INTEGER NOT NULL,"+
				   " Account_Number INTEGER NOT NULL,"+
				   " Character_CreationDate INTEGER NOT NULL,"+
				   " PRIMARY KEY(Character_Name),"+
				   " FOREIGN KEY (Account_Number) REFERENCES Player(Account_Number)"+
				   " ON DELETE CASCADE);";

   
				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }

		public void CreateCombatTable() 
		{
		    Connection conn = null;
			Scanner getDBNameObj = new Scanner(System.in);
			   try {
				   System.out.println("CreateTable");
				   conn = this.connect();
   
				   String sql="CREATE TABLE "+"Combat"+ 
	        	"(BattleNo INTEGER NOT NULL,"+
				" BattleDate VARCHAR(20) NOT NULL,"+
				" Weapon VARCHAR(20),"+
				" Attacker VARCHAR(20) NOT NULL, "+
				" Defender VARCHAR(20) NOT NULL, "+
				" Result VARCHAR(20) NOT NULL, "+
				" Damage VARCHAR(20) NOT NULL, "+
				" Character_Name VARCHAR(20) NOT NULL, "+
				" PRIMARY KEY(Attacker, Result, Damage),"+
				" FOREIGN KEY (Character_Name) REFERENCES Character(Character_Name)"+
				" ON DELETE CASCADE);";
				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   Statement UrazsOrder = conn.createStatement();

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }

		public void CreateInventoryTable() 
		{

			Connection conn = null; 
		   
			Scanner getDBNameObj = new Scanner(System.in);
			   try {
				   System.out.println("CreateTable");

				   conn = this.connect();
   
				   String sql= "CREATE TABLE "+"Inventory"+ 
	        	"(Item VARCHAR(20),"+
				" Item_Type VARCHAR(20) ,"+
				" Equipped VARCHAR(20) ,"+
				" Quantity INTEGER ,"+
				" Character_Name VARCHAR(20) ,"+
				" PRIMARY KEY(Item, Item_Type),"+
				" FOREIGN KEY (Character_Name) REFERENCES Character(Character_Name)"+
				" ON DELETE CASCADE);";

				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   Statement UrazsOrder = conn.createStatement();

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }

		public void CreateWeaponTable() 
		{
			Connection conn = null;
			Scanner getDBNameObj = new Scanner(System.in);

			
			   try {
				   //System.out.println("CreateTable");

				   conn = this.connect();
   
				   String sql ="CREATE TABLE "+"Weapon"+ 
	        	"(AttackinScore INTEGER,"+
				" Range INTEGER ,"+
				" WeaponType VARCHAR(20) ,"+
				" Price INTEGER ,"+
				" Item VARCHAR(20) ,"+
				" Item_Type VARCHAR(20) ,"+
				" PRIMARY KEY(AttackinScore, Range, Price),"+
				" FOREIGN KEY (Item, Item_Type) REFERENCES Inventory(Item, Item_Type)"+
				" ON DELETE CASCADE);";

				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   Statement UrazsOrder = conn.createStatement();

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }

		public void CreateSuppliesTable() 
		{

			Connection conn = null;
		   
			Scanner getDBNameObj = new Scanner(System.in);

			   try {
				   //System.out.println("CreateTable");

				   conn = this.connect();
   
				   String sql ="CREATE TABLE "+"Supplies"+ 
	        	"(HealingScore INTEGER,"+
				" Item VARCHAR(20) ,"+
				" Item_Type VARCHAR(20) ,"+
				" PRIMARY KEY(HealingScore),"+
				" FOREIGN KEY (Item, Item_Type) REFERENCES Inventory(Item, Item_Type)"+
				" ON DELETE CASCADE);";

				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   Statement UrazsOrder = conn.createStatement();

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }

		public void CreateArmourTable() 
		{
			Connection conn = null;
			Scanner getDBNameObj = new Scanner(System.in);

			   try {
				   //System.out.println("CreateTable");

				   conn = this.connect();
   
				   String sql= "CREATE TABLE "+"Armour"+ 
	        	"(BodyPart VARCHAR(20),"+
				" wearable VARCHAR(20) ,"+
				" DefendScore INTEGER ,"+
				" Item VARCHAR(20) ,"+
				" Item_Type VARCHAR(20) ,"+
				" PRIMARY KEY(BodyPart, wearable, DefendScore),"+
				" FOREIGN KEY (Item, Item_Type) REFERENCES Inventory(Item, Item_Type)"+
				" ON DELETE CASCADE);";


				   //System.out.println("Enter the name of the Table");
   
				   //String TBName = getDBNameObj.nextLine();
   
				   Statement UrazsOrder = conn.createStatement();

				   int resultOfQuery = UrazsOrder.executeUpdate(sql);
				

	        	 System.out.println("Table is created");	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }
		
	public void InsertPlayerTable(){

		String sql = "INSERT INTO Player  VALUES(?,?,?,?)";
		Connection conn = null;

		String line = "";
		String splitBy = ",";

		String fileName= "Customers.csv";
		String[] Player;

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));

			br.readLine();
			while ((line = br.readLine()) != null){

				System.out.println("Acc oooooooooob4 " + line);

				Player = line.split(splitBy);
				System.out.println(Player[0]);
				try{
					conn = this.connect();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,Integer.parseInt(Player[0]));
					pstmt.setString(2, Player[2]);
					pstmt.setString(3, Player[1]);
					pstmt.setInt(4,Integer.parseInt(Player[9]));
					pstmt.executeUpdate();
		
				} catch (SQLException e){
					System.out.println(e.getMessage());
				}finally { try {
					if (conn != null){
						conn.close();
					}
				}catch (SQLException ex){
					System.out.println(ex.getMessage());
				}}
				//System.out.println("Player[Account_Number=" + Player[1] + ", Forename=" + Player[2] + ", surname=" + Player[3] + ", ExperiencePoints=" + Player[4] + ", ExpiryDate=" + Player[5] + ", Character_CreationDate=" + Player[6] + "]");
			}
			br.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void InsertCharacterTable(){

		String sql = "INSERT INTO Character  VALUES(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;

		String line = "";
		String splitBy = ",";

		String fileName= "Customers.csv";
		String[] Character;

		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));

			br.readLine();
			while ((line = br.readLine()) != null){


				Character = line.split(splitBy);
				try{
					conn = this.connect();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,Character[6]);
					pstmt.setInt(2, Integer.parseInt(Character[13]));
					pstmt.setInt(3, Integer.parseInt(Character[10]));
					pstmt.setInt(4,Integer.parseInt(Character[16]));
					pstmt.setInt(3, Integer.parseInt(Character[11]));
					pstmt.setString(3, Character[7]);
					pstmt.setInt(3, Integer.parseInt(Character[8]));
					pstmt.setInt(3, Integer.parseInt(Character[0]));
					pstmt.setString(3, Character[4]);

					pstmt.executeUpdate();
		
				} catch (SQLException e){
					System.out.println(e.getMessage());
				}finally { try {
					if (conn != null){
						conn.close();
					}
				}catch (SQLException ex){
					System.out.println(ex.getMessage());
				}}
				//System.out.println("Player[Account_Number=" + Player[1] + ", Forename=" + Player[2] + ", surname=" + Player[3] + ", ExperiencePoints=" + Player[4] + ", ExpiryDate=" + Player[5] + ", Character_CreationDate=" + Player[6] + "]");
			}
			br.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
   
	 public void PrintTable() 
	 {
		 Connection conn = null;
		 Scanner getDBNameObj = new Scanner(System.in);
	        try {
	        	System.out.println("PrintTable");
	            conn = this.connect();
	            System.out.println("Enter the name of the Table");
	        	String TBName = getDBNameObj.nextLine(); 
	        	Statement UrazsQuery = conn.createStatement();
	        	ResultSet UrazsAnswer = UrazsQuery.executeQuery("SELECT * FROM "+TBName+"; ");
	        	if(UrazsAnswer.next()==false)
	        		System.out.println("Empty Table");
	        	else
	        	{
	        		String stname = UrazsAnswer.getString(1);
	        		int stage =  UrazsAnswer.getInt("STAGE");
	        		String stid = UrazsAnswer.getString(3);
	        		System.out.println(stname+" " + stage + " " + stid);
	        		while(UrazsAnswer.next())
		        	{
		        		stname = UrazsAnswer.getString(1);
		        		stage =  UrazsAnswer.getInt(2);
		        		stid = UrazsAnswer.getString(3);
		        		System.out.println(stname+" " + stage + " " + stid);
		        	}	
	        	}
	        	
	        	
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally { try {
	        	
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        	}}
	        
	    }
		/**
	     * @param args the command line arguments
	     */

		 public static void main(String[] args) {
			Database db = new Database();
			
			//Connection connected = db.connect();
			db.CreatePlayerTable();
			db.CreateCharacterTable();
			db.CreateCombatTable();
			db.CreateInventoryTable();
			db.CreateWeaponTable();
			db.CreateSuppliesTable();
			db.CreateArmourTable();

			db.InsertPlayerTable();
			db.InsertCharacterTable();
			
			

			//db.PrintTable(connected);
	
		}
	   
}



