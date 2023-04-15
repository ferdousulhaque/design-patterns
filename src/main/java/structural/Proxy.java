package structural;

// One of the Practical cases, for database query distribution

interface ORM {
    public Object select(String[] args);
    public Object update(String[] args);
    public Object delete(Integer id);
}

class RealMySQLEngine implements ORM{

    @Override
    public Object select(String[] args) {
        return null;
    }

    @Override
    public Object update(String[] args) {
        return null;
    }

    @Override
    public Object delete(Integer id) {
        return null;
    }
}

class ProxyMySQLEngine implements ORM {
    private final String masterJDBCConfig = "172.16.11.12";
    private final String slaveJDBCConfig = "172.16.11.14";

    @Override
    public Object select(String[] args) {
        Object connection = connect("select");
        // connection.query(); TODO: Do the query here
        return null;
    }

    @Override
    public Object update(String[] args) {
        Object connection = connect("update");
        // connection.query(); TODO: Do the query here
        return null;
    }

    @Override
    public Object delete(Integer id) {
        Object connection = connect("delete");
        // connection.query(); TODO: Do the query here
        return null;
    }

    private Object connect(String type){
        String JDBCConfig = DBSelection(type);
        // TODO: Return the Connected object
        return null;
    }

    private String DBSelection(String type){
        String config;
        switch (type){
            case "select" -> config = slaveJDBCConfig;
            case "update" -> config = masterJDBCConfig;
            case "delete" -> config = masterJDBCConfig;
            default -> config = masterJDBCConfig;
        }
        System.out.println(config);
        return config;
    }
}


public class Proxy {
    public static void main(String[] args) {
        ORM proxy = new ProxyMySQLEngine();
        proxy.update(new String[]{"active", "1"});
    }
}
