package designpattern;

/*
 * The front controller design pattern is used to provide a centralized request
 * handling mechanism so that all requests will be handled by a single handler.
 * This handler can do the authentication/ authorization/ logging or tracking
 * of request and then pass the requests to corresponding handlers.
 */

class HomeView {
    public void show() {
        System.out.println("Displaying Home Page");
    }
}

class StudentView {
    public void show() {
        System.out.println("Displaying Student Page");
    }
}

class Dispatcher {
    private final StudentView studentView;
    private final HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView    = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}

class FrontController {

    private final Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}

public class FrontControllerPattern {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
