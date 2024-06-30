package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        users.put(user, accounts);
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> user : users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                return user.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);

        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null) {
            return false;
        }

        double sourceBalance = sourceAccount.getBalance();
        double destinationBalance = destinationAccount.getBalance();
        if (sourceBalance - amount < 0) {
            return false;
        }

        sourceBalance -= amount;
        destinationBalance += amount;
        sourceAccount.setBalance(sourceBalance);
        destinationAccount.setBalance(destinationBalance);

        List<Account> sourceAccounts = getAccounts(sourceUser);
        List<Account> destinationAccounts = getAccounts(destinationUser);
        sourceAccounts.remove(findByRequisite(sourcePassport, sourceRequisite));
        sourceAccounts.add(sourceAccount);
        destinationAccounts.remove(findByRequisite(destinationPassport, destinationRequisite));
        destinationAccounts.add(destinationAccount);

        users.put(sourceUser, sourceAccounts);
        users.put(destinationUser, destinationAccounts);
        return true;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}