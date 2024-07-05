package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простейшую работу с моделями данных Account и User.
 * @author MIKHAIL ZENKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Класс содержит единственную переменную users, которая хранит всех пользователей
     * в коллекции HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в хранилище нового пользователя, если отсутствует аналогичный,
     * и для пользователя создается пустой список банковских счетов.
     * @param user пользователь добавляется в хранилище HashMap
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из хранилища по паспорту.
     * @param passport пасспорт для удаления по нему пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить бансковский счет определенному пользователю,
     * по паспорту которого предварительно проводится поиск.
     * Если пользователь не был найден, счет не будет добавлен.
     * @param passport пасспорт для поиска пользователя
     * @param account бансковский счет для добавления его найденному пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод проводит поиск пользователя по пасспорту через цикл foreach.
     * @param passport пасспорт для сравнения с пасспортом перебираемого пользователя
     * @return возвращает найденного пользователя или null, если ничего не нашлось
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод проводит поиск банковского счета пользователя, который предварительно
     * находится с помощью метода findByPassport. С помощью цикла foreach
     * перебираются все банковские счета пользователя.
     * @param passport пасспорт для определение пользователя
     * @param requisite реквизит для поиска банковского счета
     * @return возвращает найденный банковский счет или null, если пользователь
     * или счет не были найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод производит перевод средств с одного банковского счета на другой.
     * Проводится поиск банковских счетов с помощью метода findByRequisite, и
     * проводится списание средств и отправителя и пополнение их получателю.
     * @param sourcePassport пасспорт для нахождения пользователя-отправителя
     * @param sourceRequisite реквизит для нахождения банковского счет
     *                        пользователя-отправителя
     * @param destinationPassport пасспорт для нахождения пользователя-получателя
     * @param destinationRequisite реквизит для нахождения банковского счета
     *                             пользователя-получателя
     * @param amount сумма перевода
     * @return возвращает false, если счета не были найдены или у отправителя не хватает средств
     * для перевода, и true, если перевод прошел успешно
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() - amount >= 0) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}