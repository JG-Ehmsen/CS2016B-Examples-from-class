/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2016bfxmlandtransactions.DAL;

import cs2016bfxmlandtransactions.BE.BankAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppjleemoritzled
 */
public class BankAccountDBManager
{
    private final ConnectionManager cm = 
            new ConnectionManager();
    
    public void updateBankAccount(BankAccount account)
    {
        String sql =
           "UPDATE Customer " + 
           "SET balance=? " +
           "WHERE accountnumber=?";
        
        try (Connection con = cm.getConnection())
        {
            PreparedStatement pstmt =
                    con.prepareStatement(sql);
            pstmt.setFloat(1, account.getBalance());
            pstmt.setInt(2, account.getAccountNumber());
            pstmt.execute();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BankAccountDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BankAccount getBankAccount(int accountNumber)
    {
        BankAccount account = null;
        
        String sql = 
            "SELECT * FROM Customer WHERE accountnumber=?";
        
        try(Connection con = cm.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
            
            ResultSet rs = pstmt.executeQuery();
            rs.next(); // Point to first result
            
            account = new BankAccount(accountNumber);
            account.setBalance(rs.getFloat("balance"));
            
            return account;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BankAccountDBManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
