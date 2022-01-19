package service;

import model.Transactions;
import model.User;
import util.GenericLinkedList;
import util.ResourceNotFoundException;

public interface AccountService {

    public User addUser(User u);
    public User getUser(String userName);
    public User updateUser(User update);
    public User deleteUser(String userName) throws ResourceNotFoundException;
    public Transactions updateTransaction(Transactions update);
    public GenericLinkedList<Transactions> getTransaction();

}
