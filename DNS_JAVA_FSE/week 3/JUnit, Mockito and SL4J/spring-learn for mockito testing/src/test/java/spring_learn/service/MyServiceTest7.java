package spring_learn.service;

import static org.mockito.Mockito.inOrder;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.mock;

public class MyServiceTest7 {

    @Test
    void testInteractionOrder() {

        ExternalApi api = mock(ExternalApi.class);

        MyService service = new MyService(api);

        service.process();

        InOrder order = inOrder(api);

        order.verify(api).connect();

        order.verify(api).fetchData();

        order.verify(api).disconnect();

    }

}