package ir.maktab.service.exception;

public class NotFoundOfferForOrder extends Throwable {
    public NotFoundOfferForOrder(String notFoundOfferForOrder) {
        super(notFoundOfferForOrder);
    }
}
