package ir.maktab.service.exception;

public class NotFoundCustomerException extends Throwable {
    public NotFoundCustomerException(String customer_is_not_available) {
        super(customer_is_not_available);
    }
}
