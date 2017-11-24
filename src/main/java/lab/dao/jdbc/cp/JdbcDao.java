package lab.dao.jdbc.cp;

import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface JdbcDao extends Supplier<Connection> {

    @SneakyThrows
    default <T> T mapConnection(Function<Connection, T> connectionMapper) {
        try (val con = get()) {
            return connectionMapper.apply(con);
        }
    }
}
