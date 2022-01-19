package repositories;

import model.Transactions;
import model.User;
import util.GenericLinkedList;
import util.JDBCConnection;
import util.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepoDBImpl implements AccountRepo{

    Connection con = JDBCConnection.getConnection();

    @Override
    public User addUser(User u) {
        String sql = "INSERT INTO users VALUES (?,?,??) RETURNING*";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getExtraUser());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return  userCreate(rs);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public User getUser(String userName) {

        String sql = "SELECT * FROM  users  WHERE username =? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return  userCreate(rs);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public User deleteUser(String userName) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public User updateUser(User update) {

        String sql = "UPDATE users set first_name=?, last_name=?, extra_user=? WHERE username =? RETURNING*";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, update.getUserName());
            ps.setString(2, update.getFirstName());
            ps.setString(3, update.getLastName());
            ps.setString(4, update.getExtraUser());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return  userCreate(rs);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Transactions updateTransaction(Transactions update) {
        String sql = "UPDATE transaction set deposit=?, withdrawal=?, amount=? WHERE username =? RETURNING*";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, update.getDeposit());
            ps.setDouble(2, update.getWithdrawal());
            ps.setDouble(3, update.getAmount());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return createTransactions(rs);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public GenericLinkedList<Transactions> getTransaction() {
        String sql = "SELECT * FROM transactions";

        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs =  ps.executeQuery();
            GenericLinkedList<Transactions> transactions = new GenericLinkedList<Transactions>();
            while(rs.next()){
                transactions.add(createTransactions(rs));
            }
            return transactions;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private User userCreate(ResultSet rs) throws SQLException {
        User u = new User();
         u.setUserName(rs.getString("username"));
         u.setFirstName(rs.getString("first_name"));
        u.setLastName(rs.getString("last_name"));
        u.setExtraUser(rs.getString("extra_user"));
        return u;
    }

    private Transactions createTransactions(ResultSet rs) throws SQLException{
        Transactions t = new Transactions();
        t.setDeposit(rs.getDouble("deposit"));
        t.setWithdrawal(rs.getDouble("withdrawal"));
        t.setAmount(rs.getDouble("amount"));
        return t;
    }
}
