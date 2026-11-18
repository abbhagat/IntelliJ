package lld.paymentsystem;

public class BankTransferPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String account = request.paymentDetails().get("accountNumber");
    String ifsc = request.paymentDetails().get("ifsc");
    System.out.println("Processing Bank Transfer via IFSC " + ifsc + " to " + account);
    return new Response(200, "Bank Transfer Successful");
  }
}
