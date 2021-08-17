package com.springboot.payment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.payment.model.Employee;
import com.springboot.payment.model.Response;




@RunWith(SpringRunner.class)
@SpringBootTest
class SpringMokitoApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;         

	ObjectMapper om=new ObjectMapper();
	
	@Before(value = "")
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addEmployee() throws Exception {
		
		Employee employee=new Employee();
		employee.setName("Jaga");
		employee.setDept("IT");
		String jsonRequest=om.writeValueAsString(employee);
		MvcResult result= mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest)
				             .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect( status().isOk()).andReturn();
		String resultContent=result.getRequest().getContentAsString();
		Response response=om.readValue(resultContent,Response.class);
		Assert.assertTrue(response.isStatus()==Boolean.TRUE);
		
	}
}