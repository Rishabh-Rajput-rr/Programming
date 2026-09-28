package com.interview.tier3;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TransactionAggregation {
    public enum Type { CREDIT, DEBIT }
    public enum Status { SUCCESS, FAILED }
    public record Transaction(String account, Type type, Status status, Double amount) {}
    public record Summary(double credit, double debit) {
        public Summary add(Transaction t) { return t.type()==Type.CREDIT ? new Summary(credit+t.amount(),debit) : new Summary(credit,debit+t.amount()); }
    }

    // Custom collector: filters invalid/failed transactions and preserves account insertion order.
    public static LinkedHashMap<String, Summary> stream(List<Transaction> txns) {
        return txns.stream()
                .filter(Objects::nonNull)
                .filter(t -> t.account()!=null && t.type()!=null && t.status()==Status.SUCCESS && t.amount()!=null)
                .collect(Collectors.groupingBy(Transaction::account, LinkedHashMap::new,
                        Collector.of(() -> new Summary[]{new Summary(0,0)},
                                (box,t)->box[0]=box[0].add(t),
                                (a,b)->new Summary[]{new Summary(a[0].credit()+b[0].credit(),a[0].debit()+b[0].debit())},
                                box->box[0])));
    }

    public static void main(String[] args){
        List<Transaction> t=Arrays.asList(new Transaction("A",Type.CREDIT,Status.SUCCESS,100.0),new Transaction("A",Type.DEBIT,Status.SUCCESS,30.0),new Transaction("B",Type.CREDIT,Status.FAILED,500.0));
        System.out.println(stream(t));
    }
}
