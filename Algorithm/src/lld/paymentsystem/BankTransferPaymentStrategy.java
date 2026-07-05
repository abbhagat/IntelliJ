package lld.paymentsystem;

public class BankTransferPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String account = request.getPaymentDetails().get("accountNumber");
    String ifsc = request.getPaymentDetails().get("ifsc");
    System.out.println("Processing Bank Transfer via IFSC " + ifsc + " to " + account);
    return new Response(200, "Bank Transfer Successful");
  }
}
