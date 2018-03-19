package jig.domain.model.datasource;

public class Sql {

    SqlIdentifier identifier;
    Query query;
    SqlType sqlType;

    public Sql(SqlIdentifier identifier, Query query, SqlType sqlType) {
        this.identifier = identifier;
        this.query = query;
        this.sqlType = sqlType;
    }

    public SqlType sqlType() {
        return sqlType;
    }

    // TODO tableの型
    public String tableName() {
        return query.extractTable(sqlType);

    }

    public SqlIdentifier identifier() {
        return identifier;
    }
}
