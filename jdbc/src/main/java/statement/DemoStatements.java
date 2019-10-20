package statement;

public class DemoStatements {

    public static void main(String[] args) {
        Statements statements = new Statements();

//        statements.insertOperation("paul", "alex@gmail.com", "romania");
//        statements.queryOperation();
//        statements.updateOperation(1, "updated", "updatedEmail", "updatedCountry");
        statements.deleteOperation(1);
    }
}
