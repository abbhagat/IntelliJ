package statics;

class MyException extends Exception {

    public String toString() {
        return "MyException Caught";
    }
}

class Main {

    int display(int x) throws MyException {
        if (x < 0) {
            throw new MyException();
        }
        return (int) (Math.pow(x, 2));
    }

    public static void main(String[] args) {
        try {
            new Main().display(-2);
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}
