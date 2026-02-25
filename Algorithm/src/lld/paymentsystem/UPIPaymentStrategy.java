package lld.paymentsystem;

public class UPIPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String upiId = request.getPaymentDetails().get("upiId");
    System.out.println("Processing UPI payment for " + upiId);
    return new Response(true, "UPI Payment Successful");
  }
}
