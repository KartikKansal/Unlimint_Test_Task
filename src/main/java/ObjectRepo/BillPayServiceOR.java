package ObjectRepo;

public interface BillPayServiceOR extends BaseOR {
    String PayeeName = "//input[@name='payee.name']";
    String PayeeAddress = "//input[@name='payee.address.street']";
    String PayeeCity = "//input[@name='payee.address.city']";
    String PayeeState = "//input[@name='payee.address.state']";
    String PayeeZipCode = "//input[@name='payee.address.zipCode']";
    String PayeePhone = "//input[@name='payee.phoneNumber']";
    String PayeeAccNo = "//input[@name='payee.accountNumber']";
    String PayeeVerifyAccNo = "//input[@name='verifyAccount']";
    String PayeeAmount = "//input[@name='amount']";
    String SendPaymentBtn = "//input[@value='Send Payment']";
    String fromAccountId = "//select[@name='fromAccountId']";
    String AmountS = "#amount";
    String fromAccountIdS = "#fromAccountId";
    String payeeName = "#payeeName";
}
