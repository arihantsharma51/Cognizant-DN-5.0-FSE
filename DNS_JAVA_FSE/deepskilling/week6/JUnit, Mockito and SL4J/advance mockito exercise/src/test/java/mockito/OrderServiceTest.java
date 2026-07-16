package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testSequentialReturnValues() {

        StatusRepository mockRepository = mock(StatusRepository.class);

        when(mockRepository.getOrderStatus())
                .thenReturn("Pending",
                            "Processing",
                            "Completed");

        OrderService orderService = new OrderService(mockRepository);

        assertEquals("Pending", orderService.checkStatus());

        assertEquals("Processing", orderService.checkStatus());

        assertEquals("Completed", orderService.checkStatus());
    }

}