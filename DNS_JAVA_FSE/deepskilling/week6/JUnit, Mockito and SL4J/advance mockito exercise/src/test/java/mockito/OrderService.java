package mockito;

public class OrderService {

    private StatusRepository statusRepository;

    public OrderService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public String checkStatus() {
        return statusRepository.getOrderStatus();
    }
}