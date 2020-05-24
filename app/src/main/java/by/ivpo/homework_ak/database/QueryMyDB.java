package by.ivpo.homework_ak.database;

import java.util.List;

import by.ivpo.homework_ak.model.TableRowCount;
import by.ivpo.homework_ak.model.User;

public class QueryMyDB {

    public interface UsersQuery {
        void createUser(User User, QueryResponse<Boolean> response);
//        void readUser(int userId, QueryResponse<User> response);
//        void readAllUser(QueryResponse<List<User>> response);
//        void updateUser(User user, QueryResponse<Boolean> response);
//        void deleteUser(int userId, QueryResponse<Boolean> response);
    }

    public interface TableRowCountQuery {
        void getTableRowCount(QueryResponse<TableRowCount> response);
    }

}
