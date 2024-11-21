package com.wipro.velocity.ims.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BitPayController {

	@RequestMapping("/bitpay")
    public String viewProducts() {
       return "bit_pay";
    }
}
