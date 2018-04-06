package webshop.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import webshop.domain.Aanbieding;

public class SaleDAO extends BaseDAO{
	  public SaleDAO() {
	    }

	    /**
	     * Made it so that this func retrieves all rules and not rules based on id
	     *
	     * @return
	     */
	    public ArrayList<Aanbieding> getAllSales() {
	    	ArrayList<Aanbieding> list=new ArrayList<Aanbieding>();
	        try (Connection conn = super.getConnection()) {
	            PreparedStatement statement = conn.prepareStatement("SELECT * from Aanbiedingen ORDER BY id desc");
	            statement.executeQuery();
	            ResultSet rs = statement.executeQuery();

	            int id;
	            double prijs;
	            String tekst; 
	            String vand;
	            String totd;
	            int productid;
	            Date vandatum;
	            Date totdatum;
	            Aanbieding a=null;
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            
	            
	            while (rs.next()) {
	                id = rs.getInt("id");
	                prijs = rs.getDouble("prijs");
	                tekst = rs.getString("tekst");
	                vand=rs.getString("vandatum");
	                vandatum=format.parse(vand);
	                totd=rs.getString("totdatum");
	                totdatum=format.parse(totd);
	                productid=rs.getInt("productid");
	                a=new Aanbieding(id, prijs,tekst,vandatum,totdatum, productid);
	                list.add(a);
	            }
	            rs.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       catch (java.text.ParseException e) {
				e.printStackTrace();
			}
	        return list;
	    }
	    public Aanbieding getSaleByProductID(int pid) {
	    	Aanbieding a=null;
	        try (Connection conn = super.getConnection()) {
	            PreparedStatement statement = conn.prepareStatement("SELECT * from Aanbiedingen WHERE productid="+pid);
	            statement.executeQuery();
	            ResultSet rs = statement.executeQuery();

	            int id;
	            double prijs;
	            String tekst; 
	            String vand;
	            String totd;
	            int productid;
	            Date vandatum;
	            Date totdatum;
	  
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	            while (rs.next()) {
	                id = rs.getInt("id");
	                prijs = rs.getDouble("prijs");
	                tekst = rs.getString("tekst");
	                vand=rs.getString("vandatum");
	                vandatum=format.parse(vand);
	                totd=rs.getString("totdatum");
	                totdatum=format.parse(totd);
	                productid=rs.getInt("productid");
	                a=new Aanbieding(id, prijs,tekst,vandatum,totdatum, productid);
	            }
	            rs.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       catch (java.text.ParseException e) {
				e.printStackTrace();
			}
	        return a;
	    }
}
