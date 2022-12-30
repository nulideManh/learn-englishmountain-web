package com.springboot.myenglish.util;

import org.springframework.stereotype.Controller;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DataUtils {

    //lấy số phần trăm
    public String percent(float remember,float number){
        // Tạo đối tượng định dạng số
        NumberFormat numberFormat = NumberFormat.getInstance();
        // Đặt chính xác thành số nguyên
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat.format(remember / number / 0.01) + "%";
    }
    //nhận số 1 phần trăm
    public String unpercent(float remember,float number){
        // Tạo đối tượng định dạng số
        NumberFormat numberFormat = NumberFormat.getInstance();
        // Đặt chính xác thành số nguyên
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat.format((1 - remember / number) / 0.01) + "%";
    }

    /**
     * lấy ngày được định dạng
     */
    public Date getDate() throws ParseException {
        //Lấy ngày hiện tại - Ngày hiện tại bằng tiếng Anh
        Date date = new Date();

        //đặt định dạng ngày
        SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy" );
        //Bây giờ ngày là yyyy-MM-dd, thuộc loại Chuỗi
        String formatDate = format.format(date);
        //Chuyển đổi loại chuỗi thành loại ngày tháng

        return format.parse(formatDate);
    }

}

