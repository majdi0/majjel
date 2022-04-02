package com.majjel.majjel.tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolsController {

	@GetMapping("/tools")
	public String tools() {
		return "tools";
	}
	
	//Dynamic views
		@GetMapping("/tools/nmap")
		public String subnetCalc() {
			return "tools/nmap";
		}
		
		
		@GetMapping("/tools/google")
		public String hash() {
			return "tools/google";
		}

}
