package week6.lab38AccountManager;

/*
    Для работы с банковским счетом отдельного пользователя был разработан абстрактный класс Account.
    Поле amount хранит сумму на счете пользователя.
    Метод change(int delta) throws TryAgainException, BlockAccountException изменяет счет пользователя на значение дельты. Дельта может быть отрицательной.
    Этот метод имеет две нестандратные ситуации:
    class TryAgainException extends Exception { }
    Метод сообщает о временной неудаче, что значит:
    1. Ничего не сделано.
    2. Необходимо попробывать вызвать метод еще раз (а потом еще раз, и т.д. пока операция не пройдет).
    class BlockAccountException extends Exception { }
    Метод сообщает о полном блокировании счета, что значит:
    1. Ничего не сделано.
    2. Нет смысла вызывать метод еще раз.
    AccountManager - часть системы, которую необходимо изменить. (Менеджер счетов).
    На вход подается массив счетов и массив дельт для изменения. Массивы одинаковой длинны.
    В теле метода используется следующий код: accounts[k].change(deltas[k]) для всего массива счетов.
    Если при работе со счетом возникает TryAgainException необходимо повторять ситуацию до появления положительного результата.
    При BlockAccountException необходимо сделать откат всех предыдущих изменений и завершить работу. Т.е вернуть деньги на счета, с которых уже успели снять/положить деньги.
    На выходе метод возвращает true/false.
    true - если получилось перевести деньги на все счета.
    false - во всех остальных случаях.
*/
public class AccountManager {

    public static boolean transfer(Account[] accounts, int[] delta) {
        for (int i = 0; i < accounts.length; i++) {
                try {
                    accounts[i].change(0);
                } catch (TryAgainException e) {
                    continue;
                } catch (BlockAccountException e) {
                    return false;
                }
        }

        for (int k = 0; k < accounts.length ; k++) {
            try {
                accounts[k].change(delta[k]);
            } catch (TryAgainException e) {
                k = k - 1;
                continue;
            } catch (BlockAccountException e) {
                return false;
            }
        }

        return true;
    }


}

abstract class Account {
    protected int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public abstract void change(int delta) throws TryAgainException, BlockAccountException;

    public int getAmount() {
        return amount;
    }
}


class TryAgainException extends Exception {
}

class BlockAccountException extends Exception {

}