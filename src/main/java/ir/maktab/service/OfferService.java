package ir.maktab.service;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.UserOrdersFilterDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.*;

import java.util.List;

public interface OfferService {
    void saveNewOffer(OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException, NotFoundExpertException, NotFoundOrderException;

    void deleteOffer(OfferDto dto);

    void updateOffer(OfferDto dto);

    List<OfferDto> fetchAllOffers();

    List<OfferDto> getOrderOffersSortByRateAndPrice(CustomerDto dto,Integer id ) throws NotFoundCustomerException, NotFoundOrderException, NotFoundOfferForOrder;
    void changeSituation(Integer id) throws NotFoundOrderException;
    OfferDto paymentFromAccountCredit(Integer id,CustomerDto dto) throws NotFoundOrderException, NotFoundCustomerException, NotEnoughAccountBalance;

    void onlinePayment(OrderDto orderDto) throws NotFoundCustomerException;

}
