import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static org.hamcrest.CoreMatchers.is;

public class test6 {
    public List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.getInstance(Locale.KOREA), 1500.0),
            new Transaction(Currency.getInstance(Locale.US), 2300.0)
    );

    @Test
    public void test(){
        Map<Currency, List<Transaction>> comparative = new HashMap<>();

        for (Transaction transaction : transactions){
            Currency currency= transaction.getCurrency();
            List<Transaction> transactionsForCurrency = comparative.get(currency);
            if(transactionsForCurrency==null){
                transactionsForCurrency = new ArrayList<>();
                comparative.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        Map<Currency, List<Transaction>> control = transactions.stream().collect(groupingBy(Transaction::getCurrency));

        Assert.assertThat(comparative,is(control));
    }

    private class Transaction {
        private final double value;
        private final Currency currency;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return this.currency;
        }
    }
}
