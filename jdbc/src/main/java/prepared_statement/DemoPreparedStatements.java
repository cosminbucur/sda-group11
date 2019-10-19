package prepared_statement;

public class DemoPreparedStatements {

    public static void main(String[] args) {
        PreparedStatements statements = new PreparedStatements();

        statements.insertOperation("ana", "ana@gmail.com", "romania");
//        statements.queryOperation();
//        statements.deleteOperation(2);
    }
}
