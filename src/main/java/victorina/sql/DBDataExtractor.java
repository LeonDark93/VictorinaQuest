package victorina.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDataExtractor {

    public static final int QUESTION = 0;
    public static final int ANSWER = 1;
    private final Connection connection;


    public DBDataExtractor(Connection connection) {
        this.connection = connection;

    }

    public String[] getQuestion(int questionId) throws Exception {
        String[] arrOfQuestion = new String[2];
        Statement statement = connection.createStatement();
        String sql = "SELECT\n" +
                "         t1.title,\n" +
                "         t2.answers\n" +
                " FROM questions t1\n" +
                "INNER JOIN answers t2 on t1.id_quest = t2.id_answer\n" +
                "WHERE t1.id_quest = " + questionId;

        ResultSet rs = statement.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                arrOfQuestion[QUESTION] = rs.getString("title");
                arrOfQuestion[ANSWER] = rs.getString("answers");
            }

        }
        return arrOfQuestion;

    }


}
