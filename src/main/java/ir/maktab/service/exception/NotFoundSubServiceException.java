package ir.maktab.service.exception;

public class NotFoundSubServiceException extends Throwable {
    public NotFoundSubServiceException(String sub_service_not_found) {
        super(sub_service_not_found);
    }
}
