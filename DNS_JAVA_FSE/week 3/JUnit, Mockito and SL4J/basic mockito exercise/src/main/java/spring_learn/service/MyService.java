package spring_learn.service;

public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void process() {

        api.connect();

        api.fetchData();

        api.disconnect();

    }

}