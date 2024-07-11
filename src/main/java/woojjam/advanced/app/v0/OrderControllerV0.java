package woojjam.advanced.app.v0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

	private final OrderServiceV0 orderService;

	@GetMapping("/v0/request")
	public String request(String itemId) throws InterruptedException {
		orderService.orderItem(itemId);
		return "OK";
    }
}
