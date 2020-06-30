// 
// Decompiled by Procyon v0.5.36
// 

package bot.model;

import java.util.LinkedList;
import java.util.List;

public class ResultScrapePhones
{
    private int amountSuccessCreatedAccounts;
    private int amountDontSuccessAccounts;
    private List<Throwable> throwables;
    private int revolutUserAmount;
    private int notRevolutUserAmount;
    private String result;
    
    public ResultScrapePhones() {
        this.throwables = new LinkedList<Throwable>();
    }
    
    public int getAmountSuccessCreatedAccounts() {
        return this.amountSuccessCreatedAccounts;
    }
    
    public void setAmountSuccessCreatedAccounts(final int amountSuccessCreatedAccounts) {
        this.amountSuccessCreatedAccounts = amountSuccessCreatedAccounts;
    }
    
    public void addAmountSuccessCreatedAccounts(final int amountSuccessCreatedAccounts) {
        this.amountSuccessCreatedAccounts += amountSuccessCreatedAccounts;
    }
    
    public List<Throwable> getThrowables() {
        return this.throwables;
    }
    
    public void setThrowables(final List<Throwable> throwables) {
        this.throwables = throwables;
    }
    
    public int getAmountDontSuccessAccounts() {
        return this.amountDontSuccessAccounts;
    }
    
    public void setAmountDontSuccessAccounts(final int amountDontSuccessAccounts) {
        this.amountDontSuccessAccounts = amountDontSuccessAccounts;
    }
    
    public void addAmountDontSuccessAccounts(final int amountDontSuccessAccounts) {
        this.amountDontSuccessAccounts += amountDontSuccessAccounts;
    }
    
    public void addNewThrowable(final Throwable throwable) {
        this.throwables.add(throwable);
    }
    
    public int getRevolutUserAmount() {
        return this.revolutUserAmount;
    }
    
    public void setRevolutUserAmount(final int revolutUserAmount) {
        this.revolutUserAmount = revolutUserAmount;
    }
    
    public void addRevolutUser(final int amountRevolutUsers) {
        this.revolutUserAmount += amountRevolutUsers;
    }
    
    public void addNotRevolutUser(final int amountNotRevolutUser) {
        this.notRevolutUserAmount += amountNotRevolutUser;
    }
    
    public int getNotRevolutUserAmount() {
        return this.notRevolutUserAmount;
    }
    
    public void setNotRevolutUserAmount(final int notRevolutUserAmount) {
        this.notRevolutUserAmount = notRevolutUserAmount;
    }
    
    public String getResult() {
        return this.result;
    }
    
    public void setResult(final String result) {
        this.result = result;
    }
}
