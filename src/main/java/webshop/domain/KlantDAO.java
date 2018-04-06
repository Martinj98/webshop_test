package webshop.domain;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;

import webshop.domain.Account;
import webshop.domain.Adres;
import webshop.domain.Klant;

public class KlantDAO extends BaseDAO{

    public KlantDAO() {
    }

    /**
     * Made it so that this func retrieves all rules and not rules based on id
     *
     * @return
     */
    public ArrayList<Klant> getAllKlanten() {
    	ArrayList<Klant> list=new ArrayList<Klant>();
        try (Connection conn = super.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * from Klanten ORDER BY id desc");
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();

            int id;
            String naam;
            String geslacht; 
            int tel;
            String geboortedatum;
            String email;
            Klant klant=null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date;

            while (rs.next()) {
                id = rs.getInt("id");
                naam = rs.getString("naam");
                geslacht = rs.getString("geslacht");
                tel=rs.getInt("telefoonnummer");
                geboortedatum=rs.getString("geboortedatum");
                date=format.parse(geboortedatum);
                email=rs.getString("email");
                Account acc=getAccountByID(rs.getInt("accountid"));
                Adres adres=getAdresByID(rs.getInt("woonadres"));
                java.sql.Blob blob = rs.getBlob("Afbeelding");
                InputStream in = blob.getBinaryStream();  
                BufferedImage image = ImageIO.read(in);
                klant=new Klant(id, naam,date,geslacht,email, tel, image,adres,acc);
                list.add(klant);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        } catch (java.text.ParseException e) {
			e.printStackTrace();
		}
        return list;
    }
    public Klant getKlantByID(int i) {
        Klant klant=null;
        try (Connection conn = super.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * from Klanten where id=?");
            statement.setInt(1, i);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();

            int id;
            String naam;
            String geslacht; 
            int tel;
            String geboortedatum;
            String email;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date;

            while (rs.next()) {
                id = rs.getInt("id");
                naam = rs.getString("naam");
                geslacht = rs.getString("geslacht");
                tel=rs.getInt("telefoonnummer");
                geboortedatum=rs.getString("geboortedatum");
                date=format.parse(geboortedatum);
                email=rs.getString("email");
                Account acc=getAccountByID(rs.getInt("accountid"));
                Adres adres=getAdresByID(rs.getInt("woonadres"));
                java.sql.Blob blob = rs.getBlob("Afbeelding");
                InputStream in = blob.getBinaryStream();  
                BufferedImage image = ImageIO.read(in);
                klant=new Klant(id, naam,date,geslacht,email, tel, image,adres,acc);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
        	e.printStackTrace();
        } catch (java.text.ParseException e) {
			e.printStackTrace();
		}
        return klant;
    }
    

    public Account getAccountByID(int i) {
        Account acc= null;
        try (Connection conn = super.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * from Accounts where id=?");
            statement.setInt(1, i);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();

            int id;
            String opendatum;
            boolean actief;
            String wachtwoord;
            Adres adres;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date;

            while (rs.next()) {
                id = rs.getInt("id");
                opendatum=rs.getString("opendatum");
                date = format.parse(opendatum);
                adres=getAdresByID(rs.getInt("adresid"));
                wachtwoord=rs.getString("wachtwoord");
                if(rs.getString("actief").equals("Y")){
                	actief=true;
                }
                else{
                	actief=false;
                }
                acc=new Account(date,adres,id,actief,wachtwoord);
            }
            rs.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
			e.printStackTrace();
		}
        return acc;
    }
    public Adres getAdresByID(int i) {
        Adres ad= null;
        try (Connection conn = super.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT * from Adressen where id=" + i);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();

            int id;
            String straat;
            String nummer; 

            while (rs.next()) {
                id = rs.getInt("id");
                straat= rs.getString("straat");
                nummer = rs.getString("straatnummer");
                ad=new Adres(id,straat,nummer);
            }
            rs.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ad;
    }
    public Klant getKlantByLogin(String email, String password){
    	int klantid=0;
    	Klant k=null;
    	try(Connection conn=super.getConnection()){
    	PreparedStatement statement = conn.prepareStatement("select klanten.id FROM klanten, accounts where klanten.EMAIL=? AND klanten.accountid in (SELECT id from accounts where wachtwoord=?) AND klanten.accountid=accounts.id");
        statement.setString(1, email);
    	statement.setString(2, password);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            klantid = rs.getInt("id");
        }
        
    	k=getKlantByID(klantid);
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}
    	return k;
}
}
