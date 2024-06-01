package com.dao;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.entity.ProductOrder;

public class demo {
	public static void main(String[] args) {

		// if(dao.getOrderByDate(l.toString()))
//			{
//				
//				list.add(dao.getOrderByDateDtls(l.toString()));
//			}

		/*
		 * LocalDate startDate = LocalDate.of(2023, Month.MAY, 10);
		 * 
		 * LocalDate endDate = LocalDate.of(2023, Month.MAY, 23);
		 * 
		 * List<LocalDate> dateList =
		 * startDate.datesUntil(endDate).collect(Collectors.toList());
		 * 
		 * OrderDao dao = new OrderDao();
		 */
//		List<ProductOrder> list = new ArrayList<>() ;
//		
//		for (LocalDate l : dateList) {
//			list = dao.getAllOrder().stream().filter(e -> dao.getOrderByDate(l.toString()))
//					.collect(Collectors.toList());				
//		}
//		
//		
//		dateList.stream().
//		
//		System.out.println(list.size());
//		list.forEach(e -> System.out.println(e.getId()+"="+e.getOrderStatus() + "=" + e.getOrderDate()));

		/*
		 * List<ProductOrder> finalList = new ArrayList<>();
		 * 
		 * for (LocalDate l : dateList) { List<ProductOrder> list =
		 * dao.getOrderByDateDtls(l.toString()); list.forEach(e -> finalList.add(e)); }
		 * 
		 * finalList.forEach(e->System.out.println(e.getId()+"-"+e.getOrderDate()+"-"+e.
		 * getOrderStatus()));
		 */

		/*
		 * LocalDate startDate = LocalDate.parse("2023-05-07"); LocalDate endDate =
		 * LocalDate.parse("2023-05-23");
		 * 
		 * List<LocalDate> dateList =
		 * startDate.datesUntil(endDate).collect(Collectors.toList());
		 * 
		 * long days = ChronoUnit.DAYS.between(startDate, endDate);
		 * 
		 * List<LocalDate> dateList = Stream.iterate(startDate, localDate ->
		 * localDate.plusDays(1)).limit(days) .collect(Collectors.toList());
		 * 
		 * 
		 * OrderDao dao = new OrderDao();
		 * 
		 * List<ProductOrder> finalList = new ArrayList<>();
		 * 
		 * for (LocalDate l : dateList) { List<ProductOrder> list =
		 * dao.getOrderByDateDtls(l.toString()); for (ProductOrder p : list) {
		 * finalList.add(p); } }
		 * 
		 * for (ProductOrder p : finalList) { System.out.println(p.getId());
		 * 
		 * }
		 */
		
		
		
	

		float discountPrice=(400*5/100);
		
		
		System.out.println(discountPrice);
		//Double pr = Double.parseDouble(p.getPrice()) - discountPrice;
		
		
	}
}
