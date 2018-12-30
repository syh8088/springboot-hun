public class Main {
    public static void main(String args[]) {
        System.out.println("HI");

//        DBUtil dbUtil = new DBUtil(new NConnecter());
        DBUtil dbUtil = new DBUtil(ConnectorFactory.getConnector("R"));
    }
}
