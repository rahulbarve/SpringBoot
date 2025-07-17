package example.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController //Marks this class as an implementation class for REST Endpoints
public class RestImpl {//This class is meant for exposing REST Endpoints
	//End Point: /do-greet => Response: "Welcome to REST"
	@RequestMapping("/do-greet")//Marks this method as Request Handling method.
	public String doGreet() {
		return "Welcome to my first REST demo";
	}
	
	//End Point: /get-message => Response: Message Object (content, deliveredOn)
	@RequestMapping("/get-message")
	public Message getMessage() {
		return new Message();
	}
	
	//End Point: /get-all-messages => Response: Message Objects
	@RequestMapping("/get-all-messages")
	public List<Message> getAllMessages(){
		Message msg = new Message();
		Message msg2 = new Message("Bye Bye 2024", LocalDate.of(2024, 12, 31));
		Message msg3 = 
			new Message("Happy Independence Day", LocalDate.of(2024, 8, 15));
		List<Message> listOfMessages = List.of(msg, msg2, msg3);
		return listOfMessages;
	}
}










