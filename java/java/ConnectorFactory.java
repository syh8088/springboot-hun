public class ConnectorFactory {


    public static Connector getConnector(String type) {
        switch (type) {
            case "N":
                return new NConnecter();
            case "R":
                return new RConnecter();
            default:
                return null;
        }
    }
}
