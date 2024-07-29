package woojjam.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import woojjam.advanced.trace.threadlocal.code.FieldService;

@Slf4j
public class FieldServiceTest {

	private FieldService service = new FieldService();

	@Test
	public void field() throws Exception {
	    log.info("main start");
		Runnable userA = () -> {
			service.logic("userA");
		};
		
		Runnable userB = () -> {
            service.logic("userB");
        };

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
		// sleep(2000); // 동시성 문제 발생 X
		sleep(100); // 동시성 문제 발생 O
		threadB.start();

		sleep(2000);
		log.info("main exit");
	}

	private void sleep(int mills) {
		try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
