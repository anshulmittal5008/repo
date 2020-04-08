package com.arithmetic.demo.web;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arithmetic.demo.model.ArithmeticEntity;
import com.arithmetic.demo.service.ArithmeticService;
 
@Controller
@RequestMapping("/arithmetic")
public class ArithmeticController
{
    @Autowired
    ArithmeticService service;
    
    @RequestMapping(value="/listArithmeticExpression", method=RequestMethod.GET)
    public String listArithmeticExpressionsList(Model model) {
        List<ArithmeticEntity> arithmeticExpressionsList = service.getAllArithmeticExpressions();

        model.addAttribute("arithmeticExpressions", arithmeticExpressionsList);

        return "listArithmeticExpressions";
    }
    
    @RequestMapping(value="/evaluateArithmeticExpressionPage", method=RequestMethod.GET)
    public String evaluateArithmeticExpressionPage() {
        return "evaluateArithmeticExpression";
    }

    @RequestMapping(value="/evaluateArithmeticExpression", method=RequestMethod.POST)
    public String evaluateArithmeticExpression(@RequestParam("arithmeticExpression") String arithmeticExpression, ModelMap modelMap) {
    	if(arithmeticExpression != null && !"".equalsIgnoreCase(arithmeticExpression))
    	{
    		arithmeticExpression = arithmeticExpression.replaceAll("\\((.+?)\\)", "$1").trim();
    		String[] operator = arithmeticExpression.split("[0-9]+");
    		String[] digits = arithmeticExpression.split("[+-\\/*]");

    		final int[] index = {0};
    		int result = Stream.of(digits)
    		                    .mapToInt(Integer::parseInt)
    		                    .reduce(0, (int t, int u) -> 
    		{
    		    int output = Integer.parseInt(digits[0]);
    		    int i = index[0];
    		    if (operator[i].equals("+")) { output = t + u; } 
    		    else if (operator[i].equals("/")) { output = t / u; } 
    		    else if (operator[i].equals("*")) { output = t * u; } 
    		    else if (operator[i].equals("-")) { output = t - u; }  
    		    index[0]++;
    		    return output;
    		}); 
    		modelMap.put("arithmeticExpression", arithmeticExpression);
            modelMap.put("result", Integer.toString(result));
    	}
         return "arithmeticExpressionResult"; 
    }
 
}