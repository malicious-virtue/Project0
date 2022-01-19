package service;

import model.Transactions;
import model.User;
import repositories.AccountRepo;
import util.GenericLinkedList;
import util.ResourceNotFoundException;

public class AccountServiceImpl  implements AccountService{

    private AccountRepo ar;

    public AccountServiceImpl(AccountRepo ar) {
        this.ar = ar;
    }

    @Override
    public User addUser(User u) {
        return ar.addUser(u);
    }

    @Override
    public User getUser(String userName) {
        return ar.getUser(userName);
    }

    @Override
    public User updateUser(User update) {
        return ar.updateUser(update);
    }

    @Override
    public User deleteUser(String userName) throws ResourceNotFoundException {
        return ar.deleteUser(userName);
    }

    @Override
    public Transactions updateTransaction(Transactions update) {
        return ar.updateTransaction(update);
    }

    @Override
    public GenericLinkedList<Transactions> getTransaction() {
        return ar.getTransaction();
    }
}
