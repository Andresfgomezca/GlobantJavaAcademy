package Factory.FactoryExample2.src.com.AndresGomez;

public class ConnectionFabric {
    public IConnection getConnection (String server){
        switch(server.strip()){
            case "ORACLE":
                return new ConnectionOracle();
            case "MySql":
                return new ConnectionMySql();
            case "SqlServer":
                return new ConnectionSqlServer();
            default:
                return new ConnectionEmpty();
        }
    }

}
