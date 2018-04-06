package webshop.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BestellingDAO extends BaseDAO{
ProductDAO dao=new ProductDAO();
KlantDAO dao2=new KlantDAO();
	public BestellingDAO(){
	}
	public ArrayList<Bestelling> getAllBestellingen(){
		 ArrayList<Bestelling> list=new ArrayList<Bestelling>();
		try (Connection conn = super.getConnection()) {
	           PreparedStatement statement = conn.prepareStatement("SELECT * from  Bestellingen");
	           statement.executeQuery();
	           ResultSet rs = statement.executeQuery();

	           int id;
	           int klantid;
	           ArrayList<Bestellingsregel>lijst=new ArrayList<Bestellingsregel>();
	           Adres adres=null;;
	           Bestelling best=null;

	           while (rs.next()) {
	               id = rs.getInt("id");
	               klantid = rs.getInt("klantid");
	               lijst=getBestellingsRegelsByOrderID(id);
	               adres=dao2.getAdresByID(rs.getInt("adresid"));
	               best=new Bestelling(id,klantid,lijst,adres);
	               list.add(best);
	           }
	           rs.close();
	           statement.close();
	           conn.close();
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return list;
	   }
public ArrayList<Bestellingsregel> getBestellingsRegelsByOrderID(int ordid){
	 ArrayList<Bestellingsregel> list=new ArrayList<Bestellingsregel>();
	try (Connection conn = super.getConnection()) {
           PreparedStatement statement = conn.prepareStatement("SELECT * from  Bestellingregels where Orderid=?");
           statement.setInt(1, ordid);
           statement.executeQuery();
           ResultSet rs = statement.executeQuery();

           int id;
           int aantal;
           double prijs;
           Product product;
           Bestellingsregel regel=null;

           while (rs.next()) {
               id = rs.getInt("id");
               aantal = rs.getInt("aantal");
               product=dao.getProductByID(rs.getInt("Productid"));
               prijs=aantal*product.getPrijs();
               regel=new Bestellingsregel(id,aantal,prijs,product);
               list.add(regel);
           }
           rs.close();
           statement.close();
           conn.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }
public Bestelling getBestellingByID(int bestid){
	 Bestelling bestel=null;
	try (Connection conn = super.getConnection()) {
          PreparedStatement statement = conn.prepareStatement("SELECT * from  Bestellingen where id=?");
          statement.setInt(1, bestid);
          statement.executeQuery();
          ResultSet rs = statement.executeQuery();

          int id;
          int klantid;
          ArrayList<Bestellingsregel>lijst=new ArrayList<Bestellingsregel>();
          Adres adres=null;;
          Bestelling best=null;

          while (rs.next()) {
              id = rs.getInt("id");
              klantid = rs.getInt("klantid");
              lijst=getBestellingsRegelsByOrderID(id);
              adres=dao2.getAdresByID(rs.getInt("adresid"));
              best=new Bestelling(id,klantid,lijst,adres);
              bestel=best;
          }
          rs.close();
          statement.close();
          conn.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return bestel;
  }
}

