package com.team4.ysms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team4.ysms.common.PaymentInfo;
import com.team4.ysms.common.ReservationInfo;
import com.team4.ysms.dao.Dao_Reservation;
import com.team4.ysms.dao.Dao_Share;
import com.team4.ysms.dto.Dto_Payment;
import com.team4.ysms.dto.Dto_Share;

public class paymentResultDetailViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int rentalNo = Integer.parseInt(request.getParameter("hn"));
		System.out.println("paymentResultDetailViewCommand : " + rentalNo);
		
		
		Dao_Reservation resDao = new Dao_Reservation();
		Dto_Payment payDto = resDao.findRental(rentalNo);
		PaymentInfo.dto_payment = payDto;
		
		Dao_Share detailDao = new Dao_Share();
		Dto_Share detailDto = detailDao.rDetail(payDto.getPlace_no());
		ReservationInfo.detail = detailDto;
		
		
		request.setAttribute("DETAIL", detailDto);
		request.setAttribute("DTO", payDto);

	}

}
